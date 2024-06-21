package com.vkstech.algorithms.practice2.array;

import java.util.Arrays;

public class ArrayOperationsLevel2 {

    public static void cyclicRotateArray(int[] arr, int k) {
        int[] tempArr = new int[k];
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            tempArr[i] = arr[n - k + i];
        }

        int i = n - 1;
        while (i >= k) {
            arr[i] = arr[i - k];
            i--;
        }

        while (i >= 0) {
            arr[i] = tempArr[i];
            i--;
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        cyclicRotateArray(arr1, 2);
        System.out.println(Arrays.toString(arr1));
    }
}
