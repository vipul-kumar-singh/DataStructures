package com.vkstech.algorithms.practice.graph;

import java.util.ArrayList;

/**
 * A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes in the form (u, v).
 * Graphs are used to solve many real-life problems. Graphs are used to represent networks.
 * The networks may include paths in a city or telephone network or circuit network.
 */
public class GraphViaList {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,
                               int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
    }
}
