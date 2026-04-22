package com.vkstech.algorithms.practice3.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.N;
import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

public class LevelWiseOrder {

    public static void main(String[] args) {
        MBinaryTree bt1 = new MBinaryTree();
        bt1.insertLevelOrder(1, 2, 3, 4, 5, 6, 7, N, N, N, N, N, 8);
        ArrayList<ArrayList<Integer>> res1 = levelOrder(bt1.root);
        printArrayList(res1);

        MBinaryTree bt2 = new MBinaryTree();
        bt2.insertLevelOrder(10, 20, 30, 40, 60);
        ArrayList<ArrayList<Integer>> res2 = levelOrder(bt2.root);
        printArrayList(res2);
    }

    private static void printArrayList(ArrayList<ArrayList<Integer>> list) {
        list.forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                Node cur = q.remove();
                level.add(cur.data);

                if (cur.left != null)
                    q.add(cur.left);

                if (cur.right != null)
                    q.add(cur.right);
            }

            res.add(level);
        }

        return res;
    }
}
