package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class PascalsLeftTrianglePattern extends Pattern {
    @Override
    public void printPattern(int n) {
        int levels = 2 * n - 1;
        for (int i = 0; i < levels; i++) {
            if (i < n) {
                for (int j = n - i - 1; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = 0; k <= i; k++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j <= i - n; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < levels - i; k++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, ' ');
        int index = n - 1;
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i < n)
                ch[index--] = '*';
            else
                ch[++index] = ' ';
            System.out.println(ch);
        }
    }

    public static void main(String[] args) {
        new PascalsLeftTrianglePattern().printPatternOptimized(5);
    }
}
