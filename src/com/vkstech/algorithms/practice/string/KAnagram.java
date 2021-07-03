package com.vkstech.algorithms.practice.string;

/**
 * Check if two strings are k-anagrams or not
 * Two strings are called K-anagrams if both of the below conditions are true.
 * 1. Both have same number of characters.
 * 2. Two strings can become anagram by changing at most K characters in a string.
 * Eg: Input: str1 = "fodr", str2="gork", k = 2
 * Output: true
 * Explanation: Can change fd to gk
 */
public class KAnagram {

    public static void main(String[] args) {
        String str1 = "fodr";
        String str2 = "gork";
        int k = 2;
        System.out.println(checkKAnagram(str1, str2, k));
    }

    private static boolean checkKAnagram(String str1, String str2, int k) {
        if (str1.length() != str2.length())
            return false;

        char[] chArr = new char[256];

        for (int i = 0; i < str1.length(); i++) {
            chArr[str1.charAt(i)]++;
            chArr[str2.charAt(i)]--;
        }

        int count = 0;
        for (int i = 0; i< 256; i++){
            if (chArr[i] > 0)
                count++;
        }

        return (count/2) == k;
    }
}
