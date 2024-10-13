package com.vkstech.algorithms.practice2.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Union {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {3, 2, 2, 3, 3, 2};
        int[] union1 = getUnion(arr1, arr2);
        System.out.println(Arrays.toString(union1));

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 5, 6};
        int[] union2 = getUnion(arr3, arr4);
        System.out.println(Arrays.toString(union2));

        int[] arr5 = {1, 2, 3};
        int[] arr6 = {5, 2, 7};
        int[] union3 = getUnion(arr5, arr6);
        System.out.println(Arrays.toString(union3));

        int[] arr7 = {2, 4, 5};
        int[] arr8 = {1, 2, 3, 4, 5};
        int[] union4 = getUnion(arr7, arr8);
        System.out.println(Arrays.toString(union4));
    }

    private static int[] getUnion(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr1)
            set.add(num);

        for (int num : arr2)
            set.add(num);

        int[] arr = new int[set.size()];
        AtomicInteger index = new AtomicInteger(0);

        set.forEach(i -> arr[index.getAndIncrement()] = i);

        return arr;
    }
}
