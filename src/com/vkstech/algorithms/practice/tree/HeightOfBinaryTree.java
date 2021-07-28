package com.vkstech.algorithms.practice.tree;

import java.util.stream.IntStream;

public class HeightOfBinaryTree extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 5).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        System.out.println(getHeight(binaryTree.root));
    }

    private static int getHeight(Node node) {
        if (node == null)
            return -1;

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }
}
