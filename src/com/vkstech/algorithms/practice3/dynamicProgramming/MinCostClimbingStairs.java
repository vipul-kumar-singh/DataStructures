package com.vkstech.algorithms.practice3.dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost1));
        System.out.println(minCostClimbingStairs2(cost1));

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost2));
        System.out.println(minCostClimbingStairs2(cost2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return ways(n, cost, dp);
    }

    private static int ways(int n, int[] cost, int[] dp) {
        if(n <= 1)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = Math.min(cost[n-1] + ways(n-1, cost, dp), cost[n-2] + ways(n-2, cost, dp));
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        if(n <= 1)
            return 0;

        int prev = 0;
        int prev1 = 0;

        for (int i = 2; i <= n; i++) {
            int min = Math.min(cost[i-1] + prev, cost[i-2] + prev1);
            prev1 = prev;
            prev = min;
        }

        return prev;
    }
}
