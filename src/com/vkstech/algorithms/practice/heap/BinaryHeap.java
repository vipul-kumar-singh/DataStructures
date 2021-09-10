package com.vkstech.algorithms.practice.heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class BinaryHeap<T> {

    private Node<T> root;
    private final Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public static class Node<E> {
        E data;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
            return;
        }

        Node<T> temp = root;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.left == null) {
                node.parent = temp;
                temp.left = node;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                node.parent = temp;
                temp.right = node;
                break;
            } else {
                q.add(temp.right);
            }
        }

        heapifyUp(node);
    }

    private void heapifyUp(Node<T> node) {
        if (node.parent != null && comparator.compare(node.data, node.parent.data) > 0) {
            swap(node, node.parent);
            heapifyUp(node.parent);
        }
    }

    private void swap(Node<T> node1, Node<T> node2) {
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void delete() {
        Node<T> temp = root;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        swap(root, temp);
        deleteNode(temp);
        heapifyDown(root);
    }

    private void heapifyDown(Node<T> node) {
        Node<T> swapNode;
        if (node.left != null && node.right != null) {
            swapNode = comparator.compare(node.left.data, node.right.data) > 0 ? node.left : node.right;
        } else if (node.left != null && comparator.compare(node.left.data, node.data) > 0) {
            swapNode = node.left;
        } else if (node.right != null && comparator.compare(node.right.data, node.data) > 0) {
            swapNode = node.right;
        } else {
            return;
        }
        swap(node, swapNode);
        heapifyDown(swapNode);
    }

    private void deleteNode(Node<T> node) {
        if (node == root) {
            root = null;
            return;
        }

        if (node == node.parent.left) {
            node.parent.left = null;
            node.parent = null;
            return;
        }

        if (node == node.parent.right) {
            node.parent.right = null;
            node.parent = null;
        }
    }

    public T getTop() {
        return root.data;
    }

}
