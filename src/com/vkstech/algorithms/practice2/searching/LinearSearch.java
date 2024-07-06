package com.vkstech.algorithms.practice2.searching;

public class LinearSearch {

    public static int search(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 16, 16, 4};
        int k = 16;
        System.out.println(search(arr, k));
    }

}
