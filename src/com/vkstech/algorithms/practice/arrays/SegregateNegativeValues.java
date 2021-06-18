package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Move all negative numbers to beginning and positive to end with constant extra space
 */
public class SegregateNegativeValues {

    private static void segregateNegative(int[] arr) {
        int pIndex = 0;
        int nIndex = 0;

        while (nIndex < arr.length) {
            if (arr[nIndex] < 0) {
                if (nIndex != pIndex) {
                    int temp = arr[nIndex];
                    arr[nIndex] = arr[pIndex];
                    arr[pIndex] = temp;
                }
                pIndex++;
            }
            nIndex++;
        }
    }

    public static void main(String[] args) {
        int[] input = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        segregateNegative(input);
        System.out.println(Arrays.toString(input));
    }
}
