package com.vkstech.algorithms.practice3.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoring {

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 3}, {2, 3}};
        int m = 3;

        System.out.println(graphColoring(V, edges, m));
    }

    //  V vertices, E edges and m different colors
    private static boolean graphColoring(int v, int[][] edges, int m) {

        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);

        return generateColor(0, color, m, adj);
    }

    private static boolean generateColor(int i, int[] color, int m, List<Integer>[] adj) {
        if (i >= color.length) {
            return goodColor(adj, color);
        }

        for (int j = 0; j < m; j++) {
            color[i] = j;
            if (generateColor(i + 1, color, m, adj))
                return true;
            color[i] = -1;
        }

        return false;
    }

    private static boolean goodColor(List<Integer>[] adj, int[] color) {
        for (int i = 0; i < color.length; i++) {
            for (int num : adj[i]) {
                if (i != num && color[i] == color[num])
                    return false;
            }
        }

        return true;
    }
}
