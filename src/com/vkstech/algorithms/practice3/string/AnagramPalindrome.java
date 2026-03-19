package com.vkstech.algorithms.practice3.string;

import java.util.HashMap;
import java.util.Map;

public class AnagramPalindrome {

    private static boolean isAnagramPalindrome(String str) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            countMap.merge(ch, 1, Integer::sum);
        }

        long oddCount = countMap.values().stream().filter(val -> val % 2 != 0).count();

        return oddCount <= 1;
    }

    public static void main(String[] args) {
        String s1 = "geeksogeeks";
        String s2 = "geeksforgeeks";

        System.out.println(isAnagramPalindrome(s1));
        System.out.println(isAnagramPalindrome(s2));
    }
}
