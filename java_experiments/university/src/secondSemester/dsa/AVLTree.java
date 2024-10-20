package secondSemester.dsa;

public class AVLTree<K extends Comparable<K>> {
    private static class AVLNode<K extends Comparable<K>> {
        private int height;
        private K key;
        private AVLNode<K> left = null, right = null;
   
        public AVLNode(K e) { key = e; height = 1; }

        public K getKey() { return key; }
        public AVLNode<K> getLeft() { return left; }
        public AVLNode<K> getRight() { return right; }
        public void setLeft(AVLNode<K> n) { left = n; }
        public void setRight(AVLNode<K> n) { right = n; }

        public void updateHeight() {
            int l = (left == null) ? 0 : left.height;
            int r = (right == null) ? 0 : right.height;
            height = Math.max(l, r) + 1;
        }

        public int getBalance() {
            int l = (left == null) ? 0 : left.height;
            int r = (right == null) ? 0 : right.height;
            return l - r;
        }
    }

    private AVLNode<K> root;

    public void insert(K k) {
        System.out.println("insert(" + k + ")"); // Output zur Veranschaulichung
        if (root == null)
            root = new AVLNode<>(k);
        else
            root = insertNode(root, k);
    }

    private AVLNode<K> insertNode(AVLNode<K> n, K k) {
        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            // Schlüssel bereits vorhanden. Es ist nichts zu tun.
        } else if (cmp < 0) {
            // Rechts einfügen
            if (n.getRight() != null) {
                // Im rechten Teilbaum einfügen (rekursiv)
                n.setRight(insertNode(n.getRight(), k));
            } else {
                // Neuen Blattknoten rechts erzeugen
                n.setRight(new AVLNode<>(k));
            }
            // Höhe des rechten Teilbaums könnte sich verändert haben
            n.updateHeight();
            // Ggf. rebalancieren
            if (n.getBalance() < -1) {
                // Rebalancieren
                if (n.getRight().getBalance() < 0) {
                    // Fall 3: Einfachrotation nach links
                    // Output zur Veranschaulichung:
                    System.out.println("L("
                        + n.getRight().getKey() + ","
                        + n.getKey() + ")");
                    n = rotateLeft(n);
                } else {
                    // Fall 4: Doppelrotation (rechts-links)
                    // Output zur Veranschaulichung:
                    System.out.println("DR("
                        + n.getRight().getLeft().getKey() + ","
                        + n.getRight().getKey() + ","
                        + n.getKey() + ")");
                    n.setRight(rotateRight(n.getRight()));
                    n = rotateLeft(n);
                }
            }
        } else {
            // Links einfügen (symmetrisch)
            if (n.getLeft() != null) {
                // Im linken Teilbaum einfügen (rekursiv)
                n.setLeft(insertNode(n.getLeft(), k));
            } else {
                // Neuen Blattknoten links erzeugen
                n.setLeft(new AVLNode<>(k));
            }
            // Höhe des linken Teilbaums könnte sich verändert haben
            n.updateHeight();
            // Ggf. rebalancieren
            if (n.getBalance() > 1) {
                // Rebalancieren
                if (n.getLeft().getBalance() > 0) {
                    // Fall 1: Einfachrotation nach rechts
                    // Output zur Veranschaulichung:
                    System.out.println("R("
                        + n.getLeft().getKey() + ","
                        + n.getKey() + ")");
                    n = rotateRight(n);
                } else {
                    // Fall 2: Doppelrotation (links-rechts)
                    // Output zur Veranschaulichung:
                    System.out.println("DL("
                        + n.getLeft().getRight().getKey() + ","
                        + n.getLeft().getKey() + ","
                        + n.getKey() + ")");
                    n.setLeft(rotateLeft(n.getLeft()));
                    n = rotateRight(n);
                }
            }
        }

        return n;
    }

    private AVLNode<K> rotateLeft(AVLNode<K> n) {
        AVLNode<K> tmp = n.getRight();
        n.setRight(tmp.getLeft());
        n.updateHeight();
        tmp.setLeft(n);
        tmp.updateHeight();
        return tmp;
    }

    private AVLNode<K> rotateRight(AVLNode<K> n) {
        AVLNode<K> tmp = n.getLeft();
        n.setLeft(tmp.getRight());
        n.updateHeight();
        tmp.setRight(n);
        tmp.updateHeight();
        return tmp;
    }
    
    public static void main(String[] args) {
        // Baum instanziieren
        AVLTree<Integer> tree = new AVLTree<>();

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
