package com.vkstech.algorithms.practice2.string;

import java.util.*;
import java.util.stream.Collectors;

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

        Map<Character, Integer> map = getCharCountMap(s1);

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

    private static Map<Character, Integer> getCharCountMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        return map;
    }

    public static boolean isAnagramPalindrome(String str) {
        if (str == null)
            return false;

        Map<Character, Integer> map = getCharCountMap(str);

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

    public static int strstr(String str, String x) {
        if (isNullOrEmpty(str) || isNullOrEmpty(x))
            return -1;

        int i = 0;
        int j = 0;

        while (i < str.length()) {
            if (str.charAt(i) == x.charAt(j)) {
                j++;

                if (j == x.length())
                    return i - x.length() + 1;
            } else {
                j = 0;
            }
            i++;
        }

        return -1;
    }

    public static boolean isSubSequence(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2))
            return false;

        int i = 0;

        for (char c : s2.toCharArray()) {
            if (c == s1.charAt(i))
                i++;

            if (i == s1.length())
                return true;
        }

        return false;
    }

    public static boolean isStringRotated(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2) || (s1.length() != s2.length()))
            return false;

        int j = 0;

        while (j < s2.length()) {
            if (s1.charAt(0) == s2.charAt(j)) {
                int k = s1.length() - j;

                String sub1 = s2.substring(j);
                String sub2 = s1.substring(0, k);
                String sub3 = s2.substring(0, j);
                String sub4 = s1.substring(k);

                if (sub1.equals(sub2) && sub3.equals(sub4))
                    return true;
            }
            j++;
        }

        return false;
    }

    public static boolean isKAnagram(String s1, String s2, int k) {
        if (s1 == null && s2 == null)
            return true;

        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        Map<Character, Integer> map = getCharCountMap(s1);

        for (char c : s2.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
            else
                k--;
        }

        return k == 0;
    }

    public static void findUncommonCharacters(String s1, String s2) {
        if (s1 == null && s2 == null)
            return;

        if (s1 == null) {
            System.out.println(s2);
            return;
        }

        if (s2 == null) {
            System.out.println(s1);
            return;
        }

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char ch : s1.toCharArray())
            set1.add(ch);

        for (char ch : s2.toCharArray())
            set2.add(ch);

        List<Character> uncommon = set1.stream().filter(c -> !set2.contains(c)).collect(Collectors.toList());
        uncommon.addAll(set2.stream().filter(c -> !set1.contains(c)).collect(Collectors.toList()));

        uncommon.forEach(System.out::print);
        System.out.println();
    }

    public static void anagramOfStrings(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2))
            return;

        String a;
        String b;

        if (s1.length() >= s2.length()) {
            a = s1;
            b = s2;
        } else {
            a = s2;
            b = s1;
        }

        Map<Character, Integer> map = getCharCountMap(a);

        for (char c : b.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                System.out.println("Anagram cannot be formed");
                return;
            }
        }

        System.out.print("Characters needed to be removed from String " + a + " are: ");
        map.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    public static char findFirstNonRepeatingChar(String str) {
        if (isNullOrEmpty(str))
            return '$';

        Map<Character, Integer> map = getCharCountMap(str);

        for (char c : str.toCharArray()) {
            if (map.get(c) == 1)
                return c;
        }

        return '$';
    }

    public static int getLongestDistinctChars(String str) {
        if (isNullOrEmpty(str))
            return 0;

        int max = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                max = Math.max(max, set.size());
                set.clear();
            }
            set.add(str.charAt(i));
        }

        return max;
    }

    public static char getKthCharInString(int m, int n, int k) {
        String binaryString = decimalToBinary(m);
        StringBuilder sb = new StringBuilder(binaryString);

        for (int i = 0; i < n; i++) {
            replaceChars(sb);
        }

        return sb.charAt(k - 1);
    }

    private static void replaceChars(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0')
                sb.replace(i, ++i, "01");
            else
                sb.replace(i, ++i, "10");
        }
    }

    private static String decimalToBinary(int num) {
        int bin = 0;
        int count = 0;

        while (num != 0) {
            int rem = num % 2;
            double c = Math.pow(10, count);
            bin += (int) (rem * c);
            num = num / 2;
            count++;
        }

        return String.valueOf(bin);
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

        String s12 = "GeeksForGeeks";
        String x = "For";
        System.out.println(strstr(s12, x));

        String s13 = "gksrek";
        String s14 = "geeksforgeeks";
        System.out.println(isSubSequence(s13, s14));

        String s15 = "geeksforgeeks";
        String s16 = "forgeeksgeeks";
        System.out.println(isStringRotated(s15, s16));

        String s17 = "fodre";
        String s18 = "gorkw";
        int k = 2;
        System.out.println(isKAnagram(s17, s18, k));

        String s19 = "geeksforgeeks";
        String s20 = "geeksquiz";
        findUncommonCharacters(s19, s20);

        String s21 = "bcadeh";
        String s22 = "hea";
        anagramOfStrings(s21, s22);

        String s23 = "zxvczbtxyzvy";
        System.out.println(findFirstNonRepeatingChar(s23));

        System.out.println(getLongestDistinctChars(s19));

        int m = 5, n = 2, l = 5;
        System.out.println(getKthCharInString(m, n, l));
    }
}
