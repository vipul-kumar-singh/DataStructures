package com.vkstech.algorithms.practice3.queue;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
public class FirstNonRepeating {

    public static void main(String[] args) {
        String s1 = "aabc";
        System.out.println(firstNonRepeating(s1));
    }

    public static String firstNonRepeating(String s) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            ans.append(q.isEmpty() ? '#' : q.peek());
        }

        return ans.toString();
    }
}
