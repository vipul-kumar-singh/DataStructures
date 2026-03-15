package com.vkstech.algorithms.practice3.prefixsum;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int[] arr1 = {3, 4, -5, 8, -12, 7, 6, -2};
        System.out.println(findMaxSumSubarray(arr1));

        int[] arr2 = {-3, -4, -5,-8, -12, -7, -6, -2};
        System.out.println(findMaxSumSubarray(arr2));
    }

    // Kadane's Algorithm
    private static int findMaxSumSubarray(int[] arr) {
        int max = arr[0];
        int prefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix = Math.max(prefix + arr[i], arr[i]);
            max = Math.max(max, prefix);
        }

        return max;
    }
}
