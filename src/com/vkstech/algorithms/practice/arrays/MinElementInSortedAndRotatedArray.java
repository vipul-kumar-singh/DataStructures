package com.vkstech.algorithms.practice.arrays;

/**
 * Find the minimum element in a sorted and rotated array
 * A sorted array is rotated at some unknown point, find the minimum element in it.
 * The following solution assumes that all elements are distinct.
 */
public class MinElementInSortedAndRotatedArray {

    // O(logN)
    private static int findMin(int[] arr, int left, int right) {
        if (arr[left] <= arr[right])
            return arr[left];

        int mid = (left + right) / 2;
        if (mid != 0 && arr[mid - 1] > arr[mid])
            return arr[mid];

        if (arr[left] > arr[mid])
            return findMin(arr, left, mid - 1);
        return findMin(arr, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] input1 = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(findMin(input1, 0, input1.length - 1));

        int[] input2 = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(findMin(input2, 0, input2.length - 1));

        int[] input3 = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(input3, 0, input3.length - 1));

        int[] input4 = {1, 2, 3, 4};
        System.out.println(findMin(input4, 0, input4.length - 1));

        int[] arr1 = {5, 6, 1, 2, 3, 4};
        System.out.println("The minimum element is " + findMin(arr1, 0, arr1.length - 1));

        int[] arr2 = {1, 2, 3, 4};
        System.out.println("The minimum element is " + findMin(arr2, 0, arr2.length - 1));

        int[] arr3 = {1};
        System.out.println("The minimum element is " + findMin(arr3, 0, arr3.length - 1));

        int[] arr4 = {1, 2};
        System.out.println("The minimum element is " + findMin(arr4, 0, arr4.length - 1));

        int[] arr5 = {2, 1};
        System.out.println("The minimum element is " + findMin(arr5, 0, arr5.length - 1));

        int[] arr6 = {5, 6, 7, 1, 2, 3, 4};
        System.out.println("The minimum element is " + findMin(arr6, 0, arr6.length - 1));

        int[] arr7 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("The minimum element is " + findMin(arr7, 0, arr7.length - 1));

        int[] arr8 = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("The minimum element is " + findMin(arr8, 0, arr8.length - 1));

        int[] arr9 = {3, 4, 5, 1, 2};
        System.out.println("The minimum element is " + findMin(arr9, 0, arr9.length - 1));

    }
}
