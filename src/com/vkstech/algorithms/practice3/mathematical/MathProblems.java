package com.vkstech.algorithms.practice3.mathematical;

public class MathProblems {

    private static boolean isPrime(int n) {
        if (n == 0)
            return false;
        else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

    private static int factorial(int n) {
        if (n <= 1)
            return n;
        return n * factorial(n - 1);
    }

    private static int getGcd(int a, int b) {
        int n = Math.min(a, b);
        int gcd = 1;

        for (int i = 1; i <= n; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }

        return gcd;
    }

    private static int getLcm(int a, int b) {
        int lcm = Math.max(a, b);

        while (true) {
            if (lcm % a == 0 && lcm % b == 0)
                return lcm;
            lcm++;
        }
    }

    private static int reverseNumber(int n) {
        int rev = 0;

        while (n != 0) {
            int i = n % 10;
            rev = rev * 10 + i;
            n = n / 10;
        }

        return rev;
    }

    private static int binaryToDecimal(int n) {
        int i = 0;
        int dec = 0;

        while (n != 0) {
            int x = n % 10;
            dec = dec + (x * ((int) Math.pow(2, i)));
            n = n / 10;
            i++;
        }

        return dec;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 15; i++) {
            System.out.println(i + ": " + isPrime(i));
        }
        System.out.println();

        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));

        System.out.println();

        System.out.println(getGcd(5, 10));
        System.out.println(getGcd(14, 8));
        System.out.println(getGcd(1, 1));

        System.out.println(getLcm(5, 10));
        System.out.println(getLcm(14, 8));
        System.out.println(getLcm(1, 1));

        System.out.println();

        System.out.println(reverseNumber(122));
        System.out.println(reverseNumber(200));
        System.out.println(reverseNumber(12345));

        System.out.println();

        System.out.println(binaryToDecimal(111));
        System.out.println(binaryToDecimal(1010));
        System.out.println(binaryToDecimal(100001));
    }
}
