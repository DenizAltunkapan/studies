package secondSemester.dsa;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode<K extends Comparable<K>> {
    K key;
    TreeNode<K> left = null, right = null;
    
    public TreeNode(K e) { key = e; }
    public TreeNode<K> getLeft() { return left; }
    public TreeNode<K> getRight() { return right; }
    public K getKey() { return key; }
    
    public void setLeft (TreeNode<K> n) { left = n; }
    public void setRight (TreeNode<K> n) { right = n; }

    @Override
    public String toString() {
        return key.toString();
    }

    public static <K extends Comparable<K>> void printInorder(TreeNode<K> n) {
        if (n != null) {
            printInorder(n.getLeft());
            System.out.println(n.toString());
            printInorder(n.getRight());
        }
    }

    public static <K extends Comparable<K>> void printPreorder(TreeNode<K> n) {
        if (n != null) {
            System.out.println(n.toString());
            printPreorder(n.getLeft());
            printPreorder(n.getRight());
        }
    }

    public static <K extends Comparable<K>> void printPostorder(TreeNode<K> n) {
        if (n != null) {
            printPostorder(n.getLeft());
            printPostorder(n.getRight());
            System.out.println(n.toString());
        }
    }


    public static <K extends Comparable<K>> void printLevelorder(TreeNode<K> root) {
        if (root != null) {
            Queue<TreeNode<K>> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<K> n = queue.remove();
                if (n.getLeft() != null)
                    queue.add(n.getLeft());
                if (n.getRight() != null)
                    queue.add(n.getRight());
                System.out.println(n.toString());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("+");
        root.setLeft(new TreeNode<>("*"));
        root.getLeft().setLeft(new TreeNode<>("2"));
        root.getLeft().setRight(new TreeNode<>("5"));
        root.setRight(new TreeNode<>("*"));
        root.getRight().setLeft(new TreeNode<>("+"));
        root.getRight().getLeft().setLeft(new TreeNode<>("2"));
        root.getRight().getLeft().setRight(new TreeNode<>("1"));
        root.getRight().setRight(new TreeNode<>("3"));

        System.out.println("Inorder:");
        printInorder(root);
        
        System.out.println("Preorder:");
        printPreorder(root);

        System.out.println("Postorder:");
        printPostorder(root);

        System.out.println("Levelorder:");
        printLevelorder(root);
    }
}
