package com.vkstech.algorithms.practice.arrays;

/**
 * Program to find the minimum (or maximum) element of an array
 */
public class MinMaxElement {

    public static int getMinElement(int[] arr){
        int min = arr[0];
        for(int val : arr){
            if (val < min)
                min = val;
        }
        return min;
    }

    public static int getMaxElement(int[] arr){
        int min = arr[0];
        for(int val : arr){
            if (val > min)
                min = val;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 1234, 45, 67, 1 };
        System.out.println(getMaxElement(arr));
        System.out.println(getMinElement(arr));
    }
}
