package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.Arrays;
import java.util.Stack;

/**
 * Add all greater values to every node in a BST
 * Given a BST, modify it so that all greater values in the given BST are added to every node.
 * Input:
 * ------50
 * ----/   \
 * --30     70
 * -/  \   /  \
 * 20  40 60  80
 * Output: 350 330 300 260 210 150 80
 */
public class AddGreaterValues extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(50, 30, 70, 20, 40, 60, 80).forEach(bst::insert);
        bst.printInOrder();

        addGreaterValue(bst.root);
        bst.printInOrder();

    }

    private static void addGreaterValue(Node root) {
        if (root == null)
            throw new NullPointerException("Stack underflow");
        Stack<Node> stack = new Stack<>();
        addInorder(root, stack);

        int sum = stack.pop().data;
        while (!stack.empty()) {
            Node node = stack.pop();
            node.data += sum;
            sum = node.data;
        }
    }

    private static void addInorder(Node node, Stack<Node> stack) {
        if (node.left != null)
            addInorder(node.left, stack);

        stack.push(node);

        if (node.right != null)
            addInorder(node.right, stack);
    }
}
