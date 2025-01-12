package org.example.algomonster.dfs;

import java.util.Scanner;

public class BalancedBinaryTree {

    private static int isBalancedTree(Node<Integer> root) {
        if(root==null) {
            return 0;
        }
        int leftMax = isBalancedTree(root.left);
        if(leftMax==-1) {
            return -1;
        }
        int rightMax = isBalancedTree(root.right);
        if(rightMax==-1) {
            return -1;
        }
        if(Math.abs(leftMax - rightMax) > 1) {
            return -1;
        }
        return Math.max(leftMax, rightMax) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = Node.buildTree(Node.splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        System.out.println(isBalancedTree(root)!=-1);
    }
}
