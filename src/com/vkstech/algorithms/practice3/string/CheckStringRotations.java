package com.vkstech.algorithms.practice3.string;

public class CheckStringRotations {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcda";
        System.out.println(isStringRotation(str1, str2));
        System.out.println(isStringRotationOptimized(str1, str2));

        String str3 = "aab";
        String str4 = "aba";
        System.out.println(isStringRotation(str3, str4));
        System.out.println(isStringRotationOptimized(str3, str4));

        String str5 = "abcd";
        String str6 = "acbd";
        System.out.println(isStringRotation(str5, str6));
        System.out.println(isStringRotationOptimized(str5, str6));

        String str7 = "abcabc";
        String str8 = "bcabca";
        System.out.println(isStringRotation(str7, str8));
        System.out.println(isStringRotationOptimized(str7, str8));
    }

    private static boolean isStringRotation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        int i = 0;
        int j = 0;
        int k = 0;

        int n = str1.length();

        while (i < n) {
            if (str2.charAt(i) == str1.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                j = 0;
                k = i;
            }
        }

        for (int l = 0; l < k; l++) {
            if (str2.charAt(l) != str1.charAt(n - k + l))
                return false;
        }

        return true;
    }

    private static boolean isStringRotationOptimized(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        String concat = str1 + str1;
        return concat.contains(str2);
    }
}

