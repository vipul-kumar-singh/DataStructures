package com.vkstech.algorithms.practice2.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FibonacciUtil {

    private final Map<Integer, Integer> map = new HashMap<>();

    private final static int[] arr = new int[100];

    static {
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
    }

    public int fibonacci(int n) {
        if (n <= 1)
            return n;

        if (map.containsKey(n))
            return map.get(n);

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        map.put(n, result);
        return result;
    }

    // top down approach
    public int getFibonacci(int n) {
        if (arr[n] != -1)
            return arr[n];

        arr[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return arr[n];
    }

    // Bottom up approach
    public int getFibonacci2(int n) {
        if (n <= 1)
            return n;

        int[] fibArr = new int[n + 1];
        fibArr[0] = 0;
        fibArr[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }

        return fibArr[n];
    }

    // Reducing Space complexity
    public int getFibonacci3(int n) {
        if (n <= 1)
            return n;

        int first = 0;
        int second = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }

    public static void main(String[] args) {
        FibonacciUtil fibonacciUtil = new FibonacciUtil();
        System.out.println(fibonacciUtil.fibonacci(10));
        System.out.println(fibonacciUtil.getFibonacci(10));
        System.out.println(fibonacciUtil.getFibonacci2(10));
        System.out.println(fibonacciUtil.getFibonacci3(10));
    }
}
