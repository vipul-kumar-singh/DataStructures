package com.vkstech.algorithms.practice3.string;

public class Palindrome {

    private static boolean isPalindrome(String str) {
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("racecar"));

    }
}
