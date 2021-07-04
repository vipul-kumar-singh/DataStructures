package com.vkstech.algorithms.practice.string;

/**
 * Given a string, find the longest substring which is palindrome in Linear time O(N).
 * eg: Input : forgeeksskeegfor, Output : geeksskeeg
 * eg: Input : babcbabcbaccba, Output : abcbabcba
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String input1 = "forgeeksskeegfor";
        String input2 = "babcbabcbaccba";
        System.out.println(findPalindrome(input1));
        System.out.println(findPalindrome(input2));
    }

    private static String findPalindrome(String str) {
        String palidrome = "";

        char[] chArr = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            if (chArr[i] == chArr[i + 1]) {
                palidrome = getPalindrome(chArr, i, i + 1, palidrome);
            } else if (i != 0 && chArr[i - 1] == chArr[i + 1]) {
                palidrome = getPalindrome(chArr, i - 1, i + 1, palidrome);
            }
        }

        return palidrome;
    }

    private static String getPalindrome(char[] chArr, int l, int r, String palindrome) {
        while (l >= 0 && r < chArr.length && chArr[l] == chArr[r]) {
            l--;
            r++;
        }
        String newPalindrome = String.valueOf(chArr, l + 1, r - l - 1);
        return newPalindrome.length() > palindrome.length() ? newPalindrome : palindrome;
    }
}
