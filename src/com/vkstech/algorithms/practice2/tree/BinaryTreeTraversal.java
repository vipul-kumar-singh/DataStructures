package com.vkstech.algorithms.practice2.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class BinaryTreeTraversal extends BinaryTree {

    public static void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void levelOrder(Node node) {
        if (node == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {

            node = q.remove();
            System.out.print(node.data + " ");

            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);
        }
    }

    public static void zigZagLevelOrder(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 1;

        StringJoiner sj = new StringJoiner("");

        while (!queue.isEmpty()) {
            int n = queue.size();
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                Node temp = queue.remove();

                sb.append(temp.data);

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }

            if (level % 2 == 0)
                sj.add(sb.reverse());
            else
                sj.add(sb);

            level++;
        }

        System.out.println(sj);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        LevelOrderInsertion.insert(bt, 1);
        LevelOrderInsertion.insert(bt, 2);
        LevelOrderInsertion.insert(bt, 3);
        LevelOrderInsertion.insert(bt, 4);
        LevelOrderInsertion.insert(bt, 5);
        LevelOrderInsertion.insert(bt, 6);
        LevelOrderInsertion.insert(bt, 7);

        preOrder(bt.root);
        System.out.println();

        postOrder(bt.root);
        System.out.println();

        inOrder(bt.root);
        System.out.println();

        levelOrder(bt.root);
        System.out.println();

        zigZagLevelOrder(bt.root);
        System.out.println();
    }
}
