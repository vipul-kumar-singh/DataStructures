package com.vkstech.algorithms.practice.arrays.prefixSumAndSlidingWindow;

/**
 * Max Sum Subarray of size K
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] input = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(getMaxSum(input, 4));
    }

    private static int getMaxSum(int[] arr, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++)
            windowSum += arr[i];

        int maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
