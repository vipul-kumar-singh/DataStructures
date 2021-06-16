package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class DiamondFilledPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        final String SPACE = " ";
        final String STAR = "*";
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--) {
                System.out.print(SPACE);
            }
            for (int k = 0; k <= 2 * i; k++) {
                System.out.print(STAR);
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(SPACE);
            }
            for (int k = 2 * i - 1; k > 0; k--) {
                System.out.print(STAR);
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        final char SPACE = ' ';
        final char STAR = '*';

        char[] ch = new char[2 * n - 1];
        Arrays.fill(ch, SPACE);
        int mid = n - 1;
        int leftIndex = mid;
        int rightIndex = mid;
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                ch[leftIndex--] = STAR;
                ch[rightIndex++] = STAR;
            } else {
                ch[++leftIndex] = SPACE;
                ch[--rightIndex] = SPACE;
            }
            System.out.println(String.valueOf(ch));
        }
    }

    public static void main(String[] args) {
        new DiamondFilledPattern().testPatternOptimized();
    }
}
