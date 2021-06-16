package com.vkstech.algorithms.practice.pattern.number;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class DiamondPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            for (int l = 1; l < i; l++) {
                System.out.print(l + 1);
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            for (int l = 1; l < i; l++) {
                System.out.print(l + 1);
            }

            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        int length = 2 * n - 1;
        char[] ch = new char[length];
        Arrays.fill(ch, ' ');

        int mid = n - 1;
        int leftIndex = mid;
        int rightIndex = mid;

        char number = 49;
        for (int i = 0; i < length; i++) {
            if (i < n) {
                ch[leftIndex--] = number;
                ch[rightIndex++] = number;
                System.out.println(ch);
                number++;
            } else {
                ch[++leftIndex] = ' ';
                ch[--rightIndex] = ' ';
                System.out.println(ch);
            }
        }

    }

    public static void main(String[] args) {
        new DiamondPattern().testPatternOptimized();
    }
}
