package com.vkstech.algorithms.practice.graph;

import java.util.*;

/**
 * BFS of graph
 */
public class BFS extends GraphViaMap<Integer> {

    public static void main(String[] args) {
        GraphViaMap<Integer> graph = new GraphViaMap<>();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2, true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        bfs(2, graph);
        bfs(1, graph);
    }

    private static void bfs(Integer data, GraphViaMap<Integer> graph) {
        Set<Integer> set = new HashSet<>();
        set.add(data);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(data);

        while (!queue.isEmpty()) {
            Integer vData = queue.remove();
            System.out.print(vData + " ");

            graph.getAdjVertices(vData).stream()
                    .map(vertex -> vertex.data)
                    .filter(v -> !set.contains(v))
                    .forEach(v -> {
                        set.add(v);
                        queue.add(v);
                    });
        }

        System.out.println();
    }


}