package com.vkstech.algorithms.practice.string;

/**
 * Multiply two positive strings
 * Given two numbers as stings s1 and s2. Calculate their Product.
 * eg: Input: s1 = "33", s2 = "2"
 * Output: 66
 */
public class Multiplication {

    public static void main(String[] args) {
        String s1 = "37";
        String s2 = "2";
        System.out.println(multiply(s1, s2));
    }

    private static String multiply(String num1, String num2) {
        String s1 = new StringBuffer(num1).reverse().toString();
        String s2 = new StringBuffer(num2).reverse().toString();

        int[] m = new int[s1.length() + s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                m[i + j] = m[i + j] + (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        StringBuilder product = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            int digit = m[i] % 10;
            int carry = m[i] / 10;
            if (i + 1 < m.length)
                m[i + 1] = m[i + 1] + carry;
            product.insert(0, digit);
        }

        while (product.length() > 1 && product.charAt(0) == '0') {
            product.deleteCharAt(0);
        }

        return product.toString();
    }
}
