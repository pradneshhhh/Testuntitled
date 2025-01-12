package org.example.algomonster.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleInUndirectedGraph {

    public static boolean isCycleDetectedInUndirectedGraph(List<List<Integer>> adjList, int sv, boolean[] visited, int parent) {
        visited[sv] = true;
        if(!adjList.get(sv).isEmpty() && adjList.get(sv).size() > 0) {
            for(int i: adjList.get(sv)) {
                if(visited[i] == false) {
                    isCycleDetectedInUndirectedGraph(adjList, i, visited, sv);
                    return true;
                } else if(visited[i] == true && parent!=i) {
                    return true;
                }
            }
        }
        return false;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertex\n");
        int v = sc.nextInt();
        System.out.println("Enter number of edges\n");
        int e = sc.nextInt();
        System.out.println("Adjacency List | Number of vertex:: "+v +"\n");
        System.out.println("Adjacency List | Number of edges:: "+e +"\n");
        List<List<Integer>> adjList = buildAdjancencyList(v, e, sc);
        boolean[] visited = new boolean[v];
        System.out.println("is cycle detected in the undirected graph:: "+ isCycleDetectedInUndirectedGraph(adjList, 0, visited, -1));
    }
}
