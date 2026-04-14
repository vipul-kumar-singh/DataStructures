package com.vkstech.algorithms.practice3.hashing;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/largest-fibonacci-subsequence2206/1
public class LargestFibonacciSubsequence {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3, 9, 10, 13, 7};
        List<Integer> res1 = findFibSubset(arr1);
        res1.forEach(System.out::println);

        int[] arr2 = {0, 2, 8, 5, 2, 1, 4, 13, 23};
        List<Integer> res2 = findFibSubset(arr2);
        res2.forEach(System.out::println);
    }

    private static ArrayList<Integer> findFibSubset(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int num : arr) {
            if (isFibonacci(num))
                res.add(num);
        }

        return res;
    }

    private static boolean isFibonacci(int n) {
        if (n < 0)
            return false;

        return isPerfectSquare((5 * n * n) + 4) ||
                isPerfectSquare((5 * n * n) - 4);
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return n == sqrt * sqrt;
    }
}
