package com.vkstech.algorithms.practice.stack;

public class StackReverse extends StackWithLinkedlist {

    public static void main(String[] args) {
        StackWithLinkedlist stack = new StackWithLinkedlist();
        for (int i = 1; i <= 5; i++)
            stack.push(i);

        stack.print();

        stack = reverseStack(stack);
        stack.print();
    }

    private static StackWithLinkedlist reverseStack(StackWithLinkedlist stack) {
        StackWithLinkedlist stackRev = new StackWithLinkedlist();

        while (!stack.empty())
            stackRev.push(stack.pop());

        return stackRev;
    }
}
