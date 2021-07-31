package com.vkstech.algorithms.practice.tree;

import java.util.Stack;

/**
 * ZigZag Tree Traversal
 * Write a function to print ZigZag order traversal of a binary tree.
 * For the below binary tree the zigzag order traversal will be 1 3 2 7 6 5 4.
 * ---- 1
 * ---/   \
 * --2     3
 * -/ \   / \
 * 7  6  5   4
 */
public class ZigZagTraversal extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LevelOrderInsertion.insert(binaryTree, 1);
        LevelOrderInsertion.insert(binaryTree, 2);
        LevelOrderInsertion.insert(binaryTree, 3);
        LevelOrderInsertion.insert(binaryTree, 7);
        LevelOrderInsertion.insert(binaryTree, 6);
        LevelOrderInsertion.insert(binaryTree, 5);
        LevelOrderInsertion.insert(binaryTree, 4);

        zigzagTraversal(binaryTree);
    }

    private static void zigzagTraversal(BinaryTree binaryTree) {
        if (binaryTree.root == null)
            return;

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        currentLevel.push(binaryTree.root);
        boolean oddLevel = true;

        while (!currentLevel.isEmpty()) {

            Node node = currentLevel.pop();
            System.out.print(node.data + " ");

            if (oddLevel) {
                if (node.left != null)
                    nextLevel.push(node.left);

                if (node.right != null)
                    nextLevel.push(node.right);
            } else {
                if (node.right != null)
                    nextLevel.push(node.right);

                if (node.left != null)
                    nextLevel.push(node.left);
            }

            if (currentLevel.isEmpty()) {
                oddLevel = !oddLevel;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
}
