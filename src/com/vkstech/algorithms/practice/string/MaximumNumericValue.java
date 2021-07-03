package com.vkstech.algorithms.practice.string;

/**
 * Extract maximum numeric value
 * Given a alphanumeric string S, extract maximum numeric value from S.
 * Eg: Input: S = 100klh564abc365bg, Output: 564
 */
public class MaximumNumericValue {

    public static void main(String[] args) {
        String input = "100klh564abc365bg";
        System.out.println(getMaxNumeric(input));
    }

    private static int getMaxNumeric(String str) {
        int max = -1;
        int current = 0;

        for (char ch : str.toCharArray()) {
            if (isNumeric(ch)) {
                current = (current * 10) + ch - 48;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }

        return max;
    }

    private static boolean isNumeric(char ch) {
        return ch >= 48 && ch <= 57;
    }
}
