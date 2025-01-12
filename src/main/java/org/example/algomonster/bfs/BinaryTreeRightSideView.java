package org.example.algomonster.bfs;

import org.example.algomonster.dfs.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the rightmost node of each level.
 *
 * It should be noted that at each level there can only be at most one rightmost node.
 */
public class BinaryTreeRightSideView {

    public static List<Integer> binaryTreeRightSideView(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<Node<Integer>> q = new ArrayDeque<>();
        q.add(root);
        result.add(root.val);
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                Node<Integer> node = q.pop();
                System.out.print(node.val+" ");
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    Node<Integer> tempNode = node.right;
                    q.add(tempNode);
                    result.add(tempNode.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x").iterator(), Integer::parseInt);
        List<Integer> res = binaryTreeRightSideView(root);
        System.out.println("\n==============");
        System.out.println(res);
    }
}
