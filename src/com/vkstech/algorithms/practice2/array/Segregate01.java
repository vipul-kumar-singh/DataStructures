package com.vkstech.algorithms.practice2.array;

import java.util.Arrays;

public class Segregate01 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1};
        int[] res = getSegregatedArray(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] getSegregatedArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (right > left) {
            if (arr[left] == 1 && arr[right] == 0) {
                arr[left] = 0;
                arr[right] = 1;

                left++;
                right--;
            }

            if (arr[left] != 1) {
                left++;
            }

            if (arr[right] != 0) {
                right--;
            }

        }

        return arr;
    }
}
