package org.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LargestNumberInArray {

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 9, 7};
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        System.out.println("Largest number: " + q.peek());
    }
}
