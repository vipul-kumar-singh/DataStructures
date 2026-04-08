package com.vkstech.algorithms.practice3.string;

import java.util.HashMap;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "abccccdd";
        System.out.println(getCountOfLongestPalindrome(s1));
        System.out.println(getCountOfLongestPalindromeOptimized(s1));

        String s2 = "abaccb";
        System.out.println(getCountOfLongestPalindrome(s2));
        System.out.println(getCountOfLongestPalindromeOptimized(s2));

        String s3 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(getCountOfLongestPalindrome(s3));
        System.out.println(getCountOfLongestPalindromeOptimized(s3));
    }

    private static int getCountOfLongestPalindrome(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;

        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                value -= 1;
                if (count % 2 == 0) {
                    count += 1;
                }
            }

            count += value;
        }

        return count;
    }

    private static int getCountOfLongestPalindromeOptimized(String str) {
        int[] arr = new int[256];

        for (char ch : str.toCharArray()) {
            arr[ch]++;
        }

        int count = 0;

        for (int value : arr) {
            if (value % 2 != 0) {
                value -= 1;
                if (count % 2 == 0) {
                    count += 1;
                }
            }

            count += value;
        }

        return count;
    }
}
