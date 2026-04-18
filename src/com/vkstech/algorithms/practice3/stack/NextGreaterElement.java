package com.vkstech.algorithms.practice3.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 4};
        ArrayList<Integer> res1 = nextLargerElement(arr1);
        System.out.println(res1);

        int[] arr2 = {6, 8, 0, 1, 3};
        ArrayList<Integer> res2 = nextLargerElement(arr2);
        System.out.println(res2);

        int[] arr3 = {1, 2, 3, 5};
        ArrayList<Integer> res3 = nextLargerElement(arr3);
        System.out.println(res3);

        int[] arr4 = {5, 4, 3, 1};
        ArrayList<Integer> res4 = nextLargerElement(arr4);
        System.out.println(res4);
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Integer[] res = new Integer[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return new ArrayList<>(Arrays.asList(res));
    }
}
