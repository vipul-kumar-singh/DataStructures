package com.vkstech.algorithms.practice3.hashing;

import java.util.HashMap;

// https://www.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1
public class AtleastKOccurrence {

    public static void main(String[] args) {
        int[] arr1 = {1, 7, 4, 3, 4, 8, 7};
        int k1 = 2;
        System.out.println(firstElementKTime(arr1, k1));

        int[] arr2 = {3, 1, 3, 4, 5, 1, 3, 3, 5, 4};
        int k2 = 3;
        System.out.println(firstElementKTime(arr2, k2));

        int[] arr3 = {10, 8, 2};
        int k3 = 10;
        System.out.println(firstElementKTime(arr3, k3));
    }

    public static int firstElementKTime(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == k)
                return num;
        }

        return -1;
    }
}
