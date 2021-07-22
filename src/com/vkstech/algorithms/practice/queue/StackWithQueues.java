package com.vkstech.algorithms.practice.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class StackWithQueues<T> {

    private Queue<T> q1;
    private Queue<T> q2;

    public StackWithQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T data) {
        q1.add(data);
        System.out.println(data + " pushed to stack.");
    }

    public void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        while (q1.size() != 1)
            q2.add(q1.remove());

        T data = q1.remove();

        while (!q2.isEmpty())
            q1.add(q2.remove());

        System.out.println(data + " is popped from stack.");
    }

    public void print() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        while (!q1.isEmpty())
            q2.add(q1.remove());

        StringJoiner sj = new StringJoiner("->");

        while (!q2.isEmpty()) {
            sj.add(q2.peek().toString());
            q1.add(q2.remove());
        }

        System.out.println(sj);
    }

    public static void main(String[] args) {
        StackWithQueues<Integer> stack = new StackWithQueues<>();
        stack.pop();
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();
        stack.pop();
        stack.pop();

    }
}
