package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class LeftTrianglePattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        char[] ch = new char[5];
        Arrays.fill(ch, ' ');
        for (int i = n - 1; i >= 0; i--) {
            ch[i] = '*';
            System.out.println(String.valueOf(ch));
        }
    }

    public static void main(String[] args) {
        new LeftTrianglePattern().testPatternOptimized();
    }
}
