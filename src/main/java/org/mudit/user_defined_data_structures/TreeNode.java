package org.mudit.user_defined_data_structures;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {

    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;

    }

    public static TreeNode constructTree() {
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);

        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode root = new TreeNode(1, n2, n3);
        return root;
    }

    @Override
    public String toString() {
        return "TreeNode " + data;
    }
}
