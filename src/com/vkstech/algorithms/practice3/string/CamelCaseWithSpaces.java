package com.vkstech.algorithms.practice3.string;

import java.util.StringJoiner;

public class CamelCaseWithSpaces {

    private static String convertSolution1(String str) {
        StringBuilder sb = new StringBuilder(str);

        if (sb.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == ' ')
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }

        return sb.toString();
    }

    private static String convertSolution2(String str) {
        String[] words = str.split(" ");
        StringJoiner sj = new StringJoiner(" ");

        for (String word : words) {
            String newWord = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            sj.add(newWord);
        }

        return sj.toString();
    }

    public static void main(String[] args) {
        String str1 = "gEEKs";
        String str2 = "i love programming";

        System.out.println(convertSolution1(str1));
        System.out.println(convertSolution2(str1));
        System.out.println(convertSolution1(str2));
        System.out.println(convertSolution2(str2));
    }
}
