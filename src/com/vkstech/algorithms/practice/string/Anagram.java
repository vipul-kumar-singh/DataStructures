package com.vkstech.algorithms.practice.string;

public class Anagram {

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] count = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int value : count) {
            if (value != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(isAnagram(s1, s2));
    }
}
