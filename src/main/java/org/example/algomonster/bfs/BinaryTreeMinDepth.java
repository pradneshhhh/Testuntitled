package org.example.algomonster.bfs;

import org.example.algomonster.dfs.Node;

import java.util.ArrayDeque;

/**
 * Given a binary tree, find the depth of the shallowest leaf node.
 */
public class BinaryTreeMinDepth {

    public static int binaryTreeMinDepth(Node<Integer> root) {
        int level = 0;
        ArrayDeque<Node<Integer>> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                Node<Integer> node = q.pop();
                if(node.left==null && node.right==null) {
                    System.out.println("The min depth node value is:: "+node.val);
                    return level;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            level += 1;
        }
        return level;
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x").iterator(), Integer::parseInt);
        System.out.println(binaryTreeMinDepth(root));
    }
}
