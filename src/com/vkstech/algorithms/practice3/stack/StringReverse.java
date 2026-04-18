package com.vkstech.algorithms.practice3.stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
public class StringReverse {

    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        System.out.println(reverse(s1));

        String s2 = "Geek";
        System.out.println(reverse(s2));
    }

    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
