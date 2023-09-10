package org.mudit.heap;

import java.util.ArrayList;

/**
 * Max heap insert and delete operations
 * 
 * @author jainm15
 *
 */
public class HeapOperations {

    public static void main(String[] args) {
        int arr[] = { 30, 40, 45, 1, 5, 7, 90 };
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        HeapSort(al);

    }

    /**
     * Max heap insert
     * Works in O(NLogN) for N insertions
     * 
     * @param arr
     * @return
     */
    public static ArrayList<Integer> prepareMaxHeap(ArrayList<Integer> arr) {
        ArrayList<Integer> maxHeap = new ArrayList<>();
        // put first element into the heap directly
        maxHeap.add(0, arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            maxHeap.add(i, arr.get(i));
            int parent = (i - 1) / 2;
            int child = i;
            while (maxHeap.get(parent) < maxHeap.get(child)) {
                // swap parent and this,percolate up
                int temp = maxHeap.get(parent);
                maxHeap.set(parent, maxHeap.get(child));
                maxHeap.set(child, temp);
                // now parent will be parent of current parent, and child will be current parent
                child = parent;
                parent = (parent - 1) / 2;
            }
        }
        return maxHeap;
    }

    public static int deleteMaxHeap(ArrayList<Integer> maxHeap) {
        // always delete top of the heap i.e max element from heap
        int result = maxHeap.get(0);

        // put last node at the root position.
        // This is very IMPORTANT to preserve complete BT property..
        maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
        maxHeap.remove(maxHeap.size() - 1);
        // Now we have maintain heap property, as we have moved last element to root..

        int parent = 0;
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;

        while (rightChild <= maxHeap.size()) {
            int maxChild = 0;
            if (rightChild == maxHeap.size()) {
                // there is only left child
                maxChild = leftChild;
            } else {
                maxChild = maxHeap.get(leftChild) > maxHeap.get(rightChild) ? leftChild : rightChild;
            }
            if (maxHeap.get(parent) < maxHeap.get(maxChild)) {
                // swap maxChild with its parent, percolate down
                int temp = maxHeap.get(parent);
                maxHeap.set(parent, maxHeap.get(maxChild));
                maxHeap.set(maxChild, temp);

                // Now parent will be maxChild and left, right child be its child..
                parent = maxChild;
                leftChild = 2 * parent + 1;
                rightChild = 2 * parent + 2;
            } else {
                break;
            }
        }

        return result;
    }

    public static void HeapSort(ArrayList<Integer> arr) {
        ArrayList<Integer> maxHeap = prepareMaxHeap(arr);
        System.out.println();
        for (int i = maxHeap.size(); i > 0; i--) {
            System.out.print(deleteMaxHeap(maxHeap) + " ");

        }

    }
}
