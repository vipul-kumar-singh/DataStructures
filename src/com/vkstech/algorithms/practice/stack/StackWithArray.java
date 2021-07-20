package com.vkstech.algorithms.practice.stack;

import java.util.StringJoiner;

public class StackWithArray {

    private final int[] stackArr;
    private int headIndex;

    public StackWithArray() {
        this(10); //default size
    }

    public StackWithArray(int size) {
        stackArr = new int[size];
        headIndex = 0;
    }

    public boolean isFull() {
        return headIndex == stackArr.length;
    }

    public boolean isEmpty() {
        return headIndex == 0;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        stackArr[headIndex++] = data;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        stackArr[--headIndex] = 0;
    }

    public void print() {
        StringJoiner sj = new StringJoiner("->");
        for (int i = 0; i < headIndex; i++) {
            sj.add(String.valueOf(stackArr[i]));
        }
        System.out.println(sj);
    }

}
