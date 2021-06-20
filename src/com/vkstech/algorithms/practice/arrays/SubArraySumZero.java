package com.vkstech.algorithms.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Find if there is a subarray with 0 sum
 * Input: {4, 2, -3, 1, 6}
 * Output: true
 */
public class SubArraySumZero {

    private static boolean checkSubarraySumZero(int[] arr) {
        Set<Integer> hs = new HashSet<>();
        int sum = 0;
        for (int val : arr) {
            sum += val;
            if (val == 0 || sum == 0 || hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {4, 2, -3, 1, 6};
        System.out.println(checkSubarraySumZero(input));
    }
}
