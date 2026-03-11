package com.vkstech.algorithms.practice3.mathematical;

import java.util.Arrays;

public class NumberPattern {

    private static void printNumberPattern1(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(i + 1);
            System.out.println(sb);
        }
    }

    private static void printNumberPattern2(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(i + 1);
        }

        for (int i = n; i > 0; i--) {
            System.out.println(sb);
            sb.deleteCharAt(i - 1);
        }
    }

    private static void printNumberPattern3(int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, ' ');

        StringBuilder sb = new StringBuilder();
        sb.append(ch);

        for (int i = 0; i < n; i++) {
            sb.deleteCharAt(0);
            sb.append(i + 1);
            System.out.println(sb);
        }
    }

    private static void printNumberPattern4(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(i + 1);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(sb);
            sb.deleteCharAt(n - 1);
            sb.insert(0, ' ');
        }
    }

    private static void printNumberPattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void printNumberPattern6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        printNumberPattern1(5);
        printNumberPattern2(4);
        printNumberPattern3(5);
        printNumberPattern4(5);
        printNumberPattern5(4);
        printNumberPattern6(6);
    }
}
