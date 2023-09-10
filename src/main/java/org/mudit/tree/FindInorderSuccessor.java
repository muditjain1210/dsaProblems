package org.mudit.tree;

import UserDefinedDataStructures.TreeNode;

public class FindInorderSuccessor {
    public static void main(String[] args) {
        TreeNode n8 = new TreeNode(8, null, null);
        TreeNode n9 = new TreeNode(9, null, null);

        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, n8, n9);

        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode root = new TreeNode(1, n2, n3);

        findInorderSuccesor(root, root);
        isPreVisited = false;
        System.out.println(succ);

    }

    static boolean isPreVisited = false;
    static TreeNode succ = null;

    static void findInorderSuccesor(TreeNode root, TreeNode node) {

        if (succ != null) {
            return;
        }
        if (root == null) {
            return;
        }

        findInorderSuccesor(root.left, node);

        if (isPreVisited && succ == null) {
            System.out.println("Successor node is " + root.data);
            succ = root;
            return;
        }

        if (root.data == node.data) {
            System.out.println("Visted the input node " + root.data);
            isPreVisited = true;
        }

        findInorderSuccesor(root.right, node);

    }

}
