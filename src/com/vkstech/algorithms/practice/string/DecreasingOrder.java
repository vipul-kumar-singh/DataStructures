package com.vkstech.algorithms.practice.string;

/**
 * Sort the string in descending order
 * Given a string str containing only lower case alphabets, the task is to sort it in lexicographically-descending order.
 * eg - Input: str = "geeks", Output: "skgee"
 */
public class DecreasingOrder {

    public static void main(String[] args) {
        String input = "geeks";
        System.out.println(reverseSort(input));
    }

    private static String reverseSort(String str) {
        int[] count = new int[256];

        for (char ch : str.toCharArray())
            count[ch]++;

        StringBuilder sb = new StringBuilder();
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] > 0) {
                while (count[i]-- > 0) {
                    sb.append((char) i);
                }
            }
        }
        return sb.toString();
    }
}
