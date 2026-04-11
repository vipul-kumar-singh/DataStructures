package com.vkstech.algorithms.practice3.sorting.comparisonBased;

import com.vkstech.algorithms.practice3.sorting.ArraySort;

import java.util.Arrays;

import static com.vkstech.algorithms.practice2.array.ArrayOperations.swap;

public class BubbleSort implements ArraySort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] arr1 = {7, 4, 8, 5, 3};
        bubbleSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        bubbleSort.sortOptimized(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void sortOptimized(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped)
                return;
        }
    }
}
