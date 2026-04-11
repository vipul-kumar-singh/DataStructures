package com.vkstech.algorithms.practice3.sorting.nonComparisonBased;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        CountingSort bubbleSort = new CountingSort();

        int[] arr1 = {2, 1, 2, 2, 3, 1, 4};
        bubbleSort.sort(arr1, 1, 5);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {7, 4, 8, 5, 3};
        bubbleSort.sort(arr2, 3, 10);
        System.out.println(Arrays.toString(arr2));

    }

    public void sort(int[] arr, int start, int end) {
        int[] temp = new int[end - start + 1];

        for (int num : arr) {
            if (num < start || num > end) {
                throw new IllegalArgumentException("Value out of range: " + num);
            }

            temp[num - start]++;
        }

        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                arr[index] = i + start;
                temp[i]--;
                index++;
            }
        }
    }
}
