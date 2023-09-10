package org.mudit.linkedlist;

import UserDefinedDataStructures.Node;

public class LinkedListProblems {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static Node addLinkedListForward(Node n1, Node n2) {
        // Get length of both LL
        int l1 = getLenth(n1);
        int l2 = getLenth(n2);

        // padd Zeros to shorter LL
        if (l1 > l2) {
            n2 = paddingZeroToList(n2, l1 - l2);
        }
        if (l2 > l1) {
            n1 = paddingZeroToList(n1, l2 - l1);
        }

        PartialSum sum = getPartialSum(n1, n2);

        if (sum != null && sum.carry != 0) {
            return new Node(sum.n, 1);
        }
        if (sum != null && sum.carry == 0) {
            return sum.n;
        }

        return null;
    }

    static PartialSum getPartialSum(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }

        PartialSum sum = getPartialSum(n1.next, n2.next);

        if (sum == null) {
            // We hit the end of LL
            int carry = 0;
            int digit = n1.data + n2.data;
            if (digit > 9) {
                digit = digit % 10;
                carry = 1;
            }
            Node n = new Node(null, digit);
            return new PartialSum(n, carry);

        } else {
            int carry = 0;
            int digit = n1.data + n2.data + sum.carry;

            if (digit > 9) {
                digit = digit % 10;
                carry = 1;
            }
            Node n = new Node(sum.n, digit);
            return new PartialSum(n, carry);
        }

    }

    static int getLenth(Node n) {
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    static Node paddingZeroToList(Node head, int zeroCount) {
        Node newHead = head;
        for (int i = 0; i < zeroCount; i++) {
            newHead = new Node(newHead, 0);
        }
        return newHead;
    }

    static void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

    static Node sumLinkedListReverse(Node n1, Node n2) {
        int carry = 0;
        Node result = null;
        Node head = null;
        while (n1 != null || n2 != null || carry != 0) {
            int digit = carry;

            if (n1 != null) {
                digit += n1.data;
                n1 = n1.next;
            }

            if (n2 != null) {
                digit += n2.data;
                n2 = n2.next;
            }

            if (digit > 9) {
                digit = digit % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            if (result == null) {
                result = new Node(null, digit);
                head = result;
            } else {
                result.next = new Node(null, digit);
                result = result.next;
            }

        }
        return head;
    }

    static Node partition(Node n, int x) {
        Node retHead = null;
        Node stTail = null;
        Node head = null;
        Node tail = null;

        while (n != null) {
            if (n.data < x) {
                if (head == null) {
                    head = n;
                    retHead = n;
                } else {
                    head.next = n;
                    head = head.next;
                }
            } else {
                if (tail == null) {
                    tail = n;
                    stTail = n;
                } else {
                    tail.next = n;
                    tail = tail.next;
                }
            }
            n = n.next;
        }
        head.next = stTail;
        tail.next = null;
        return retHead;
    }

    static Node deleteDuplicate2(Node head) {
        if (head.next == null) {
            return head;
        }
        Node n1 = head;
        while (n1 != null) {
            Node n2 = n1.next;
            Node prev = n1;

            while (n2 != null) {
                if (n2.data == n1.data) {
                    prev.next = n2.next;
                    n2 = n2.next;
                } else {
                    prev = n2;
                    n2 = n2.next;
                }
            }
            n1 = n1.next;
        }
        return head;
    }

    static Node findKthFromLast(Node head, int k) {
        Node runner1 = head;
        Node runner2 = null;
        int count = 0;
        while (runner1 != null) {

            if (count == k) {
                runner2 = head;
            }
            if (runner2 != null && runner1.next != null) {
                runner2 = runner2.next;
            }
            runner1 = runner1.next;
            count++;

        }
        return runner2;
    }

    static Node prepareLLwithSize(int size) {
        Node head = null;
        Node tail = null;
        for (int i = 1; i <= size; i++) {

            if (tail == null) {
                tail = new Node(null, i);
                head = tail;

            } else {
                tail.next = new Node(null, i);
                tail = tail.next;
            }

        }
        return head;
    }

    public static int findSize(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + findSize(head.next);
    }

    public Node deleteKthNodeFromEnd(Node head, int k) {
        if (head == null) {
            return head;
        }
        Node fast = head;
        // ListNode slow = null;
        int i = 1;
        while (i < k && fast != null) {
            fast = fast.next;
            i++;
        }
        return null;
    }

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node temp = null;
        while (head != null) {
            temp = head.next; // save head.next
            head.next = prev;

            prev = head;
            head = temp;
        }
        return prev;
    }

}

class PartialSum {
    Node n;
    int carry;

    PartialSum(Node n, int carry) {
        this.carry = carry;
        this.n = n;
    }
}
