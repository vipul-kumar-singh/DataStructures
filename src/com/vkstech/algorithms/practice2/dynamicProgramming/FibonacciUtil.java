package com.vkstech.algorithms.practice2.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciUtil {

    private final Map<Integer, Integer> map = new HashMap<>();

    public int fibonacci(int n) {
        if (n <= 1)
            return n;

        if (map.containsKey(n))
            return map.get(n);

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciUtil fibonacciUtil = new FibonacciUtil();
        System.out.println(fibonacciUtil.fibonacci(10));
    }
}
