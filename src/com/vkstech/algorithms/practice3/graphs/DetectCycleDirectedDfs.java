package com.vkstech.algorithms.practice3.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleDirectedDfs {

    public static void main(String[] args) {
        int V1 = 4, edges1[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(detectCycleUsingDfs(V1, edges1));

        int V2 = 4, edges2[][] = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(detectCycleUsingDfs(V2, edges2));

        int V3 = 4, edges3[][] = {{1, 2}, {2, 3}};
        System.out.println(detectCycleUsingDfs(V3, edges3));

        int V4 = 4, edges4[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 0}};
        System.out.println(detectCycleUsingDfs(V4, edges4));
    }

    public static boolean detectCycleUsingDfs(int V, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return false;
        }

        List<List<Integer>> adjencies = getAdjFromEdges(V, edges);

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];


        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean cycle = detectCycleUsingDfs(adjencies, i, visited, pathVisited);
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
        }

        return new ArrayList<>(adjMap.values());
    }

    private static boolean detectCycleUsingDfs(List<List<Integer>> adjencies, int cur,
                                               boolean[] visited, boolean[] pathVisited) {
        visited[cur] = true;
        pathVisited[cur] = true;

        List<Integer> adj = adjencies.get(cur);

        for (int next : adj) {
            if (pathVisited[next])
                return true;

            if (!visited[next]) {
                boolean cycle = detectCycleUsingDfs(adjencies, next, visited, pathVisited);
                if (cycle) {
                    return true;
                }
            }
        }

        pathVisited[cur] = false;
        return false;
    }
}
