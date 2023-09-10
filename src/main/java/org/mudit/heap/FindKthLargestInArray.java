package org.mudit.heap;

import java.util.ArrayList;

/**
 * Find kth largest element in a array.
 * We will use heap to find this.
 *
 * @author jainm15
 */
public class FindKthLargestInArray {

    public static void main(String[] args) {
        int[] arr = {30, 40, 45, 1, 5, 7, 90};
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        findKthLargest(al, 4);

    }

    public static int findKthLargest(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> maxHeap = HeapOperations.prepareMaxHeap(arr);
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result = HeapOperations.deleteMaxHeap(maxHeap);
        }
        System.out.println(result);
        return result;
    }

}
