package com.vkstech.algorithms.practice3.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleUndirectedDfs {

    public static void main(String[] args) {
        int V1 = 4, edges1[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(detectCycleUsingDfs(V1, edges1));

        int V2 = 4, edges2[][] = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(detectCycleUsingDfs(V2, edges2));

        int V3 = 4, edges3[][] = {{1, 2}, {2, 3}};
        System.out.println(detectCycleUsingDfs(V3, edges3));
    }

    public static boolean detectCycleUsingDfs(int V, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return false;
        }

        if (V <= 2)
            return false;

        List<List<Integer>> adjencies = getAdjFromEdges(V, edges);

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean cycle = detectCycleUsingDfs(adjencies, i, -1, visited);
                if (cycle) {
                    return true;
                }
            }
        }

        return false;
    }

    private static List<List<Integer>> getAdjFromEdges(int v, int[][] edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < v; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        return new ArrayList<>(adjMap.values());
    }

    private static boolean detectCycleUsingDfs(List<List<Integer>> adjencies, int cur, int parent, boolean[] visited) {
        if (visited[cur]) {
            return true;
        }

        visited[cur] = true;

        List<Integer> adj = adjencies.get(cur);

        for (int next : adj) {
            if (next == parent)
                continue;

            if (visited[next])
                return true;

            if (detectCycleUsingDfs(adjencies, next, cur, visited))
                return true;
        }

        return false;
    }
}
