package com.vkstech.algorithms.practice3.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
public class StockSpan {

    public static void main(String[] args) {
        int[] arr1 = {100, 80, 90, 120};
        ArrayList<Integer> res1 = calculateSpan(arr1);
        System.out.println(res1);

        int[] arr2 = {10, 4, 5, 90, 120, 80};
        ArrayList<Integer> res2 = calculateSpan(arr2);
        System.out.println(res2);

    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        Integer[] res = new Integer[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                res[stack.peek()] = stack.pop() - i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.peek()] = stack.pop() + 1;
        }

        return new ArrayList<>(Arrays.asList(res));
    }
}
