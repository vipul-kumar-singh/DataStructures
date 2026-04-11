package com.vkstech.algorithms.practice3.sorting.comparisonBased;

import com.vkstech.algorithms.practice3.sorting.ArraySort;

import java.util.Arrays;

public class InsertionSort implements ArraySort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr1 = {7, 4, 2, 3, 5};
        insertionSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int j = i + 1;
            int val = arr[j];

            while (j > 0 && val < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = val;
        }
    }
}
