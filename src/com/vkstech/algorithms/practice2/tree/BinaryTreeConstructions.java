package com.vkstech.algorithms.practice2.tree;

import java.util.HashMap;

public class BinaryTreeConstructions extends BinaryTree {

    private final static HashMap<Integer, Integer> map = new HashMap<>();
    private static int index;

    private static Node buildTree(int[] in, int[] post, int len) {
        for (int i = 0; i < len; i++)
            map.put(in[i], i);

        index = len - 1;
        return buildUtil(post, 0, len - 1);
    }

    private static Node buildUtil(int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        int curr = postOrder[index];
        Node node = new Node(curr);
        index--;

        if (inStart == inEnd)
            return node;

        int iIndex = map.get(curr);

        node.right = buildUtil(postOrder, iIndex + 1, inEnd);
        node.left = buildUtil(postOrder, inStart, iIndex - 1);
        return node;
    }


    private static Node constructTreeFromPreAndIn(int[] inorder, int[] preorder,
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
            parent.left = constructTreeFromPreAndIn(inorder, preorder, inStart, inMid, preStart);

        if (inMid + 1 < inEnd)
            parent.right = constructTreeFromPreAndIn(inorder, preorder, inMid + 1, inEnd, rightPreStart);

        return parent;
    }

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.root = buildTree(inOrder, postOrder, inOrder.length);
        BinaryTreeTraversal.preOrder(binaryTree1.root);

        System.out.println();

        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};

        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.root = constructTreeFromPreAndIn(inorder, preorder, 0, inorder.length, 0);
        BinaryTreeTraversal.postOrder(binaryTree2.root);
    }

}
