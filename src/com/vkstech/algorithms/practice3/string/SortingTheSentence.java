package com.vkstech.algorithms.practice3.string;

import java.util.StringJoiner;
import java.util.TreeMap;

// https://leetcode.com/problems/sorting-the-sentence/
public class SortingTheSentence {

    public static void main(String[] args) {
        String s1 = "is2 sentence4 This1 a3";
        System.out.println(getSortedSentence(s1));

        String s2 = "myself4 me2 I1 and3";
        System.out.println(getSortedSentence(s2));
    }

    private static String getSortedSentence(String str) {
        TreeMap<Character, String> map = new TreeMap<>();

        String[] strArr = str.split(" ");

        for (String s : strArr) {
            int n = s.length();
            map.put(s.charAt(n - 1), s.substring(0, n - 1));
        }

        StringJoiner sj = new StringJoiner(" ");
        map.values().forEach(sj::add);

        return sj.toString();
    }
}
