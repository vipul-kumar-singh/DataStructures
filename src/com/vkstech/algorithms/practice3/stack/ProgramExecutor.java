package com.vkstech.algorithms.practice3.stack;

public class ProgramExecutor {

    public static void main(String[] args) {
        MLinkedStack stack = new MLinkedStack();
        stack.pop();
        System.out.println(stack.peek());

        stack.push(5);
        stack.push(6);

        System.out.println(stack.peek());
        System.out.println(stack.size());

        stack.pop();
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());


        MArrayStack arrStack = new MArrayStack(5);
        arrStack.pop();
        System.out.println(arrStack.peek());

        arrStack.push(5);
        arrStack.push(6);
        arrStack.push(3);
        arrStack.push(2);
        arrStack.push(1);
        arrStack.push(9);

        System.out.println(arrStack.peek());
        System.out.println(arrStack.size());

        arrStack.pop();
        System.out.println(arrStack.peek());

        arrStack.pop();
        System.out.println(arrStack.peek());
        System.out.println(arrStack.size());

        arrStack.pop();
        arrStack.pop();
        arrStack.pop();

        System.out.println(arrStack.peek());
        System.out.println(arrStack.size());

        arrStack.pop();

    }
}
