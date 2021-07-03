package com.vkstech.algorithms.practice.string;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharacter {

    public static void main(String[] args) {
        String input = "mississippi";
        System.out.println(firstRepeatingChar(input));
    }

    private static Character firstRepeatingChar(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (charSet.contains(ch)){
                return ch;
            }
            charSet.add(ch);
        }
        System.out.println("No character is repeating");
        return null;
    }
}
