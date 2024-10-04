package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of 0s and 1s. Find the length of the largest subarray with equal number of 0s and 1s.
 */
public class LargestSubArray01 {

    public static int getLargestSubArray01(int[] arr) {

        // Replace all zeroes with -1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        int sum = 0;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // add current element to sum
            sum += arr[i];

            // if sum is zero, then max is index + 1
            if (sum == 0) {
                max = i + 1;
            }

            if (map.containsKey(sum)) {
                if (max < i - map.get(sum)) {
                    max = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 0, 0, 1};
        System.out.println(getLargestSubArray01(arr));
    }
}
