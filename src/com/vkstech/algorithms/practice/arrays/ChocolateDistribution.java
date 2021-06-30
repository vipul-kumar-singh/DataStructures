package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Chocolate Distribution Problem
 * Given an array of n integers where each value represents the number of chocolates in a packet.
 * Each packet can have a variable number of chocolates.
 * There are m students, the task is to distribute chocolate packets such that:
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates in the packet with maximum chocolates and
 * packet with minimum chocolates given to the students is minimum.
 * Eg : Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50} , m = 7
 * Output: Minimum Difference is 10
 * Explanation: We need to pick 7 packets. We pick 40, 41 42, 44, 48, 43 and 50
 * to minimize difference between maximum and minimum.
 */
public class ChocolateDistribution {

    private static int getMaxDiff(int[] arr, int m) {
        Arrays.sort(arr);
        int minDiff = arr[m-1] - arr[0];
        for (int i = 1; i<= arr.length - m ; i++){
            int diff = arr[i+m-1] - arr[i];
            if (diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] input = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;

        System.out.println(getMaxDiff(input, m));
    }
}
