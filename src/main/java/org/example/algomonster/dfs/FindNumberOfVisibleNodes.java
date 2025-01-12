package org.example.algomonster.dfs;

public class FindNumberOfVisibleNodes {

    public static int findNumberOfVisibleNodes(Node<Integer> root, int currentMax) {
        if(root == null) {
            return 0;
        }
        int total = 0;
        if(root.val > currentMax) {
            total += 1;
        }
        total += findNumberOfVisibleNodes(root.left, Math.max(root.val, currentMax));
        total += findNumberOfVisibleNodes(root.right, Math.max(root.val, currentMax));

        return total;
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("5 4 3 x x 8 x x 6 x x").iterator(), Integer::parseInt);
        System.out.println(findNumberOfVisibleNodes(root, Integer.MIN_VALUE));
    }
}
