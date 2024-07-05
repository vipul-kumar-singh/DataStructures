package com.vkstech.algorithms.practice2.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashingOperations {

    public static void findCommonElements(int[][] mat) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int[] arr = mat[i];

            for (int j = 0; j < arr.length; j++) {
                Integer temp = map.get(mat[i][j]);

                if (temp == null)
                    map.put(mat[i][j], 1);
                else if (temp == i)
                    map.put(mat[i][j], temp + 1);

            }
        }

        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == mat.length)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static int[] frequencyMatch(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        int[] result = new int[arr.length];

        for (int i = 1; i <= result.length; i++) {
            Integer count = map.get(i);
            result[i - 1] = count != null ? count : 0;
        }

        return result;
    }

    public static boolean isEqualArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int num : arr2) {
            if (!map.containsKey(num))
                return false;
            else
                map.put(num, map.get(num) - 1);
        }

        for (Integer num : map.values()) {
            if (num > 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{2, 1, 4, 3},
                {1, 2, 3, 2},
                {3, 6, 2, 3},
                {5, 2, 5, 3}};
        findCommonElements(mat1);

        int[][] mat2 = {{12, 1, 14, 3, 16},
                {14, 2, 1, 3, 35},
                {14, 1, 14, 3, 11},
                {14, 5, 3, 2, 1},
                {1, 18, 3, 21, 14}};
        findCommonElements(mat2);

        int[] arr1 = {2, 3, 2, 3, 5};
        int[] result = frequencyMatch(arr1);
        System.out.println(Arrays.toString(result));

        int[] arr2 = {1, 2, 5, 4, 0};
        int[] arr3 = {2, 4, 5, 0, 1};
        System.out.println(isEqualArrays(arr2, arr3));
    }
}
