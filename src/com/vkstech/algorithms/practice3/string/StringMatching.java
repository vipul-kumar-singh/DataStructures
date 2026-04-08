package com.vkstech.algorithms.practice3.string;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1971685095/
public class StringMatching {

    public static void main(String[] args) {
        String s1 = "abcabdefg";
        String s2 = "def";
        System.out.println(getIndex(s1, s2));

        String s3 = "aaa";
        String s4 = "aa";
        System.out.println(getIndex(s3, s4));
    }

    private static int getIndex(String haystack, String needle) {
        int[] lps = getLps(needle);

        int i = 0;
        int j = 0;

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        if (j == needle.length())
            return i - j;

        return -1;
    }

    private static int[] getLps(String str) {
        int[] lps = new int[str.length()];

        int pre = 0;
        int suf = 1;
        int n = str.length();

        while (suf < n) {
            // matched
            if (str.charAt(pre) == str.charAt(suf)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            }

            // not matched
            else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }

        return lps;
    }
}
