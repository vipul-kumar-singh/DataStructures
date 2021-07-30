package com.vkstech.algorithms.practice.tree;

/**
 * Construct Tree from Inorder & Preorder
 * Given 2 Arrays of Inorder and preorder traversal.
 * Construct a tree and print the Postorder traversal.
 */
public class TreeFromInOrderAndPreOrder extends BinaryTree {

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = constructTree(inorder, preorder, 0, inorder.length, 0);

        Traversal.printPostOrder(binaryTree);
    }

    private static Node constructTree(int[] inorder, int[] preorder,
                                      int inStart, int inEnd, int preStart) {
        Node parent = new Node(preorder[preStart]);

        int inMid;
        int rightPreStart = preStart;
        for (inMid = inStart; inMid < inEnd; inMid++) {
            rightPreStart++;
            if (inorder[inMid] == parent.data)
                break;
        }
        preStart++;

        if (inStart < inMid)
            parent.left = constructTree(inorder, preorder, inStart, inMid, preStart);

        if (inMid + 1 < inEnd)
            parent.right = constructTree(inorder, preorder, inMid + 1, inEnd, rightPreStart);

        return parent;
    }
}
