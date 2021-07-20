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
        if (isFull())
            throw new StackOverflowError("Stack Overflow");

        stackArr[headIndex++] = data;
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Stack Underflow");

        int data = stackArr[--headIndex];
        stackArr[headIndex] = 0;
        return data;
    }

    public void print() {
        StringJoiner sj = new StringJoiner("->");
        for (int i = 0; i < headIndex; i++)
            sj.add(String.valueOf(stackArr[i]));
        System.out.println(sj);
    }

}
