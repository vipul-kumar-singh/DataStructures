package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Preorder to Postorder
 * Given an array arr[] of N nodes representing preorder traversal of BST.
 * The task is to print its postorder traversal.
 */
public class PreorderToPostorder extends BinarySearchTree {

    public static void main(String[] args) {
        int[] preOrder = {40, 30, 35, 80, 100};
        findPostOrder(preOrder);
    }

    public static void findPostOrder(int[] pre) {
        AtomicInteger index = new AtomicInteger(0);
        findPostOrderUtil(pre, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static void findPostOrderUtil(int[] arr, AtomicInteger index,
                                          int min, int max) {

        int i = index.get();
        if (i == arr.length || arr[i] < min || arr[i] > max)
            return;

        int val = arr[i];
        index.getAndIncrement();

        findPostOrderUtil(arr, index, min, val);
        findPostOrderUtil(arr, index, val, max);

        System.out.print(val + " ");
    }
}
