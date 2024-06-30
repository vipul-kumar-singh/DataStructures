package com.vkstech.algorithms.practice2.string;

import java.util.*;

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

    public static String mergeAlternatively(String s1, String s2) {
        if (s1 == null && s2 == null)
            return null;

        if (s1 == null)
            return s2;

        if (s2 == null)
            return s1;

        if (s1.isEmpty() && s2.isEmpty())
            return s1;

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s1.length() && i < s2.length()) {
            sb.append(s1.charAt(i))
                    .append(s2.charAt(i));
            i++;
        }

        while (i < s1.length()) {
            sb.append(s1.charAt(i));
            i++;
        }

        while (i < s2.length()) {
            sb.append(s2.charAt(i));
            i++;
        }

        return sb.toString();
    }

    public static boolean isGoodString(String str) {
        if (isNullOrEmpty(str))
            return true;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int vowel = 0;
        int cons = 0;

        for (char c : str.toCharArray()) {
            if (c == '?') {
                vowel++;
                cons++;
            } else if (set.contains(c)) {
                vowel++;
                cons = 0;
            } else {
                cons++;
                vowel = 0;
            }

            if (vowel > 5 || cons > 3) {
                return false;
            }
        }

        return true;
    }

    public static String urlify(String str) {
        if (isNullOrEmpty(str))
            return str;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static int extractMaximum(String str) {
        if (isNullOrEmpty(str))
            return -1;

        int max = 0;
        int cur = 0;

        for (char c : str.toCharArray()) {
            int num = c - 48;

            if (num >= 0 && num <= 9) {
                cur = cur * 10 + num;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }

        return max;
    }

    public static String reverseWords(String str) {
        if (isNullOrEmpty(str))
            return str;

        String[] arr = str.split("\\.");

        StringJoiner sj = new StringJoiner(".");

        for (int i = arr.length - 1; i >= 0; i--) {
            sj.add(arr[i]);
        }

        return sj.toString();
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

        String s6 = "Hello";
        String s7 = "Bye";
        System.out.println(mergeAlternatively(s6, s7));

        String s8 = "aeioup???";
        System.out.println(isGoodString(s8));

        String s9 = "Mr John Smith";
        System.out.println(urlify(s9));

        String s10 = "100klh564abc365bg";
        System.out.println(extractMaximum(s10));

        String s11 = "i.like.this.program.very.much";
        System.out.println(reverseWords(s11));
    }
}
