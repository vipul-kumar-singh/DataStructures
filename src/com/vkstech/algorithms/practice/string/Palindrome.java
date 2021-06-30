package com.vkstech.algorithms.practice.string;

/**
 * Given a string S, check if it is palindrome or not.
 */
public class Palindrome {

    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()- 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abcdba"));
    }
}
