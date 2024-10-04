package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers.
 * Find if there is a subarray (of size at-least one) with 0 sum.
 * You just need to return true/false depending upon whether there is a subarray present with 0-sum or not.
 * Printing will be taken care by the driver code.
 */
public class SubArrayWithZeroSum {

    private static boolean isSubArrayWithZeroSumExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (sum == 0)
                return true;

            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0)
                    return true;
            }
        }
        return false;
    }

    private static boolean isSubArrayWithZeroSumExistOptimized(int[] arr) {
        Set<Integer> set = new HashSet<>();

        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (num == 0 || sum == 0 || set.contains(sum))
                return true;

            set.add(sum);
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {10, 2, -3, 1, 8};
        System.out.println(isSubArrayWithZeroSumExistOptimized(arr));
    }

}
