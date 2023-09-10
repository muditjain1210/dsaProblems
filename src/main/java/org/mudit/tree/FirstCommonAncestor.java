package org.mudit.tree;

import UserDefinedDataStructures.TreeNode;

public class FirstCommonAncestor {

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode n11 = new TreeNode(11, null, null);

        TreeNode n8 = new TreeNode(8, n10, n11);
        TreeNode n9 = new TreeNode(9, null, null);

        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);

        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, n8, n9);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode root = new TreeNode(1, n2, n3);
        // System.out.println(firstCommonAncestorOptimized(root, n10, n11));
        System.out.println(firstCommonAncestor(root, n4, n7));

    }

    static TreeNode firstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        // When either of n1 or n2 is CHILD of this root, then root will be first ancestor
        if (root.left.data == n1.data || root.left.data == n2.data || root.right.data == n1.data || root.right.data == n2.data) {
            return root;
        }

        FoundNodes fndNodes = searchNodes(root.left, n1, n2, new FoundNodes());
        if (fndNodes.isNode1Founded ^ fndNodes.isNode2Founded) {
            // One of the node is not present in the left subtree of this root, so root should be first common ancestor..
            return root;
        }
        if (!(fndNodes.isNode1Founded && fndNodes.isNode2Founded)) {
            // Both of the nodes are NOT present in Left subtree, we have search right subtree
            return firstCommonAncestor(root.right, n1, n2);
        }
        if (fndNodes.isNode1Founded && fndNodes.isNode2Founded) {
            // Both of the nodes are present in Left subtree, we have to search deeper not
            return firstCommonAncestor(root.left, n1, n2);
        }
        return root;
    }

    static FoundNodes searchNodes(TreeNode root, TreeNode n1, TreeNode n2, FoundNodes fndNodes) {
        if (root == null) {
            return fndNodes;
        }

        if (root.data == n1.data) {
            fndNodes.isNode1Founded = true;
        }
        if (root.data == n2.data) {
            fndNodes.isNode2Founded = true;
        }
        if (fndNodes.isNode1Founded && fndNodes.isNode2Founded) {
            return fndNodes;
        }

        searchNodes(root.left, n1, n2, fndNodes);
        searchNodes(root.right, n1, n2, fndNodes);
        return fndNodes;
    }

    static TreeNode firstCommonAncestorOptimized(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        // When either of n1 or n2 is CHILD of this root, then root will be first ancestor
        if (root.left != null && (root.left.data == n1.data || root.left.data == n2.data)) {
            return root;
        }
        if (root.right != null && (root.right.data == n1.data || root.right.data == n2.data)) {
            return root;
        }
        firstCommonAncestorOptimized(root.left, n1, n2);

        firstCommonAncestorOptimized(root.right, n1, n2);

        return null;
    }
}

class FoundNodes {
    boolean isNode1Founded;
    boolean isNode2Founded;
}