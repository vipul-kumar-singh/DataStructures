package com.vkstech.algorithms.practice3.hashing;

import java.util.*;

// https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
public class FourSum {

    public static void main(String[] args) {
        int[] arr1 = {0, 0, 2, 1, 1};
        int target1 = 3;
        ArrayList<ArrayList<Integer>> result1 = fourSum(arr1, target1);
        printListOfList(result1);

        int[] arr2 = {10, 2, 3, 4, 5, 7, 8};
        int target2 = 23;
        ArrayList<ArrayList<Integer>> result2 = fourSum(arr2, target2);
        printListOfList(result2);

        int[] arr3 = {0, 0, 2, 1, 1};
        int target3 = 2;
        ArrayList<ArrayList<Integer>> result3 = fourSum(arr3, target3);
        printListOfList(result3);
    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        Set<ArrayList<Integer>> set = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        set.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right])));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    private static void printListOfList(ArrayList<ArrayList<Integer>> result) {
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
