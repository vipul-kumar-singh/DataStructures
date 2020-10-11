package com.vkstech.algorithms.sorting;

public class QuickSort {

    private static int partition(int[] arr, int p, int r) {
        int i = p;
        int key = arr[r-1];

        for (int j = p; j < r; j++) {
            if (arr[j] <= key) {
                swap(arr, i, j);
                i++;
            }
        }
        return i-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }

    private static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q);
            quickSort(arr, q + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 6, 0, 3, 2, 1, 7};
        quickSort(arr, 0, arr.length);
        CommonUtils.printArray(arr);

    }
}
