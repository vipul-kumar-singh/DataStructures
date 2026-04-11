package com.vkstech.algorithms.practice3.sorting.nonComparisonBased;

import com.vkstech.algorithms.practice3.sorting.ArraySort;

import java.util.Arrays;

public class RadixSort implements ArraySort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();

        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    private int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    private void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];

        for (i = 0; i < n; i++) {
            int key = (arr[i] / exp) % 10;
            count[key]++;
        }

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            int key = (arr[i] / exp) % 10;
            output[count[key] - 1] = arr[i];
            count[key]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

}
