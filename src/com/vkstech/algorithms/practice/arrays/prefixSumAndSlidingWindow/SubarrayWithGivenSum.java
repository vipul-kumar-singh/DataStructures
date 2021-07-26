package com.vkstech.algorithms.practice.arrays.prefixSumAndSlidingWindow;

/**
 * Subarray with given sum
 * Given an unsorted array A of size N that contains only non-negative integers,
 * find a continuous sub-array which adds to a given number S.
 */
public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 7, 5};
        int sum = 12;
        findSubarrayWithSum(input, sum);
    }

    private static void findSubarrayWithSum(int[] arr, int sum) {
        int i = 0;
        int j = 0;
        int curSum = 0;

        while (j != arr.length || i != arr.length) {
            if (curSum == sum) {
                break;
            } else if (curSum < sum && j < arr.length) {
                curSum += arr[j++];
            } else {
                curSum -= arr[i++];
            }
        }

        if (curSum != sum) {
            System.out.println("Sum not found!");
            return;
        }

        for (; i < j; i++) {
            System.out.println(arr[i]);
        }
    }
}
