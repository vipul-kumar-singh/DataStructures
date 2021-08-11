package com.vkstech.algorithms.practice.binarySearchTree;

import java.util.*;

/**
 * Find a pair with given sum in BST
 * Given a Binary Search Tree and a target sum.
 * Check whether there's a pair of Nodes in the BST with value summing up to the target sum
 */
public class PairSum extends BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(6, 5, 3, 1, 4).forEach(bst::insert);

        getPair(bst, 7);
        getPair(bst, 5);
        getPair(bst, 2);
        getPair(bst, 8);
    }

    private static void getPair(BinarySearchTree bst, int sum) {
        Set<Integer> set = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(bst.root);

        int num1 = -1;
        int num2 = -1;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (set.contains(node.data)) {
                num1 = node.data;
                num2 = sum - node.data;
                break;
            }

            if (node.data > sum) {
                queue.add(node.left);
                continue;
            }

            int diff = sum - node.data;
            set.add(diff);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        if (num1 == -1 && num2 == -1)
            System.out.println("Pair with sum " + sum + " not found!");
        else
            System.out.println(sum + " = " + num1 + " + " + num2);
    }
}
