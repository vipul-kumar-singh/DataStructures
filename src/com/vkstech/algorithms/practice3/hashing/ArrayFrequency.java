package com.vkstech.algorithms.practice3.hashing;

import java.util.*;

// https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1
public class ArrayFrequency {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 2, 3, 5};
        System.out.println(frequencyCount(arr1));

        int[] arr2 = {3, 3, 3, 3};
        System.out.println(frequencyCount(arr2));

        int[] arr3 = {1};
        System.out.println(frequencyCount(arr3));
    }

    private static List<Integer> frequencyCount(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(arr).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        for (int i = 1; i <= arr.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
        }

        return new ArrayList<>(map.values());
    }
}
