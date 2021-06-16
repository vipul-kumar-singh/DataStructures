package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

public class SandGlassPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        final String SPACE = " ";
        final String STAR = "* ";
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(SPACE);
            }
            for (int k = i; k <= n - 1; k++) {
                System.out.print(STAR);
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(SPACE);
            }
            for (int k = i; k <= n - 1; k++) {
                System.out.print(STAR);
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        char STAR = '*';
        char SPACE = ' ';

        int length = 2 * n - 1;
        char[] chEven = new char[length];
        char[] chOdd = new char[length];

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                chEven[i] = STAR;
                chOdd[i] = SPACE;
            } else {
                chEven[i] = SPACE;
                chOdd[i] = STAR;
            }
        }
        int leftIndex = 0;
        int rightIndex = length - 1;

        for (int i = 0; i <= length; i++) {
            if (i < n) {
                if (i % 2 == 0) {
                    System.out.println(chEven);
                    chEven[leftIndex++] = SPACE;
                    chEven[rightIndex--] = SPACE;
                } else {
                    System.out.println(chOdd);
                    chOdd[leftIndex++] = SPACE;
                    chOdd[rightIndex--] = SPACE;
                }
            } else {
                if (i % 2 == 0) {
                    chEven[--leftIndex] = STAR;
                    chEven[++rightIndex] = STAR;
                    System.out.println(chEven);
                } else {
                    chOdd[--leftIndex] = STAR;
                    chOdd[++rightIndex] = STAR;
                    System.out.println(chOdd);
                }
            }
        }
    }

    public static void main(String[] args) {
        new SandGlassPattern().testPatternOptimized();
    }
}
