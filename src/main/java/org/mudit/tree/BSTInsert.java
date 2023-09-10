package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

public class BSTInsert {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static TreeNode Insert(TreeNode root, int value) {
        if (root == null) {
            TreeNode n = new TreeNode();
            n.data = value;
            n.left = null;
            n.right = null;
            root = n;
        } else if (value < root.data) {
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }
        return root;
    }
}
