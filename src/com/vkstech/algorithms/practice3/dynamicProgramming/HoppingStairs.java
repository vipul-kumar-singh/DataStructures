package com.vkstech.algorithms.practice3.dynamicProgramming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1?page=1&difficulty%5B%5D=0&category%5B%5D=Dynamic%2520Programming&sortBy=submissions
public class HoppingStairs {

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println(countWaysWithDPTopDown(n1));
        System.out.println(countWaysWithDPBottomUp(n1));

        int n2 = 4;
        System.out.println(countWaysWithDPTopDown(n2));
        System.out.println(countWaysWithDPBottomUp(n2));
    }

    public static int countWaysWithDPTopDown(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return DPTopDownHelper(n, dp);
    }

    private static int DPTopDownHelper(int n, int[] dp) {
        if (n <= 1)
            return 1;

        if (n == 2)
            return 2;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = DPTopDownHelper(n - 1, dp) + DPTopDownHelper(n - 2, dp) + DPTopDownHelper(n - 3, dp);
        return dp[n];
    }

    private static int countWaysWithDPBottomUp(int n) {
        if (n <= 1)
            return 1;

        if (n == 2)
            return 2;

        int first = 1;
        int second = 1;
        int third = 2;

        for (int i = 3; i <= n; i++) {
            int cur = first + second+third;
            first = second;
            second = third;
            third = cur;
        }

        return third;
    }
}
