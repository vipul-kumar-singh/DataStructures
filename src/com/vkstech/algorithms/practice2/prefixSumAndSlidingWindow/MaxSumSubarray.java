package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

/**
 * Given an array of integers Arr of size N and a number K.
 * Return the maximum sum of a subarray of size K.
 */
public class MaxSumSubarray {

    private static int getMaxSumSubArray(int[] arr, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {900, 200, 300, 400};
        int k = 2;

        System.out.println(getMaxSumSubArray(arr, k));
    }

}
