package com.vkstech.algorithms.practice2.array;

public class ArrayOperationsLevel3 {

    private static int maxIndexDiff(int[] arr) {
        int n = arr.length;

        int[] leftMin = new int[n];
        leftMin[0] = arr[0];

        for (int i = 1; i < n; i++)
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);

        int maxDist = Integer.MIN_VALUE;
        int i = n - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (arr[j] >= leftMin[i]) {
                maxDist = Math.max(maxDist, j - i);
                i--;
            } else {
                j--;
            }
        }

        return maxDist;
    }

    public static void main(String[] args) {
        int[] arr1 = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.print(maxIndexDiff(arr1));
    }
}
