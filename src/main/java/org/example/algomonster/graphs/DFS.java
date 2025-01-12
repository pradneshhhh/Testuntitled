package org.example.algomonster.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

    public static void printGraphWithDFS(int[][] adjMatrix, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        for(int i=0; i<adjMatrix.length; i++) {
            if(adjMatrix[sv][i]==1 && visited[i]==false) {
                printGraphWithDFS(adjMatrix, i, visited);
            }
        }
    }

    public static void print(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        for(int i=0; i<adjMatrix.length; i++) {
            if(visited[i]==false)
                printGraphWithDFS(adjMatrix, i, visited);
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

    public static List<List<Integer>> buildAdjancencyList(int v, int e, Scanner sc) {
        List<List<Integer>> adjList = new ArrayList<>(v);
        for(int i=0;i<v; i++) {
            adjList.add(new ArrayList<>());
        }
        System.out.println("Adjacency List | Enter edges\n");
        for(int i=0;i<e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        System.out.println("The view of Adjacency List::\n");
        System.out.println(adjList.toString());
        return adjList;
    }

    public static void printDSFForAdjacencyList(List<List<Integer>> adjList, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        if(!adjList.get(sv).isEmpty()) {
            for(int i: adjList.get(sv)) {
                if(visited[i] == false) {
                    printDSFForAdjacencyList(adjList, i, visited);
                }
            }
        }
    }

    public static void printAdjacencyList(List<List<Integer>> adjList, int v) {
        boolean[] visited = new boolean[v];
        printDSFForAdjacencyList(adjList, 0, visited);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertex\n");
        int v = sc.nextInt();
        System.out.println("Enter number of edges\n");
        int e = sc.nextInt();
        int[][] adjMatrix = buildAdjacencyMatrix(v, e, sc);
        System.out.println("The Graph when accessed through DFS, looks like::\n");
        print(adjMatrix);
        System.out.println("----------------------------------");
        System.out.println("Adjacency List | Number of vertex:: "+v +"\n");
        System.out.println("Adjacency List | Number of edges:: "+e +"\n");
        List<List<Integer>> adjList = buildAdjancencyList(v, e, sc);
        System.out.println("Adjacency List | The Graph when accessed through DFS, looks like::\n");
        printAdjacencyList(adjList, v);
    }
}
