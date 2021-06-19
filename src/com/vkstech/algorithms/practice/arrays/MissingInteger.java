package com.vkstech.algorithms.practice.arrays;

/**
 * Find the Missing Number from unsorted array
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 * Explanation: The missing number from 1 to 8 is 5
 */
public class MissingInteger {

    private static int getMissingNumber(int[] arr) {
        int min = arr[0];
        int sum = 0;
        for (int val : arr) {
            sum += val;

            if (val < min)
                min = val;
        }
        int n = arr.length + 1;
        double ap = ((double) n / 2) * ((2 * min) + (n - 1)); // Arithmetic Progression Sum
        return (int) ap - sum;

    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(getMissingNumber(input1));

        int[] input2 = {-2, -1, 0, 3, 2, 1};
        System.out.println(getMissingNumber(input2));
    }

}
