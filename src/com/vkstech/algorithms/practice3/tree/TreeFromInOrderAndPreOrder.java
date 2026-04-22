package com.vkstech.algorithms.practice3.tree;

import java.util.concurrent.atomic.AtomicInteger;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

// https://www.geeksforgeeks.org/problems/construct-tree-1/1
public class TreeFromInOrderAndPreOrder {

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};
        MBinaryTree tree = new MBinaryTree();
        tree.root = buildTree(inorder, preorder);
        tree.printLevelOrder();
    }

    public static Node buildTree(int[] inorder, int[] preorder) {
        AtomicInteger preIndex = new AtomicInteger(0);
        return buildTree(inorder, preorder, preIndex, 0, preorder.length - 1);
    }

    private static Node buildTree(int[] inorder, int[] preorder, AtomicInteger preIndex, int left, int right) {
        if (left > right)
            return null;

        int rootVal = preorder[preIndex.getAndIncrement()];
        Node root = new Node(rootVal);

        int index = search(inorder, rootVal, left, right);

        root.left = buildTree(inorder, preorder, preIndex, left, index - 1);
        root.right = buildTree(inorder, preorder, preIndex, index + 1, right);

        return root;
    }

    private static int search(int[] inorder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }
}
