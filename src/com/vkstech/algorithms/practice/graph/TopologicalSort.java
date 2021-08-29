package com.vkstech.algorithms.practice.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Topological sort
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.cf
 */
public class TopologicalSort extends GraphViaMap<Integer> {

    public static void main(String[] args) {
        GraphViaMap<Integer> graph = new GraphViaMap<>();
        Arrays.asList(0, 1, 2, 3, 4, 5).forEach(graph::addVertex);

        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph:");
        topologicalSort(graph);
    }

    public static void topologicalSort(GraphViaMap<Integer> graph) {
        Stack<Integer> stack = new Stack<>();

        int n = graph.getVertices().size();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, graph);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    private static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack,
                                            GraphViaMap<Integer> graph) {
        visited[v] = true;

        List<Integer> adjVertices = graph.getAdjVertices(v).stream()
                .map(k -> k.data)
                .collect(Collectors.toList());

        adjVertices.forEach(vertex -> {
            if (!visited[vertex])
                topologicalSortUtil(vertex, visited, stack, graph);
        });

        stack.push(v);
    }
}
