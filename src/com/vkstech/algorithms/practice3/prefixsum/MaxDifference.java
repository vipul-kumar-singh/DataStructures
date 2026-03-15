package com.vkstech.algorithms.practice3.prefixsum;

public class MaxDifference {

    public static void main(String[] args) {
        int[] arr = {9, 5, 8, 12, 2, 3, 7, 4};
        System.out.println(findMaxDifference(arr));
    }

    private static int findMaxDifference(int[] arr) {
        int n = arr.length;
        int[] suffixArr = new int[n];
        int maxSuffix = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            maxSuffix = Math.max(maxSuffix, arr[i]);
            suffixArr[i] = maxSuffix;
        }

        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, suffixArr[i] - arr[i]);
        }

        return maxDiff;
    }
}
