package com.vkstech.algorithms.practice2.string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringOperations {

    public static boolean isPalindrome(String str) {
        if (isNullOrEmpty(str))
            return false;

        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i))
                return false;
        }

        return true;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (char c : s2.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
            else
                return false;
        }

        for (Integer i : map.values()) {
            if (i > 0)
                return false;
        }

        return true;
    }

    public static boolean isAnagramPalindrome(String str) {
        if (str == null)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        int oddCount = 0;

        for (Integer v : map.values()) {
            if (v % 2 != 0) {
                oddCount++;
                if (oddCount > 1)
                    return false;
            }
        }

        return true;
    }

    public static String convertFirstToUpperCase(String str) {
        if (isNullOrEmpty(str))
            return str;

        str = str.trim();

        char[] strArr = str.toCharArray();
        strArr[0] = toUpperCase(strArr[0]);

        for (int i = 1; i < str.length(); i++) {
            if (strArr[i] == ' ' && strArr[i + 1] != ' ')
                strArr[i + 1] = toUpperCase(strArr[i + 1]);
        }

        return new String(strArr);
    }

    private static char toUpperCase(char c) {
        if (c >= 97 && c <= 122)
            return (char) ((int) c - 32);
        return c;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String sortDescending(String str) {
        if (isNullOrEmpty(str))
            return str;

        Map<Character, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (char c : str.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> {
            while (value > 0) {
                sb.append(key);
                value--;
            }
        });

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "abcba";
        System.out.println(isPalindrome(s1));

        String s2 = "geeksforgeeks";
        String s3 = "forgeeksgeeks";
        System.out.println(isAnagram(s2, s3));

        String s4 = "geeksfogeeks";
        System.out.println(isAnagramPalindrome(s4));

        String s5 = "i love programming";
        s5 = convertFirstToUpperCase(s5);
        System.out.println(s5);

        System.out.println(sortDescending(s2));
    }
}
