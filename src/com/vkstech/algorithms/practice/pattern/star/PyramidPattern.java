package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class PyramidPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {
        char[] charArrEven = new char[n * 2 - 1];
        char[] charArrOdd = new char[n * 2 - 1];
        Arrays.fill(charArrEven, ' ');
        Arrays.fill(charArrOdd, ' ');

        int mid = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                charArrEven[mid + i] = '*';
                charArrEven[mid - i] = '*';
                System.out.println(String.valueOf(charArrEven));
            } else {
                charArrOdd[mid + i] = '*';
                charArrOdd[mid - i] = '*';
                System.out.println(String.valueOf(charArrOdd));
            }
        }
    }

    public static void main(String[] args) {
        new PyramidPattern().testPatternOptimized();
    }

}
