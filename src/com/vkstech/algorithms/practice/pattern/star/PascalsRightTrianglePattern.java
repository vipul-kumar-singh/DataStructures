package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

public class PascalsRightTrianglePattern extends Pattern {
    @Override
    public void printPattern(int n) {
        int levels = 2 * n - 1;
        for (int i = 0; i < levels; i++) {
            if (i < n) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < levels - i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i < n)
                sb.append("*");
            else
                sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        new PascalsRightTrianglePattern().testPatternOptimized();
    }
}
