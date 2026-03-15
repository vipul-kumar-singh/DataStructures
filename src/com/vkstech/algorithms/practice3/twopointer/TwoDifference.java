package com.vkstech.algorithms.practice3.twopointer;

public class TwoDifference {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 10, 50, 80};

        findTwoDiff(arr, 45);
        findTwoDiff(arr, 8);
        findTwoDiff(arr, 30);
        findTwoDiff(arr, 35);
    }

    private static void findTwoDiff(int[] arr, int diff) {
        int start = 0;
        int end = 1;

        while (end < arr.length) {
            int num = arr[end] - arr[start];
            if (num == diff) {
                System.out.println(arr[start] + ", " + arr[end]);
                return;
            } else if (num < diff) {
                end++;
            } else {
                start++;
            }
        }
        System.out.println("Two diff not found!");
    }
}
