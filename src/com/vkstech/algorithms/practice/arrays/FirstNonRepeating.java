package com.vkstech.algorithms.practice.arrays;

import java.util.*;

/**
 * Find the first non-repeating element in a given array of integers.
 */
public class FirstNonRepeating {

    private static int getFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : arr){
            countMap.merge(val, 1, Integer::sum);
        }
        for (int val : arr){
            if (countMap.get(val) == 1)
                return val;
        }
        throw new RuntimeException("No element is non repeating");
    }

    public static void main(String[] args) {
        int[] input = {-1, 2, -1, 3, 2};
        System.out.println(getFirstNonRepeating(input));
    }
}
