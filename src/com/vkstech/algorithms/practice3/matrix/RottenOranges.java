package com.vkstech.algorithms.practice3.matrix;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] mat1 = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        System.out.println(getTimeToRot(mat1));

        int[][] mat2 = {{2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        System.out.println(getTimeToRot(mat2));

        int[][] mat3 = {{0}};
        System.out.println(getTimeToRot(mat3));

        int[][] mat4 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(getTimeToRot(mat4));

        int[][] mat5 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(getTimeToRot(mat5));

        int[][] mat6 = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        System.out.println(getTimeToRot(mat6));

        int[][] mat7 = {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}};
        System.out.println(getTimeToRot(mat7));

    }

    private static int getTimeToRot(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0)
            return 0;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;

        boolean freshOranges = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }

                if (!freshOranges && mat[i][j] == 1) {
                    freshOranges = true;
                }
            }
        }

        if (!freshOranges)
            return 0;

        if (queue.isEmpty())
            return -1;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.remove();
                int row = pair.getKey();
                int col = pair.getValue();

                for (int[] dir : directions) {
                    int u = row + dir[0];
                    int v = col + dir[1];

                    if (u >= 0 && u < n && v >= 0 && v < m) {
                        if (mat[u][v] == 1) {
                            mat[u][v] = 2;
                            queue.add(new Pair<>(u, v));
                        }
                    }
                }

            }
        }

        for (int[] arr : mat) {
            for (int num : arr) {
                if (num == 1)
                    return -1;
            }
        }

        return count;
    }
}
