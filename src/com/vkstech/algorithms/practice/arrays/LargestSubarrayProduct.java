package com.vkstech.algorithms.practice.arrays;

/**
 * Maximum Product Subarray
 * Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
 */
public class LargestSubarrayProduct {

    private static int largestProduct(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];

        max[0] = min[0] = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                max[i] = Math.max(arr[i], max[i - 1] * arr[i]);
                min[i] = Math.min(arr[i], min[i - 1] * arr[i]);
            } else {
                max[i] = Math.max(arr[i], min[i - 1] * arr[i]);
                min[i] = Math.min(arr[i], max[i - 1] * arr[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {6, -3, -10, 0, 2};
        System.out.println(largestProduct(input1));

        int[] input2 = {-1, -3, -10, 0, 60};
        System.out.println(largestProduct(input2));

        int[] input3 = {-2, -40, 0, -2, -3};
        System.out.println(largestProduct(input3));
    }
}
