package org.example.algomonster.dfs;

public class Template {

    /**
     *
     * Backtracking and DFS are similar concepts and essentially the same thing since in DFS you always "backtrack" after exploring a deeper node. It's like saying I program computers by doing coding. If we really want to make the distinction, then backtracking is the concept of retracing and DFS is the algorithm that implements it. In computer science textbooks, backtracking is often mentioned and associated with combinatorial search problems. We will do the same in the course.
     *
     * We have two recursive calls dfs(root.left) and dfs(root.right), and we return based on the results from the recursive calls. This is also a divide and conquer algorithm, i.e. splitting into sub-problems of the same type (search in left and right children) until they are simple enough to be solved directly (null nodes or found target) and combine the results from these subproblems (return non-null node). We'll investigate divide and conquer more in a later module.
     *
     */
    public static Node<Integer> dfs(Node<Integer> root, int target) {
        if (root == null) return null;
        if (root.val == target) {
            return root;
        }
        Node<Integer> left = dfs(root.left, target);
        if (left != null) {
            return left;
        }
        return dfs(root.right, target);
    }

}
