package com.vkstech.algorithms.practice2.hashing;

import java.util.*;

public class HashingOperations {

    public static void findCommonElements(int[][] mat) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int[] arr = mat[i];

            for (int j = 0; j < arr.length; j++) {
                Integer temp = map.get(mat[i][j]);

                if (temp == null)
                    map.put(mat[i][j], 1);
                else if (temp == i)
                    map.put(mat[i][j], temp + 1);

            }
        }

        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == mat.length)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static int[] frequencyMatch(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        int[] result = new int[arr.length];

        for (int i = 1; i <= result.length; i++) {
            Integer count = map.get(i);
            result[i - 1] = count != null ? count : 0;
        }

        return result;
    }

    public static int atleastKOccurrences(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            Integer temp = map.get(num);

            if (temp == null) {
                map.put(num, 1);
            } else {
                if (temp == k - 1)
                    return num;
                map.put(num, temp + 1);
            }
        }

        return -1;
    }

    public static boolean isEqualArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int num : arr2) {
            if (!map.containsKey(num))
                return false;
            else
                map.put(num, map.get(num) - 1);
        }

        for (Integer num : map.values()) {
            if (num > 0)
                return false;
        }

        return true;
    }

    public static void findMissing(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr2).forEach(set::add);

        for (int num : arr1) {
            if (!set.contains(num))
                System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printAnagramsTogether(String[] strArr) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String str : strArr) {
            Map<Character, Integer> tempMap = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    tempMap.put(str.charAt(i), tempMap.get(str.charAt(i)) + 1);
                } else {
                    tempMap.put(str.charAt(i), 1);
                }
            }


            if (map.containsKey(tempMap)) {
                map.get(tempMap).add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }

        }

        map.keySet().stream().map(map::get).forEach(System.out::println);
    }


    public static void countVotes(String[] votes) {
        Map<String, Integer> map = new TreeMap<>();

        for (String name : votes) {
            if (map.containsKey(name))
                map.put(name, map.get(name) + 1);
            else
                map.put(name, 1);
        }

        int vote = 0;
        String winner = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > vote) {
                vote = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println(winner);
    }

    public static void findTwoElementSum(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(sum - num)) {
                System.out.println(sum + " = " + num + " + " + (sum - num));
                return;
            } else {
                set.add(num);
            }
        }

        System.out.println("Elements with sum " + sum + " does not exist.");
    }

    public static void findTwoElementDiff(int[] arr, int diff) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(set::add);

        for (int num : arr) {
            if (set.contains(diff + num)) {
                System.out.println(diff + " = " + (diff + num) + " - " + num);
            }
        }
    }

    public static void findTwoElementSumPairs(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(sum - num)) {
                System.out.println(sum + " = " + num + " + " + (sum - num));
            }
            set.add(num);
        }
    }

    public static void findFibonacciElements(int[] arr) {
        Arrays.stream(arr).filter(HashingOperations::isFibonacci).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    private static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    public static void main(String[] args) {
        int[][] mat1 = {{2, 1, 4, 3},
                {1, 2, 3, 2},
                {3, 6, 2, 3},
                {5, 2, 5, 3}};
        findCommonElements(mat1);

        int[][] mat2 = {{12, 1, 14, 3, 16},
                {14, 2, 1, 3, 35},
                {14, 1, 14, 3, 11},
                {14, 5, 3, 2, 1},
                {1, 18, 3, 21, 14}};
        findCommonElements(mat2);

        int[] arr1 = {2, 3, 2, 3, 5};
        int[] result = frequencyMatch(arr1);
        System.out.println(Arrays.toString(result));

        int[] arr2 = {1, 2, 5, 4, 0};
        int[] arr3 = {2, 4, 5, 0, 1};
        System.out.println(isEqualArrays(arr2, arr3));

        int[] arr4 = {1, 7, 4, 3, 4, 8, 7};
        int k = 2;
        System.out.println(atleastKOccurrences(arr4, k));

        int[] arr5 = {1, 2, 3, 4, 5, 10};
        int[] arr6 = {2, 3, 1, 0, 5};
        findMissing(arr5, arr6);

        String[] arr7 = {"act", "god", "cat", "dog", "tac"};
        printAnagramsTogether(arr7);

        String[] arr8 = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        countVotes(arr8);

        int[] arr9 = {1, 4, 45, 6, 10, 8};
        int sum1 = 16;
        findTwoElementSum(arr9, sum1);

        int[] arr10 = {1, 5, 3};
        int diff = 2;
        findTwoElementDiff(arr10, diff);

        int[] arr11 = {1, 5, 7, 1};
        int sum2 = 6;
        findTwoElementSumPairs(arr11, sum2);

        int[] arr12 = {1, 4, 3, 9, 10, 13, 7};
        findFibonacciElements(arr12);
    }
}
