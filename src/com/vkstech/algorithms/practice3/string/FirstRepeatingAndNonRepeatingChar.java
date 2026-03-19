package com.vkstech.algorithms.practice3.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingAndNonRepeatingChar {

    private static Character firstRepeatingChar(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (charSet.contains(ch)) {
                return ch;
            }
            charSet.add(ch);
        }
        return null;
    }

    private static Character firstNonRepeatingChar(String str) {
        int[] ascii = new int[256];

        for(char ch : str.toCharArray()){
            ascii[ch]++;
        }

        for(char ch : str.toCharArray()){
            if (ascii[ch] == 1)
                return ch;
        }
        return null;

    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(firstRepeatingChar(str));
        System.out.println(firstRepeatingChar("abc"));
        System.out.println(firstNonRepeatingChar(str));
        System.out.println(firstNonRepeatingChar("racecar"));
        System.out.println(firstNonRepeatingChar("aabbccc"));
    }
}
