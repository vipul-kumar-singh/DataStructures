package com.vkstech.algorithms.practice.arrays;

/**
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 * Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
 * Output: 6  (j = 7, i = 1)
 */
public class MaxIndexDiff {

    public static int getMaxIndexDiff(int[] arr) {
        int n = arr.length;
        int maxDiff;
        int i;
        int j;

        int[] rMax = new int[n];
        int[] lMin = new int[n];

        lMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            lMin[i] = Math.min(arr[i], lMin[i - 1]);

        rMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            rMax[j] = Math.max(arr[j], rMax[j + 1]);

        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (lMin[i] < rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else
                i++;
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(getMaxIndexDiff(input));
    }
}
