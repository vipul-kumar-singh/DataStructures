package com.vkstech.algorithms.practice3.string;

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String s1 = "abab";
        System.out.println(getLps(s1));

    }

    private static int getLps(String str) {
        int n = str.length();
        int[] lps = new int[n];

        int pre = 0;
        int suf = 1;

        while (suf < n) {
            // Matched
            if (str.charAt(pre) == str.charAt(suf)) {
                lps[suf] = pre + 1;
                suf++;
                pre++;
            }
            // Not matched
            else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }

        return lps[n - 1];
    }
}
