package com.vkstech.algorithms.practice.tree;

import java.util.stream.IntStream;

/**
 * Count Leaves in Binary Tree
 */
public class LeavesCount extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 5).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        System.out.println(countLeaves(binaryTree.root));
    }

    private static int countLeaves(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }
}
