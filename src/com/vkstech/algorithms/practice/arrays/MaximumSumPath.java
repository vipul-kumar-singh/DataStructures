package com.vkstech.algorithms.practice.arrays;

/**
 * Maximum Sum Path in Two Arrays
 * Given two sorted arrays, such that the arrays may have some common elements.
 * Find the sum of the maximum sum path to reach from the beginning of any array to end of any of the two arrays.
 * We can switch from one array to another array only at common elements.
 * Note: The common elements do not have to be at the same indexes.
 * Input: ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}
 * ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}
 * Output: 122
 * Explanation: 122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34
 */
public class MaximumSumPath {

    private static int getMaximumSumPath(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;

        int max = 0;
        int sum1 = 0;
        int sum2 = 0;

        while (i < arr1.length || j < arr2.length) {
            if (i == arr1.length && j < arr2.length){
                max += arr2[j++];
            } else if (j == arr2.length && i < arr1.length){
                max += arr1[i++];
            } else if (arr1[i] < arr2[j]) {
                sum1 += arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j++];
            } else if (arr1[i] == arr2[j]) {
                sum1 += arr1[i++];
                sum2 += arr2[j++];
                max += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, 8, 10, 15, 16, 19};
        int[] arr2 = {2, 3, 7, 10, 12, 15, 30, 34};
        System.out.println(getMaximumSumPath(arr1, arr2));
    }
}
