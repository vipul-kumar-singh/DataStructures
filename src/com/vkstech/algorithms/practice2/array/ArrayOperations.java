package com.vkstech.algorithms.practice2.array;

public class ArrayOperations {

    public static int findPeakElement(int[] arr) {
        int n = arr.length;

        if (n == 0)
            return -1;

        if (n == 1 || arr[0] > arr[1])
            return arr[0];

        for (int i = 1; i < n - 1; i++) {
            int left = arr[i - 1];
            int cur = arr[i];
            int right = arr[i + 1];

            if (cur > left && cur > right)
                return cur;
        }

        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1];

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {100, 13, 15, 20, 23, 90, 97};
        System.out.println(findPeakElement(arr));
    }
}
