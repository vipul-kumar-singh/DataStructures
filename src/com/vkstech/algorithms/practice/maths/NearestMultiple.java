package com.vkstech.algorithms.practice.maths;

/**
 * Nearest multiple of 10
 * Given a number N representing a positive number.
 * The task is to round N to the nearest multiple of 10.
 * Note: If you are having two multiple equally apart from N then we will choose the smallest element among them.
 * Eg: Input : N = 15, Output : 10
 * Explanation: Numbers which are multiple of 10 are 10, 20, 30.
 * We can see 10 and 20 are equally distant from 20.
 * So, we will choose the smallest element among them i.e., 10.
 */
public class NearestMultiple {

    public static void main(String[] args) {
        int[] inputs = {23, 15, 87};
        int factor = 10;
        for (int num : inputs) {
            System.out.println(getNearestMultiple(num, factor));
        }
    }

    private static int getNearestMultiple(int num, int factor) {
        int rem = num % factor;

        return rem <= factor / 2
                ? num - rem
                : num + factor - rem;
    }

}
