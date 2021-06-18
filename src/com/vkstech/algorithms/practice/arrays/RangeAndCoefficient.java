package com.vkstech.algorithms.practice.arrays;

public class RangeAndCoefficient {

    public static void rangeAndCoefficient(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int val : arr){
            if (val < min)
                min = val;
            if (val > max)
                max = val;
        }
        System.out.println("Range = " + (max - min));
        System.out.println("Coefficient = " + (double)(max - min)/(max + min));
    }

    public static void main(String[] args) {
        int[] input = {15, 16, 10, 9, 6, 7, 17};
        rangeAndCoefficient(input);
    }
}
