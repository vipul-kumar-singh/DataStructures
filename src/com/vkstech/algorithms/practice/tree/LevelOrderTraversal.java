package com.vkstech.algorithms.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class LevelOrderTraversal extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 15).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        printLevelOrder(binaryTree);
    }

    private static void printLevelOrder(BinaryTree binaryTree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }
}
