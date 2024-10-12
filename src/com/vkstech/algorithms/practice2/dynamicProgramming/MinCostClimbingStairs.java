package com.vkstech.algorithms.practice2.dynamicProgramming;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCost(cost));
    }

    private static int minCost(int[] cost) {
        int n = cost.length;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return getMinCost(n, cost, arr);
    }

    private static int getMinCost(int n, int[] cost, int[] arr) {
        if (n <= 1)
            return 0;

        if (arr[n] != -1)
            return arr[n];

        arr[n] = Math.min(cost[n - 1] + getMinCost(n - 1, cost, arr),
                cost[n - 2] + getMinCost(n - 2, cost, arr));

        return arr[n];

    }


}
