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

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 8, 2, 9};
        System.out.println(countBuildingsFacingTheSun(arr1));

        int[] arr2 = {0, 10, 20, 30};
        magnetForceCalculator(arr2);
    }
}
