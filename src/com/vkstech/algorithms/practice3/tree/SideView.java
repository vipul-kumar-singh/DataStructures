package com.vkstech.algorithms.practice3.tree;

import java.util.LinkedList;
import java.util.Queue;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

public class SideView {

    public static void main(String[] args) {
        MBinaryTree tree = new MBinaryTree();
        tree.insertLevelOrder(1, 2, 3, 4, 5);
        printLeftSide(tree.root);
        printRightSide(tree.root);
    }

    private static void printLeftSide(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                Node temp = queue.remove();

                if (i == 1)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        System.out.println();
    }

    private static void printRightSide(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                Node temp = queue.remove();

                if (i == n)
                    System.out.print(temp.data + " ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        System.out.println();
    }
}
