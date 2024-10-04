package com.vkstech.algorithms.practice2.prefixSumAndSlidingWindow;

import java.util.HashMap;

/**
 * Given an array of integers and a number K.
 * Find the count of distinct elements in every window of size K in the array.
 */
public class DistinctInWindow {

    private static void countDistinct(int[] arr, int k) {
        if (arr.length < k)
            return;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map.size());

        for (int i = k; i < arr.length; i++) {
            //remove old element
            int num = arr[i - k];
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }

            //add current element
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.println(map.size());

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        countDistinct(arr, k);
    }

}
