package com.vkstech.algorithms.practice2.dynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {2, 7, 9, 3, 1};
        int[] arr3 = {7, 3, 2, 8, 2, 1, 10};

        System.out.println(getMaxAmount(arr1));
        System.out.println(getMaxAmount(arr2));
        System.out.println(getMaxAmount(arr3));
        System.out.println();

        System.out.println(getMaxAmount2(arr1));
        System.out.println(getMaxAmount2(arr2));
        System.out.println(getMaxAmount2(arr3));
        System.out.println();

        System.out.println(getMaxAmount3(arr1));
        System.out.println(getMaxAmount3(arr2));
        System.out.println(getMaxAmount3(arr3));
        System.out.println();

        System.out.println(getMaxAmount4(arr1));
        System.out.println(getMaxAmount4(arr2));
        System.out.println(getMaxAmount4(arr3));
    }

    // Recursion
    private static int getMaxAmount(int[] nums) {
        int n = nums.length;
        return getMaxAmt(n - 1, nums);
    }

    private static int getMaxAmt(int n, int[] nums) {
        if (n == 0)
            return nums[0];

        if (n < 0)
            return 0;

        return Math.max(nums[n] + getMaxAmt(n - 2, nums),
                getMaxAmt(n - 1, nums));
    }

    // Recursion - DP - Top Down
    private static int getMaxAmount2(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        return getMaxAmt2(n - 1, nums, arr);
    }

    private static int getMaxAmt2(int n, int[] nums, int[] arr) {
        if (n == 0)
            return nums[0];

        if (n == 1)
            return Math.max(nums[0], nums[1]);

        if (arr[n] != -1)
            return arr[n];

        arr[n] = Math.max(nums[n] + getMaxAmt(n - 2, nums),
                getMaxAmt(n - 1, nums));

        return arr[n];
    }

    // DP - Bottom Up
    private static int getMaxAmount3(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            max[i] = Math.max(nums[i] + max[i - 2], max[i - 1]);
        }

        return max[n - 1];
    }

    // DP - Bottom up - Reduced Space Complexity
    private static int getMaxAmount4(int[] nums) {
        int n = nums.length;
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int cur = 0;

        for (int i = 2; i < n; i++) {
            cur = Math.max(nums[i] + prev2, prev);
            prev2 = prev;
            prev = cur;
        }

        return cur;
    }

}
