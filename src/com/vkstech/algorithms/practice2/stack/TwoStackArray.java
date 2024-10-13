package com.vkstech.algorithms.practice2.stack;

import java.util.Arrays;

public class TwoStackArray {

    private final int[] arr;
    private int index1;
    private int index2;

    public TwoStackArray(int n) {
        this.arr = new int[n];
        Arrays.fill(arr, -1);
        index1 = 0;
        index2 = n - 1;
    }

    public void push1(int data) {
        if (index1 - index2 == 1)
            throw new StackOverflowError();

        arr[index1++] = data;
    }

    public void push2(int data) {
        if (index1 - index2 == 1)
            throw new StackOverflowError();

        arr[index2--] = data;
    }

    public int pop1() {
        int element = arr[--index1];
        arr[index1] = -1;
        return element;
    }

    public int pop2() {
        int element = arr[++index2];
        arr[index2] = -1;
        return element;
    }

    public static void main(String[] args) {
        TwoStackArray stack = new TwoStackArray(6);
        stack.push1(1);
        stack.push2(2);
        stack.push1(3);
        stack.push2(4);
        stack.push1(5);
        stack.push1(6);

        System.out.println(Arrays.toString(stack.arr));

        stack.pop1();
        System.out.println(Arrays.toString(stack.arr));

        stack.pop1();
        System.out.println(Arrays.toString(stack.arr));

        stack.pop1();
        System.out.println(Arrays.toString(stack.arr));

        stack.push1(7);
        System.out.println(Arrays.toString(stack.arr));
    }
}
