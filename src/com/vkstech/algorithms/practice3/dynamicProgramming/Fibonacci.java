package com.vkstech.algorithms.practice3.dynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciTopDown(5));
        System.out.println(fibonacciTopDown(6));
        System.out.println(fibonacciTopDown(0));
        System.out.println(fibonacciTopDown(1));
        System.out.println(fibonacciTopDown(2));

        System.out.println(fibonacciBottomUp(5));
        System.out.println(fibonacciBottomUp(6));
        System.out.println(fibonacciBottomUp(0));
        System.out.println(fibonacciBottomUp(1));
        System.out.println(fibonacciBottomUp(2));
    }

    public static int fibonacciTopDown(int n) {
        if (n < 2) {
            return n;
        }

        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;

        return calculateFibonacci(n, arr);
    }

    private static int calculateFibonacci(int n, int[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }

        arr[n] = calculateFibonacci(n - 1, arr) + calculateFibonacci(n - 2, arr);
        return arr[n];
    }

    public static int fibonacciBottomUp(int n) {
        if (n < 2) {
            return n;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
}
