package com.vkstech.algorithms.practice2.searching;

public class BinarySearch {

    public static int search(int[] arr, int k) {
        return binarySearch(arr, k, 0, arr.length);
    }

    private static int binarySearch(int[] arr, int k, int start, int end) {
        if (start == end)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == k)
            return mid;

        if (k < arr[mid])
            return binarySearch(arr, k, start, mid);

        if (k > arr[mid])
            return binarySearch(arr, k, mid + 1, end);

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println(search(arr, k));
    }
}
