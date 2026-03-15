package com.vkstech.algorithms.practice3.arrays;

public class PairSum {

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1, 1, 5, 5, 7};
        findPairs(arr1, 6);

        int[] arr2 = new int[]{1, 1, 1, 1};
        findPairs(arr2, 2);

        int[] arr3 = new int[]{-1, 10, 10, 12, 15};
        findPairs(arr3, 125);
    }

    private static void findPairs(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println("Pair = [" + arr[i] + ", " + arr[j] + "]");
                }
            }
        }
    }
}
