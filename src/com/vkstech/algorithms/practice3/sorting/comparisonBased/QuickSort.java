package com.vkstech.algorithms.practice3.sorting.comparisonBased;

import com.vkstech.algorithms.practice3.sorting.ArraySort;

import java.util.Arrays;

public class QuickSort implements ArraySort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] arr1 = {6, 3, 5, 2, 2, 8, 1, 3, 2, 9};
        quickSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {6, 4, 7, 2, 9, 8, 3, 5};
        quickSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    @Override
    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pos = start;
        int i = start;

        while (i <= end) {
            if (arr[i] <= arr[end]) {
                swap(arr, i, pos);
                pos++;
            }
            i++;
        }

        return pos - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
