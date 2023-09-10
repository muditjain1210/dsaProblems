package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBSTProperty {

    public static int prev = Integer.MIN_VALUE;
    public static boolean isBST = true;

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(2, null, null);
        TreeNode n5 = new TreeNode(6, null, null);

        TreeNode n6 = new TreeNode(31, null, null);
        TreeNode n7 = new TreeNode(45, null, null);

        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n3 = new TreeNode(30, n6, n7);

        TreeNode root = new TreeNode(10, n2, n3);
        validateBST(root);
        // validateBSTIterative(root);
        // System.out.println(isBST);

    }

    public static void validateBST(TreeNode root) {
        if (root == null || !isBST) {
            return;
        }
        validateBST(root.left);

        if (root.data < prev) {
            isBST = false;
            System.out.println("NOT BST!!!!!!!");
            return;
        }
        prev = root.data;

        validateBST(root.right);
    }

    public static boolean validateBSTIterative(TreeNode root) {
        Queue<TreeNodeMinMax> q = new LinkedList<>();
        TreeNodeMinMax first = new TreeNodeMinMax(root, Integer.MIN_VALUE, root.data, root.data, Integer.MAX_VALUE);
        q.add(first);

        while (!q.isEmpty()) {
            TreeNodeMinMax temp = q.remove();
            if (temp.node.left != null) {
                TreeNode LChild = temp.node.left;
                if (LChild.data > temp.LMin && LChild.data < temp.LMax) { // validate BST property
                    // Create new TreeNodeMinMAx and add to Q..
                    TreeNodeMinMax tempNode = new TreeNodeMinMax(LChild, temp.LMin, LChild.data, LChild.data, temp.LMax);
                    q.add(tempNode);
                } else {
                    System.out.println("NOT BST!!!!!!!");
                    return false;
                }
            }

            if (temp.node.right != null) {
                TreeNode RChild = temp.node.right;
                if (RChild.data > temp.RMin && RChild.data < temp.RMax) { // validate BST property
                    // Create new TreeNodeMinMAx and add to Q..
                    TreeNodeMinMax tempNode = new TreeNodeMinMax(RChild, temp.RMin, RChild.data, RChild.data, temp.RMax);
                    q.add(tempNode);
                } else {
                    System.out.println("NOT BST!!!!!!!");
                    return false;
                }
            }
        }
        System.out.println("IS A  BST!!!!!!!");
        return true;
    }

    static class TreeNodeMinMax {

        TreeNode node;
        int LMin;
        int LMax;
        int RMin;
        int RMax;

        public TreeNodeMinMax(TreeNode node, int lMin, int lMax, int rMin, int rMax) {
            this.node = node;
            LMin = lMin;
            LMax = lMax;
            RMin = rMin;
            RMax = rMax;
        }

    }
}
