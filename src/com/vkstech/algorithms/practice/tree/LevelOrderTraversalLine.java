package com.vkstech.algorithms.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Print level order traversal line by line
 */
public class LevelOrderTraversalLine extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 15).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        printLevelOrder(binaryTree);
    }

    private static void printLevelOrder(BinaryTree binaryTree) {
        Queue<Node> outerQueue = new LinkedList<>();
        outerQueue.add(binaryTree.root);

        while (!outerQueue.isEmpty()) {
            Queue<Node> innerQueue = new LinkedList<>();

            while (!outerQueue.isEmpty()) {
                innerQueue.add(outerQueue.remove());
            }

            while (!innerQueue.isEmpty()) {
                Node node = innerQueue.remove();
                System.out.print(node.data + " ");

                if (node.left != null)
                    outerQueue.add(node.left);

                if (node.right != null)
                    outerQueue.add(node.right);
            }
            System.out.println();

        }
        System.out.println();
    }
}
