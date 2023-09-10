package org.mudit.hash_map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
//Own implemented HashMap
public class MyHashMap<K, V> implements Map<K, V> {
    private HashMapEntry<K, V>[] table;
    private int size; // total number of key-values in map
    private int threshold;  // resizing barrier( size* DEFAULT_LOAD_FACTOR)

    private static final int DEFAULT_SIZE = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMap() {
        this.table = new HashMapEntry[DEFAULT_SIZE];
        this.threshold = (int) (DEFAULT_SIZE * DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap) {
        this.table = new HashMapEntry[cap];
        this.threshold = (int) (cap * DEFAULT_LOAD_FACTOR);
    }

    static class HashMapEntry<K, V> {

        K key; // to store key
        V value; // to store value
        int hashcode;   // to store hashCode of key
        HashMapEntry<K, V> next;  // pointer to next node

        HashMapEntry(int hashcode, K key, V value, HashMapEntry<K, V> next) {
            this.hashcode = hashcode;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "HashMapEntry [key=" + key + ", value=" + value + ", hashcode=" + hashcode + ", next=" + next + "]";
        }
    }

    @Override
    public V put(K key, V value) {
        return putVal(key, value, hash(key));
    }

    private V putVal(K key, V value, int hashCode) { // put key value in the map and return value if being replaced..
        int bucket = hashCode == 0 ? 0 : hashCode & (table.length - 1);

        HashMapEntry<K, V> node = table[bucket];
        if (node == null) {
            // NO Collision case..
            table[bucket] = new HashMapEntry<>(hashCode, key, value, null);
        } else {
            // bucket has node..Collision case..
            HashMapEntry<K, V> prevNode = null;
            for (HashMapEntry<K, V> tempNode = table[bucket]; tempNode != null; tempNode = tempNode.next) {

                if (hashCode == tempNode.hashcode &&
                        ((key == tempNode.key) || (key != null && key.equals(tempNode.key)))) {
                    // we hit the node whose key is logically equals to parameter key
                    HashMapEntry<K, V> n2 = tempNode;
                    tempNode.value = value; // replace the original value with new value
                    return n2.value;
                }
                prevNode = tempNode;
            }
            // we didn't find any node "equals" to the provided key.so append this node to end of LL..
            HashMapEntry<K, V> n3 = new HashMapEntry<>(hashCode, key, value, null);
            prevNode.next = n3;
        }
        if (++size > threshold) {
            // we have to resize the map
            resize();
        }
        return null;
    }

    private static int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // re
    private HashMapEntry<K, V>[] resize() {
        int newcap = table.length << 1; // double the length of table..
        threshold = (int) (newcap * DEFAULT_LOAD_FACTOR);
        HashMapEntry<K, V>[] newTab = new HashMapEntry[newcap];

        for (int i = 0; i < table.length; i++) {
            HashMapEntry<K, V> node = table[i];
            if (node != null) {
                table[i] = null;// setting null at old table i-th position..
                newTab[node.hashcode & (newcap - 1)] = node;
                node = node.next;
                while (node != null) {

                }
            }

        }

        return null;

    }

    @Override
    public V get(Object key) {
        int hashCode = hash(key);
        int bucket = hashCode & table.length - 1;
        if (table[bucket] == null) {
            // no node present at this bucket
            return null;
        }
        for (HashMapEntry<K, V> tempNode = table[bucket]; tempNode != null; tempNode = tempNode.next) {
            if (hashCode == tempNode.hashcode &&
                    ((key == tempNode.key) || (key != null && key.equals(tempNode.key)))) {
                // we hit the node whose key is logically equals to parameter key
                return tempNode.value;
            }
        }
        // no node with given key in this bucket..
        return null;
    }

    @Override
    public V remove(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return false;
    }
}
