package com.vkstech.algorithms.practice.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Smaller Element
 * Given an array arr[ ] of size N having distinct elements, the task is to find the next smaller element
 * for each element of the array in order of their appearance in the array.
 * Next smaller element of an element in the array is the nearest element on the right which is smaller than the current element.
 * If there does not exist next smaller of current element, then next smaller element for current element is -1.
 */
public class NextSmallerElement {

    public static void main(String[] args) {
        int[] input = {4, 2, 1, 5, 3};
        int[] output = getNextSmallerElement(input);
        System.out.println(Arrays.toString(output));
    }

    private static int[] getNextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.empty()) {
                while (!stack.empty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
            }
            nse[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return nse;
    }
}
