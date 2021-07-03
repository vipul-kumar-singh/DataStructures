package com.vkstech.algorithms.practice.string;

/**
 * The function takes two strings as arguments (s,x) and locates the occurrence of the string x in the string s.
 * The function returns and integer denoting the first occurrence of the string x in s (0 based indexing).
 * Note: You are not allowed to use inbuilt function.
 * Input: s = GeeksForGeeks, x = For
 * Output: 5
 */
public class StringOccurrence {

    public static void main(String[] args) {
        String inputString = "GeeksForGeeks";
        String searchKey = "For";
        System.out.println(getOccurrence(inputString, searchKey));
    }

    private static int getOccurrence(String str, String key) {
        if (str.length() < key.length())
            return -1;

        if (str.equals(key))
            return 0;

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (j == key.length() - 1) {
                return i - j;
            } else if (str.charAt(i) != key.charAt(j)) {
                j = 0;
            } else {
                j++;
            }
        }
        return -1;
    }
}
