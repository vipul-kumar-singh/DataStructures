package com.vkstech.algorithms.practice3.tree;

import java.util.concurrent.atomic.AtomicInteger;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

// https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
public class TreeFromInOrderAndPostOrder {

    public static void main(String[] args) {
        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};

        MBinaryTree tree = new MBinaryTree();
        tree.root = buildTree(inorder, postorder);
        tree.printLevelOrder();
    }

    public static Node buildTree(int[] inorder, int[] postorder) {
        AtomicInteger postIndex = new AtomicInteger(postorder.length - 1);
        return buildTree(inorder, postorder, postIndex, 0, inorder.length - 1);
    }

    private static Node buildTree(int[] inorder, int[] postorder, AtomicInteger postIndex, int left, int right) {
        if (left > right)
            return null;

        int rootVal = postorder[postIndex.getAndDecrement()];
        Node root = new Node(rootVal);

        int index = search(inorder, rootVal, left, right);

        root.right = buildTree(inorder, postorder, postIndex, index + 1, right);
        root.left = buildTree(inorder, postorder, postIndex, left, index - 1);

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
