package com.vkstech.algorithms.practice3.dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/description/
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1));
        System.out.println(rob2(nums1));

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums2));
        System.out.println(rob2(nums2));

        int[] nums3 = {1, 2};
        System.out.println(rob(nums3));
        System.out.println(rob2(nums3));

        int[] nums4 = {1, 3, 1};
        System.out.println(rob(nums4));
        System.out.println(rob2(nums4));

    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return ways(n - 1, nums, dp);
    }

    private static int ways(int n, int[] nums, int[] dp) {
        if (n == 0)
            return nums[0];

        if (n == 1)
            return Math.max(nums[0], nums[1]);

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = Math.max(nums[n] + ways(n - 2, nums, dp), ways(n - 1, nums, dp));
    }

    public static int rob2(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int max = Math.max(nums[i] + first, second);
            first = second;
            second = max;
        }

        return second;
    }
}
