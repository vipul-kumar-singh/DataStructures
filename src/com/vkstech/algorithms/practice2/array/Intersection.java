package com.vkstech.algorithms.practice2.array;

import java.util.*;

public class Intersection {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 3, 1};
        int[] arr2 = {3, 1, 3, 4, 1};
        Integer[] intersection1 = getIntersection(arr1, arr2);
        System.out.println(Arrays.toString(intersection1));

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 5, 6};
        Integer[] intersection2 = getIntersection(arr3, arr4);
        System.out.println(Arrays.toString(intersection2));

        int[] arr5 = {4, 5, 2, 3};
        int[] arr6 = {1, 7};
        Integer[] intersection3 = getIntersection(arr5, arr6);
        System.out.println(Arrays.toString(intersection3));

        int[] arr7 = {5, 6, 2, 1, 4};
        int[] arr8 = {7, 9, 4, 2};
        Integer[] intersection4 = getIntersection(arr7, arr8);
        System.out.println(Arrays.toString(intersection4));
    }

    private static Integer[] getIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr1)
            set.add(num);

        List<Integer> intersection = new ArrayList<>();

        for (int num : arr2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        return intersection.toArray(new Integer[0]);
    }
}
