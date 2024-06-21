package com.vkstech.algorithms.practice2.array;

import java.util.Arrays;

public class ArrayOperations {

    public static int findPeakElement(int[] arr) {
        int n = arr.length;

        if (n == 0)
            return -1;

        if (n == 1 || arr[0] > arr[1])
            return arr[0];

        for (int i = 1; i < n - 1; i++) {
            int left = arr[i - 1];
            int cur = arr[i];
            int right = arr[i + 1];

            if (cur > left && cur > right)
                return cur;
        }

        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1];

        return -1;
    }

    public static int findMinElement(int[] arr) {
        if (arr.length == 0)
            return -1;

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static void reverseArray(int[] arr) {
        if (arr.length <= 1)
            return;

        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - 1 - i] = temp;
        }
    }

    public static int kthSmallest(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (count(nums, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    private static int count(int[] nums, int mid) {
        int cnt = 0;

        for (int num : nums)
            if (num <= mid)
                cnt++;

        return cnt;
    }

    public static int countOccurrence(int[] arr, int n) {
        int count = 0;
        for (int num : arr) {
            if (num == n)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {100, 13, 15, 20, 23, 90, 97};
        System.out.println(findPeakElement(arr));

        System.out.println(findMinElement(arr));

        reverseArray(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Kth smallest element is " + kthSmallest(arr, 5));

        int[] arr1 = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(countOccurrence(arr1, 2));
    }
}
