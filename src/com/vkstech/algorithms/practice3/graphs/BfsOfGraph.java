package com.vkstech.algorithms.practice3.graphs;

import java.util.*;

public class BfsOfGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj1.add(new ArrayList<>(Collections.singletonList(0)));
        adj1.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj1.add(new ArrayList<>(Collections.singletonList(0)));
        adj1.add(new ArrayList<>(Collections.singletonList(2)));

        ArrayList<Integer> bfs = bfs(adj1);
        System.out.println(bfs);
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        if (adj == null || adj.isEmpty()) {
            return new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean[] visited = new boolean[adj.size()];

        ArrayList<Integer> bfs = new ArrayList<>();
        bfs.add(0);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();

            visited[vertex] = true;

            ArrayList<Integer> neighbors = adj.get(vertex);
            neighbors.stream().filter(n -> !visited[n]).forEach(e -> {
                queue.add(e);
                visited[e] = true;
                bfs.add(e);
            });
        }
        return bfs;
    }
}
