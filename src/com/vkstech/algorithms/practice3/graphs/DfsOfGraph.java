package com.vkstech.algorithms.practice3.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DfsOfGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj1.add(new ArrayList<>(Collections.singletonList(0)));
        adj1.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj1.add(new ArrayList<>(Collections.singletonList(0)));
        adj1.add(new ArrayList<>(Collections.singletonList(2)));

        ArrayList<Integer> dfs = dfs(adj1);
        System.out.println(dfs);
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();

        if (adj == null || adj.isEmpty()) {
            return dfs;
        }

        boolean[] visited = new boolean[adj.size()];

        return getdfs(adj, dfs, 0, visited);
    }

    private static ArrayList<Integer> getdfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, int i, boolean[] visited) {
        visited[i] = true;
        dfs.add(i);

        for (Integer next : adj.get(i)) {
            if (!visited[next]) {
                getdfs(adj, dfs, next, visited);
            }
        }

        return dfs;
    }
}
