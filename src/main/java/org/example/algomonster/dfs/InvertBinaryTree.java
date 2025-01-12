package org.example.algomonster.dfs;

public class InvertBinaryTree {

    public static Node<Integer> invertBinaryTree(Node<Integer> root) {
        if(root == null) {
            return null;
        }
        return new Node<Integer>(root.val, invertBinaryTree(root.right), invertBinaryTree(root.left));
    }

    public static void preOrderTraversal(Node<Integer> root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("1 2 4 x x 5 6 x x x 3 x x").iterator(), Integer::parseInt);
        preOrderTraversal(root);
        System.out.println("----------------------");
        Node<Integer> invertedTree = invertBinaryTree(root);
        preOrderTraversal(invertedTree);
    }
}
