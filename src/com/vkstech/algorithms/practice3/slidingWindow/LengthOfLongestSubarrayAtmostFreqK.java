package com.vkstech.algorithms.practice3.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayAtmostFreqK {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 2, 3, 3, 4, 1, 2};
        System.out.println(findLength(arr1, 2));

        int[] arr2 = {1, 4, 4, 3};
        System.out.println(findLength(arr2, 1));
    }

    private static int findLength(int[] arr, int k) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        int n = arr.length;

        while (end < n) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.get(arr[end]) > k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                start++;
            }

            len = Math.max(len, end - start + 1);
            end++;
        }

        return len;
    }
}
