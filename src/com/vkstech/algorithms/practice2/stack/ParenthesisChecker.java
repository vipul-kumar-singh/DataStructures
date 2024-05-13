package com.vkstech.algorithms.practice2.stack;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        String input = "{([])}";
        System.out.println(checkValidParenthesis(input));
    }

    private static boolean checkValidParenthesis(String input) {
        if (input == null || input.isEmpty() || input.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.pop() != '{')
                        return false;
                    break;
                case ')':
                    if (stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.pop() != '[')
                        return false;
                    break;
            }
        }
        return true;
    }
}
