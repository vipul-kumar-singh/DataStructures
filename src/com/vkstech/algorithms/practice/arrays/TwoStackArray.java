package com.vkstech.algorithms.practice.arrays;

/**
 * Create a data structure twoStacks that represents two stacks.
 * Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements.
 * Following functions must be supported by twoStacks.
 * - push1(int x) –> pushes x to first stack
 * - push2(int x) –> pushes x to second stack
 * - pop1() –> pops an element from first stack and return the popped element
 * - pop2() –> pops an element from second stack and return the popped element
 * Implementation of twoStack should be space efficient.
 */
public class TwoStackArray {

    static class TwoStacks {
        private final int[] arr;
        private final int SIZE;
        private int leftIndex;
        private int rightIndex;

        public TwoStacks(int SIZE) {
            this.SIZE = SIZE;
            arr = new int[SIZE];
            leftIndex = -1;
            rightIndex = SIZE;
        }

        public void push1(int data) {
            if (overflow()) {
                System.out.println("Stack Overflow!!");
                return;
            }
            arr[++leftIndex] = data;
            System.out.println(data + " pushed into stack 1");
        }

        public void push2(int data) {
            if (overflow()) {
                System.out.println("Stack Overflow!!");
                return;
            }
            arr[--rightIndex] = data;
            System.out.println(data + " pushed into stack 2");
        }

        public int pop1() {
            if (leftIndex == -1) {
                System.out.println("Stack Underflow!!");
                return 0;
            }
            int temp = arr[leftIndex--];
            System.out.println(temp + " popped from stack 1");
            return temp;
        }

        public int pop2() {
            if (rightIndex == SIZE) {
                System.out.println("Stack Underflow!!");
                return 0;
            }
            int temp = arr[rightIndex++];
            System.out.println(temp + " popped from stack 2");
            return temp;
        }

        private boolean overflow() {
            return leftIndex == rightIndex - 1;
        }

    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(6);
        twoStacks.pop1();
        twoStacks.pop2();
        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push1(3);
        twoStacks.push1(4);
        twoStacks.push2(6);
        twoStacks.push2(5);
        twoStacks.push1(7);
        twoStacks.push2(8);
        twoStacks.pop1();
        twoStacks.pop2();
        twoStacks.push1(7);
        twoStacks.push2(8);
    }
}
