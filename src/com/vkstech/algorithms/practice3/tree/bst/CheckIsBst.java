package com.vkstech.algorithms.practice3.tree.bst;

import static com.vkstech.algorithms.practice3.tree.bst.MBinarySearchTree.Node;

// https://www.geeksforgeeks.org/problems/check-for-bst/1
public class CheckIsBst {

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        Node rightNode1 = new Node(3);
        rightNode1.right = new Node(5);
        root1.right = rightNode1;
        System.out.println(isBST(root1));

        Node root2 = new Node(2);
        Node rightRightNode1 = new Node(6);
        rightRightNode1.right = new Node(9);
        Node rightNode2 = new Node(7);
        rightNode2.right = rightRightNode1;
        root2.right = rightNode2;
        System.out.println(isBST(root2));

        Node root3 = new Node(10);
        root3.left = new Node(5);
        Node rightNode3 = new Node(20);
        rightNode3.right = new Node(25);
        rightNode3.left = new Node(9);
        root3.right = rightNode3;
        System.out.println(isBST(root3));
    }

    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        return isBST(node.left, min, node.data - 1) &&
                isBST(node.right, node.data + 1, max);
    }
}
