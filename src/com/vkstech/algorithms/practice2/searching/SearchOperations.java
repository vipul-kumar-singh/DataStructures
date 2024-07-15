package com.vkstech.algorithms.practice2.searching;

import java.util.Arrays;

public class SearchOperations {

    public static int countBuildingsFacingTheSun(int[] arr) {
        int min = -1;
        int count = 0;

        for (int num : arr) {
            if (num > min) {
                min = num;
                count++;
            }
        }

        return count;
    }

    public static void magnetForceCalculator(int[] arr) {
        double[] force = new double[arr.length - 1];

        for (int i = 0; i < force.length; i++)
            force[i] = calculateForce(arr, arr[i], arr[i + 1]);

        Arrays.stream(force).forEach(f -> System.out.printf("%.2f ", f));
        System.out.println();
    }

    private static double calculateForce(int[] arr, double start, double end) {
        double mid = (start + end) / 2.0;
        double force = force(arr, mid);

        if (Math.abs(force) < 0.0000000000001)
            return mid;

        if (force > 0)
            return calculateForce(arr, mid, end);
        else
            return calculateForce(arr, start, mid);
    }

    private static double force(int[] arr, double mid) {
        double force = 0.0;

        for (int num : arr)
            force += (1.0 / (mid - num));

        return force;
    }

    public static int floorSearch(int[] arr, int k, int low, int high) {
        if (low > high)
            return -1;

        if (k >= arr[high])
            return high;

        int mid = (low + high) / 2;

        if (arr[mid] == k)
            return mid;

        if (mid > 0 && arr[mid - 1] <= k && k < arr[mid])
            return mid - 1;

        if (k < arr[mid])
            return floorSearch(arr, k, low, mid - 1);

        return floorSearch(arr, k, mid + 1, high);
    }

    public static int countOccurrence(int[] arr, int k) {
        int firstIndex = searchFirstOcc(arr, k, 0, arr.length - 1);
        if (firstIndex == -1)
            return -1;

        int lastIndex = searchLastOcc(arr, k, firstIndex, arr.length - 1);

        return lastIndex - firstIndex + 1;
    }

    private static int searchFirstOcc(int[] arr, int k, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if ((mid == 0 || k > arr[mid - 1]) && arr[mid] == k)
            return mid;
        else if (k > arr[mid])
            return searchFirstOcc(arr, k, mid + 1, end);
        else
            return searchFirstOcc(arr, k, start, mid - 1);
    }

    private static int searchLastOcc(int[] arr, int k, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if ((mid == arr.length - 1 || k < arr[mid + 1]) && arr[mid] == k)
            return mid;
        else if (k < arr[mid])
            return searchLastOcc(arr, k, start, mid - 1);
        else
            return searchLastOcc(arr, k, mid + 1, end);
    }

    public static int searchRotated(int[] arr, int k, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + ((right - left) / 2);

        if (arr[mid] == k)
            return mid;

        if (arr[left] <= arr[mid]) {
            if (k >= arr[left] && k < arr[mid]) {
                return searchRotated(arr, k, left, mid - 1);
            } else {
                return searchRotated(arr, k, mid + 1, right);
            }
        } else {
            if (k > arr[mid] && k <= arr[right]) {
                return searchRotated(arr, k, mid + 1, right);
            } else {
                return searchRotated(arr, k, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 8, 2, 9};
        System.out.println(countBuildingsFacingTheSun(arr1));

        int[] arr2 = {0, 10, 20, 30};
        magnetForceCalculator(arr2);

        int[] arr3 = {1, 2, 8, 10, 11, 12, 19};
        int x1 = 5;
        System.out.println(floorSearch(arr3, x1, 0, arr3.length - 1));

        int[] arr4 = {1, 1, 2, 2, 2, 2, 3};
        int x2 = 2;
        System.out.println(countOccurrence(arr4, x2));

        int[] arr5 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int k1 = 10;
        System.out.println(searchRotated(arr5, k1, 0, arr5.length - 1));
    }
}
