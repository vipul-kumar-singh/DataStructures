package com.vkstech.algorithms.practice.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Greater Element
 * Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element
 * for each element of the array in order of their appearance in the array.
 * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 * If there does not exist next greater of current element, then next greater element for current element is -1.
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] input = {11, 13, 21, 3};
        int[] output = getNextGreaterElement(input);
        System.out.println(Arrays.toString(output));
    }

    private static int[] getNextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.empty()) {
                while (!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            nge[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return nge;
    }
}
