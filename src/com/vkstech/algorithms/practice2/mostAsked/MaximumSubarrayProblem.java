package com.vkstech.algorithms.practice2.mostAsked;

public class MaximumSubarrayProblem {

    private static int getMaxSubarraySum(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            sum += num;

            if (sum < 0) {
                if (num >= sum) {
                    sum = num;
                } else {
                    sum = 0;
                }
            }

            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, -2, 5};
        System.out.println(getMaxSubarraySum(arr1));

        int[] arr2 = {-1, -2, -3, -4};
        System.out.println(getMaxSubarraySum(arr2));

        int[] arr3 = {5, 4, 7};
        System.out.println(getMaxSubarraySum(arr3));

        int[] arr4 = {2, -1, -2, 3, 1, -3, 5, -5};
        System.out.println(getMaxSubarraySum(arr4));

        int[] arr5 = {5, 2, -1, 4, -2, 9};
        System.out.println(getMaxSubarraySum(arr5));

        int[] arr6 = {5, 4, -3, 1};
        System.out.println(getMaxSubarraySum(arr6));

        int[] arr7 = {1, -3, 4, 5};
        System.out.println(getMaxSubarraySum(arr7));

        int[] arr8 = {-4, -3, -5, -1, -2};
        System.out.println(getMaxSubarraySum(arr8));

        int[] arr9 = {0, 0, 0, 0, 0};
        System.out.println(getMaxSubarraySum(arr9));

    }

}
