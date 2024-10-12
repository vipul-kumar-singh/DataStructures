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

    public int getFibonacci(int n) {
        if (arr[n] != -1)
            return arr[n];

        arr[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return arr[n];
    }

    public static void main(String[] args) {
        FibonacciUtil fibonacciUtil = new FibonacciUtil();
        System.out.println(fibonacciUtil.fibonacci(10));
        System.out.println(fibonacciUtil.getFibonacci(10));
    }
}
