package org.mudit.tree;

import UserDefinedDataStructures.TreeNode;

public class FindMaxInEvenOddBST {

    public static void main(String[] args) {

        TreeNode n9 = new TreeNode(60, null, null);
        TreeNode n10 = new TreeNode(45, null, null);

        TreeNode n8 = new TreeNode(50, n9, n10);

        TreeNode n6 = new TreeNode(40, null, n8);
        TreeNode n7 = new TreeNode(26, null, null);

        TreeNode n4 = new TreeNode(22, null, null);
        TreeNode n5 = new TreeNode(10, null, null);

        TreeNode n2 = new TreeNode(20, n4, n5);
        TreeNode n3 = new TreeNode(30, n6, n7);

        TreeNode root = new TreeNode(25, n2, n3); // Level 1

        System.out.println(findMaxNode(root));
    }

    public static int level = 1;

    static TreeNode findMaxNode(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (level % 2 == 0) {
            // EVEN LEVEL
            // root.right < root < root.left
            if (root.left == null) {
                return root;
            } else {
                level++;
                return findMaxNode(root.left);
            }
        }
        if (level % 2 != 0) {
            // ODD level
            // root.left < root < root.right

            if (root.right == null) {
                return root;
            } else {
                level++;
                return findMaxNode(root.right);
            }
        }
        return null;
    }
}
