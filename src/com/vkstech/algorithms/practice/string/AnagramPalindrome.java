package com.vkstech.algorithms.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, Check if characters of the given string can be rearranged to form a palindrome.
 * Input: S = "geeksogeeks"
 * Output: Yes
 * Explanation: The string can be converted into a palindrome: geeksoskeeg
 */
public class AnagramPalindrome {

    public static void main(String[] args) {
        String input1 = "geeksogeeks"; // geeksoskeeg
        String input2 = "geeksforgeeks"; // Not Possible
        String input3 = "aabbccddeee"; // abcdeeedcba
        System.out.println(checkAnagramPalindrome(input1));
        System.out.println(checkAnagramPalindrome(input2));
        System.out.println(checkAnagramPalindrome(input3));
    }

    private static boolean checkAnagramPalindrome(String input) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : input.toCharArray())
            countMap.merge(ch, 1, Integer::sum);

        long oddCount = countMap.values().stream().filter(val -> val % 2 != 0).count();
        return oddCount <= 1;
    }
}
