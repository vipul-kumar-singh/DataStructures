package com.vkstech.algorithms.practice2.array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, 27};
        int sum = 22;
        findTwoSum(sum, arr);
        findTwoSumWithoutCollections(sum, arr);
    }

    private static void findTwoSum(int sum, int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(sum - num)) {
                System.out.println(num + " + " + (sum - num) + " = " + sum);
                break;
            } else {
                set.add(num);
            }
        }
    }

    // arr should be sorted
    private static void findTwoSumWithoutCollections(int sum, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int num = arr[start] + arr[end];
            if (num == sum) {
                System.out.println(arr[start] + " + " + arr[end] + " = " + sum);
                break;
            } else if (num > sum) {
                end--;
            } else {
                start++;
            }
        }
    }
}
