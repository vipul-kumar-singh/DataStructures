package com.vkstech.algorithms.practice3.stack;

import java.util.Arrays;

public class MArrayStack {

    private final int[] arr;
    private final int MAX_SIZE;

    public MArrayStack(int n) {
        MAX_SIZE = n;
        arr = new int[n];
        Arrays.fill(arr, -1);
    }

    public boolean isEmpty() {
        return arr[0] == -1;
    }

    public boolean isFull() {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (arr[i] == -1) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        int count = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            if (arr[i] == -1) {
                break;
            }
            count++;
        }
        return count;
    }

    public void push(int data) {
        int len = size();

        if (len >= MAX_SIZE) {
            System.out.println("Stack Overflow");
            return;
        }

        for (int i = len; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int len = size();
        int del = arr[0];

        for (int i = 0; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[len - 1] = -1;
        return del;
    }

    public int peek() {
        return arr[0];
    }
}
