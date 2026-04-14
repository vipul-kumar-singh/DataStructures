package com.vkstech.algorithms.practice3.hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// https://www.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1
public class ElectionWinner {

    public static void main(String[] args) {
        String[] votes1 = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        System.out.println(Arrays.toString(winner(votes1, votes1.length)));

        String[] votes2 = {"smith", "jones", "andy"};
        System.out.println(Arrays.toString(winner(votes2, votes2.length)));

        String[] votes3 = {"john"};
        System.out.println(Arrays.toString(winner(votes3, votes3.length)));

        String[] votes4 = {};
        System.out.println(Arrays.toString(winner(votes4, votes4.length)));
    }

    public static String[] winner(String[] arr, int n) {
        Map<String, Integer> map = new TreeMap<>();

        if (n == 0)
            return new String[]{"-1"};

        if (n == 1)
            return new String[]{arr[0], "1"};

        Arrays.stream(arr).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));

        Map.Entry<String, Integer> maxEntry = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();

        return new String[]{maxEntry.getKey(), String.valueOf(maxEntry.getValue())};
    }
}
