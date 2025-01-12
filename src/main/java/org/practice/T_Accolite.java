package org.practice;

import java.util.Arrays;

public class T_Accolite {

    /**
     * Given a 2-D matrix print the column wise sum (preferably use streams)
     * e.g.
     * int arr[][] = {
     *                         {1, 2,  3,  4},
     *                         {5, 6,  7,  8},
     *                         {9, 10, 11, 12}
     *                     };
     * sum of 1st column is 1 + 5 + 9 = 15, 2nd column is 2 + 6 + 10 = 18 and so on.
     *
     * the o/p should be :
     * 15
     * 18
     * 21
     * 24
     *
     */
    public static void main(String[] args) {
        int arr[][] = {
                        {1, 2,  3,  4},
                        {5, 6,  7,  8},
                        {9, 10, 11, 12}
                     };
        evaluateColumnSum(arr);
//        Arrays.stream(arr).flatMapToInt(subArr -> Arrays.stream(subArr)).map(i -> evaluateColumnSum(i)).collect(Collectors.toList());
//        Arrays.stream(arr).forEach(array -> System.out.println(Arrays.toString(array)));

    }

    private static int[] evaluateColumnSum(int[][] arr) {
        int[] res = new int[arr[1].length];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[1].length;j++) {
                res[j] = res[j] + arr[i][j];
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

}
