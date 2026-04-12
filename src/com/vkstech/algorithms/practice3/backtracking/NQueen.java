package com.vkstech.algorithms.practice3.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static boolean[] cols, leftDiagonal, rightDiagonal;

    public static void main(String[] args) {
        List<List<Integer>> ans1 = solveNQueens(4);
        System.out.println(ans1);

        List<List<Integer>> ans2 = solveNQueens(5);
        System.out.println(ans2);
    }

    private static List<List<Integer>> solveNQueens(int n) {

        cols = new boolean[n];

        leftDiagonal = new boolean[2 * n];
        rightDiagonal = new boolean[2 * n];

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++)
            temp.add(0);

        solveNQUtil(result, n, 0, temp);

        return result;
    }

    private static void solveNQUtil(List<List<Integer>> result, int n, int row, List<Integer> temp) {
        if (row == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (cols[i] || leftDiagonal[row + i] || rightDiagonal[row - i + n])
                continue;

            cols[i] = leftDiagonal[row + i] = rightDiagonal[row - i + n] = true;

            temp.set(i, row + 1);
            solveNQUtil(result, n, row + 1, temp);

            cols[i] = leftDiagonal[row + i] = rightDiagonal[row - i + n] = false;
        }
    }
}
