package com.vkstech.algorithms.practice3.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1
public class DistinctPairWithDifference {

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 4, 1, 2};
        int k1 = 0;
        System.out.println(totalPairs(arr1, k1));

        int[] arr2 = {1, 5, 3};
        int k2 = 2;
        System.out.println(totalPairs(arr2, k2));
    }

    private static int totalPairs(int[] nums, int k) {

        if (k < 0) return 0; // difference cannot be negative

        // Case 1: k == 0 → count duplicates
        if (k == 0) {
            Map<Integer, Integer> freq = new HashMap<>();
            int count = 0;

            for (int x : nums) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            for (int val : freq.values()) {
                if (val > 1) count++;
            }

            return count;
        }

        // Case 2: k > 0 → check x-k existence
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);

        int count = 0;
        for (int x : set) {
            if (set.contains(x - k)) {
                count++;
            }
        }

        return count;
    }
}
