package com.vkstech.algorithms.practice2.stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(maxValidLength(")))((("));
        System.out.println(maxValidLength("((()"));
        System.out.println(maxValidLength(")()())"));
        System.out.println(maxValidLength("((()))"));
    }

    private static int maxValidLength(String str) {
        if (str == null || str.isEmpty())
            return 0;

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }

        }

        int n = str.length();
        while (!stack.isEmpty()) {
            stack.pop();
            n--;
        }
        return n;
    }
}
