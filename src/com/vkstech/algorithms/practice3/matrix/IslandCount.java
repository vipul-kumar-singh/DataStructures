package com.vkstech.algorithms.practice3.matrix;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/dsa/find-the-number-of-islands-using-dfs/
public class IslandCount {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };
        System.out.println(getNumberOfIslands(grid1));

        char[][] grid2 = {
                {'W', 'L', 'L', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'L', 'L', 'W', 'L', 'W'}
        };
        System.out.println(getNumberOfIslands(grid2));
    }

    private static int getNumberOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W' || dp[i][j] == 1) {
                    continue;
                }

                if (grid[i][j] == 'L') {
                    count++;
                    queue.add(new Pair<>(i, j));
                    dp[i][j] = 1;

                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> pair = queue.remove();
                        int pair_i = pair.getKey();
                        int pair_j = pair.getValue();

                        for (int[] dir : directions) {
                            int u = pair_i + dir[0];
                            int v = pair_j + dir[1];

                            if (u >= 0 && u < n && v >= 0 && v < m) {
                                if (grid[u][v] == 'L' && dp[u][v] == 0) {
                                    queue.add(new Pair<>(u, v));
                                    dp[u][v] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }


}
