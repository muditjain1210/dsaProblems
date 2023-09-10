package org.mudit.tree;

import UserDefinedDataStructures.TreeNode;

/**
 * Given a String that represents a Binary Tree, write a method - decompressTree that decompresses that tree (reconstructs the tree) and
 * returns the root TreeNode. The compression algorithm included traversing the tree level by level, from the left to the right. The
 * TreeNode's data values were appended to the String, delimited by commas. Also, null TreeNodes were denoted by appending an asterisk - *.
 * The input String denotes the structure of a Full Binary Tree - i.e. a tree that is structurally balanced. However, the reconstructed tree
 * may not be a full tree as the String included * characters, which represent null TreeNodes.
 * 
 * <p>
 * Note:
 * You can assume that if a Binary Tree contains k levels, the compressed String will contain 2k-1 elements - either numbers or *.</em>
 * <p>
 * Example:
 * Compressed String : "1,2,3,4,*,6,*"
 * 
 * Output Tree:
 * 1
 * / \
 * 2 3
 * / /
 * 4 6
 * 
 * 
 *
 */
public class TreeDecompression {

    public static void main(String[] args) {
        String str = "1,2,3,4,*,6,*";
        TreeNode root = decompressTree(str);
        System.out.println(root);

    }

    public static TreeNode decompressTree(String str) {
        String[] arr = str.split(",");
        return decompressTreeHelper(arr, 0);

    }

    public static TreeNode decompressTreeHelper(String[] arr, int index) {
        if (index >= arr.length || arr[index].equals("*")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        root.left = decompressTreeHelper(arr, 2 * index + 1);
        root.right = decompressTreeHelper(arr, 2 * index + 2);
        return root;

    }
}
