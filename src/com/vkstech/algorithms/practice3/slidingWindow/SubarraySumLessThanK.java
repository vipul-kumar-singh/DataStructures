package com.vkstech.algorithms.practice3.slidingWindow;

// https://www.geeksforgeeks.org/dsa/number-subarrays-sum-less-k/
public class SubarraySumLessThanK {

    public static void main(String[] args) {
        int[] arr1 = {1, 11, 2, 3, 15};
        System.out.println(countSubarray(arr1, 10));

        int[] arr2 = {2, 5, 6};
        System.out.println(countSubarray(arr2, 10));
    }

    private static int countSubarray(int[] arr, int k) {
        int start = 0;
        int end = 0;

        int sum = 0;
        int n = arr.length;

        int count = 0;

        while (end < n) {
            sum += arr[end];

            while (sum >= k && start <= end) {
                sum -= arr[start];
                start++;
            }

            count += (end - start + 1);
            end++;
        }

        return count;
    }

}
