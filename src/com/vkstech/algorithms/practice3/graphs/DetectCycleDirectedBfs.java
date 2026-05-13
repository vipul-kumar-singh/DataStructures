package com.vkstech.algorithms.practice3.graphs;

import java.util.*;

public class DetectCycleDirectedBfs {

    public static void main(String[] args) {
        int V1 = 4, edges1[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(detectCycleUsingBfs(V1, edges1));

        int V2 = 4, edges2[][] = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(detectCycleUsingBfs(V2, edges2));

        int V3 = 4, edges3[][] = {{1, 2}, {2, 3}};
        System.out.println(detectCycleUsingBfs(V3, edges3));
    }

    public static boolean detectCycleUsingBfs(int V, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return false;
        }

        List<List<Integer>> adjencies = getAdjFromEdges(V, edges);

        int[] indegree = new int[V];

        // calculate indegree
        for (List<Integer> adj : adjencies) {
            for (int next : adj) {
                indegree[next]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // start from indegree 0 nodes
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedNodes = 0;

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            processedNodes++;

            for (int next : adjencies.get(cur)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return processedNodes != V;
    }

    private static List<List<Integer>> getAdjFromEdges(int v, int[][] edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < v; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
        }

        return new ArrayList<>(adjMap.values());
    }

}
