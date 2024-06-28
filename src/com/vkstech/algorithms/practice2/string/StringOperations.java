package com.vkstech.algorithms.practice2.string;

public class StringOperations {

    private static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty())
            return false;

        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcba";
        System.out.println(isPalindrome(s1));
    }
}
