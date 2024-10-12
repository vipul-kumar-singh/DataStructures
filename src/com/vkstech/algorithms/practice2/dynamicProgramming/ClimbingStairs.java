package com.vkstech.algorithms.practice2.dynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {

        int end = 5;
        System.out.println(waysToClimbStairs(0, end));
        System.out.println(waysToClimbStairs(end));
        System.out.println(waysToClimbStairs2(end));
        System.out.println(waysToClimbStairs3(end));
    }

    /**
     * METHOD 1
     */

    // Recursion
    private static int waysToClimbStairs(int start, int end) {
        if (start == end)
            return 1;

        if (start > end)
            return 0;

        return waysToClimbStairs(start + 1, end) + waysToClimbStairs(start + 2, end);
    }

    // DP - Top Down approach
    private static int waysToClimbStairs(int n) {
        int[] arr = new int[n + 2];
        Arrays.fill(arr, -1);
        return countWays(0, n, arr);
    }

    private static int countWays(int start, int end, int[] arr) {
        if (start == end)
            return 1;

        if (start > end)
            return 0;

        if (arr[start] != -1)
            return arr[start];

        arr[start] = countWays(start + 1, end, arr) + countWays(start + 2, end, arr);
        return arr[start];
    }

    // DP - Bottom down
    private static int waysToClimbStairs2(int end) {
        int[] arr = new int[end + 2];
        arr[end] = 1;
        arr[end + 1] = 0;

        for (int i = end - 1; i >= 0; i--) {
            arr[i] = arr[i + 1] + arr[i + 2];
        }

        return arr[0];
    }

    // DP - Bottom down - Reduced Space Complexity
    private static int waysToClimbStairs3(int end) {
        int first = 1;
        int second = 0;
        int result = 0;

        for (int i = end - 1; i >= 0; i--) {
            result = first + second;
            second = first;
            first = result;
        }

        return result;
    }


    /**
     * METHOD 2
     */

}
