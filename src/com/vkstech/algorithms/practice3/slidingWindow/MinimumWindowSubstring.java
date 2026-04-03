package com.vkstech.algorithms.practice3.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String str1 = "ADOBECODEBANC";
        String subStr1 = "ABC";

        System.out.println(getMinSubstring(str1, subStr1));
    }

    private static String getMinSubstring(String str, String subStr) {
        Map<Character, Integer> charMap = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        String ans = null;

        for (char ch : subStr.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        int total = subStr.length();

        int start = 0;
        int end = 0;
        int n = str.length();

        while (end < n) {
            char key = str.charAt(end);
            if (charMap.containsKey(key)) {
                int val = charMap.get(key);
                if (val > 0) {
                    total--;
                }
                charMap.put(key, val - 1);
            } else {
                charMap.put(key, -1);
            }

            while (total == 0 && start < end) {
                int curLen = (end - start + 1);
                if (curLen < minLength) {
                    ans = str.substring(start, end + 1);
                    minLength = curLen;
                }

                char key2 = str.charAt(start);
                int val2 = charMap.get(key2);

                if (val2 >= 0)
                    total++;

                charMap.put(key2, val2 + 1);
                start++;
            }

            end++;

        }
        return ans;
    }
}
