package com.vkstech.algorithms.practice3.arrays;

import java.util.Arrays;

public class MinMaxArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 3, 5, 8, 6};
        int[] result1 = findMinMax(arr1);
        System.out.println(Arrays.toString(result1));

        int[] arr2 = new int[]{12, 3, 15, 7, 9};
        int[] result2 = findMinMax(arr2);
        System.out.println(Arrays.toString(result2));
    }

    private static int[] findMinMax(int[] arr) {
        int[] minMaxArr = new int[]{arr[0], arr[0]};

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minMaxArr[0])
                minMaxArr[0] = arr[i];

            if (arr[i] > minMaxArr[1])
                minMaxArr[1] = arr[i];
        }

        return minMaxArr;
    }
}
