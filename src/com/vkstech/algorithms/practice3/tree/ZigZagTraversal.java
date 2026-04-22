package com.vkstech.algorithms.practice3.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

public class ZigZagTraversal {

    public static void main(String[] args) {
        MBinaryTree tree = new MBinaryTree();
        tree.insertLevelOrder(1, 2, 3, 4, 5, 6, 7);
        ArrayList<Integer> res = zigZagTraversal(tree.root);
        System.out.println(res);
    }

    public static ArrayList<Integer> zigZagTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> res = new ArrayList<>();
        int level = 1;

        Stack<Node> stack = new Stack<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 1; i <= size; i++) {
                Node node = queue.remove();

                if (level % 2 == 0) {
                    stack.push(node);
                } else {
                    res.add(node.data);
                }

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

            }

            while (!stack.isEmpty()) {
                res.add(stack.pop().data);
            }

            level++;
        }
        return res;
    }
}
