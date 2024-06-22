package com.vkstech.algorithms.practice2.array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayOperationsLevel2 {

    public static void cyclicRotateArray(int[] arr, int k) {
        int[] tempArr = new int[k];
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            tempArr[i] = arr[n - k + i];
        }

        int i = n - 1;
        while (i >= k) {
            arr[i] = arr[i - k];
            i--;
        }

        while (i >= 0) {
            arr[i] = tempArr[i];
            i--;
        }
    }

    private static int findMissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2;
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(arr).forEach(sum::addAndGet);
        return totalSum - sum.get();
    }

    private static int countPairsWithSum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;


        for (int num : arr) {
            if (map.containsKey(sum - num)) {
                count += map.get(sum - num);
            }

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        return count;
    }

    public static void findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length - 1);

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        map.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static void findCommonELements(int[]... arrs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr : arrs) {
            for (int num : arr) {
                if (map.containsKey(num))
                    map.put(num, map.get(num) + 1);
                else
                    map.put(num, 1);
            }
        }

        map.entrySet().stream().filter(entry -> entry.getValue() == arrs.length)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static int findFirstNotRepeatingElement(int[] arr) {
        boolean found;
        for (int i = 0; i < arr.length; i++) {
            found = false;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return arr[i];
        }
        return -1;
    }

    public static int countSubArrayWithEqualZeroAndOne(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = -1;

            sum += arr[i];

            if (sum == 0)
                count++;

            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }

    public static void reArrangeAltPositiveNegative(int[] arr) {
        if (arr.length <= 1)
            return;

        int left = 0;
        int right = 1;

        while (right < arr.length) {
            if (arr[left] >= 0 && arr[right] < 0
                    || arr[left] < 0 && arr[right] >= 0) {
                rotateSubArray(arr, left, right);
                left++;
                right++;
                continue;
            }

            if (arr[right] >= 0 || left == right)
                right++;

            if ((arr[left] < 0 && left % 2 == 0) || (arr[left] >= 0 && left % 2 != 0))
                left++;
        }
    }


    private static void rotateSubArray(int[] arr, int left, int right) {
        int temp = arr[right];

        int i = right;
        while (i > left) {
            arr[i] = arr[i - 1];
            i--;
        }

        arr[i] = temp;
    }

    public static boolean subArraySumZero(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;

            if (sum == 0 || num == 0 || set.contains(sum))
                return true;

            set.add(sum);
        }
        return false;
    }

    public static int largestSumOfSubArray(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];

        for (int num : arr) {
            sum = Math.max(num, sum + num);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        cyclicRotateArray(arr1, 2);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 4, 6, 3, 7, 8};
        int n = 8;
        System.out.println(findMissingNumber(arr2, n));

        int[] arr3 = {1, 1, 1, 1};
        int sum = 2;
        System.out.println(countPairsWithSum(arr3, sum));

        int[] arr4 = {1, 2, 3, 6, 3, 6, 1};
        findDuplicates(arr4);

        int[] arr5 = {1, 5, 10, 20, 40, 80};
        int[] arr6 = {6, 7, 10, 20, 80, 100};
        int[] arr7 = {3, 4, 6, 7, 15, 20, 30, 70, 80, 120};
        findCommonELements(arr5, arr6, arr7);

        int[] arr8 = {-1, 2, -1, 2, 3, 2, 0};
        System.out.println(findFirstNotRepeatingElement(arr8));

        int[] arr9 = {1, 0, 0, 1, 1, 0, 0, 1};
        System.out.println(countSubArrayWithEqualZeroAndOne(arr9));

        int[] arr10 = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        reArrangeAltPositiveNegative(arr10);
        System.out.println(Arrays.toString(arr10));

        int[] arr11 = {4, 2, -3, 1, 6};
        System.out.println(subArraySumZero(arr11));

        int[] arr12 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(largestSumOfSubArray(arr12));
    }

}
