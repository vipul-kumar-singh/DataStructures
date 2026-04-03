package com.vkstech.algorithms.practice3.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarray {

    public static void main(String[] args) {
        int[] arr1 = {0, 0, 5, 5, 0, 0};
        int[] arr2 = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int[] arr3 = {0};

        System.out.println(findZeroSumSubarraysCount(arr1));
        System.out.println(findZeroSumSubarraysCount(arr2));
        System.out.println(findZeroSumSubarraysCount(arr3));
    }

    private static int findZeroSumSubarraysCount(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(sum, 1);

        int total = 0;

        for (int i : arr) {
            sum = sum + i;

            if (map.containsKey(sum)) {
                int n = map.get(sum);
                total += n;
                map.put(sum, n + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return total;
    }
}
