package com.vkstech.algorithms.practice.arrays.prefixSumAndSlidingWindow;

/**
 * Given an array containing N integers and an integer K.,
 * Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
 * Example : A[] = {10, 5, 2, 7, 1, 9}, Sum = 15
 * Output : 4
 * Explanation: The sub-array is {5, 2, 7, 1}
 */
public class LongestSubarrayWithGivenSum {

    public static void main(String[] args) {
        int[] input = {10, 5, 2, 7, 2, 9};
        int sum = 15;

        findLongestSubarrayWithSum(input, sum);
    }

    private static void findLongestSubarrayWithSum(int[] arr, int sum) {
        int start = -1;
        int end = -1;
        int maxLength = 0;

        int i = 0;
        int j = 0;
        int curSum = 0;

        while (j != arr.length || i != arr.length) {
            if (curSum == sum && maxLength < (j - i)) {
                start = i;
                end = j;

                maxLength = j - i;
                curSum -= arr[i++];
            } else if (curSum < sum && j < arr.length) {
                curSum += arr[j++];
            } else {
                curSum -= arr[i++];
            }
        }

        if (start == -1 && end == -1) {
            System.out.println("Sum not found!");
            return;
        }

        System.out.println("Max length : " + maxLength);
        while (start < end)
            System.out.println(arr[start++]);
    }

}
