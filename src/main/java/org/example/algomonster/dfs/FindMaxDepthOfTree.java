package org.example.algomonster.dfs;

public class FindMaxDepthOfTree {

    public static int findMaxDepthOfTree(Node<Integer> root) {
        if(root == null) {
            return -1;
        }
        int leftMaxDepth = findMaxDepthOfTree(root.left);
        int rightMaxDepth = findMaxDepthOfTree(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x").iterator(), Integer::parseInt);
        System.out.println(findMaxDepthOfTree(root));
    }
}
