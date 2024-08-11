package com.vkstech.algorithms.practice2.interview;

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

    public static void main(String[] args) {
        int[] input1 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(findLongestSubSequence(input1));

    }

}
