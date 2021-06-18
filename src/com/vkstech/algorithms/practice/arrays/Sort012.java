package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Sort an array of 0s, 1s and 2s
 * Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 * Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
