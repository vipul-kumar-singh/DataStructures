package com.vkstech.algorithms.practice.graph;

import java.util.*;

/**
 * Bipartite Graph
 * Given an adjacency list of a graph adj  of V no. of vertices having 0 based index.
 * Check whether the graph is bipartite or not.
 */
public class BipartiteGraph extends GraphViaMap<Integer> {

    public static void main(String[] args) {
        GraphViaMap<Integer> graph = new GraphViaMap<>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);

        System.out.println(isBipartite(graph));
    }

    private static boolean isBipartite(GraphViaMap<Integer> graph) {
        Set<Integer> color1Set = new HashSet<>();
        Set<Integer> color2Set = new HashSet<>();
        color1Set.add(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean isColor1 = false;

        while (!queue.isEmpty()) {
            Integer current = queue.remove();

            List<Vertex<Integer>> adjVertices = graph.getAdjVertices(current);
            for (GraphViaMap<Integer>.Vertex<Integer> vertex : adjVertices) {
                Integer data = vertex.data;
                if (isColor1) {
                    if (color2Set.contains(data))
                        return false;
                    if (color1Set.contains(data))
                        continue;
                    color1Set.add(data);
                } else {
                    if (color1Set.contains(data))
                        return false;
                    if (color2Set.contains(data))
                        continue;
                    color2Set.add(data);
                }
                queue.add(data);
            }
            isColor1 = !isColor1;
        }
        return true;
    }
}
