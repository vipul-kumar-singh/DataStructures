package com.vkstech.algorithms.practice3.hashing;

import java.util.Arrays;
import java.util.HashSet;

// https://www.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1
public class NutsAndBolt {

    private static final Character[] order = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};

    public static void main(String[] args) {
        char[] nuts1 = {'@', '%', '$', '#', '^'},
                bolts1 = {'%', '@', '#', '$', '^'};
        matchPairs(nuts1.length, nuts1, bolts1);
        System.out.println(Arrays.toString(nuts1));
        System.out.println(Arrays.toString(bolts1));

        char[] nuts2 = {'^', '&', '%', '@', '#', '*', '$', '?', '!'},
                bolts2 = {'?', '#', '@', '%', '&', '*', '$', '^', '!'};
        matchPairs(nuts2.length, nuts2, bolts2);
        System.out.println(Arrays.toString(nuts2));
        System.out.println(Arrays.toString(bolts2));
    }

    private static void matchPairs(int n, char[] nuts, char[] bolts) {
        HashSet<Character> set = new HashSet<>();

        for (char nut : nuts)
            set.add(nut);

        int idx = 0;
        for (char c : order) {
            if (set.contains(c)) {
                nuts[idx] = c;
                bolts[idx] = c;
                idx++;
            }
        }
    }
}
