package com.vkstech.algorithms.practice.arrays;

/**
 * Check if a key is present in every segment of size k in an array
 */
public class KeyPresentInSegment {

    public static boolean checkKeyIsPresent(int[] arr, int x, int k) {
        int count = 0;
        int segment = 1;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (count == k && !found) {
                return false;
            }

            if (arr[i] == x) {
                found = true;
                count = 0;
                i = segment * k - 1;
                segment++;
            } else {
                found = false;
                count++;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] arrInput = {3, 5, 2, 4, 9, 2, 1, 7, 3, 11, 12, 3};
        int x = 3;
        int k = 3;

        System.out.println(checkKeyIsPresent(arrInput, x, k));
    }
}
