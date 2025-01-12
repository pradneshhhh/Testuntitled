package org.example.algomonster.dfs;

import java.util.Scanner;

public class BST {

    public static boolean validBst(Node<Integer> root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(min>root.val || max<root.val) {
            return false;
        }
        return (validBst(root.left, min, root.val) && validBst(root.right, root.val, max));
    }

    public static Node<Integer> insertBst(Node<Integer> bst, int val) {
        if(bst==null){
            return new Node<>(val);
        }
        if(bst.val<val) {
            bst.right = insertBst(bst.right, val);
        } else {
            bst.left = insertBst(bst.left, val);
        }
        return bst;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = Node.buildTree(Node.splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        System.out.println(validBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
