package com.vkstech.algorithms.practice.binarySearchTree;

public class SortedArrayToBalancedBST extends BinarySearchTree {

    public static void main(String[] args) {
        int[] inputArr = new int[]{1, 2, 3, 4, 5, 6, 7};

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = sortedArrayToBST(inputArr, 0, inputArr.length - 1);

        PreOrderTraversal.printPreorder(bst);
    }

    public static Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}
