package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This program will create Linked Lists from Tree Nodes at each level
 *
 * @author jainm15
 */
public class LinkedListForEachDepth {

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree();
        for (LinkedList<TreeNode> l : getListOfLinkedListAtEachDepth(root)) {
            System.out.println(l);
        }

    }

    static ArrayList<LinkedList<TreeNode>> getListOfLinkedListAtEachDepth(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> al = new ArrayList<>();

        LinkedList<TreeNode> zeroDepth = new LinkedList<>();
        zeroDepth.add(root);
        al.add(0, zeroDepth);

        for (int i = 0; al.get(i) != null; i++) {

            LinkedList<TreeNode> thisDepthLL = al.get(i);
            LinkedList<TreeNode> nextDepthLL = null;
            // Iterate over all nodes of this depth
            for (TreeNode node : thisDepthLL) {
                if (node.left != null) {
                    if (nextDepthLL == null) {
                        nextDepthLL = new LinkedList<>();
                    }
                    nextDepthLL.add(node.left);
                }
                if (node.right != null) {
                    nextDepthLL.add(node.right);
                }
            }
            // add nextdepth LL to array
            al.add(i + 1, nextDepthLL);
        }
        return al;
    }

}