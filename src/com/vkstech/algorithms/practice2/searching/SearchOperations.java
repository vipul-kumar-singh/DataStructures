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

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 8, 2, 9};
        System.out.println(countBuildingsFacingTheSun(arr1));

        int[] arr2 = {0, 10, 20, 30};
        magnetForceCalculator(arr2);

        int[] arr3 = {1, 2, 8, 10, 11, 12, 19};
        int x = 5;
        System.out.println(floorSearch(arr3, x, 0, arr3.length - 1));
    }
}
