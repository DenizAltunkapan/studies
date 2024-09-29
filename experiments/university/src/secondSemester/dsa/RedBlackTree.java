package secondSemester.dsa;

public class RedBlackTree<K extends Comparable<K>> {
    private static class RBNode<K extends Comparable<K>> {
        private K key;
        private RBNode<K> left = null, right = null;
        private boolean red = false;

        public RBNode(K e) { key = e; }

        public K getKey() { return key; }
        public RBNode<K> getLeft() { return left; }
        public RBNode<K> getRight() { return right; }
        public void setLeft(RBNode<K> n) { left = n; }
        public void setRight(RBNode<K> n) { right = n; }

        public boolean isRed() { return red; }
        public void setRed(boolean b) { red = b; }
    }

    private RBNode<K> root;

    public boolean insert(K k) {
        System.out.println("insert(" + k + ")"); // Output zur Veranschaulichung

        if (root == null) {
            root = new RBNode<>(k);
            return true;
        }

        // Suchen der Einfügeposition
        RBNode<K> parent = null, grand = null, great = null;
        RBNode<K> node = root;
        while (node != null) {
            // 4-Knoten präventiv aufspalten:
            if (node.getLeft() != null && node.getLeft().isRed() &&
                node.getRight() != null && node.getRight().isRed())
                split(node, parent, grand, great);
            great = grand;
            grand = parent;
            parent = node;
            int cmp = parent.getKey().compareTo(k);
            if (cmp == 0)
                return false;
            if (cmp > 0)
                node = parent.getLeft();
            else
                node = parent.getRight();
        }

        // Verlinken des neuen Knotens
        System.out.println("new RBNode<>(" + k + ")"); // Output zur Veranschaulichung
        node = new RBNode<>(k);
        if (parent.getKey().compareTo(k) > 0)
            parent.setLeft(node);
        else
            parent.setRight(node);

        // Gerade ist der neue Knoten noch schwarz, aber durch die folgende
        // Split-Operation wird er rot gefärbt und in den "2-3-4-Elternknoten"
        // hochgezogen. Letzterer ist ein 2- oder 3-Knoten und wird dadurch
        // zum 3- oder 4-Knoten.
        split(node, parent, grand, great);

        return true;
    }

    private void split(RBNode<K> node, RBNode<K> parent, RBNode<K> grand, RBNode<K> great) {
        // Output zur Veranschaulichung:
        System.out.println("split("
            + (node == null ? "null" : node.getKey()) + ", "
            + (parent == null ? "null" : parent.getKey()) + ", "
            + (grand == null ? "null" : grand.getKey()) + ", "
            + (great == null ? "null" : great.getKey()) + ")");

        // Kinder umfärben
        if (node.getLeft() != null) node.getLeft().setRed(false);
        if (node.getRight() != null) node.getRight().setRed(false);

        // Fall 1 (4-Knoten ist Wurzel): nichts weiter zu tun
        if (node == root) return;

        node.setRed(true); // Knoten umfärben

        // Fall 2 (4-Knoten unter 2-Knoten) oder Fall 3a (4-Knoten unter
        // schwarzem Knoten eines 3-Knotens): nichts weiter zu tun
        if (!parent.isRed()) return;

        if ((grand.getLeft() == parent) == (parent.getLeft() == node)) {
            // Fall 3b: erkennbar daran, dass wir in den letzten beiden
            // Suchiterationen auf die gleiche Seite gingen
            replaceChild(great, grand, rotate(grand));
            grand.setRed(true);
            parent.setRed(false);
        } else {
            // Fall 3c: erkennbar daran, dass wir in den letzten beiden
            // Suchiterationen auf unterschiedliche Seiten gingen
            replaceChild(grand, parent, rotate(parent));
            replaceChild(great, grand, rotate(grand));
            grand.setRed(true);
            node.setRed(false);
        }
    }

    private RBNode<K> rotate(RBNode<K> n) {
        // Beobachtung: Bei den Rotationen ist immer genau ein Kind rot
        boolean leftIsRed = n.getLeft() != null && n.getLeft().isRed();
        boolean rightIsRed = n.getRight() != null && n.getRight().isRed();
        if (leftIsRed == rightIsRed)
            throw new IllegalArgumentException();

        // Wir rotieren das rote Kind nach oben
        if (leftIsRed)
            return rotateRight(n);
        else
            return rotateLeft(n);
    }

    private RBNode<K> rotateLeft(RBNode<K> n) {
        RBNode<K> tmp = n.getRight();
        n.setRight(tmp.getLeft());
        tmp.setLeft(n);
        return tmp;
    }

    private RBNode<K> rotateRight(RBNode<K> n) {
        RBNode<K> tmp = n.getLeft();
        n.setLeft(tmp.getRight());
        tmp.setRight(n);
        return tmp;
    }

    public void replaceChild(RBNode<K> node, RBNode<K> oldChild, RBNode<K> newChild) {
        // Diese Funktion kann auch benutzt werden um die Wurzel zu ersetzen,
        // indem `node = null` übergeben wird.
        if (node == null) {
            if (root != oldChild)
                throw new IllegalArgumentException();
            root = newChild;
        }
        else if (node.getLeft() == oldChild)
            node.setLeft(newChild);
        else if (node.getRight() == oldChild)
            node.setRight(newChild);
        else
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        // Baum instanziieren
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        // Elemente in Baum einfügen
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(16);
        tree.insert(15);
    }
}
