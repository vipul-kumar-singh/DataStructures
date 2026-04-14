package com.vkstech.algorithms.practice3.hashing;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1
public class EqualArrays {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 5, 4, 0}, b1 = {2, 4, 5, 0, 1};
        System.out.println(checkEqual(a1, b1));

        int[] a2 = {1, 2, 5}, b2 = {2, 4, 15};
        System.out.println(checkEqual(a2, b2));
    }

    public static boolean checkEqual(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (!map.containsKey(num)) {
                return false;
            }

            if (map.get(num) == 1) {
                map.remove(num);
            } else {
                map.put(num, map.get(num) - 1);
            }

        }

        return true;
    }
}
