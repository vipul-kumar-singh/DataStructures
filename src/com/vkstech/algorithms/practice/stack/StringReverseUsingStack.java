package com.vkstech.algorithms.practice.stack;

import java.util.Stack;

/**
 * Reverse a string using stack
 */
public class StringReverseUsingStack {

    public static void main(String[] args) {
        String input = "Bob The Builder";
        System.out.println(input);

        String inputRev = reverseString(input);
        System.out.println(inputRev);
    }

    private static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray())
            stack.push(ch);

        StringBuilder strRev = new StringBuilder();
        while (!stack.empty())
            strRev.append(stack.pop());
        return strRev.toString();
    }
}
