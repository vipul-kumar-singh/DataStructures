package com.vkstech.algorithms.practice.stack;

public class MinElementStack extends StackWithLinkedlist {

    int min;

    @Override
    public void push(int data) {
        if (this.empty()) {
            min = data;
            super.push(data);
            return;
        }

        if (data < min) {
            super.push(2 * data - min);
            min = data;
        } else {
            super.push(data);
        }
    }

    @Override
    public int pop() {
        int data = super.pop();

        int temp = data;
        if (data < min) {
            temp = min;
            min = 2 * min - data;
        }

        return temp;
    }

    public Integer getMin() {
        if (this.empty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return min;
    }

    public static void main(String[] args) {
        MinElementStack stack = new MinElementStack();
        System.out.println("Min : " + stack.getMin());

        stack.push(10);
        System.out.println("Min : " + stack.getMin());

        stack.push(20);
        System.out.println("Min : " + stack.getMin());

        stack.push(9);
        System.out.println("Min : " + stack.getMin());

        System.out.println("Popped " + stack.pop());
        System.out.println("Min : " + stack.getMin());

        System.out.println("Popped " + stack.pop());
        System.out.println("Min : " + stack.getMin());

        System.out.println("Popped " + stack.pop());
        System.out.println("Min : " + stack.getMin());

    }
}
