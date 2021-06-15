package com.vkstech.algorithms.practice.pattern;

public abstract class Pattern {

    public void printPattern(int n){}
    public abstract void printPatternOptimized(int n);

    public void testPattern(){
        for (int i = 1; i <= 5; i++) {
            printPattern(i);
            System.out.println();
        }
    }

    public void testPatternOptimized(){
        for (int i = 1; i <= 5; i++) {
            printPatternOptimized(i);
            System.out.println();
        }
    }
}
