package com.vkstech.algorithms.practice2.array;

import java.util.*;

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

    public static void sort012(int[] arr) {
        int[] arr012 = {0, 0, 0};

        for (int num : arr) {
            arr012[num]++;
        }

        int i = 0;
        for (int j = 0; j < arr012.length; j++) {
            int n = arr012[j];
            while (n != 0) {
                arr[i] = j;
                n--;
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void shiftNegativeAndPositive(int[] arr) {
        if (arr.length <= 1)
            return;

        int left = 0;
        int right = 0;

        while (left != arr.length) {
            if (arr[left] < 0) {
                if (left == right) {
                    left++;
                    right++;
                } else if (left > right) {
                    swap(arr, left, right);
                    right++;
                }
            } else {
                left++;
            }
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static Integer[] getUnion(int[] arr1, int[] arr2) {
        Set<Integer> union = new TreeSet<>();

        for (int num : arr1) {
            union.add(num);
        }

        for (int num : arr2) {
            union.add(num);
        }

        return union.toArray(new Integer[0]);
    }

    public static Integer[] getIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i != arr1.length && j != arr2.length) {
            int n1 = arr1[i];
            int n2 = arr2[j];

            if (n1 == n2) {
                intersection.add(n1);
                i++;
                j++;
            } else if (n1 < n2) {
                i++;
            } else {
                j++;
            }
        }

        return intersection.toArray(new Integer[0]);
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

        int[] arr2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr2);

        int[] arr3 = {1, 2, -3, 4, 5, 6, -7, 8, -9};
        shiftNegativeAndPositive(arr3);
        System.out.println(Arrays.toString(arr3));


        int[] arr4 = {1, 3, 4, 5, 7};
        int[] arr5 = {2, 3, 5, 6};
        Integer[] union = getUnion(arr4, arr5);
        Integer[] intersection = getIntersection(arr4, arr5);
        System.out.println(Arrays.toString(union));
        System.out.println(Arrays.toString(intersection));
    }
}
