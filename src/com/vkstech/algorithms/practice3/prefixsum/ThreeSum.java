package com.vkstech.algorithms.practice3.prefixsum;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        System.out.println(isThreeSum(arr, 13));
        System.out.println(isThreeSum(arr, 14));
        System.out.println(isThreeSum(arr, 19));
    }

    private static boolean isThreeSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            int start = i + 1;
            int end = n - 1;

            int newSum = sum - arr[i];

            while (start < end) {
                int num = arr[start] + arr[end];
                if (num == newSum) {
                    System.out.println(arr[i] + ", " + arr[start] + ", " + arr[end]);
                    return true;
                } else if (num > newSum) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return false;
    }
}
