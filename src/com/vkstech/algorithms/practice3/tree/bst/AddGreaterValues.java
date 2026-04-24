package com.vkstech.algorithms.practice3.tree.bst;

import static com.vkstech.algorithms.practice3.tree.bst.MBinarySearchTree.Node;

// https://www.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1
public class AddGreaterValues {

    public static void main(String[] args) {
        MBinarySearchTree bst = new MBinarySearchTree();
        bst.insert(50, 30, 70, 20, 40, 60, 80);
        modify(bst.root);
        bst.printLevelOrder();
    }

    public static Node modify(Node root) {
        if (root == null) {
            return null;
        }

        modify(root, 0);
        return root;
    }

    private static int modify(Node node, int sum) {
        if (node == null) {
            return sum;
        }

        int rightSum = modify(node.right, sum);

        sum = rightSum + node.data;
        node.data = sum;

        int leftSum = modify(node.left, sum);

        return leftSum;
    }
}
