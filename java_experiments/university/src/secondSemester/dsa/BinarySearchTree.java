package secondSemester.dsa;

import java.util.*;

public class BinarySearchTree<K extends Comparable<K>> {
    private TreeNode<K> root;
    private IterationOrder iterationOrder;

    public void setIterationOrder(IterationOrder io) {
        this.iterationOrder = io;
    }

    public Iterator<K> iterator() {
        switch (this.iterationOrder) {
            case INORDER:
                return new InorderIterator<K>(this);
            case PREORDER:
                return new PreorderIterator<K>(this);
            case POSTORDER:
                return new PostorderIterator<K>(this);
            case LEVELORDER:
                return new LevelorderIterator<K>(this);
        }
        return new InorderIterator<K>(this); // should be unreachable
    }

    TreeNode<K> recursiveFindNode(K k) {
        return recursiveFindNode(this.root, k);
    }

    private TreeNode<K> recursiveFindNode(TreeNode<K> node, K k) {
        if (node == null)
            return null;
        int cmp = node.getKey().compareTo(k);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) { // node.key > k 
            return recursiveFindNode(node.getLeft(), k);
        } else {
            return recursiveFindNode(node.getRight(), k);
        }
    }

    TreeNode<K> iterativeFindNode(K k) {
        TreeNode<K> node = root;
        while (node != null) {
            int cmp = node.getKey().compareTo(k);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return null;
    }
    
    public K findMinElement() {
        if (root == null)
            throw new NoSuchElementException();
        TreeNode<K> node = root;
        while (node.getLeft() != null)
            node = node.getLeft();
        return node.getKey();
    }

    public boolean insert (K k) {
        if (root == null) {
            root = new TreeNode<>(k);
            return true;
        }

        // Suchen der Einfügeposition
        TreeNode<K> parent = null;
        TreeNode<K> child = root;
        while (child != null) {
            parent = child;
            int cmp = parent.getKey().compareTo(k);
            if (cmp == 0)
                return false;
            if (cmp > 0)
                child = parent.getLeft();
            else
                child = parent.getRight();
        }

        // Verlinken des neuen Knotens
        TreeNode<K> newNode = new TreeNode<>(k);
        if (parent.getKey().compareTo(k) > 0)
            parent.setLeft(newNode);
        else
            parent.setRight(newNode);
        return true;
    }

    public boolean remove (K k) {
        // Knoten suchen
        TreeNode<K> parent = null;
        TreeNode<K> node = root;
        while (node != null) {
            int cmp = node.getKey().compareTo(k);
            if (cmp == 0)
                break;
            parent = node;
            if (cmp > 0)
                node = parent.getLeft();
            else
                node = parent.getRight();
        }
        if (node == null)
            return false; // Element nicht gefunden
            
        // Nachrücker finden (1/2)
        TreeNode<K> successor;
        if (node.getLeft() == null && node.getRight() == null) // Fall 2.1
            successor = null;
        else if (node.getRight() == null)                      // Fall 2.2(a)
            successor = node.getLeft();
        else if (node.getLeft() == null)                       // Fall 2.2(b)
            successor = node.getRight();

        // Nachrücker finden (2/2)
        else {                                                 // Fall 2.3
            TreeNode<K> tmp = node;
            successor = node.getRight();
            while (successor.getLeft() != null) {
                tmp = successor;
                successor = successor.getLeft();
            }
            successor.setLeft(node.getLeft());
            if (tmp != node) {
                tmp.setLeft(successor.getRight());
                successor.setRight(node.getRight());
            }
        }

        // Baum reorganisieren
        if (root == node)
            root = successor;
        else if (parent.getLeft() == node)
            parent.setLeft(successor);
        else
            parent.setRight(successor);
        return true;
    }

    public static void main(String[] args) {
        // Baum instanziieren
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Elemente in Baum einfügen
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(7);
        tree.insert(3);
        tree.insert(9);tree.insert(1);
        preOrder(tree.root);


//        // Durch Baum iterieren und Elemente ausgeben
//        tree.setIterationOrder(IterationOrder.PREORDER);
//        Iterator<Integer> iterator = tree.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next());
//        // Suche nach Node mit key==2
//        if (tree.iterativeFindNode(2) != null){
//            System.out.println("node found");
//        }


    }

    public static enum IterationOrder {
        INORDER,
        PREORDER,
        POSTORDER,
        LEVELORDER,
    }

    public static void preOrder(TreeNode node){
        Stack<TreeNode> myStack = new Stack<>();
        myStack.push(node);
        while(!myStack.isEmpty()){
            TreeNode current = myStack.pop();
            if(current.getRight()!= null) {
                myStack.push(current.getRight());
            }
            if(current.getLeft()!= null){
                myStack.push(current.getLeft());
            }
            System.out.println(current.getKey());
        }
    }

    private static class InorderIterator<K extends Comparable<K>> implements Iterator<K> {
        Queue<TreeNode<K>> queue = new LinkedList<>();
        public InorderIterator(BinarySearchTree<K> tree) {
            if(tree != null) queue.add(tree.root);
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        public K next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }
    }

    private static class PreorderIterator<K extends Comparable<K>> implements Iterator<K> {

        Stack<TreeNode<K>> stack = new Stack<>();

        public PreorderIterator(BinarySearchTree<K> tree) {
            if (tree.root != null)
                stack.push(tree.root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public K next() {
            TreeNode<K> node = stack.pop();
            K obj = node.getKey();
            if (node.getRight() != null)
                stack.push(node.getRight());
            if (node.getLeft() != null)
                stack.push(node.getLeft());
            return obj;
        }
    }
    
    private static class PostorderIterator<K extends Comparable<K>> implements Iterator<K> {
        public PostorderIterator(BinarySearchTree<K> tree) {
            // TODO Auto-generated constructor stub
        }
        public boolean hasNext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        }
        public K next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }
    }

    private static class LevelorderIterator<K extends Comparable<K>> implements Iterator<K> {
        public LevelorderIterator(BinarySearchTree<K> tree) {
            // TODO Auto-generated constructor stub
        }
        public boolean hasNext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        }
        public K next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }
    }
}
