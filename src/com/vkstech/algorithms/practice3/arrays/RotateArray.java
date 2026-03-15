package com.vkstech.algorithms.practice3.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        rotateArr(arr, 2);
        System.out.println(Arrays.toString(arr));
        rotateArr(arr, 2);
        System.out.println(Arrays.toString(arr));
        rotateArr(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateArr(int[] arr, int r) {

        int[] tempArr = new int[r];

        int n = arr.length;

        for (int i = 0; i < r; i++) {
            tempArr[i] = arr[n - r + i];
        }

        for (int i = n - 1; i >= r; i--) {
            arr[i] = arr[i - r];
        }

        for (int i = 0; i < r; i++) {
            arr[i] = tempArr[i];
        }
    }
}
