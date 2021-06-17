package com.vkstech.algorithms.practice.pattern.number;

import com.vkstech.algorithms.practice.pattern.Pattern;

public class PascalsTrianglePattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            int number = 1;
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {

    }

    public static void main(String[] args) {
        new PascalsTrianglePattern().testPattern();
    }
}
