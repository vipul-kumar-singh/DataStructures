package com.vkstech.algorithms.practice3.arrays;

import java.util.Arrays;

public class ArrayReverse {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 3, 2, 6, 5};
        int[] arr2 = new int[]{4, 5, 2};
        int[] arr3 = new int[]{1};

        reverseArr(arr1);
        reverseArr(arr2);
        reverseArr(arr3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    private static void reverseArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
