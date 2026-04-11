package com.vkstech.algorithms.practice3.sorting.comparisonBased;

import com.vkstech.algorithms.practice3.sorting.ArraySort;

import java.util.Arrays;

public class MergeSort implements ArraySort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] arr1 = {6, 3, 5, 2, 2, 8, 1, 3, 2, 9};
        mergeSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {6, 4, 7, 2, 9, 8, 3, 5};
        mergeSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start == end)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;

        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[i] = arr[left];
                left++;
            } else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        while (left <= mid) {
            temp[i] = arr[left];
            left++;
            i++;
        }

        while (right <= end) {
            temp[i] = arr[right];
            right++;
            i++;
        }

        i = 0;

        while (start <= end) {
            arr[start] = temp[i];
            start++;
            i++;
        }
    }
}
