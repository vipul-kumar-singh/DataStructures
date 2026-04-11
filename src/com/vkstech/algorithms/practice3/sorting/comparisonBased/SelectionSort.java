package com.vkstech.algorithms.practice3.sorting.comparisonBased;

import com.vkstech.algorithms.practice3.sorting.ArraySort;

import java.util.Arrays;

import static com.vkstech.algorithms.practice2.array.ArrayOperations.swap;

public class SelectionSort implements ArraySort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] arr1 = {9, 7, 3, 1, 6};
        selectionSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 8, 2, 3, 1, 4};
        selectionSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    @Override
    public void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex)
                swap(arr, i, minIndex);
        }
    }
}
