package com.vkstech.algorithms.practice3.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.vkstech.algorithms.practice3.tree.MBinaryTree.Node;

public class Serialization {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> serialize(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            root = q.remove();
            res.add(root.data);

            if (root.left != null) {
                q.add(root.left);
            }

            if (root.right != null) {
                q.add(root.right);
            }
        }

        return res;
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        Node root = build(arr, 0);
        return root;
    }

    private Node build(ArrayList<Integer> arr, int i) {
        if (i >= arr.size() || arr.get(i) == -1) {
            return null;
        }

        Node node = new Node(arr.get(i));
        node.left = build(arr, 2 * i + 1);
        node.right = build(arr, 2 * i + 2);

        return node;
    }
}
