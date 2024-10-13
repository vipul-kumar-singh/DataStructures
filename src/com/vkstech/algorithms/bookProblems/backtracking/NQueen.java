package com.vkstech.algorithms.bookProblems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static List<List<Integer>> result = new ArrayList<>();
    public static boolean[] cols, leftDiagonal, rightDiagonal;

    public static List<List<Integer>> nQueen(int n) {
        // cols[i] = true if there is a queen previously placed at ith column
        cols = new boolean[n];
        // leftDiagonal[i] = true if there is a queen previously placed at
        // i = (row + col )th left diagonal
        leftDiagonal = new boolean[2 * n];
        // rightDiagonal[i] = true if there is a queen previously placed at
        // i = (row - col + n - 1)th rightDiagonal diagonal
        rightDiagonal = new boolean[2 * n];
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) temp.add(0);
        solveNQUtil(result, n, 0, temp);

        return result;
    }

    private static void solveNQUtil(List<List<Integer>> result, int n, int row, List<Integer> comb) {
        if (row == n) {
            // if row==n it means we have successfully placed all n queens.
            // hence add current arrangement to our answer
            // comb represent current combination
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int col = 0; col < n; col++) {
            // if we have a queen previously placed in the current column
            // or in current left or right diagonal we continue
            if (cols[col] || leftDiagonal[row + col] || rightDiagonal[row - col + n])
                continue;
            // otherwise we place a queen at cell[row][col] and
            //make current column, left diagonal and right diagonal true
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = true;
            comb.set(col, row + 1);
            // then we goto next row
            solveNQUtil(result, n, row + 1, comb);
            // then we backtrack and remove our currently placed queen
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = false;
        }
    }

    // Driver code
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> res = nQueen(n);
        System.out.println(res);
    }
}
