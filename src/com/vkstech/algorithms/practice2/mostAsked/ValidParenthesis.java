package com.vkstech.algorithms.practice2.mostAsked;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";
        System.out.println(isValidParenthesis(input));
    }

    private static boolean isValidParenthesis(String string) {
        Stack<Character> stack = new Stack<>();

        for (char ch : string.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                char lastChar = stack.peek();

                switch (lastChar) {
                    case '(':
                        if (ch != ')')
                            return false;
                        break;
                    case '[':
                        if (ch != ']')
                            return false;
                        break;
                    case '{':
                        if (ch != '}')
                            return false;
                        break;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
