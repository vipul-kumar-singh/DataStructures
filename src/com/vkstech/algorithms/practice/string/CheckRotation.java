package com.vkstech.algorithms.practice.string;

/**
 * Check if strings are rotations of each other or not
 * Given two strings s1 and s2.
 * The task is to check if s2 is a rotated version of the string s1.
 * The characters in the strings are in lowercase.
 * Example : Input: s1 : geeksforgeeks, s2 : forgeeksgeeks
 * Output: true
 * Explanation: s2 can be obtained by left-rotating s1 by 5 units.
 */
public class CheckRotation {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";
        System.out.println(checkRotation(s1, s2));
    }

    private static boolean checkRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        if (s1.equals(s2))
            return true;

        int i;
        int j = 0;
        for (i = 0; i < s1.length(); i++) {
            j = s1.charAt(i) == s2.charAt(j) ? j + 1 : 0;
        }

        if (j == 0)
            return false;

        i = 0;
        while (j < s2.length()) {
            if (s1.charAt(i++) != s2.charAt(j++)) {
                return false;
            }
        }

        return true;
    }
}
