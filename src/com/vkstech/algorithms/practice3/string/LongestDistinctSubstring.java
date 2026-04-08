package com.vkstech.algorithms.practice3.string;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctSubstring {

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        System.out.println(getLongestSubstring(str1));

        System.out.println(getLongestSubstring("abcabcbb")); // Output: 3 ("abc")
        System.out.println(getLongestSubstring("bbbbb"));    // Output: 1 ("b")
        System.out.println(getLongestSubstring("pwwkew"));

        System.out.println(getLongestSubstring("abcbde"));
    }

    private static int getLongestSubstring(String str) {
        int count = 0;
        int maxCount = 0;
        Set<Character> charSet = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!charSet.contains(ch)) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 1;
                charSet.clear();
            }
            charSet.add(ch);
        }

        return maxCount;
    }
}
