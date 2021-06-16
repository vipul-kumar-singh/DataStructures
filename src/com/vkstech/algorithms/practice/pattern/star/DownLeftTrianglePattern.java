package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class DownLeftTrianglePattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = n - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, '*');
        for (int i = 0; i < n; i++) {
            System.out.println(String.valueOf(ch));
            ch[i] = ' ';
        }
    }

    public static void main(String[] args) {
        new DownLeftTrianglePattern().testPatternOptimized();
    }
}
