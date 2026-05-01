package com.vkstech.algorithms.practice3.dynamicProgramming;

// https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber2 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        System.out.println(rob(nums1));

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(rob(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println(rob(nums3));

    }

    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        if (n == 2)
            return Math.max(nums[0], nums[1]);


        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
        }

        int max1 = HouseRobber.rob(nums1);
        int max2 = HouseRobber.rob(nums2);

        return Math.max(max1, max2);
    }
}