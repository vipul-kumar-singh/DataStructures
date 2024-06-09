package com.vkstech.algorithms.practice2.tree;

class Dll {
    DllNode head;
    DllNode tail;

    static class DllNode {
        int data;
        DllNode next;
        DllNode previous;

        public DllNode(int data) {
            this.data = data;
        }
    }
}

public class BinaryTreeConversion extends BinaryTree {

    private static Dll getDllFromBT(BinaryTree bt) {
        Dll dll = new Dll();
        dll.head = getDllNode(bt.root);

        Dll.DllNode temp = dll.head;
        while (temp.next != null) {
            Dll.DllNode prev = temp;
            temp = temp.next;
            temp.previous = prev;
        }
        dll.tail = temp;
        return dll;
    }

    private static Dll.DllNode getDllNode(Node node) {
        if (node == null)
            return null;

        Dll.DllNode temp = getDllNode(node.left);
        Dll.DllNode root = temp;

        if (temp != null) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Dll.DllNode(node.data);
            temp = temp.next;
        } else {
            temp = new Dll.DllNode(node.data);
            root = temp;
        }

        temp.next = getDllNode(node.right);

        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        LevelOrderInsertion.insert(bt, 35);
        LevelOrderInsertion.insert(bt, 19);
        LevelOrderInsertion.insert(bt, 16);
        LevelOrderInsertion.insert(bt, 15);
        LevelOrderInsertion.insert(bt, 4);
        LevelOrderInsertion.insert(bt, 10);
        LevelOrderInsertion.insert(bt, 6);

        Dll dll = getDllFromBT(bt);
        System.out.println(dll);
    }

}


