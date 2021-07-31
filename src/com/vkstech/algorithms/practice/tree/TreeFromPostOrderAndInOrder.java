package com.vkstech.algorithms.practice.tree;

import java.util.HashMap;

/**
 * Tree from Postorder and Inorder
 * Given inorder and postorder traversals of a Binary Tree in the arrays in[] and post[] respectively.
 * The task is to construct the binary tree from these traversals.
 */
public class TreeFromPostOrderAndInOrder extends BinaryTree {

    private final static HashMap<Integer, Integer> map = new HashMap<>();
    private static int index;

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = buildTree(inOrder, postOrder, inOrder.length);

        Traversal.printPreOrder(binaryTree);
    }

    private static Node buildTree(int[] in, int[] post, int len) {
        for (int i = 0; i < len; i++)
            map.put(in[i], i);

        index = len - 1;
        return buildUtil(post, 0, len - 1);
    }

    private static Node buildUtil(int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        Node parent = new Node(postOrder[index]);
        index--;

        if (inStart == inEnd)
            return parent;

        int inIndex = map.get(parent.data);
        parent.left = buildUtil(postOrder, inStart, inIndex - 1);
        parent.right = buildUtil(postOrder, inIndex + 1, inEnd);

        return parent;
    }

}
