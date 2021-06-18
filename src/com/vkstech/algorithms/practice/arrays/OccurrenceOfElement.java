package com.vkstech.algorithms.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the occurrence of an integer in the array
 */
public class OccurrenceOfElement {

    private static int getOccurrence(int[] arr, int x) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int val : arr){
            occurrenceMap.merge(val, 1, Integer::sum);
        }
        return occurrenceMap.get(x);
    }

    public static void main(String[] args) {
        int[] input = {0, 5, 5, 5, 4};
        int x = 5;

        System.out.println(getOccurrence(input, x));
    }
}
