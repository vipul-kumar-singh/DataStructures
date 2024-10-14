package com.vkstech.algorithms.practice2.mostAsked;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String input = "geeksforgeeks";
        System.out.println(countLongestDistinctChars(input));
    }

    private static int countLongestDistinctChars(String str) {
        HashSet<Character> set = new HashSet<>();

        int maxCount = 0;
        int left = 0;
        int right = 0;

        while (right < str.length()) {
            char ch = str.charAt(right);

            while (set.contains(ch)) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(ch);
            maxCount = Math.max(maxCount, right - left + 1);

            right++;
        }

        return maxCount;
    }
}
