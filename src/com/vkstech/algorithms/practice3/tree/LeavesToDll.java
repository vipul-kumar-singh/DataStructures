package com.vkstech.algorithms.practice3.tree;

// https://www.geeksforgeeks.org/problems/leaves-to-dll/1
public class LeavesToDll {

    public static void main(String[] args) {
        Node root = new Node(1);

        Node leftNode = new Node(2);
        Node rightNode = new Node(3);

        leftNode.left = new Node(4);
        leftNode.right = new Node(5);

        rightNode.left = new Node(6);
        rightNode.right = new Node(7);

        root.left = leftNode;
        root.right = rightNode;

        Node dll = convertToDLL(root);
        System.out.println(dll.data);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node convertToDLL(Node root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        Node dll = new Node(-1);
        createDll(root, dll);
        dll = dll.right;
        dll.left = null;
        return dll;
    }

    private static boolean createDll(Node node, Node dll) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            Node newNode = new Node(node.data);

            Node temp = dll;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = newNode;
            newNode.left = temp;

            return true;
        }

        if (node.left != null) {
            boolean isChildNode = createDll(node.left, dll);
            if (isChildNode)
                node.left = null;

        }

        if (node.right != null) {
            boolean isChildNode = createDll(node.right, dll);
            if (isChildNode)
                node.right = null;
        }

        return false;
    }
}
