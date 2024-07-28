package com.vkstech.algorithms.practice2.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] arr) {
        int n = arr.length - 1;

        for (int i = 0; i < n; i++) {
            boolean isSwapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }

            if (!isSwapped)
                break;
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
