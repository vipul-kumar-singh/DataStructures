package com.vkstech.algorithms.practice3.string;

import java.util.Arrays;

public class Anagram {

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] ascii = new int[256];

        for (int i = 0; i < s1.length(); i++) {
                ascii[s1.charAt(i)]++;
                ascii[s2.charAt(i)]--;
        }

        for(int i : ascii){
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";

        String s3 = "allergy";
        String s4 = "allergyy";

        String s5 = "listen";
        String s6 = "lists";

        String s7 = "listen";
        String s8 = "silent";

        System.out.println(isAnagram(s1, s2));
        System.out.println(isAnagram(s3, s4));
        System.out.println(isAnagram(s5, s6));
        System.out.println(isAnagram(s7, s8));
    }
}
