package com.vkstech.algorithms.practice.tree;

import com.vkstech.algorithms.practice.linkedList.doubly.DoublyLinkedList;

import java.util.stream.IntStream;

/**
 * Leaves to DLL
 * Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List strating from the left most leaf.
 * Modify the original tree to make the DLL thus removing the leaf nodes from the tree.
 * Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.
 */
public class LeavesToDll extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.rangeClosed(1, 7).forEach(i -> LevelOrderInsertion.insert(binaryTree, i));
        System.out.println("Original Tree : ");
        Traversal.printPreOrder(binaryTree);

        DoublyLinkedList doublyLinkedList = getDoublyLinkedList(binaryTree);

        System.out.println("Modified Tree : ");
        Traversal.printPreOrder(binaryTree);

        System.out.println("Doubly LinkedList :");
        doublyLinkedList.print();
    }

    private static DoublyLinkedList getDoublyLinkedList(BinaryTree binaryTree) {
        DoublyLinkedList dll = new DoublyLinkedList();
        checkLeafNode(binaryTree.root, dll);
        return dll;
    }

    private static boolean checkLeafNode(Node node, DoublyLinkedList dll) {
        if (node == null)
            return false;

        if (node.left == null && node.right == null) {
            dll.insertAtTail(node.data);
            return true;
        }

        if (checkLeafNode(node.left, dll))
            node.left = null;

        if (checkLeafNode(node.right, dll))
            node.right = null;

        return false;
    }


}
