package com.vkstech.algorithms.practice3.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
public class ArraySubset {

    public static void main(String[] args) {
        int[] a1 = {11, 7, 1, 13, 21, 3, 7, 3}, b1 = {11, 3, 7, 1, 7};
        System.out.println(isSubset(a1, b1));

        int[] a2 = {1, 2, 3, 4, 4, 5, 6}, b2 = {1, 2, 4};
        System.out.println(isSubset(a2, b2));

        int[] a3 = {10, 5, 2, 23, 19}, b3 = {19, 5, 3};
        System.out.println(isSubset(a3, b3));

        int[] a4 = {1, 2, 2}, b4 = {1, 1};
        System.out.println(isSubset(a4, b4));
    }

    private static boolean isSubset(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        return Arrays.stream(b).allMatch(num -> {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                return true;
            } else
                return false;
        });
    }
}
