package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeTopView {

    public static void main(String[] args) {
        topView(TreeNode.constructTree());

    }

    static void topView(TreeNode root) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        prepareMap(root, 0, mp);
        for (Integer i : mp.keySet()) {
            System.out.print(mp.get(i).get(0) + " ");
        }

    }

    static void prepareMap(TreeNode root, int dist, Map<Integer, List<Integer>> mp) {
        if (root == null) {
            return;
        }

        if (mp.containsKey(dist)) {
            List<Integer> nodes = mp.get(dist);
            nodes.add(root.data);
            mp.put(dist, nodes);
        } else {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(root.data);
            mp.put(dist, nodes);
        }

        prepareMap(root.left, dist - 1, mp);
        prepareMap(root.right, dist + 1, mp);
    }
}
