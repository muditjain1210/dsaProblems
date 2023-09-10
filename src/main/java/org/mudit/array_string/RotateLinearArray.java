package org.mudit.array_string;

import java.util.HashMap;

/**
 * Rotate an array to the left by k positions without using extra space.k can be greater than the size of the array.
 * <p>
 * Example:
 * rotateLeft({1,2,3,4,5},2) --> {3,4,5,1,2}
 *
 * @author jainm15
 */
public class RotateLinearArray {

    public static void main(String[] args) {

        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        long time = System.currentTimeMillis();
        arr = rotateLeftUsingMap(arr, arr.length - 3);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        arr = rotateLeft(arr, arr.length - 3);
        System.out.println(System.currentTimeMillis() - time);
        /*
         * for (int i = 0; i < arr.length; i++) {
         * System.out.println(arr[i]);
         * }
         */

    }

    public static int[] rotateLeft(int[] arr, int k) {
        // Time: O(K*N) Space: Constant
        k = k % arr.length;
        if (k == 0) {
            return arr;
        }
        for (int j = 0; j < k; j++) {
            int temp = arr[0];

            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    public static int[] rotateLeftUsingMap(int[] arr, int k) {
        // Time: O(N) Space: O(N)
        k = k % arr.length;
        if (k == 0) {
            return arr;
        }
        HashMap<Integer, Integer> indexAfterKRot = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = i - k;
            // new index after k rotations would be (i-k) if (i-k) is negative it
            // means element's new index is rotated towards end
            int newIndex = diff < 0 ? arr.length + diff : diff;
            indexAfterKRot.put(arr[i], newIndex);
        }

        for (Integer i : indexAfterKRot.keySet()) {
            arr[indexAfterKRot.get(i)] = i;
        }
        return arr;
    }
}
