package org.mudit.array_string;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rotate an array to the left by k positions without using extra space.k can be greater than the size of the array.
 * <p>
 * Example:
 * rotateLeft({1,2,3,4,5},2) --> {3,4,5,1,2}
 *
 * @author jainm15
 */
@Log4j2
public class RotateLinearArray {
    /**
     * This method will take O(k*n) time complexity but will take constant space
     *
     * @param arr
     * @param k
     * @return
     */
    public static List<Integer> rotateLeftKTimes(int[] arr, int k) {
        //rotating array by arr.length times will give original array itself
        //If k is greater than arr.length we can get actual rotations by this:
        k = k % arr.length;

        while (k > 0) {
            int firstElement = arr[0];
            for (int index = 1; index < arr.length; index++) {
                arr[index - 1] = arr[index];
            }
            arr[arr.length - 1] = firstElement;
            k--;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        return Arrays.stream(arr).boxed().toList();
    }

    public static List<Integer> rotateLeftKTimesUsingStorage(int[] arr, int k) {
        //rotating array by arr.length times will give original array itself
        //If k is greater than arr.length we can get actual rotations by this:
        k = k % arr.length;

        //Store all elements with their index as key and element at index and value in map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }

        for (int index = 0; index < arr.length; index++) {
            int newIndex = index - k; //this will k times left shift
            if (newIndex < 0) {   //negative means number has to moved to right side..
                newIndex = arr.length + newIndex;
            }
            arr[newIndex] = map.get(index);
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
        return Arrays.stream(arr).boxed().toList();
    }

    public static void printKTimesLeftRotatedArray(int[] arr, int k) {
        //rotating array by arr.length times will give original array itself
        //If k is greater than arr.length we can get actual rotations by this:
        k = k % arr.length;

        log.info("Rotating input array {} times", k);
        for (int index = 0; index < arr.length; index++) {
            int newIndex = index - k; //this will k times left shift
            if (newIndex < 0) {   //negative means number has to moved to right side..
                newIndex = arr.length + newIndex;
            }
            System.out.println(arr[newIndex]);
        }
    }
}
