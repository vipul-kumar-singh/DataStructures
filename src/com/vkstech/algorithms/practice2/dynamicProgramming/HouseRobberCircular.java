package com.vkstech.algorithms.practice2.dynamicProgramming;

public class HouseRobberCircular {

    public static void main(String[] args) {
        int[] arr0 = {2, 3, 2};
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {2, 7, 9, 3, 1};
        int[] arr3 = {7, 3, 2, 8, 2, 1, 10};

        System.out.println(getMaxAmount(arr0));
        System.out.println(getMaxAmount(arr1));
        System.out.println(getMaxAmount(arr2));
        System.out.println(getMaxAmount(arr3));
    }

    private static int getMaxAmount(int[] nums) {
        int n = nums.length;

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int cur = prev;

        for (int i = 2; i < n - 1; i++) {
            cur = Math.max(nums[i] + prev2, prev);
            prev2 = prev;
            prev = cur;
        }

        prev2 = nums[1];
        prev = Math.max(nums[1], nums[2]);
        int cur2 = prev;

        for (int i = 3; i < n; i++) {
            cur2 = Math.max(nums[i] + prev2, prev);
            prev2 = prev;
            prev = cur2;
        }

        return Math.max(cur, cur2);
    }
}
