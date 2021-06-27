package com.vkstech.algorithms.practice.arrays;

/**
 * Print a given matrix in spiral form
 */
public class SpiralMatrix {

    private static final String SPACE = " ";

    private static void printSpiral(int[][] arr, int r, int c) {
        int m = 0;
        int n = 0;
        int loop = 0;
        int i = r*c;
        while (i > 0) {
            if (m == loop && n == loop) {
                while (n < c) {
                    System.out.print(arr[m][n++] + SPACE);
                    i--;
                }
                n--;
            } else if (m == loop && n == c -1){
                while(m < r-1){
                    System.out.print(arr[++m][n] + SPACE);
                    i--;
                }
            } else if ( m  == r - 1 && n == c - 1){
                while(n > loop){
                    System.out.print(arr[m][--n] + SPACE);
                    i--;
                }
            } else {
                while (m > loop + 1) {
                    System.out.print(arr[--m][n] + SPACE);
                    i--;
                }
                loop++;
                n++;
                c--;
                r--;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int r = 3;
        int c = 6;
        int[][] input = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};

        // Function Call
        printSpiral(input, r, c);

        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        printSpiral(a, 4, 4);
    }
}
