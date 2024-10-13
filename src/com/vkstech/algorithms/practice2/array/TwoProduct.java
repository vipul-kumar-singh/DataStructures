package com.vkstech.algorithms.practice2.array;

import java.util.Arrays;

public class TwoProduct {

    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 2, 50, 80};
        int product = 150;
        findProductPair(product, arr);
    }

    private static void findProductPair(int product, int[] arr) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int num = arr[start] * arr[end];
            if (num == product) {
                System.out.println(arr[start] + " * " + arr[end] + " = " + product);
                break;
            } else if (num > product) {
                end--;
            } else {
                start++;
            }
        }
    }
}
