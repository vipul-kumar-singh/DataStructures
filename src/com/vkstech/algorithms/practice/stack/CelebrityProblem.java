package com.vkstech.algorithms.practice.stack;

import java.util.Stack;

/**
 * A celebrity is a person who is known to all but does not know anyone at a party.
 * If you go to a party of N people, find if there is a celebrity in the party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that
 * if an element of row i and column j is set to 1 it means ith person knows jth person.
 * Here M[i][i] will always be 0.
 * <p>
 * Example 1:Input: M[][] = {{0 1 0}, {0 0 0}, {0 1 0}} ; Output: 1
 * Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity.
 * <p>
 * Example 2: Input: M[][] = {{0 1}, {1 0}} ; Output: -1
 * Explanation: The two people at the party both know each other. None of them is a celebrity.
 */
public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] inputArr = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(findCelebrity(inputArr));

        int[][] inputArr2 = {{0, 1}, {1, 0}};
        System.out.println(findCelebrity(inputArr2));
    }

    public static int findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();

        if (arr.length == 0)
            return -1;

        for (int i = 0; i < arr.length; i++)
            st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            st.push(arr[a][b] == 1 ? b : a);
        }

        int c = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != c && (arr[c][i] == 1 || arr[i][c] != 1))
                return -1;
        }
        return c;
    }
}
