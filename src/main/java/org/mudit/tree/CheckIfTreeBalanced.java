package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

public class CheckIfTreeBalanced {

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);

        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode root = new TreeNode(1, n2, null);
        checkIfTreeIsBalanced(root);

    }

    static void checkIfTreeIsBalanced(TreeNode root) {
        int ht = checkIfTreeIsBalancedHelper(root);

        if (ht != Integer.MIN_VALUE) {
            System.out.println("BALANCED");
        } else {
            System.out.println("NOT BALANCED");
        }

    }

    static int checkIfTreeIsBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lheight = checkIfTreeIsBalancedHelper(root.left);

        if (lheight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rheight = checkIfTreeIsBalancedHelper(root.right);

        if (rheight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(lheight - rheight) > 1) {
            return Integer.MIN_VALUE;
        }
        return 1 + Math.max(lheight, lheight);
    }
}
