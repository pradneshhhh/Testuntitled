package org.example.algomonster.binarysearch;

public class Template {

    /**
     *
     The binary decision we must make when we look at an element is:

     If the element is false, we discard everything to the left and the current element itself.
     If the element is true, the current element could be the first true although there may be other true to the left. We discard everything to the right but what about the current element?
     We can either keep the current element in the range or record it somewhere and then discard it. Here we choose the latter. We'll discuss the other approach in the alternative solution section.

     We keep a variable boundary_index that represents the currently recorded leftmost true's index. If the current element is true, then we update boundary_index with its index and discard everything to the right including the current element itself since its index has been recorded by the variable.

     Time Complexity: O(log(n))

     Space Complexity: O(1)

    public static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int firstTrueIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (feasible(mid)) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return firstTrueIndex;
    }

     **/
}
