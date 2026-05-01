package com.vkstech.algorithms.practice3.dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/description/
// https://www.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1?page=1&difficulty%5B%5D=0&category%5B%5D=Dynamic%2520Programming&sortBy=submissions
// Reverse Fibonacci of n+1
public class ClimbingStairs {

    public static void main(String[] args) {
        int n1 = 5;
        System.out.println(countWaysWithBruteForce(n1));
        System.out.println(countWaysWithDPTopDown(n1));
        System.out.println(countWaysWithDPBottomUp(n1));
    }

    public static int countWaysWithBruteForce(int n) {
        return bruteForceHelper(n, 0);
    }

    private static int bruteForceHelper(int n, int cur) {
        if (cur == n) {
            return 1;
        }

        if (cur > n) {
            return 0;
        }

        return bruteForceHelper(n, cur + 1)
                + bruteForceHelper(n, cur + 2);
    }

    public static int countWaysWithDPTopDown(int n) {
        int[] dp = new int[n + 2];
        Arrays.fill(dp, -1);
        return DPTopDownHelper(n, 0, dp);
    }

    private static int DPTopDownHelper(int n, int cur, int[] dp) {
        if (cur == n) {
            return 1;
        }

        if (cur > n) {
            return 0;
        }

        if (dp[cur] != -1) {
            return dp[cur];
        }

        dp[cur] = DPTopDownHelper(n, cur + 1, dp)
                + DPTopDownHelper(n, cur + 2, dp);
        return dp[cur];
    }

    private static int countWaysWithDPBottomUp(int n) {

        int nextnext = 0;
        int next = 1;

        for (int i = n-1; i >= 0; i--) {
            int cur = next + nextnext;
            nextnext = next;
            next = cur;
        }

        return next;
    }
}
