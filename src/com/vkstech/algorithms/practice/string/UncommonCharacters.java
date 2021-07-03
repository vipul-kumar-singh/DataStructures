package com.vkstech.algorithms.practice.string;

/**
 * Given two strings A and B. Find the characters that are not common in the two strings.
 * A = geeksforgeeks
 * B = geeksquiz
 * Output: fioqruz
 */
public class UncommonCharacters {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "geeksquiz";
        System.out.println(getUncommonCharacters(s1, s2));
    }

    private static String getUncommonCharacters(String s1, String s2) {
        char[] chArr = new char[256];
        int i = 0;

        while (i < s1.length() && i < s2.length()) {
            chArr[s1.charAt(i)]++;
            chArr[s2.charAt(i)]++;
            i++;
        }

        while (i < s1.length()){
            chArr[s1.charAt(i++)]++;
        }

        while (i < s2.length()){
            chArr[s2.charAt(i++)]++;
        }

        StringBuilder sb = new StringBuilder();
        for(i = 0; i < 256; i++){
            if (chArr[i] == 1){
                sb.append((char) i);
            }
        }
        return sb.toString();
    }
}
