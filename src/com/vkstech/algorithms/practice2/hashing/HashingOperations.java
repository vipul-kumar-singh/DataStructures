package com.vkstech.algorithms.practice2.hashing;

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
    }
}
