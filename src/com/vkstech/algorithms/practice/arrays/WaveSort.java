package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Sort an array in wave form
 * arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
 */
public class WaveSort {

    public static void waveSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            if (i %2 == 0){
                if (arr[i] < arr[i+1])
                    swap(arr, i, i+1);
            } else {
                if (arr[i] > arr[i+1])
                    swap(arr, i, i+1);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] input = {10, 5, 6, 3, 2, 20, 100, 80};
        waveSort(input);
        System.out.println(Arrays.toString(input));
    }
}
