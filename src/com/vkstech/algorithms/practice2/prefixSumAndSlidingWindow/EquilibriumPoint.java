package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

import java.util.Arrays;

/**
 * Given an array arr of non-negative numbers.
 * The task is to find the first equilibrium point in an array.
 * The equilibrium point in an array is an index (or position) such that
 * the sum of all elements before that index is the same as the sum of elements after it.
 */
public class EquilibriumPoint {

    private static int getEquilibriumPoint(int[] arr) {
        if (arr.length == 0)
            return -1;

        if (arr.length == 1)
            return arr[0];

        int lSum = arr[0];
        int rSum = Arrays.stream(arr).sum() - lSum;

        for (int i = 1; i < arr.length; i++) {
            rSum = rSum - arr[i];
            if (rSum == lSum)
                return i;
            lSum += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 4};
        System.out.println(getEquilibriumPoint(arr));
    }
}
