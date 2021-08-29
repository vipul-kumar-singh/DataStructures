package com.vkstech.algorithms.practice.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Detect cycle in an undirected graph
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
 */
public class DetectCycleUnDirected extends GraphViaMap<Integer> {

    public static void main(String[] args) {
        //Example 1
        GraphViaMap<Integer> graph = new GraphViaMap<>();
        IntStream.rangeClosed(0, 4).forEach(graph::addVertex);

        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 1, true);

        System.out.println(isCyclePresent(graph));

        //Example 2
        GraphViaMap<Integer> graph2 = new GraphViaMap<>();
        IntStream.rangeClosed(0, 3).forEach(graph2::addVertex);

        graph2.addEdge(1, 2, true);
        graph2.addEdge(2, 3, true);

        System.out.println(isCyclePresent(graph2));
    }

    public static boolean isCyclePresent(GraphViaMap<Integer> graph) {
        List<Integer> vertices = graph.getVertices().stream()
                .map(v -> v.data)
                .collect(Collectors.toList());

        Set<Integer> visited = new HashSet<>();

        for (Integer vertex : vertices) {
            if (visited.contains(vertex))
                continue;

            boolean cycle = checkForCycle(vertex, -1, visited, graph);
            if (cycle)
                return true;

            visited.add(vertex);
        }

        return false;
    }

    private static boolean checkForCycle(Integer vertex, Integer parent, Set<Integer> visited, GraphViaMap<Integer> graph) {
        List<Vertex<Integer>> adjVertices = graph.getAdjVertices(vertex);
        for (Vertex<Integer> v : adjVertices) {
            Integer data = v.data;

            if (data.equals(parent))
                continue;

            if (visited.contains(data))
                return true;

            visited.add(data);
            checkForCycle(data, vertex, visited, graph);
        }
        return false;
    }
}
