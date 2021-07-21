package com.vkstech.algorithms.practice.stack;

import java.util.Stack;

/**
 * Longest valid Parentheses
 * Given a string S consisting of opening and closing parenthesis '(' and ')'.
 * Find length of the longest valid parenthesis substring.
 * Eg: Input : (((), Output : 2
 * Eg: Input : )()()), Output : 4
 */
public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(maxValidLength(")))((("));
        System.out.println(maxValidLength("((()"));
        System.out.println(maxValidLength(")()())"));
        System.out.println(maxValidLength("((()))"));
    }

    private static int maxValidLength(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else
                stack.push(ch);
        }

        int n = str.length();

        while (!stack.empty()) {
            stack.pop();
            n--;
        }
        return n;
    }
}
