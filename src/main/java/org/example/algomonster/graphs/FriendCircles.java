package org.example.algomonster.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {

    public static int findFriendCircles(int[][] adjMatrix) {
        return findGraphComponents(adjMatrix, 0);
    }

    private static int findGraphComponents(int[][] adjMatrix, int ans) {
        int v = adjMatrix.length;
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(visited[i]==false) {
                ans++;
                BFS(adjMatrix, i, visited);
            }
        }
        return ans;
    }

    public static void BFS(int[][] adjMatrix, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            for(int i=0; i<adjMatrix.length; i++) {
                if(adjMatrix[front][i]==1 && visited[i]==false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] M =  {
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 0 }
        };
        System.out.println("Number of friend circles in given matrix are: "+findFriendCircles(M));
    }
}
