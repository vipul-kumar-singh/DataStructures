package com.vkstech.algorithms.practice3.string;

public class CheckSubsequence {

    public static void main(String[] args) {
        String A = "AXY";
        String B = "YADXCP";
        System.out.println(isSubsequence(A, B));

        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        System.out.println(isSubsequence(str1, str2));
    }

    private static boolean isSubsequence(String str1, String str2) {
        int i = 0;

        for (char ch : str2.toCharArray()) {
            if (str1.charAt(i) == ch)
                i++;

            if (i == str1.length())
                return true;
        }

        return false;
    }
}
