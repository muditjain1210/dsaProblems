package org.mudit.linkedlist;

import java.util.ArrayList;

import UserDefinedDataStructures.ListNode;

/**
 * Write a method to merge k Sorted Linked Lists. Why would you ever want to do that? Well, if
 * you're dealing with a list of over 200 Million Integers that needs to be sorted, an efficient
 * approach might involve splitting up the massive list into k smaller lists, sorting each list in
 * memory and then combining the sorted lists to re-create the original list, albeit sorted.
 * <p>
 * Example:
 * Inputs Lists :
 * LinkedList1: 1->2->13->20
 * LinkedList2: 1->20->35->40
 * LinkedList3: 5->6->12->18
 * <p>
 * Output List:
 * LinkedList: 1->1->2->5->6->12->13->18->20->20->35->40
 * <p>
 * Note:
 * mergeKLists takes in an ArrayList of ListNodes - lists, where each ListNode is the head of a
 * custom Linked List structure.
 * 
 * @author jainm15
 *
 */
public class MergeKSortedLL {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode root = null;
        ListNode result = null;
        while (lists.size() > 1) {
            int minIndex = findMinValueIndex(lists);
            ListNode minNode = lists.get(minIndex);
            if (root == null) {
                root = minNode;
                result = root;
            } else {
                result.next = minNode; // attach this min node to result list..
                result = result.next;
            }
            if (minNode.next != null) {
                lists.set(minIndex, minNode.next); // change pointer of list[minIndex] to next node
                minNode.next = null; // current min node next should be set to null.

            } else {
                // delete this index from array, as this list is finished
                lists.remove(minIndex);
            }

        }
        // process the last list..
        result.next = lists.get(0);
        return root;
    }

    public static int findMinValueIndex(ArrayList<ListNode> lists) {
        int minIndex = 0;
        int min_value = Integer.MAX_VALUE;

        for (int i = 0; i < lists.size(); i++) {
            int data = lists.get(i).data;
            if (data < min_value) {
                min_value = data;
                minIndex = i;
            }
        }
        return minIndex;
    }

}
