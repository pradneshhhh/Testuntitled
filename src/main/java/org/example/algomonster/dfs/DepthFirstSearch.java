package org.example.algomonster.dfs;

public class DepthFirstSearch {

    public static Node<Integer> dfs(Node<Integer> root, int target) {
        if(root==null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        Node<Integer> leftNode = dfs(root.left, target);
        if(leftNode!=null){
            return leftNode;
        }
        return dfs(root.right, target);
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x").iterator(), Integer::parseInt);
        System.out.println(dfs(root, 8).val);
    }
}
