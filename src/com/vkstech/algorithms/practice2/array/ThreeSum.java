package com.vkstech.algorithms.practice2.array;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 13;
        System.out.println(findThreeSum(sum, arr));
    }

    private static boolean findThreeSum(int sum, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int p1 = i + 1;
            int p2 = n - 1;

            int tempSum = sum - arr[i];

            while (p1 < p2) {
                int num = arr[p1] + arr[p2];

                if (num == tempSum) {
                    System.out.println(arr[i] + " + " + arr[p1] + " + " + arr[p2] + " = " + sum);
                    return true;
                } else if (num > tempSum) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return false;
    }
}
