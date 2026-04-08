package com.vkstech.algorithms.practice3.string;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1970518970/
public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String s1 = "abcdecbeade";
        System.out.println(getLongestSubstringLength(s1));
    }

    private static int getLongestSubstringLength(String str) {
        char[] chArr = str.toCharArray();
        int n = str.length();

        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 0;
        int len = 0;

        while (end < n) {

            while (set.contains(chArr[end])) {
                set.remove(chArr[start]);
                start++;
            }

            set.add(chArr[end]);
            len = Math.max(end - start + 1, len);
            end++;
        }


        return len;
    }
}
