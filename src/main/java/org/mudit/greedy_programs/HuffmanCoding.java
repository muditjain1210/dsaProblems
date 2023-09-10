package org.mudit.greedy_programs;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        huffmanEncode(chars, freq);
    }

    public static void huffmanEncode(char[] chars, int[] freq) {
        // prepare HuffMan Tree from the characters and their frequencies..
        HuffManTreeNode root = prepareHuffManTree(chars, freq);

        // Prepare Huffman code from the HuffMan tree..
        HashMap<Character, String> table = new HashMap<>();
        prepareHuffManCodeTable(root, "", table);
        System.out.println(table);

    }

    public static void prepareHuffManCodeTable(HuffManTreeNode root, String s, HashMap<Character, String> table) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // leaf node..
            table.put(root.character, s);
            return;
        }

        prepareHuffManCodeTable(root.left, s + "0", table); // STRING ARE IMMUTABLE!!!
        prepareHuffManCodeTable(root.right, s + "1", table);
    }

    public static HuffManTreeNode prepareHuffManTree(char[] chars, int[] freq) {
        PriorityQueue<HuffManTreeNode> que = new PriorityQueue<>();

        // prepare min heap using priority queue.
        // Each element of min heap will be HuffMan Tree Node
        for (int i = 0; i < chars.length; i++) {
            que.add(new HuffManTreeNode(null, null, freq[i], chars[i]));
        }
        // We will loop until we have 1 element in min heap..
        while (que.size() > 1) {

            // Remove first two elements from min heap
            HuffManTreeNode node1 = que.poll();
            HuffManTreeNode node2 = que.poll();

            // Create a node from the above two node by adding their frequencies..
            // And make this new internal node left and right child above two nodes..
            HuffManTreeNode internalNode = new HuffManTreeNode(node1, node2, node1.frequency + node2.frequency, ' ');

            // Put this new internal node to min heap..
            que.add(internalNode);
        }
        // Last remaining node in the heap will be root of the Huffman Tree
        HuffManTreeNode root = que.poll();
        return root;
    }

}

class HuffManTreeNode implements Comparable<Object> {

    HuffManTreeNode left;
    HuffManTreeNode right;
    Integer frequency;
    char character;

    public HuffManTreeNode(HuffManTreeNode left, HuffManTreeNode right, Integer frequency, char character) {
        this.left = left;
        this.right = right;
        this.frequency = frequency;
        this.character = character;
    }

    @Override
    public int compareTo(Object o) {
        HuffManTreeNode node = (HuffManTreeNode) o;
        // Node with minimum frequency should have highest priority(top of min heap)
        return frequency.compareTo(node.frequency);
    }

    @Override
    public String toString() {
        return "HuffManTreeNode [left=" + left + ", right=" + right + ", frequency=" + frequency + ", character=" + character + "]";
    }

}