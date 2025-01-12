package org.example.algomonster.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class MaxValueDFS {
    public static class Node<T> {
        public T val;
        public MaxValueDFS.Node<T> left;
        public MaxValueDFS.Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, MaxValueDFS.Node<T> left, MaxValueDFS.Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Integer maxValueUsingReturn(MaxValueDFS.Node<Integer> root) {
        if(root==null) {
            return Integer.MIN_VALUE;
        }
        int leftMaxValue = maxValueUsingReturn(root.left);
        int rightMaxValue = maxValueUsingReturn(root.right);
        return Math.max(root.val, Math.max(leftMaxValue, rightMaxValue));
    }

    static int globalMax = Integer.MIN_VALUE;
    public static MaxValueDFS.Node<Integer> maxValueUsingGlobalVar(MaxValueDFS.Node<Integer> root) {
        if(root == null) {
            return null;
        }
        if(root.val > globalMax) {
            globalMax = root.val;
        }
        MaxValueDFS.Node<Integer> leftNode = maxValueUsingGlobalVar(root.left);
        if(leftNode!=null) {
            return leftNode;
        }
        return maxValueUsingGlobalVar(root.right);
    }
    static int visibleNodes = 0;
    public static int dfs(Node<Integer> root, int currentMax) {
        if(root==null){
            return 0;
        }
        if(root.val >= currentMax){
            visibleNodes += 1;
        }
        currentMax = Math.max(root.val, currentMax);
        int left = dfs(root.left, currentMax);
        int right = dfs(root.right, currentMax);
        return visibleNodes;
    }

    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> MaxValueDFS.Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        MaxValueDFS.Node<T> left = buildTree(iter, f);
        MaxValueDFS.Node<T> right = buildTree(iter, f);
        return new MaxValueDFS.Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaxValueDFS.Node<Integer> root = buildTree(splitWords("1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x").iterator(), Integer::parseInt);
        scanner.close();
        System.out.println(maxValueUsingReturn(root));
        maxValueUsingGlobalVar(root);
        System.out.println(globalMax);
        dfs(root, Integer.MIN_VALUE);
        System.out.println(visibleNodes);
    }
}
