package com.vkstech.algorithms.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntersection {

    private static List<Integer> intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>(Math.min(arr1.length, arr2.length));

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < arr1.length && rightIndex < arr2.length) {
            if (arr1[leftIndex] < arr2[rightIndex]) {
                leftIndex++;
            } else if (arr1[leftIndex] > arr2[rightIndex]) {
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
        List<Integer> intersectionList = intersection(arr1, arr2);
        System.out.println(intersectionList.toString());
    }

}
