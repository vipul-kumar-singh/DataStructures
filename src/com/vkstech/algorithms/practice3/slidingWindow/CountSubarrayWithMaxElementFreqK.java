package com.vkstech.algorithms.practice3.slidingWindow;

// Count Subarray where max element  appear at least k times
public class CountSubarrayWithMaxElementFreqK {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 3, 1, 2, 3, 3, 2};
        System.out.println(countSubarrays(arr1, 2));

        int[] arr2 = {1, 3, 2, 3, 3};
        System.out.println(countSubarrays(arr2, 2));
    }

    private static int countSubarrays(int[] arr, int k) {
        // find max element
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            max = Math.max(max, num);
        }

        //count subarrays
        int start = 0;
        int end = 0;
        int n = arr.length;
        int maxCount = 0;
        int subCount = 0;

        while (end < n) {
            if (arr[end] == max)
                maxCount++;

            while (maxCount == k) {
                subCount += n - end;

                if (arr[start] == max)
                    maxCount--;

                start++;
            }

            end++;
        }

        return subCount;
    }
}
