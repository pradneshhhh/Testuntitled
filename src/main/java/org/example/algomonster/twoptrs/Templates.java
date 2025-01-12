package org.example.algomonster.twoptrs;

public class Templates {

    /**

     Sliding window problems are a variant of the same direction two pointers problems. The function performs on the entire interval between the two pointers instead of only at the two positions. Usually, we keep track of the overall result of the window, and when we "slide" the window (insert/remove an item), we simply manipulate the result to accommodate the changes to the window. Time complexity wise, this is much more efficient as we do not recalculate the overlapping intervals between two windows over and over again. We try to reduce a nested loop into two passes on the input (one pass with each pointer).

     https://algo.monster/problems/subarray_sum_fixed

    private static W slidingWindowFixed(List<T> input, int windowSize) {
        W ans = window = input.subList(0, windowSize);
        for (int right = windowSize; right < input.length(); ++right) {
            int left = right - windowSize
            remove input[left] from window
            append input[right] to window
            ans = optimal(ans, window);
        }
        return ans
    }
    **/

    /**
     *
     Observe that to find the longest (maximum size) subarray, the condition within the window is naturally satisfied. That is, before we process the array when left == right == 0, the empty array [] is a valid longest subarray during that stage. In the above example, the empty subarray satisfies the constraint that sum <= target To extend the window, we wish to increment the right pointer. This could in fact break the constraint of a valid window, so we will need to increment the left pointer until the window becomes valid again. Additionally, only invalid windows go into the while loop, which means when the window exits the while loop, it must be valid. At the beginning of each for loop iteration, the window is valid, and at the very end of each iteration, the window is still valid. This is what we call the "invariant" - the condition(s) that holds before and after the loop. Using this property, we can update ans at the end of each for loop iteration, as the window is guaranteed to be valid there.

     To find the longest subarray, we move the left pointer as little as possible. Here is the template.

    private static W slidingWindowFlexibleLongest(List<T> input) {
        initialize window, ans
        int left = 0;
        for (int right = 0; right < input.size(); ++right) {
            append input.get(right) to window
            while (invalid(window)) {         // update left until window is valid again
                remove input.get(left) from window
                ++left;
            }
            ans = Math.max(ans, window);           // window is guaranteed to be valid here
        }
        return ans;
    }

    **/


    /**

     Contrary to the longest window, the very first window (empty window) is naturally invalid. As in the above example, the starting sum is 0 so it's less than target. We would like to extend the right pointer until we reach a valid window. If we start with a valid window, incrementing right does not break the window condition(s), because adding more elements will only make the condition stronger. But we are looking for the shortest subarray, which means when we reach a valid window, we must shrink the window to find a smaller valid window by incrementing the left pointer until incrementing makes the window become invalid. We can do this by incrementing the left pointer. In this case to find shortest (minimum) subarray, we wish to increment left as much as possible (we can guarantee that left <= right because an empty window is invalid!).

    private static W slidingWindowFlexibleShortest(List<T> input) {
        initialize window, ans
        int left = 0;
        for (int right = 0; right < input.size(); ++right) {
            append input.get(right) to window
            while (valid(window)) {
                ans = Math.min(ans, window);   // window is guaranteed to be valid here
                remove input.get(left) from window
                ++left;
            }
        }
        return ans;
    }

     **/

}
