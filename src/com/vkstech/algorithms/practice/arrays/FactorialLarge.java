package com.vkstech.algorithms.practice.arrays;

import java.math.BigInteger;

/**
 * Factorial of a large number
 * Factorial of 100 has 158 digits. It is not possible to store these many digits even if we use long long int.
 */
public class FactorialLarge {

    private static BigInteger factorial(BigInteger num) {
        if (num.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        int input = 100;
        System.out.println(factorial(BigInteger.valueOf(input)));
        printFactorial(input);

        input = 1000;
        System.out.println(factorial(BigInteger.valueOf(input)));
    }

    private static void printFactorial(int n) {
        int[] res = new int[500];

        res[0] = 1;
        int size = 1;

        for (int x = 2; x <= n; x++)
            size = multiply(x, res, size);

        for (int i = size - 1; i >= 0; i--)
            System.out.print(res[i]);
        System.out.println();
    }

    private static int multiply(int x, int[] res, int size) {
        int carry = 0;

        for (int i = 0; i < size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            res[size] = carry % 10;
            carry = carry / 10;
            size++;
        }

        return size;
    }

}
