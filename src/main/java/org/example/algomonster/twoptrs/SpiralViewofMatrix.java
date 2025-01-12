package org.example.algomonster.twoptrs;

import java.util.ArrayList;
import java.util.List;

public class SpiralViewofMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};

        List<Integer> ans = printSpiral(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    private static List<Integer> printSpiral(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int row=mat.length;
        int col=mat[0].length;

        int left=0;
        int right=col-1;
        int top=0;
        int bottom=row-1;

        while (top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) {
                ans.add(mat[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;

            for(int i=right; i>=left; i--) {
                ans.add(mat[bottom][i]);
            }
            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
