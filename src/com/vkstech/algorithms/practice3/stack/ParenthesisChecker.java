package com.vkstech.algorithms.practice3.stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
public class ParenthesisChecker {

    public static void main(String[] args) {
        String s1 = "[{()}]";
        System.out.println(isBalanced(s1));

        String s2 = "[()()]{}";
        System.out.println(isBalanced(s2));

        String s3 = "([]";
        System.out.println(isBalanced(s3));

        String s4 = "([{]})";
        System.out.println(isBalanced(s4));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                switch (ch) {
                    case '}':
                        if (stack.peek() != '{') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case ']':
                        if (stack.peek() != '[') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case ')':
                        if (stack.peek() != '(') {
                            return false;
                        }
                        stack.pop();
                        break;
                }
            }


        }

        return stack.isEmpty();
    }
}
