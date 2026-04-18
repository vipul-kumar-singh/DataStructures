package com.vkstech.algorithms.practice3.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
public class NextSmallerElement {

    public static void main(String[] args) {
        int[] arr1 = {4, 8, 5, 2, 25};
        ArrayList<Integer> res1 = nextSmallerEle(arr1);
        System.out.println(res1);

        int[] arr2 = {13, 7, 6, 12};
        ArrayList<Integer> res2 = nextSmallerEle(arr2);
        System.out.println(res2);

        int[] arr3 = {4, 1};
        ArrayList<Integer> res3 = nextSmallerEle(arr3);
        System.out.println(res3);

    }

    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        Integer[] res = new Integer[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return new ArrayList<>(Arrays.asList(res));
    }
}
