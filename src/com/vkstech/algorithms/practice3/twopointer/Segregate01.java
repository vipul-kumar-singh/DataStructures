package com.vkstech.algorithms.practice3.twopointer;

import java.util.Arrays;

import static com.vkstech.algorithms.practice2.array.ArrayOperations.swap;

public class Segregate01 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 0, 1, 0, 1, 0};
        segregate(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{1, 0, 0, 1, 0, 1, 1};
        segregate(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private static void segregate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] == 1 && arr[end] == 0) {
                swap(arr, start, end);
            }

            if (arr[start] == 0)
                start++;

            if (arr[end] == 1)
                end--;
        }
    }
}
