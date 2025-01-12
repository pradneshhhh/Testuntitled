package org.example.algomonster.graphs;

/**
 * https://www.youtube.com/watch?v=3CoLbGz-3fc&list=PLpO3gASfJEIJ6cYs4kAY3SnH2kpohSTZI&index=11
 */
public class NumberOfIslands {

    public static int numberOfIslands(int[][] adjMat) {
        int count = 0;
        for(int i=0; i<adjMat.length; i++){
            for(int j=0; j<adjMat.length; j++) {
                if(adjMat[i][j] == 1) {
                    count++;
                    dfsFill(adjMat, i, j);
                }
            }
        }
        return count;
    }

    private static void dfsFill(int[][] adjMat, int i, int j) {
        if(i>=0 && j>=0 && i<adjMat.length && j<adjMat.length && adjMat[i][j]==1) {
            adjMat[i][j] = 0;
            dfsFill(adjMat, i+1, j);
            dfsFill(adjMat, i-1, j);
            dfsFill(adjMat, i, j+1);
            dfsFill(adjMat, i, j-1);
        }
    }

    public static void main(String[] args) {
        int[][] adjMat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0}
        };
        System.out.println("Number of islands in given matrix are:: "+ numberOfIslands(adjMat));
    }
}
