package com.vkstech.algorithms.practice3.string;

public class SmallestDistinctWindow {

    public static void main(String[] args) {
        String s1 = "AABBBCBBAC";
        System.out.println(getSmallestDistinctWindowLength(s1));
    }

    private static int getSmallestDistinctWindowLength(String str) {
        int[] count = new int[256];
        int first = 0;
        int second = 0;
        int len = Integer.MAX_VALUE;
        int diff = 0;
        int n = str.length();

        while (first < n) {
            if (count[str.charAt(first)] == 0)
                diff++;

            count[str.charAt(first)]++;
            first++;
        }

        count = new int[256];
        first = 0;

        while (second < n) {

            while (diff > 0 && second < n) {
                if (count[str.charAt(second)] == 0)
                    diff--;

                count[str.charAt(second)]++;
                second++;
            }

            len = Math.min(len, second - first);

            while (diff != 1) {
                len = Math.min(len, second - first);
                count[str.charAt(first)]--;

                if (count[str.charAt(first)] == 0)
                    diff++;

                first++;
            }
        }

        return len;

    }
}
