package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Program to cyclically rotate an array
 */
public class CyclicRotate {

    private static void antiClockwiseRotate(int[] arr, int d) {
        if (d == 0)
            return;

        int n = arr.length;
        d = d % n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    private static void clockwiseRotate(int[] arr, int d) {
        if (d == 0)
            return;

        int n = arr.length;
        d = d % n;
        reverseArray(arr, n-d, n-1);
        reverseArray(arr, 0, n-1-d);
        reverseArray(arr, 0, n-1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(input));
        antiClockwiseRotate(input, 2);
        System.out.println(Arrays.toString(input));
        antiClockwiseRotate(input, 3);
        System.out.println(Arrays.toString(input));
        clockwiseRotate(input, 5);
        System.out.println(Arrays.toString(input));
    }

}
