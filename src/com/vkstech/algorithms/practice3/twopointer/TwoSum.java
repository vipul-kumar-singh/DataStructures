package com.vkstech.algorithms.practice3.twopointer;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15, 27};
        findTwoSum(arr, 22);
        findTwoSum(arr, 9);
        findTwoSum(arr, 26);
        findTwoSum(arr, 10);
    }

    private static void findTwoSum(int[] arr, int sum) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int num = arr[start] + arr[end];

            if (num == sum) {
                System.out.println(arr[start] + ", " + arr[end]);
                return;
            } else if (num > sum) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println("Two sum not found!");
    }
}
