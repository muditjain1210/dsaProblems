package org.mudit.linkedlist;

import org.mudit.user_defined_data_structures.Node;

import java.util.Stack;

/**
 * Given a singly-linked list, write a method isListPalindrome to determine if the list is a palindrome.
 * A palindrome is a sequence that reads the same backward as forward.
 * Examples:
 * <p>
 * 1->2->3->2->1 ==> true
 * <p>
 * 1->2->2->3 ==> false
 * <p>
 * 1 ==> true
 * <p>
 * null ==> true
 *
 * @author jainm15
 */
public class LinkedListPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * Using stack
     * Time: O(N), Space: O(N)
     *
     * @param head
     * @return
     */
    static boolean isLLPalindromeUsingStack(Node head) {
        if (head == null || head.next == null) {
            return true; // Single/Zero node is always palindrome..
        }
        boolean isPalindrome = true;

        Node slow = head;
        Node fast = head; // fast moves 2X of slow..

        Stack<Integer> stack = new Stack<>(); // considering LL contains int data

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // In case of even LL fast would reach end of LL (null) and slow will be next element exactly to middle
        // slow--> 1,2,3,4 fast--> 1,3,5,null (LL size 6)
        // In case of odd slow would be at middle but fast would be at last element.
        // slow--> 1,2,3,4 fast--> 1,3,5,7 (LL size 7)
        // so we can skip middle element (odd case) and increment slow by 1.
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pop()) {
                isPalindrome = false;
                break;
            }
            slow = slow.next;
        }

        return isPalindrome;

    }

    /**
     * Without using any extra space..
     * TIME: O(N), Space: O(1).
     *
     * @param head
     * @return
     */
    public Boolean isListPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // find middle of list
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int middle = (count / 2) + 1;

        // reach till middle
        temp = head;
        int i = 1;
        while (i < middle) {
            temp = temp.next;
            i++;
        }

        // reverse from this middle point..
        Node prev = null;
        while (temp != null) {
            Node temp2 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }

        // compare two half null
        while (prev != null) {
            if (prev.data != head.data) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
