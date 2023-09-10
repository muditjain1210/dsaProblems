package org.mudit.searching_sorting;

/**
 * Sort an array with only 0s and 1s
 *
 * @author jainm15
 */
public class SortZeroOneArray {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 0, 0, 1};
        sortArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void sortArray(int[] arr) {
        int pivot = arr[0];
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            while (arr[i] <= pivot && i < arr.length) {
                i++;
            }
            while (arr[j] > pivot && j >= 0) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot with j..
        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;
    }
}
