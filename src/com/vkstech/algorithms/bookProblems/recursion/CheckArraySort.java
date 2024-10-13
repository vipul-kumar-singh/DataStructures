package com.vkstech.algorithms.bookProblems.recursion;

public class CheckArraySort {

    public static boolean isArraySorted(int[] arr, int i) {
        if (arr[i] == 1 || i == 1)
            return true;
        return arr[i - 1] >= arr[i - 2] && isArraySorted(arr, i - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 4, 3};

        System.out.println(isArraySorted(arr1, arr1.length - 1));
        System.out.println(isArraySorted(arr2, arr2.length - 1));
    }
}
