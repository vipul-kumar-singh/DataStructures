package com.vkstech.algorithms.practice3.string;

public class KAnagram {

    public static void main(String[] args) {
        String str1 = "fodr";
        String str2 = "gork";
        int k = 2;
        System.out.println(checkKAnagram(str1, str2, k));
    }

    private static boolean checkKAnagram(String str1, String str2, int k) {
        if (str1.length() != str2.length())
            return false;

        int[] chArr = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            chArr[str1.charAt(i)]++;
            chArr[str2.charAt(i)]--;
        }

        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (chArr[i] != 0)
                count++;
        }

        return (count / 2) == k;
    }
}
