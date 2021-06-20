package com.vkstech.algorithms.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the first repeating element in an array of integers
 */
public class FirstRepeating {

    private static int getFirstRepeating(int[] arr) {
        Set<Integer> sumSet = new HashSet<>(arr.length);
        int min= 0;
        for (int i = arr.length-1; i >= 0; i--) {
            int val = arr[i];
            if (sumSet.contains(val))
                min = val;
            sumSet.add(val);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] input = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(getFirstRepeating(input));
    }
}
