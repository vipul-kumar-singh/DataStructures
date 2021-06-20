package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Rearrange positive and negative numbers in O(n) time and O(1) extra space
 */
public class AlternateRearranging {

    private static void reArrange(int[] arr) {
        int pIndex = 0;
        int nIndex = 0;
        int temp;

        while (nIndex < arr.length) {
            if (arr[nIndex] < 0) {
                if (nIndex != pIndex) {
                    temp = arr[nIndex];
                    arr[nIndex] = arr[pIndex];
                    arr[pIndex] = temp;
                }
                pIndex++;
            }
            nIndex++;
        }

        nIndex = 1;

        while (pIndex < arr.length && nIndex < pIndex && arr[nIndex] < 0)
        {
            temp = arr[nIndex];
            arr[nIndex] = arr[pIndex];
            arr[pIndex] = temp;
            pIndex++;
            nIndex   += 2;
        }
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, -4, -1, 4};
        reArrange(input1);
        System.out.println(Arrays.toString(input1));

        int[] input2 = {-5, -2, 5, 2, 4, 7, 1, 8};
        reArrange(input2);
        System.out.println(Arrays.toString(input2));

    }
}
