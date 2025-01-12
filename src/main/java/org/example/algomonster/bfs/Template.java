package org.example.algomonster.bfs;

import org.example.algomonster.dfs.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Template {


    /**
     *
     * We can use DFS for this problem by keeping track of the depth of each node. A better way, though, is to use BFS since it naturally traverses the tree level by level.
     *
     * Applying the template, we use a queue to keep track of the nodes to visit next.
     *
     * How to get a node's level
     * When we dequeue a node from the queue, we need to know the level it sits in the tree to add it to the corresponding level in the result. But nodes in the queue do not have any information about their level. How do we get a node's level?
     *
     * One observation is that the queue contains at most two levels of nodes. To see why, let's assume our tree is three-level deep. Let's call the nodes of the shallowest level "level 0" nodes and their children "level 1" nodes, whose children are "level 2" nodes. When we do a BFS, we first push "level 0" nodes into the queue, and as we process them, we push their children "level 1" nodes into the queue. To get "level 2" nodes onto the queue, we have to start dequeuing and processing "level 1" nodes but we can't dequeue any "level 1" nodes until we have finished dequeuing and processing "level 0" nodes since a queue is a First-in-First-Out structure. Therefore, it's impossible to have three levels in the queue at the same time, and we can have at most two levels in the queue.
     *
     * Also, observe that we always push the leftmost node of a level into the queue first. When we dequeue the leftmost node (and before we add its children), the queue contains only one level of nodes. We can save the number of nodes in the queue in a variable n, and dequeue the next n nodes.
     *
     * Time Complexity: O(n)
     *
     * We traverse every edge and node once, but since the number of edges is n - 1, it essentially becomes O(n).
     *
     * Space Complexity: O(n)
     *
     * There are at most O(n) nodes in the queue.
     *
     */
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
}
