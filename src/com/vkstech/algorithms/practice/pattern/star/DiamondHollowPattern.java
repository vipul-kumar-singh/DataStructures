package com.vkstech.algorithms.practice.pattern.star;

import com.vkstech.algorithms.practice.pattern.Pattern;

import java.util.Arrays;

public class DiamondHollowPattern extends Pattern {

    @Override
    public void printPattern(int n) {
        final String SPACE = " ";
        final String STAR = "*";
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--) {
                System.out.print(SPACE);
            }
            for (int k = 0; k <= 2 * i; k++) {
                if (k == 0 || k == 2 * i)
                    System.out.print(STAR);
                else
                    System.out.print(SPACE);
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(SPACE);
            }
            for (int k = 2 * i - 1; k > 0; k--) {
                if (k == 2 * i - 1 || k == 1)
                    System.out.print(STAR);
                else
                    System.out.print(SPACE);
            }
            System.out.println();
        }
    }

    @Override
    public void printPatternOptimized(int n) {

        final char SPACE = ' ';
        final char STAR = '*';

        int levels = 2 * n - 1;
        char[] ch = new char[levels];
        Arrays.fill(ch, SPACE);
        int mid = n - 1;
        int leftIndex = mid;
        int rightIndex = mid;

        for (int i = 0; i < levels; i++) {
            if (i < n) {
                setValue(ch, leftIndex, rightIndex, STAR);
                System.out.println(ch);
                setValue(ch, leftIndex, rightIndex, SPACE);
                leftIndex--;
                rightIndex++;
            } else {
                if (i == n) {
                    leftIndex++;
                    rightIndex--;
                }
                leftIndex++;
                rightIndex--;
                setValue(ch, leftIndex, rightIndex, STAR);
                System.out.println(ch);
                setValue(ch, leftIndex, rightIndex, SPACE);
            }
        }
    }

    private void setValue(char[] charArr, int leftIndex, int rightIndex, char ch) {
        charArr[leftIndex] = ch;
        charArr[rightIndex] = ch;
    }

    public static void main(String[] args) {
        new DiamondHollowPattern().printPatternOptimized(5);
    }
}
