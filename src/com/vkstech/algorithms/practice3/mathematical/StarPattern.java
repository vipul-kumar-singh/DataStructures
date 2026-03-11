package com.vkstech.algorithms.practice3.mathematical;

import java.util.Arrays;

public class StarPattern {

    private static void printStarPattern1(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("*");
            System.out.println(sb);
        }
    }

    private static void printStarPattern2(int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, '*');

        StringBuilder sb = new StringBuilder();
        sb.append(ch);

        for (int i = n; i > 0; i--) {
            System.out.println(sb);
            sb.deleteCharAt(i - 1);
        }
    }

    private static void printStarPattern3(int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, ' ');

        StringBuilder sb = new StringBuilder();
        sb.append(ch);

        for (int i = 0; i < n; i++) {
            sb.deleteCharAt(0);
            sb.append("*");
            System.out.println(sb);
        }
    }

    private static void printStarPattern4(int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, '*');

        StringBuilder sb = new StringBuilder();
        sb.append(ch);

        for (int i = 0; i < n; i++) {
            System.out.println(sb);
            sb.replace(i, i + 1, " ");
        }
    }

    private static void printStarPattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n-i-1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printStarPattern6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = n-i; j >0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        printStarPattern1(5);
        printStarPattern2(4);
        printStarPattern3(5);
        printStarPattern4(5);
        printStarPattern5(4);
        printStarPattern6(4);
    }
}
