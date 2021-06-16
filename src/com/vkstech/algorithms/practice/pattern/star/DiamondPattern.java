package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class DiamondPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        final String SPACE = " ";
        final String STAR = "* ";
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--) {
                System.out.print(SPACE);
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(STAR);
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(SPACE);
            }
            for (int k = i; k > 0; k--) {
                System.out.print(STAR);
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {

        final char SPACE = ' ';
        final char STAR = '*';

        int levels = 2 * n - 1;
        char[] chEven = new char[levels];
        char[] chOdd = new char[levels];
        Arrays.fill(chEven, SPACE);
        Arrays.fill(chOdd, SPACE);
        int mid = n - 1;
        int leftIndex = mid;
        int rightIndex = mid;

        for (int i = 0; i < levels; i++) {
            if (i < n) {
                if (i % 2 == 0) {
                    setValue(chEven, leftIndex, rightIndex, STAR);
                    System.out.println(chEven);
                } else {
                    setValue(chOdd, leftIndex, rightIndex, STAR);
                    System.out.println(chOdd);
                }
                leftIndex--;
                rightIndex++;
            } else {
                leftIndex++;
                rightIndex--;
                if (i % 2 == 0) {
                    System.out.println(chEven);
                    setValue(chOdd, leftIndex, rightIndex, SPACE);
                } else {
                    System.out.println(chOdd);
                    setValue(chEven, leftIndex, rightIndex, SPACE);
                }
            }
        }

    }

    private void setValue(char[] charArr, int leftIndex, int rightIndex, char ch) {
        charArr[leftIndex] = ch;
        charArr[rightIndex] = ch;
    }

    public static void main(String[] args) {
        new DiamondPattern().testPatternOptimized();
    }
}
