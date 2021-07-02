package com.vkstech.algorithms.practice.string;

/**
 * Given a string str, convert the first letter of each word in the string to uppercase.
 * Input: str = "i love programming"
 * Output: "I Love Programming"
 * Explanation: 'I', 'L', 'P' are the first letters of the three words.
 */
public class TitleCaseConversion {

    private static String convertTitledCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i-1) == ' ')
                sb.append((char)(str.charAt(i) - 32));
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "i love programming";
        System.out.println(convertTitledCase(input));
    }
}
