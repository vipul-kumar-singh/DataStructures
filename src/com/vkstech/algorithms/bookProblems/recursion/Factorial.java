package com.vkstech.algorithms.bookProblems.recursion;

public class Factorial {

    public static int factorial(int n) {
        if (n == 1) {
            System.out.println("Returning 1");
            return 1;
        } else {
            System.out.println("Calling factorial(" + (n-1) + ")");
            int result =  n * factorial(n - 1);
            System.out.println("Returning resullt: " + result);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
