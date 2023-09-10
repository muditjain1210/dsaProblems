package org.mudit.tree;

import UserDefinedDataStructures.TreeNode;

/**
 * Given a binary tree consisting of nodes with positive integer values, write a method -
 * maxSumPath that returns the maximum sum of data values obtained by traversing nodes
 * along a path between any 2 nodes of the tree. The path must originate and terminate at 2
 * different nodes of the tree, and the maximum sum is obtained by summing all the data
 * values of the nodes traversed along this path.
 * <p>
 * Example:
 * 
 * 1
 * / \
 * 2 3 => 18
 * / \ / \
 * 4 5 6 7
 * 
 * Path: 5 -> 2 -> 1 -> 3 -> 7
 * Max Sum = 5+2+1+3+7 = 18
 * 
 * @author jainm15
 *
 */
public class TreeMaxSumPath {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static int maxSumPath(TreeNode root) {
        maxSumPathHelper(root);
        int sum = MAX;
        MAX = 0;
        return sum;
    }

    public static int MAX = Integer.MIN_VALUE;

    public static int maxSumPathHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxSumPathHelper(root.left);
        int rightSum = maxSumPathHelper(root.right);

        if (root.data + leftSum + rightSum > MAX) {
            MAX = root.data + leftSum + rightSum;
        }
        return Math.max(root.data + leftSum, root.data + rightSum);

    }

}
