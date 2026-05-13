package com.vkstech.algorithms.practice3.matrix;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

import static com.vkstech.algorithms.practice.arrays.MatrixCreation.printMatrix;

public class WallsAndGates {

    private static final int INF = 2147483647;

    public static void main(String[] args) {
        int[][] grid1 = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        getPathToTreasure(grid1);
        printMatrix(grid1);

        int[][] grid2 = {
                {0, -1},
                {INF, INF}
        };
        getPathToTreasure(grid2);
        printMatrix(grid2);
    }

    private static void getPathToTreasure(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.remove();
            int i = pair.getKey();
            int j = pair.getValue();

            for (int[] dir : directions) {
                int u = i + dir[0];
                int v = j + dir[1];

                if (u >= 0 && u < n && v >= 0 && v < m) {
                    if (grid[u][v] == INF) {
                        grid[u][v] = grid[i][j] + 1;
                        queue.add(new Pair<>(u, v));
                    }
                }
            }
        }
    }
}
