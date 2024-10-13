package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

/**
 * Maximum Difference between Two Elements such that Larger Element Appears after the Smaller Element
 */
public class MaxDiffBetweenElements {

    public static int findMaxDiff(int[] arr) {
        int[] suffixMax = new int[arr.length];

        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            suffixMax[i] = max;
        }

        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            diff = Math.max(diff, suffixMax[i] - arr[i]);
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(findMaxDiff(arr));

        int[] arr2 = {7, 9, 5, 6, 3, 2};
        System.out.println(findMaxDiff(arr2));

    }
}
