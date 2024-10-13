package com.vkstech.algorithms.practice2.array;

public class ArrayOperationsLevel3 {

    public static int maxIndexDiff(int[] arr) {
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

    public static int maxSumPath(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;

        int sum1 = 0;
        int sum2 = 0;
        int maxSum = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j];
                j++;
            } else {
                maxSum += Math.max(sum1, sum2);
                maxSum += arr1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            sum1 += arr1[i];
            i++;
        }

        while (j < arr2.length) {
            sum2 += arr2[j];
            j++;
        }

        return maxSum + Math.max(sum1, sum2);

    }

    public static void findMissingAndRepeatingNumber(int[] arr) {
        int[] temp = new int[arr.length];
        int missing = 0;
        int repeating = 0;

        for (int num : arr) {
            if (temp[num - 1] == 1)
                repeating = num;
            else
                temp[num - 1] = 1;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0)
                missing = i + 1;
        }

        System.out.println("Repeating value is " + repeating + ", and missing value is " + missing + ".");
    }

    public static int getMaximumProfit(int[] price) {
        int maxProfit = 0;
        int min = price[0];
        int max = price[0];

        int n = price.length;
        int i = 1;

        while (i < n) {

            while (i < n && price[i] <= price[i - 1]) {
                min = price[i];
                i++;
            }

            while (i < n && price[i] > price[i - 1]) {
                max = price[i];
                i++;
            }

            maxProfit += (max - min);

        }

        return maxProfit;
    }

    public static void printClosest(int[] arr, int k) {
        int left = 0;
        int right = 0;

        int l = 0;
        int r = arr.length - 1;
        int diff = Integer.MAX_VALUE;

        while (r > l) {
            int temp = Math.abs(arr[l] + arr[r] - k);

            if (temp < diff) {
                left = l;
                right = r;
                diff = temp;
            }
            if (arr[l] + arr[r] > k)
                r--;
            else
                l++;
        }

        System.out.println("The closest pair is " + arr[left] + " and " + arr[right] + ".");
    }

    public static void main(String[] args) {
        int[] arr1 = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(arr1));

        int[] arr2 = {2, 3, 7, 10, 12, 15, 30, 34};
        int[] arr3 = {1, 5, 7, 8, 10, 15, 16, 19};
        System.out.println(maxSumPath(arr2, arr3));

        int[] arr4 = {4, 3, 6, 2, 1, 1};
        findMissingAndRepeatingNumber(arr4);

        int[] priceArr = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(getMaximumProfit(priceArr));

        int[] arr5 = {10, 22, 28, 29, 30, 40};
        int k = 54;
        printClosest(arr5, k);
    }
}
