package com.vkstech.algorithms.practice3.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDifferentInteger {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        System.out.println(findSubarray(arr, 2));
    }

    private static int findSubarray(int[] arr, int k) {
        int kCount = calculateAtleast(arr, k);
        int kPlusCount = calculateAtleast(arr, k + 1);
        return kPlusCount - kCount;
    }

    private static int calculateAtleast(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int n = arr.length;
        int count = 0;
        int total = 0;

        while (end < n) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            if (map.get(arr[end]) == 1) {
                count++;
            }

            while (count == k) {
                total += end - n;
                map.put(arr[start], map.get(arr[start]) - 1);

                if (map.get(arr[start]) == 0)
                    count--;

                start++;
            }

            end++;
        }

        return total;
    }
}
