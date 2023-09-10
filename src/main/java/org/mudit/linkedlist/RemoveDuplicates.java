package org.mudit.linkedlist;

import java.util.HashSet;

import UserDefinedDataStructures.ListNode;

/**
 * Given a singly-linked list, remove duplicates in the list and return head of the list.
 * Target a worst case space complexity of O(n).
 * 
 * Examples:
 * 1->2->2->4->3->1 ==> 1->2->4->3
 * 1 ==> 1
 * "" ==> ""
 * 
 * @author jainm15
 *
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (!set.contains(curr.data)) {
                set.add(curr.data);
                prev = curr;
            } else {
                // delete this node..
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
