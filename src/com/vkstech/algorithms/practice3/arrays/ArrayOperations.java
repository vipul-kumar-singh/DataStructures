package com.vkstech.algorithms.practice3.arrays;

import java.util.Arrays;

public class ArrayOperations {

    private static int[] insert(int[] arr, int n, int k) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < k; i++) {
            newArr[i] = arr[i];
        }

        newArr[k] = n;

        for (int i = k + 1; i < newArr.length; i++) {
            newArr[i] = arr[i - 1];
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        arr = insert(arr, 5, 2);
        arr = insert(arr, 6, 5);
        arr = insert(arr, -1, 0);
        System.out.println(Arrays.toString(arr));
    }
}
