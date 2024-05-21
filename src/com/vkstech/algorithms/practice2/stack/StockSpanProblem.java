package com.vkstech.algorithms.practice2.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args) {
        int[] priceArr = {100, 80, 60, 70, 60, 75, 85};
        int[] stock = calculateSpan(priceArr);

        // print the calculated span values
        System.out.print(Arrays.toString(stock));
    }

    private static int[] calculateSpan(int[] priceArr) {
        int n = priceArr.length;
        int[] stocks = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        stocks[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!stack.empty() && priceArr[stack.peek()] <= priceArr[i])
                stack.pop();

            stocks[i] = (stack.empty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return stocks;

    }
}
