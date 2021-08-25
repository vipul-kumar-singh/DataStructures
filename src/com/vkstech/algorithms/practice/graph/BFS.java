package com.vkstech.algorithms.practice.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BFS of graph
 */
public class BFS extends GraphViaMap<Integer> {

    private static Set<Integer> set;

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

        printBfs(2, graph);
        printBfs(1, graph);
    }

    public static void printBfs(Integer data, GraphViaMap<Integer> graph) {
        set = new HashSet<>();
        bfs(data, graph);
        System.out.println();
    }

    private static void bfs(Integer data, GraphViaMap<Integer> graph) {
        if (set.contains(data))
            return;

        System.out.print(data + " ");
        set.add(data);
        List<Vertex<Integer>> vertices = graph.getAdjVertices(data);
        vertices.stream()
                .map(vertex -> vertex.data)
                .filter(v -> !set.contains(v))
                .forEach(v -> bfs(v, graph));
    }


}