package com.vkstech.algorithms.practice3.stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] mat1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        System.out.println(celebrity(mat1));

        int[][] mat2 = {{1, 1}, {1, 1}};
        System.out.println(celebrity(mat2));
    }

    public static int celebrity(int[][] mat) {
        Stack<Integer> stack = new Stack<>();
        int n = mat.length;

        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();

            if (mat[i][j] == 1 && mat[j][i] == 0) {
                stack.push(j);
            } else if (mat[i][j] == 0 && mat[j][i] == 1) {
                stack.push(i);
            }
        }

        if (stack.isEmpty()) {
            return -1;
        }

        int last = stack.pop();
        int rowSum = 0, colSum = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (last == i) {
                continue;
            }

            rowSum += mat[i][last];
            colSum += mat[last][i];
        }

        if (rowSum == n - 1 && colSum == 0)
            return last;

        return -1;
    }
}
