package com.vkstech.algorithms.practice.stack;

import java.util.Stack;

/**
 * Check for Balanced Brackets in an expression (well-formedness) using Stack.
 * Eg: Input: exp = “[()]{}{[()()]()}”, Output: true
 * Input: exp = “[(])”, Output: false
 */
public class ParenthesisChecker {

    public static void main(String[] args) {
        String input = "[()]{}{[()()]()}";
        System.out.println(checkBalanced(input));
    }

    private static boolean checkBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }

            if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.empty())
                    return false;

                char check = stack.pop();
                switch (check) {
                    case '{':
                        check = '}';
                        break;
                    case '[':
                        check = ']';
                        break;
                    case '(':
                        check = ')';
                        break;
                }

                if (ch != check)
                    return false;
            }
        }
        return stack.empty();
    }
}
