package org.mudit.user_defined_data_structures;

public class Node {
    public Node next;
    public int data;

    public Node(Node next, int data) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }
}
