package org.example.algomonster.graphs;

/**
 * https://www.youtube.com/watch?v=KEyd_d9EA0c&list=PLpO3gASfJEIJ6cYs4kAY3SnH2kpohSTZI&index=12
 */
public class IslandPerimeter {
    public static int perimeter = 0;

    public static int evaluateIslandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==1 && visited[i][j]==false) {
                    dfsEvaluate(grid, i, j, visited);
                }
            }
        }
        return perimeter;
    }

    private static void dfsEvaluate(int[][] grid, int i, int j,
                             boolean[][] visited) {
        int gridSize = grid.length;
        if(i==-1 || j==-1 || i==gridSize || j==gridSize || grid[i][j]==0) {
            perimeter++;
            return;
        }
        if(i>=0 && j>=0 && grid[i][j]==1 && i<gridSize && j<gridSize && visited[i][j]==false) {
            visited[i][j] = true;
            dfsEvaluate(grid, i+1, j, visited);
            dfsEvaluate(grid, i-1, j, visited);
            dfsEvaluate(grid, i, j+1, visited);
            dfsEvaluate(grid, i, j-1, visited);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println("The perimeter on given island grid is:: "+ evaluateIslandPerimeter(grid));
    }
}
