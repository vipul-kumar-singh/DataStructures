package com.vkstech.algorithms.practice3.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/print-anagrams-together/1
public class PrintAnagrams {

    public static void main(String[] args) {
        String[] arr1 = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> result1 = anagrams(arr1);
        printListOfList(result1);

        String[] arr2 = {"no", "on", "is"};
        ArrayList<ArrayList<String>> result2 = anagrams(arr2);
        printListOfList(result2);

        String[] arr3 = {"listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"};
        ArrayList<ArrayList<String>> result3 = anagrams(arr3);
        printListOfList(result3);
    }

    private static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {
            String key = getSortedString(str);
            map.computeIfAbsent(key, v -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static String getSortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static void printListOfList(ArrayList<ArrayList<String>> result) {
        for (ArrayList<String> list : result) {
            System.out.println(list);
        }
    }
}
