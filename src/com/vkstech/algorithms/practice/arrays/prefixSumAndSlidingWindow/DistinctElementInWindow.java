package com.vkstech.algorithms.practice.arrays.prefixSumAndSlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Count distinct elements in every window
 * Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
 * Example: Input A[] = {1,2,1,3,4,2,3}, K = 4
 * Output: 3 4 4 3
 */
public class DistinctElementInWindow {

    public static void main(String[] args) {
        int[] input = {1, 2, 1, 3, 4, 2, 3};
        int windowSize = 4;

        int[] distinctArr = findDistinctInWindow(input, windowSize);
        System.out.println(Arrays.toString(distinctArr));
    }

    private static int[] findDistinctInWindow(int[] arr, int k) {
        Map<Integer, Integer> distinctMap = new HashMap<>();
        int[] distinctArr = new int[arr.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++)
            distinctMap.merge(arr[i], 1, Integer::sum);

        distinctArr[index++] = distinctMap.size();

        for (int i = k; i < arr.length; i++) {
            int key = arr[i - k];
            int value = distinctMap.get(key);

            if (value > 1)
                distinctMap.put(key, value - 1);
            else
                distinctMap.remove(key);

            distinctMap.merge(arr[i], 1, Integer::sum);
            distinctArr[index++] = distinctMap.size();
        }

        return distinctArr;
    }
}
