package com.vkstech.algorithms.practice2.mostAsked;

import com.vkstech.algorithms.practice.tree.BinaryTree.Node;
import com.vkstech.algorithms.practice.tree.BinaryTree;
import com.vkstech.algorithms.practice.tree.LevelOrderInsertion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class InOrderTraversal {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 5).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));

        printLevelOrder(binaryTree);
        printInOrder(binaryTree.root);
        System.out.println();
    }

    private static void printLevelOrder(BinaryTree binaryTree) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.root);

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);

            System.out.print(node.data);

        }
        System.out.println();
    }

    private static void printInOrder(Node node) {
        if (node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);

    }
}
