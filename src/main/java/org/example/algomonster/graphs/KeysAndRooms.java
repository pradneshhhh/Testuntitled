package org.example.algomonster.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public static boolean allLocksCouldBeOpened(List<List<Integer>> adjList) {
        return isGraphComplete(adjList);
    }

    private static boolean isGraphComplete(List<List<Integer>> adjList) {
        int numberOfComponents = 0;
        int v = adjList.size();
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(visited[i]==false) {
                numberOfComponents++;
                BFS(adjList, i, visited);
            }
        }
        return numberOfComponents == 1;
    }

    private static void BFS(List<List<Integer>> adjList, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            if(!adjList.get(front).isEmpty() && adjList.get(front).size()>0) {
                for(int i:adjList.get(front)) {
                    if(visited[i]==false) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(List.of(1,3));
        adjList.add(List.of(3,0,1));
        adjList.add(List.of(2));
        adjList.add(List.of(0));

        System.out.println("allLocksCouldBeOpened:: "+allLocksCouldBeOpened(adjList));
    }
}
