package com.vkstech.algorithms.practice3.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

// https://www.geeksforgeeks.org/problems/find-distinct-elements2054/1
public class FindDistinct {

    public static void main(String[] args) {
        int[][] mat1 = {{2, 1, 4, 3},
                {1, 2, 3, 2},
                {3, 6, 2, 3},
                {5, 2, 5, 3}};
        System.out.println(distinct(mat1, mat1.length));

        int[][] mat2 = {{12, 1, 14, 3, 16},
                {14, 2, 1, 3, 35},
                {14, 1, 14, 3, 11},
                {14, 5, 3, 2, 1},
                {1, 18, 3, 21, 14}};
        System.out.println(distinct(mat2, mat2.length));
    }

    private static int distinct(int[][] mat, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] arr : mat) {
            Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toSet())
                    .forEach(key -> map.put(key, map.getOrDefault(key, 0) + 1));
        }

        return (int) map.entrySet().stream().filter(entry -> entry.getValue() == n).count();
    }

    static int distinctOptimized(int[][] M, int N) {
        int maxVal = 100000;
        int[] freq = new int[maxVal + 1];

        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[maxVal + 1];

            for (int j = 0; j < N; j++) {
                int val = M[i][j];
                if (!seen[val]) {
                    freq[val]++;
                    seen[val] = true;
                }
            }
        }

        int count = 0;
        for (int x = 1; x <= maxVal; x++) {
            if (freq[x] == N) count++;
        }

        return count;
    }

}
