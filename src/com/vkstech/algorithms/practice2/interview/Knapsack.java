package com.vkstech.algorithms.practice2.interview;

public class Knapsack {

    private static int knapsack(int[] wt, int[] val, int w) {
        int n = wt.length;

        int[] prev = new int[w + 1];

        for (int i = wt[0]; i <= w; i++) {
            prev[i] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                int notTaken = prev[j];
                int taken = Integer.MIN_VALUE;

                if (wt[i] <= j) {
                    taken = val[i] + prev[j - wt[i]];
                }

                prev[j] = Math.max(notTaken, taken);
            }
        }

        return prev[w];
    }


    public static void main(String[] args) {
        int[] wt = {3, 4, 5};
        int[] val = {30, 50, 60};
        int W = 8;

        System.out.println("Maximum value of items that the thief can steal is " + knapsack(wt, val, W));
    }

}
