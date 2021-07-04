package com.vkstech.algorithms.practice.string;

/**
 * Add Binary Strings
 * Given two binary strings A and B consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
 * Example 1: Input: A = "1101", B = "111", Output: 10100
 * Explanation: 1101 + 111 = 10100
 */
public class BinaryAddition {

    public static void main(String[] args) {
        String a = "1101";
        String b = "111";
        System.out.println(add(a, b));
    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int num1, num2, sum;

        int m = a.length() - 1;
        int n = b.length() - 1;

        while (m >= 0 || n >= 0) {
            num1 = m >= 0 ? (int) a.charAt(m--) - 48 : 0;
            num2 = n >= 0 ? (int) b.charAt(n--) - 48 : 0;
            sum = num1 + num2 + carry;

            switch (sum) {
                case 2:
                    carry = 1;
                    sb.append(0);
                    break;
                case 3:
                    carry = 1;
                    sb.append(1);
                    break;
                default:
                    carry = 0;
                    sb.append(sum);
            }
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
