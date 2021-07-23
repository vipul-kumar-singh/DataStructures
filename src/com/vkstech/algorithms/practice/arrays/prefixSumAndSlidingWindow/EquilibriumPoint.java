package com.vkstech.algorithms.practice.arrays.prefixSumAndSlidingWindow;

/**
 * Equilibrium Point
 * Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
 * Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
 * Example 1: Input: {1}, Output: 1
 * Explanation: Since its the only element hence its the only equilibrium point.
 * Example 2: Input: {1,3,5,2,2}, Output: 3
 * Explanation: Equilibrium point is at position 3 as elements before it (1+3) = elements after it (2+2).
 */
public class EquilibriumPoint {

    public static void main(String[] args) {
        int[] input1 = {1, 3, 5, 2, 2};
        System.out.println(getEquilibriumPoint(input1));

        int[] input2 = {1};
        System.out.println(getEquilibriumPoint(input2));
    }

    private static int getEquilibriumPoint(int[] arr) {
        if (arr.length == 1)
            return 1;

        int leftSum = arr[0];
        int rightSum = 0;

        for (int val : arr)
            rightSum += val;

        int eq = -1;
        rightSum -= leftSum;

        for (int i = 1; i < arr.length; i++) {
            rightSum -= arr[i];

            if (leftSum == rightSum) {
                eq = i + 1;
                break;
            }

            leftSum += arr[i];
        }

        return eq;
    }
}
