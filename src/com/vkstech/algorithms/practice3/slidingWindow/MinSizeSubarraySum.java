package com.vkstech.algorithms.practice3.slidingWindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinSizeSubarraySum {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 2, 4, 3};
        System.out.println(findMinSizeSubarraySum(arr1, 7));
    }

    private static int findMinSizeSubarraySum(int[] arr, int k) {
        int start = 0;
        int end = 0;

        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (start < n && end < n) {
            sum += arr[end];

            while (sum >= k && start <= end) {
                min = Math.min(min, (end - start + 1));
                sum -= arr[start];
                start++;
            }

            end++;
        }

        return min;
    }
}
