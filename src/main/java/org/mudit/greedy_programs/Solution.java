package org.mudit.greedy_programs;

import java.util.HashSet;
import java.util.Scanner;

import UserDefinedDataStructures.ListNode;

/**
 * 
 * 
 * @author jainm15
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queryCount = scanner.nextInt();

        scanner.close();
    }

    static int findMergeNode(ListNode head1, ListNode head2) {
        int result = 0;
        HashSet<ListNode> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (set.contains(head2)) {
                result = head2.data;
            }
            head2 = head2.next;
        }
        return result;
    }

}
