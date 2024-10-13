package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

import java.util.HashMap;

/**
 * Given an array arr containing n integers and an integer k.
 * Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value k
 */
public class LongestSubArraySum {

    private static int getLongestSubArraySum(int[] arr, int k) {
        int prefixSum = 0;
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefix sum is same as k, we have a prefix subarray from 0 to i
            if (prefixSum == k) {
                result = i + 1;
            }

            // Check if prefixSum - k exists in the map
            if (map.containsKey(prefixSum - k)) {
                result = Math.max(result, i - map.get(prefixSum - k));
            }

            // Insert prefixSum in the map if not already present
            map.putIfAbsent(prefixSum, i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 2, 6, 9};
        int k = 15;
        System.out.println(getLongestSubArraySum(arr, k));
    }
}
