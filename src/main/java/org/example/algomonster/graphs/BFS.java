package org.example.algomonster.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void printBFS(int[][] adjMatrix, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]= true;
        System.out.println(q.peek());
        while(!q.isEmpty()) {
            int front = q.poll();
            for(int i=0; i<adjMatrix.length; i++) {
                if(adjMatrix[front][i]==1 && visited[i]==false) {
                    q.add(i);
                    visited[i]= true;
                }
            }
        }
    }

    public static void print(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        for(int i=0; i<adjMatrix.length; i++) {
            printBFS(adjMatrix, i, visited);
        }
    }

    public static int[][] buildAdjacencyMatrix(int v, int e, Scanner sc) {
        int[][] adjMatrix = new int[v][v];
        System.out.println("Enter edges\n");
        for(int i=0;i<e;i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        System.out.println("The view of adjacency matrix::\n");
        for(int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return adjMatrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertex\n");
        int v = sc.nextInt();
        System.out.println("Enter number of edges\n");
        int e = sc.nextInt();
        int[][] adjMatrix = buildAdjacencyMatrix(v, e, sc);
        System.out.println("The Graph when accessed through BFS, looks like::\n");
        print(adjMatrix);
    }
}
