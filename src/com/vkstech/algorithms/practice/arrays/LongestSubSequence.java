package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Subsequence
 * Given an array of integers, find the length of the longest sub-sequence such that elements
 * in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
 * Output: 4
 * Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
 */
public class LongestSubSequence {

    // Method 1
    private static int getLongestSubSequence(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int max = 0;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((cur + 1) == arr[i]) {
                count++;
                cur = arr[i];
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(getLongestSubSequence(input1));
        System.out.println(findLongestSubSequence(input1));

    }

    //Method 2
    static int findLongestSubSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int val : arr) set.add(val);

        for (int val : arr) {
            if (!set.contains(val - 1)) {
                int cur = val;

                while (set.contains(cur))
                    cur++;

                count = Math.max(count, cur - val);
            }
        }
        return count;
    }
}
