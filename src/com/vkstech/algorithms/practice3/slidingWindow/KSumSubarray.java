package com.vkstech.algorithms.practice3.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class KSumSubarray {

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 7, -4, 2, 1, 3, 4, -15, 2, -3, 6};
        System.out.println(findKSumSubarrayCount(arr1, 6));

        int[] arr2 = {3, 4, 5, 3, -6, 4, -2, 12};
        System.out.println(findKSumSubarrayCount(arr2, 8));
    }

    private static int findKSumSubarrayCount(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int total = 0;
        int sum = 0;
        map.put(sum, 1);

        for (int i : arr) {
            sum += i;
            int key = sum - k;

            if (map.containsKey(key)) {
                total += map.get(key);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return total;
    }
}
