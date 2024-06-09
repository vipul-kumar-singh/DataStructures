package com.vkstech.algorithms.practice2.tree;

import java.util.HashMap;

public class BinaryTreeConstructions extends BinaryTree {

    private final static HashMap<Integer, Integer> map = new HashMap<>();
    private static int index;

    private static Node buildTree(int[] in, int[] post, int len) {
        for (int i = 0; i < len; i++)
            map.put(in[i], i);

        index = len - 1;
        return buildUtil(post, 0, len - 1);
    }

    private static Node buildUtil(int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        int curr = postOrder[index];
        Node node = new Node(curr);
        index--;

        if (inStart == inEnd)
            return node;

        int iIndex = map.get(curr);

        node.right = buildUtil(postOrder, iIndex + 1, inEnd);
        node.left = buildUtil(postOrder, inStart, iIndex - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = buildTree(inOrder, postOrder, inOrder.length);
        BinaryTreeTraversal.preOrder(binaryTree.root);
    }

}
