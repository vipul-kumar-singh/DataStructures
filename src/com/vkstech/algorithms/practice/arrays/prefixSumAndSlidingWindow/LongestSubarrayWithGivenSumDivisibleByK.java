package com.vkstech.algorithms.practice.arrays.prefixSumAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest subarray with sum divisible by K
 * Given an array containing N integers and a positive integer K,
 * find the length of the longest sub array with sum of the elements divisible by the given value K.
 * Example : A[] = {2, 7, 6, 1, 4, 5}, K = 3
 * Output : 4
 * Explanation: The subarray is {7, 6, 1, 4}, with sum 18, which is divisible by 3.
 */
public class LongestSubarrayWithGivenSumDivisibleByK {

    public static void main(String[] args) {
        int[] input = {2, 7, 6, 1, 4, 5};
        int k = 3;

        System.out.println(findLongestSubarrayWithSumDivisibleByK(input, k));
    }

    private static int findLongestSubarrayWithSumDivisibleByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] modArr = new int[arr.length];

        int maxLen = 0;
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            modArr[i] = ((curSum % k) + k) % k; //taking modulo twice as the sum can be negative
        }

        for (int i = 0; i < arr.length; i++) {
            if (modArr[i] == 0) {
                maxLen = i + 1;
            } else if (!map.containsKey(modArr[i])) {
                map.put(modArr[i], i);
            } else if (maxLen < (i - map.get(modArr[i]))) {
                maxLen = i - map.get(modArr[i]);
            }
        }

        return maxLen;
    }

}
