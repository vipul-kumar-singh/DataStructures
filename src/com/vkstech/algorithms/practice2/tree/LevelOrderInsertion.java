package com.vkstech.algorithms.practice2.tree;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp.left == null) {
                temp.left = node;
                break;
            }
            queue.add(temp.left);

            if (temp.right == null) {
                temp.right = node;
                break;
            }
            queue.add(temp.right);
        }
    }
}
