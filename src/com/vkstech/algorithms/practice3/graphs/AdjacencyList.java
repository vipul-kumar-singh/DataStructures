package com.vkstech.algorithms.practice3.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {

    public static void main(String[] args) {
        int vertex = 5;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {2, 4}, {0, 2}};
        List<List<Integer>> graph = getGraph(vertex, edges);
        System.out.println(graph);
    }

    private static List<List<Integer>> getGraph(int vertex, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            insertEdgeInMap(map, edge[0], edge[1]);
            insertEdgeInMap(map, edge[1], edge[0]);
        }

        return new ArrayList<>(map.values());
    }

    private static void insertEdgeInMap(Map<Integer, List<Integer>> map, int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
}
