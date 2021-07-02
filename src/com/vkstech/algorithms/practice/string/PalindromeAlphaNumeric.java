package com.vkstech.algorithms.practice.string;

/**
 * Save Ironman
 * Jarvis is weak in computing palindromes for Alphanumeric characters.
 * While Ironman is busy fighting Thanos, he needs to activate sonic punch but Jarvis is stuck in computing palindromes.
 * You are given a string S containing alphanumeric characters. Find out whether the string is a palindrome or not.
 * If you are unable to solve it then it may result in the death of Iron Man.
 * Example 1: Input : S = "I am :IronnorI Ma, i"
 * Output : YES
 * Explanation: Ignore all the symbol and whitespaces S = "IamIronnorIMai".
 * Now, Check for palindrome ignoring uppercase and lowercase english letter.
 */
public class PalindromeAlphaNumeric {

    public static void main(String[] args) {
        String input = "I am :IronnorI Ma, i";
        System.out.println(isPalindrome(input));
    }

    private static boolean isPalindrome(String str) {
        int leftIndex = 0;
        int rightIndex = str.length() - 1;
        while(leftIndex < rightIndex){
            if (!isAlphaNumeric(str.charAt(leftIndex))){
                leftIndex++;
            } else if (!isAlphaNumeric(str.charAt(rightIndex))){
                rightIndex--;
            } else if (toLower(str.charAt(leftIndex)) != toLower(str.charAt(rightIndex))){
                return false;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(char ch){
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57);
    }

    private static char toLower(char ch){
        if (ch >= 65 && ch <= 90)
            ch+=32;
        return ch;
    }
}
