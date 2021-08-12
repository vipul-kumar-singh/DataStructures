package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Median of BST
 * Given a Binary Search Tree of size N, find the Median of its Node values.
 */
public class MedianOfBST extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(6, 3, 8, 1, 5, 7, 9).forEach(bst::insert);

        System.out.println(getMedian(bst));

        bst.root.right.right = null;
        System.out.println(getMedian(bst));
    }

    private static double getMedian(BinarySearchTree bst) {
        List<Integer> arrayList = new ArrayList<>();
        inOrderToList(bst.root, arrayList);

        int mid = arrayList.size() / 2;

        if (arrayList.size() % 2 != 0)
            return arrayList.get(mid);
        else
            return ((double) (arrayList.get(mid - 1) + arrayList.get(mid))) / 2;
    }

    private static void inOrderToList(Node node, List<Integer> list) {
        if (node == null)
            return;

        inOrderToList(node.left, list);
        list.add(node.data);
        inOrderToList(node.right, list);
    }
}
