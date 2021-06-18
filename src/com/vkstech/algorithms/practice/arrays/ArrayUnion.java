package com.vkstech.algorithms.practice.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted arrays, find their union
 */
public class ArrayUnion {

    private static List<Integer> union(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr1.length + arr2.length);

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < arr1.length || rightIndex < arr2.length) {
            if (leftIndex == arr1.length){
                arrayList.add(arr2[rightIndex]);
                rightIndex++;
            } else if (rightIndex == arr2.length){
                arrayList.add(arr1[leftIndex]);
                leftIndex++;
            }else if (arr1[leftIndex] < arr2[rightIndex]) {
                arrayList.add(arr1[leftIndex]);
                leftIndex++;
            } else if (arr1[leftIndex] > arr2[rightIndex]) {
                arrayList.add(arr2[rightIndex]);
                rightIndex++;
            } else {
                arrayList.add(arr1[leftIndex]);
                leftIndex++;
                rightIndex++;
            }
        }

        arrayList.trimToSize();
        return arrayList;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};
        List<Integer> unionList = union(arr1, arr2);
        System.out.println(unionList.toString());
    }

}
