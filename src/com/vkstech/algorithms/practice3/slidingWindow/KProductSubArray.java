package com.vkstech.algorithms.practice3.slidingWindow;

public class KProductSubArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 5, 10, 8, 100, 1000, 5, 15};
        System.out.println(findSubArrayProductLessThanKCount(arr1, 999));

        int[] arr2 = {1, 2, 3};
        System.out.println(findSubArrayProductLessThanKCount(arr2, 0));

    }

    private static int findSubArrayProductLessThanKCount(int[] nums, int k) {
        int start = 0;
        int end = 0;

        int product = 1;
        int count = 0;

        int n = nums.length;

        while (end < n) {
            product *= nums[end];

            while (product >= k && start <= end) {
                product /= nums[start];
                start++;
            }

            count += (end - start + 1);
            end++;
        }
        return count;
    }
}
