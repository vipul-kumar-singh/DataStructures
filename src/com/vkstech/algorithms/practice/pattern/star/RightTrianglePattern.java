package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

public class RightTrianglePattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append("*");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        new RightTrianglePattern().testPatternOptimized();
    }
}
