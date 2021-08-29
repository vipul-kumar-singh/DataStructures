package com.vkstech.algorithms.practice.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Detect cycle in a directed graph
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 * check whether it contains any cycle or not.
 */
public class DetectCycleDirectedGraph {

    public static void main(String[] args) {
        GraphViaMap<Integer> graph = new GraphViaMap<>();
        IntStream.rangeClosed(0, 3).forEach(graph::addVertex);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        System.out.println(isCyclePresent(graph));
    }

    public static boolean isCyclePresent(GraphViaMap<Integer> graph) {
        List<Integer> vertices = graph.getVertices().stream()
                .map(v -> v.data)
                .collect(Collectors.toList());

        Set<Integer> visited = new HashSet<>();

        for (Integer vertex : vertices) {
            if (visited.contains(vertex))
                continue;

            boolean cycle = checkForCycle(vertex, visited, graph);
            if (cycle)
                return true;

            visited.add(vertex);
        }

        return false;
    }

    private static boolean checkForCycle(Integer vertex, Set<Integer> visited, GraphViaMap<Integer> graph) {
        List<Integer> adjVertices = graph.getAdjVertices(vertex).stream()
                .map(v -> v.data)
                .collect(Collectors.toList());

        for (Integer data : adjVertices) {
            if (visited.contains(data))
                return true;
            visited.add(data);
            checkForCycle(data, visited, graph);
        }
        return false;
    }
}
