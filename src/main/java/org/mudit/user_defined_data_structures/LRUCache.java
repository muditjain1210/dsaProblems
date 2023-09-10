package org.mudit.user_defined_data_structures;

import java.util.HashMap;

/**
 * Design a data structure for LRU Cache. It should support the following operations: get and set.
 * <p>
 * get(key) � Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * <p>
 * set(key, value) � Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * <p>
 * Examples:
 * 
 * // Let�s say we have a LRU cache of capacity 2.
 * LRUCache cache = new LRUCache(2);
 * <p>
 * cache.set(1, 10); // it will store a key (1) with value 10 in the cache.
 * cache.set(2, 20); // it will store a key (2) with value 20 in the cache.
 * cache.get(1); // returns 10
 * cache.set(3, 30); // evicts key 2 and store a key (3) with value 30 in the cache.
 * cache.get(2); // returns -1 (not found)
 * cache.set(4, 40); // evicts key 1 and store a key (4) with value 40 in the cache.
 * cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 30
 * cache.get(4); // returns 40
 * 
 * @author jainm15
 *
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [key=" + key + ", value=" + value + "]";
        }
    }

    private HashMap<Integer, Node> map;
    private int capicity, count;
    private Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capicity = capacity;
    }

    // This method works in O(1)
    public int get(int key) {
        if (!map.containsKey(key)) {
            System.out.println("This key is NOT present");
            return -1;
        }
        Node node = map.get(key);

        if (node == head) {
            // requested node is already the head of LL, no need to do anything..
            System.out.println("Requested node is already the head of LL, no need to do anything.." + head);
            return node.value;
        }
        if (node == tail) {
            node.pre.next = null;
            tail = node.pre;
        } else {
            // delete this node
            Node prev = node.pre;
            Node next = node.next;
            prev.next = next;
            next.pre = prev;
        }
        // make this node as head..
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
        System.out.println("New head will be this node(Most recently used) " + head);
        return head.value;
    }

    // This method works in O(1)
    public void set(int key, int value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
            count++;
            map.put(key, node);
            return;
        }
        if (count < capicity) {
            System.out.println("Appending node to tail " + tail);
            // append to tail..
            tail.next = node;
            node.pre = tail;
        } else {
            // delete the tail and add this node..
            System.out.println("Deleting tail: " + tail + "and making this node as tail.");
            Node prev = tail.pre;
            prev.next = node;
            node.pre = prev;
            map.remove(tail.key);
        }
        tail = node;
        count++;
        map.put(key, node);
    }

    public static void main(String args[]) {
        LRUCache cache = new LRUCache(5);
        cache.set(3, 10);
        cache.set(5, 25);
        cache.set(1, 11);
        cache.set(2, 16);
        cache.set(7, 19);
        cache.get(3);
        cache.get(7);
        cache.set(6, 21);
    }
}
