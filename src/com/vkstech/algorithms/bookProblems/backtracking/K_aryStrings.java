package com.vkstech.algorithms.bookProblems.backtracking;

import java.util.Arrays;

/**
 * Generate all the strings of length n drawn from 0...k-1
 */
public class K_aryStrings {
    int[] arr;

    public K_aryStrings(int n) {
        arr = new int[n];
    }

    public void base_K_strings(int n, int k) {
        if (n <= 0) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = 0; i < k; i++) {
                arr[n - 1] = i;
                base_K_strings(n - 1, k);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        K_aryStrings obj = new K_aryStrings(n);
        obj.base_K_strings(n, k);
    }
}
