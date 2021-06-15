package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

public class ReversePyramidPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = n - i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {

        final char STAR = '*';
        final char SPACE = ' ';

        int arrLength = 2 * n - 1;
        char[] chArrEven = new char[arrLength];
        char[] chArrOdd = new char[arrLength];
        for (int i = 0; i < arrLength; i++) {
            if (i % 2 == 0) {
                chArrEven[i] = STAR;
                chArrOdd[i] = SPACE;
            } else {
                chArrOdd[i] = STAR;
                chArrEven[i] = SPACE;
            }
        }
        int leftIndex = 0;
        int rightIndex = arrLength - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println(chArrEven);
                chArrEven[leftIndex++] = SPACE;
                chArrEven[rightIndex--] = SPACE;
            } else {
                System.out.println(chArrOdd);
                chArrOdd[leftIndex++] = SPACE;
                chArrOdd[rightIndex--] = SPACE;
            }
        }
    }

    public static void main(String[] args) {
        new ReversePyramidPattern().testPatternOptimized();
    }
}
