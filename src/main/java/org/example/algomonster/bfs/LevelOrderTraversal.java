package org.example.algomonster.bfs;

import org.example.algomonster.dfs.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> newLevel = new ArrayList<>();
            for(int i=0; i<qSize; i++){
                Node<Integer> node = queue.pop();
                newLevel.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(newLevel);
        }
        return res;
    }

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftFirst = false;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for(int i=0; i<qSize; i++) {
                Node<Integer> nodeVal = queue.poll();
                innerList.add(nodeVal.val);
                if(leftFirst) {
                    if (nodeVal.left != null) {
                        queue.add(nodeVal.left);
                    }
                    if (nodeVal.right != null) {
                        queue.add(nodeVal.right);
                    }
                } else {
                    if (nodeVal.right != null) {
                        queue.add(nodeVal.right);
                    }
                    if (nodeVal.left != null) {
                        queue.add(nodeVal.left);
                    }
                }
            }
            leftFirst = !leftFirst;
            res.add(innerList);
        }
        return res;
    }

    public static void main(String[] args) {
        Node<Integer> root = Node.buildTree(Node.splitWords("1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x").iterator(), Integer::parseInt);
        List<List<Integer>> res = levelOrderTraversal(root);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        System.out.println("---------------------------------");
        List<List<Integer>> resZigZag = zigZagTraversal(root);
        for (List<Integer> row : resZigZag) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
