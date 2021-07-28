package com.vkstech.algorithms.practice.tree;

import java.util.stream.IntStream;

public class Traversal extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 5).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        printInOrder(binaryTree);
        printPreOrder(binaryTree);
        printPostOrder(binaryTree);
    }

    public static void printInOrder(BinaryTree binaryTree) {
        inOrder(binaryTree.root);
        System.out.println();
    }

    public static void printPreOrder(BinaryTree binaryTree) {
        preOrder(binaryTree.root);
        System.out.println();
    }

    public static void printPostOrder(BinaryTree binaryTree) {
        postOrder(binaryTree.root);
        System.out.println();
    }

    private static void inOrder(Node parent) {
        if (parent == null)
            return;

        inOrder(parent.left);
        System.out.print(parent.data + " ");
        inOrder(parent.right);
    }

    private static void preOrder(Node parent) {
        if (parent == null)
            return;

        System.out.print(parent.data + " ");
        preOrder(parent.left);
        preOrder(parent.right);
    }

    private static void postOrder(Node parent) {
        if (parent == null)
            return;

        postOrder(parent.left);
        postOrder(parent.right);
        System.out.print(parent.data + " ");
    }
}
