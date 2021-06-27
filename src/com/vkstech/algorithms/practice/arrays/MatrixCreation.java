package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Construct a unique matrix n x n for an input n
 * Given an odd integer n, find a matrix of size n x n with following conditions:
 * 1. Each cell contains an integer from 1 and n (inclusive).
 * 2. No integer appears twice in the same row or the same column.
 * 3. All 1’s must be at every possible distance from the center of the matrix.
 * The center of a n x n square is cell ((n-1)/2, (n-1)/2) for odd n.
 */
public class MatrixCreation {

    private static void createMatrix(int n) {
        if (n%2 == 0){
            System.out.println("Invalid size " + n);
            return;
        }

        int[][] matrix = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j < i + n; j++) {
                matrix[i - 1][j - i] = (j > n) ? j - n : j;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        createMatrix(3);
        createMatrix(4);
        createMatrix(5);
    }
}
