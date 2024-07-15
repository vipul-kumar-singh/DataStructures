package com.vkstech.algorithms.practice2.searching;

import java.util.Arrays;

public class SearchOperations {

    public static int countBuildingsFacingTheSun(int[] arr) {
        int min = -1;
        int count = 0;

        for (int num : arr) {
            if (num > min) {
                min = num;
                count++;
            }
        }

        return count;
    }

    public static void magnetForceCalculator(int[] arr) {
        double[] force = new double[arr.length - 1];

        for (int i = 0; i < force.length; i++)
            force[i] = calculateForce(arr, arr[i], arr[i + 1]);

        Arrays.stream(force).forEach(f -> System.out.printf("%.2f ", f));
        System.out.println();
    }

    private static double calculateForce(int[] arr, double start, double end) {
        double mid = (start + end) / 2.0;
        double force = force(arr, mid);

        if (Math.abs(force) < 0.0000000000001)
            return mid;

        if (force > 0)
            return calculateForce(arr, mid, end);
        else
            return calculateForce(arr, start, mid);
    }

    private static double force(int[] arr, double mid) {
        double force = 0.0;

        for (int num : arr)
            force += (1.0 / (mid - num));

        return force;
    }

    public static int floorSearch(int[] arr, int k, int low, int high) {
        if (low > high)
            return -1;

        if (k >= arr[high])
            return high;

        int mid = (low + high) / 2;

        if (arr[mid] == k)
            return mid;

        if (mid > 0 && arr[mid - 1] <= k && k < arr[mid])
            return mid - 1;

        if (k < arr[mid])
            return floorSearch(arr, k, low, mid - 1);

        return floorSearch(arr, k, mid + 1, high);
    }

    public static int countOccurrence(int[] arr, int k) {
        int firstIndex = searchFirstOcc(arr, k, 0, arr.length - 1);
        if (firstIndex == -1)
            return -1;

        int lastIndex = searchLastOcc(arr, k, firstIndex, arr.length - 1);

        return lastIndex - firstIndex + 1;
    }

    private static int searchFirstOcc(int[] arr, int k, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if ((mid == 0 || k > arr[mid - 1]) && arr[mid] == k)
            return mid;
        else if (k > arr[mid])
            return searchFirstOcc(arr, k, mid + 1, end);
        else
            return searchFirstOcc(arr, k, start, mid - 1);
    }

    private static int searchLastOcc(int[] arr, int k, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if ((mid == arr.length - 1 || k < arr[mid + 1]) && arr[mid] == k)
            return mid;
        else if (k < arr[mid])
            return searchLastOcc(arr, k, start, mid - 1);
        else
            return searchLastOcc(arr, k, mid + 1, end);
    }

    public static int searchRotated(int[] arr, int k, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + ((right - left) / 2);

        if (arr[mid] == k)
            return mid;

        if (arr[left] <= arr[mid]) {
            if (k >= arr[left] && k < arr[mid]) {
                return searchRotated(arr, k, left, mid - 1);
            } else {
                return searchRotated(arr, k, mid + 1, right);
            }
        } else {
            if (k > arr[mid] && k <= arr[right]) {
                return searchRotated(arr, k, mid + 1, right);
            } else {
                return searchRotated(arr, k, left, mid - 1);
            }
        }
    }

    private static int findMissingInAP(int[] arr) {
        int n = arr.length;
        int diff = (arr[n - 1] - arr[0]) / n;
        return findMissingUtil(arr, 0, n - 1, diff);
    }

    private static int findMissingUtil(int[] arr, int low, int high, int diff) {
        if (high <= low)
            return Integer.MAX_VALUE;

        int mid = low + (high - low) / 2;

        if (arr[mid + 1] - arr[mid] != diff)
            return (arr[mid] + diff);

        if (mid > 0 && arr[mid] - arr[mid - 1] != diff)
            return (arr[mid - 1] + diff);

        if (arr[mid] == arr[0] + mid * diff)
            return findMissingUtil(arr, mid + 1, high, diff);

        return findMissingUtil(arr, low, mid - 1, diff);
    }

    public static int floorSqrt(int k) {
        if (k == 0 || k == 1)
            return k;

        long start = 1, end = k / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid * mid == k)
                return (int) mid;

            if (mid * mid < k) {
                start = mid + 1;
                ans = mid;
            } else
                end = mid - 1;
        }
        return (int) ans;
    }

    public static int findTransitionPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == 0)
                low = mid + 1;

            else if (arr[mid] == 1) {
                if (mid == 0 || arr[mid - 1] == 0)
                    return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findLastIndexOf1(int[] arr, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if ((mid == arr.length - 1 || 1 < arr[mid + 1]) && arr[mid] == 1)
            return mid;

        if (1 < arr[mid])
            return findLastIndexOf1(arr, start, mid - 1);
        else
            return findLastIndexOf1(arr, mid + 1, end);
    }


    public static void main(String[] args) {
        int[] arr1 = {7, 4, 8, 2, 9};
        System.out.println(countBuildingsFacingTheSun(arr1));

        int[] arr2 = {0, 10, 20, 30};
        magnetForceCalculator(arr2);

        int[] arr3 = {1, 2, 8, 10, 11, 12, 19};
        int x1 = 5;
        System.out.println(floorSearch(arr3, x1, 0, arr3.length - 1));

        int[] arr4 = {1, 1, 2, 2, 2, 2, 3};
        int x2 = 2;
        System.out.println(countOccurrence(arr4, x2));

        int[] arr5 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int k1 = 10;
        System.out.println(searchRotated(arr5, k1, 0, arr5.length - 1));

        int[] arr6 = {2, 4, 8, 10, 12, 14};
        System.out.println(findMissingInAP(arr6));

        System.out.println(floorSqrt(11));

        int[] arr7 = {0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(findTransitionPoint(arr7));

        int[] arr8 = {0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(findLastIndexOf1(arr8, 0, arr8.length - 1));
    }
}
