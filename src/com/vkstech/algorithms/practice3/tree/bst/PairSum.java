package com.vkstech.algorithms.practice3.tree.bst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static com.vkstech.algorithms.practice3.tree.bst.MBinarySearchTree.Node;

// https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
public class PairSum {

    public static void main(String[] args) {
        MBinarySearchTree bst = new MBinarySearchTree();
        bst.insert(7, 3, 8, 2, 4, 9);
        System.out.println(findTarget(bst.root, 12));
    }

    public static boolean findTarget(Node root, int target) {
        if (root == null)
            return false;

        Set<Integer> set = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            int diff = target - temp.data;

            if (set.contains(diff)) {
                return true;
            }

            set.add(temp.data);

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return false;

    }
}
