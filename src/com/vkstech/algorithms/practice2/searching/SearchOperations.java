package com.vkstech.algorithms.practice2.searching;

public class SearchOperations {

    public static int countBuildingsFacingTheSun(int[] arr) {
        int min = -1;
        int count = 0;

        for (int num : arr) {
            if (num > min) {
                min = num;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 8, 2, 9};
        System.out.println(countBuildingsFacingTheSun(arr1));

    }
}
