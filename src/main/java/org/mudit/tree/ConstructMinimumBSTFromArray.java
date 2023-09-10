package org.mudit.tree;

import UserDefinedDataStructures.TreeNode;

/**
 * This program construct minimum height BST from sorted input {@code array}
 * 
 * @author jainm15
 *
 */
public class ConstructMinimumBSTFromArray {
    public static void main(String args[]) {
        int[] ar = { 1, 2, 3, 4, 5, 6, 7 };

        TreeLevelOrderTraveral.levelOrderTraversal(constructMinimumBST(ar));

        System.out.println("======================");
        int[] ar2 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        TreeLevelOrderTraveral.levelOrderTraversal(constructMinimumBST(ar2));

    }

    static TreeNode constructMinimumBST(int[] ar) {
        return constructMinimumHelper(ar, 0, ar.length - 1);

    }

    static TreeNode constructMinimumHelper(int[] ar, int st, int end) {

        // This condition comes when calling node has only 1 child.
        // then starting index would become greater than end index
        // either for right child or left one, depending which is null..
        if (st > end) {
            return null;
        }
        if (st == end) {
            // serves base condition when there is only 1 element in array
            // serves construction of leaf nodes..
            return new TreeNode(ar[st], null, null);
        }

        int mid = (st + end) / 2;
        TreeNode root = new TreeNode(ar[mid], null, null);
        root.left = constructMinimumHelper(ar, st, mid - 1);
        root.right = constructMinimumHelper(ar, mid + 1, end);
        return root;
    }
}
