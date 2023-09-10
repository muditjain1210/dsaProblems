package org.mudit.user_defined_data_structures;

public class ListNode {
    public ListNode next;
    public int data;

    public ListNode(ListNode next, int data) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }
}
