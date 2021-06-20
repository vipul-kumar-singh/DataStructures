package com.vkstech.algorithms.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find duplicates in O(n) time and O(1) extra space
 * Array of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of time
 * Input array[] = {1, 2, 3, 6, 3, 6, 1}
 * Output: 1, 3, 6
 */
public class DuplicateCount {

    private static void countDuplicatesO1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                System.out.println(i + " ");
            }
        }
    }

    private static void countDuplicates(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : arr)
            countMap.merge(val, 1, Integer::sum);
        countMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 6, 3, 6, 1};
        countDuplicatesO1(input);
    }

}
