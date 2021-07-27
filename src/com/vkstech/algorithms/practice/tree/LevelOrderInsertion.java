package com.vkstech.algorithms.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Insertion in a Binary Tree in level order
 * Given a binary tree and a key, insert the key into the binary tree at the first position available in level order.
 */
public class LevelOrderInsertion extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        insert(tree, 4);
        insert(tree, 3);
        insert(tree, 7);
        insert(tree, 1);
        insert(tree, 9);
        insert(tree, 2);
    }

    public static void insert(BinaryTree tree, int data) {
        Node node = new Node(data);

        if (tree.root == null) {
            tree.root = node;
            return;
        }

        Node temp = tree.root;
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.left == null) {
                temp.left = node;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = node;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }
}
