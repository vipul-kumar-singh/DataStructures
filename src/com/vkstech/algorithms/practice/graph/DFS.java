package com.vkstech.algorithms.practice.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DFS of graph
 */
public class DFS extends GraphViaMap<Integer> {

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

        printDfs(2, graph);
        printDfs(1, graph);
    }

    public static void printDfs(Integer data, GraphViaMap<Integer> graph) {
        set = new HashSet<>();
        dfs(data, graph);
        System.out.println();
    }

    private static void dfs(Integer data, GraphViaMap<Integer> graph) {
        if (set.contains(data))
            return;

        System.out.print(data + " ");
        set.add(data);
        List<Vertex<Integer>> vertices = graph.getAdjVertices(data);
        vertices.stream()
                .map(vertex -> vertex.data)
                .filter(v -> !set.contains(v))
                .forEach(v -> dfs(v, graph));
    }


}