package com.vkstech.algorithms.practice3.searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr1 = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(arr1, -1));
        System.out.println(binarySearch(arr1, 0));
        System.out.println(binarySearch(arr1, 3));
        System.out.println(binarySearch(arr1, 5));
        System.out.println(binarySearch(arr1, 9));
        System.out.println(binarySearch(arr1, 12));
        System.out.println(binarySearch(arr1, -2));
        System.out.println(binarySearch(arr1, 15));
        System.out.println(binarySearch(arr1, 7));
    }

    private static int binarySearch(int[] arr, int k) {
        int n = arr.length;
        return search(arr, 0, n - 1, k);
    }

    private static int search(int[] arr, int start, int end, int k) {
        if (start > end)
            return -1;

        int mid = (start + (end - start) / 2);

        if (arr[mid] == k)
            return mid;

        if (arr[mid] < k)
            return search(arr, mid + 1, end, k);

        if (arr[mid] > k)
            return search(arr, start, mid - 1, k);

        return -1;
    }
}
