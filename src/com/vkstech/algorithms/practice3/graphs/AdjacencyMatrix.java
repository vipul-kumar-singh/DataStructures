package com.vkstech.algorithms.practice3.graphs;

import static com.vkstech.algorithms.practice.arrays.MatrixCreation.printMatrix;

public class AdjacencyMatrix {

    public static void main(String[] args) {
        int vertex = 5;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {2, 4}, {0, 2}};
        int[][] graph = getGraph(vertex, edges);
        printMatrix(graph);
    }

    private static int[][] getGraph(int vertex, int[][] edges) {
        int[][] matrix = new int[vertex][vertex];

        for (int[] arr : edges) {
            matrix[arr[0]][arr[1]] = 1;
            matrix[arr[1]][arr[0]] = 1;
        }

        return matrix;
    }
}
