package com.vkstech.algorithms.practice3.stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1
public class ValidParenthesis {

    public static void main(String[] args) {
        String s1 = "((()";
        System.out.println(maxLength(s1));

        String s2 = ")()())";
        System.out.println(maxLength(s2));

        String s3 = "())()()";
        System.out.println(maxLength(s3));

        String s4 = "()(()";
        System.out.println(maxLength(s4));

        String s5 = "(((()()))())";
        System.out.println(maxLength(s5));
    }

    public static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int lastInvalid = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastInvalid = i; // reset boundary
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - lastInvalid);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }

        return maxLen;
    }
}
