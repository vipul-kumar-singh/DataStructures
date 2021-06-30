package com.vkstech.algorithms.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the repeating and the missing element
 * Given an unsorted array of size n. Array elements are in the range from 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in the array.
 * Find these two numbers.
 * Input: arr[] = {3, 1, 3}
 * Output: Missing = 2, Repeating = 3
 */
public class RepeatingAndMissing {

    private static void printRepeatingAndMissing(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);

        int repeating = -1;
        int min = arr[0];
        int sum = 0;

        for (int val : arr) {

            if (val < min){
                min = val;
            }

            if (set.contains(val)){
                repeating = val;
            } else {
                set.add(val);
                sum += val;
            }
        }

        double ap = ((double) arr.length / 2) * ((2 * min) + (arr.length - 1)); // n/2[2a + (n – 1)d]
        System.out.println("Repeating Element = " + repeating);
        System.out.println("Missing Element = " + ((int) ap - sum));
    }

    public static void main(String[] args) {
        int[] input = {3,1,3};
        printRepeatingAndMissing(input);
    }
}
