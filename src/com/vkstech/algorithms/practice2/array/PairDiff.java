package com.vkstech.algorithms.practice2.array;

public class PairDiff {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 10, 50, 80};
        int diff = 45;
        findPairDiff(diff, arr);
    }

    private static void findPairDiff(int diff, int[] arr) {
        int left = arr[0];
        int right = arr[1];
        int n = arr.length;

        while (right < n) {
            if (arr[right] - arr[left] == diff) {
                System.out.println(arr[right] + " - " + arr[left] + " = " + diff);
                break;
            } else if (arr[right] - arr[left] > diff) {
                left++;
            } else {
                right++;
            }
        }
    }
}
