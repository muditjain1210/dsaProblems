package org.mudit.array_string;

import java.util.HashMap;

/**
 * A Trie or Prefix Tree an efficient data lookup structure - often used to store large collections
 * of words or dictionaries. With a Trie, search complexities can be reduced to O(k) where k is the
 * key or word length. The auto correct on your iOS or Android keyboard uses a Trie of the most commonly
 * used words along with fuzzy match algorithms to auto correct and auto suggest words as you type.
 * <p>
 * Example:
 * trie.inserWord("AB")
 * trie.inserWord("ABS")
 * trie.inserWord("ADS")
 * trie.inserWord("ADSD")
 * trie.inserWord("ACS")
 *
 * <p>
 * Internal Trie Structure:
 *
 * <br>
 * A
 * <br>
 * / | \
 * <br>
 * B C D
 * <br>
 * | | |
 * <br>
 * S S S
 * <br>
 * |
 * <br>
 * D
 * <p>
 * Note:
 * In the above example, underlined letters represent word boundaries. Word boundaries are important
 * when differentiating between words and prefixes. For example, searchPrefix("AC") should return true,
 * but since C is not a word boundary, searchWord("AC") should return false.
 * The TrieNode class has a Boolean - isLeaf that is used to denote if the node is a word boundary.
 */
public class TrieDS {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("AB");
        trie.insertWord("ABS");
        trie.insertWord("ADS");
        trie.insertWord("ADSD");
        trie.insertWord("ACS");
        // System.out.println(trie.toString());
        System.out.println(trie.searchWord("AC"));
    }

}

class Trie {
    private TrieNode root;

    public Trie() {
    }

    @Override
    public String toString() {
        return "Trie [root=" + root + "]";
    }

    public void insertWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        char[] ch = word.toCharArray();

        if (root == null) {
            root = new TrieNode(ch[0]);
        }
        TrieNode node = root;
        for (int i = 1; i < ch.length; i++) {
            if (node.children.containsKey(ch[i])) {
                node = node.children.get(ch[i]);
                continue;
            }
            TrieNode temp = new TrieNode(ch[i]);
            node.children.put(ch[i], temp);
            node.isLeaf = false;
            node = temp;
        }
        node.isLeaf = true;
    }

    public Boolean searchWord(String word) {
        if (root == null) {
            return false;
        }
        char[] ch = word.toCharArray();
        TrieNode node = root;

        if (node.c != ch[0]) {
            return false;
        }
        for (int i = 1; i < ch.length; i++) {
            if (!node.children.containsKey(ch[i])) {
                return false;
            }
            node = node.children.get(ch[i]);
        }
        return node.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        if (root == null) {
            return false;
        }
        char[] ch = word.toCharArray();
        TrieNode node = root;
        if (node.c != ch[0]) {
            return false;
        }
        for (int i = 1; i < ch.length; i++) {
            if (!node.children.containsKey(ch[i])) {
                return false;
            }
            node = node.children.get(ch[i]);
        }
        return true;
    }
}

class TrieNode {

    Character c;
    Boolean isLeaf = false;

    HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
    }

    public TrieNode(Character c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "TrieNode [c=" + c + ", isLeaf=" + isLeaf + ", children=" + children + "]";
    }
}