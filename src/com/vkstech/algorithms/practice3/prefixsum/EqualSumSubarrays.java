package com.vkstech.algorithms.practice3.prefixsum;

public class EqualSumSubarrays {

    public static void main(String[] args) {
        int[] arr = {3, 4, -2, 5, 8, 20, -10, 8};
        System.out.println(isEqualSubArraySumExist(arr));
    }

    private static boolean isEqualSubArraySumExist(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        int prefixSum = 0;

        for (int i : arr) {
            prefixSum += i;
            if (prefixSum == sum - prefixSum)
                return true;
        }

        return false;
    }
}
