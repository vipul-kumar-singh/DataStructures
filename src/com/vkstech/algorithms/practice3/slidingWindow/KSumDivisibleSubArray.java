package com.vkstech.algorithms.practice3.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class KSumDivisibleSubArray {

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 3, 9, 4, 6, 9};
        System.out.println(getKSumDivisibleSubarrayCount(arr1, 7));

        int[] arr2 = {2, 3, -8, -3, 11, 4, 8, 6, 9, 4};
        System.out.println(getKSumDivisibleSubarrayCount(arr2, 7));

        int[] arr3 = {4, 5, 0, -2, -3, 1};
        System.out.println(getKSumDivisibleSubarrayCount(arr3, 5));

        int[] arr4 = {5};
        System.out.println(getKSumDivisibleSubarrayCount(arr4, 9));

    }

    private static int getKSumDivisibleSubarrayCount(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int total = 0;
        int sum = 0;

        map.put(0, 1);

        for (int i : arr) {
            sum += i;

            int m = sum % k;
            if (m < 0) {
                m += k;
            }

            if (map.containsKey(m)) {
                int val = map.get(m);
                total += val;
                map.put(m, val + 1);
            } else {
                map.put(m, 1);
            }
        }

        return total;
    }
}
