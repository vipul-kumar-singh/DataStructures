package com.vkstech.algorithms.practice.arrays;

/**
 * Stock Buy Sell to Maximize Profit
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days.
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0, selling on day 3.
 * Again buy on day 4 and sell on day 6.
 * If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
public class MaximizeProfitInStocks {

    private static int getMaximumProfit(int[] arr) {
        int buyIndex = 0;
        int sellIndex = 0;
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[sellIndex] < arr[i]) {
                sellIndex = i;
            } else if (arr[sellIndex] > arr[i] && sellIndex == buyIndex) {
                buyIndex = i;
                sellIndex = i;
            } else {
                System.out.println("Buy on day " + buyIndex);
                System.out.println("Sell on day " + sellIndex);
                maxProfit += arr[sellIndex] - arr[buyIndex];
                buyIndex = sellIndex = i;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stocks = {200, 100, 180, 260, 310, 40, 535, 695, 55};
        System.out.println("Maximum Profit : " + getMaximumProfit(stocks));

        int[] stocks2 = {200, 100, 40, 5};
        System.out.println("Maximum Profit : " + getMaximumProfit(stocks2));

    }
}
