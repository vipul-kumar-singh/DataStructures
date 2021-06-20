package com.vkstech.algorithms.practice.arrays;

import java.util.Arrays;

/**
 * Find the largest three distinct elements in an array
 * Input: arr[] = {10, 4, 3, 50, 23, 90}
 * Output: 90, 50, 23
 */
public class LargestThreeDistinct {

    private static void get3LargestDistinct(int[] arr) {
        int[] hi3 = new int[3];
        Arrays.fill(hi3, Integer.MIN_VALUE);

        for(int val : arr){
            if (val == hi3[0] || val == hi3[1] || val == hi3[2]){
                continue;
            }
            if (val > hi3[0]){
                hi3[2] = hi3[1];
                hi3[1] = hi3[0];
                hi3[0] = val;
            } else if(val > hi3[1]){
                hi3[2] = hi3[1];
                hi3[1] = val;
            } else if (val > hi3[2]){
                hi3[2] = val;
            }
        }
        System.out.println(Arrays.toString(hi3));
    }

    public static void main(String[] args) {
        int[] input = {10, 4, 3, 50, 23, 90, 90};
        get3LargestDistinct(input);
    }
}
