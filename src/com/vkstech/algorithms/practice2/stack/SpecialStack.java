package com.vkstech.algorithms.practice2.stack;

import java.util.EmptyStackException;

public class SpecialStack extends Stack {
    private final Stack minStack = new Stack();

    @Override
    public void push(int data) {
        super.push(data);
        if (minStack.isEmpty() || data < minStack.peek().data) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek().data);
        }
    }

    @Override
    public Node pop() {
        minStack.pop();
        return super.pop();
    }

    public int getMin() {
        if (minStack.isEmpty())
            throw new EmptyStackException();

        return minStack.head.data;
    }

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();

        stack.push(18);
        System.out.println(stack.getMin());

        stack.push(19);
        System.out.println(stack.getMin());

        stack.push(29);
        System.out.println(stack.getMin());

        stack.push(15);
        System.out.println(stack.getMin());

        stack.push(16);
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());
    }
}
