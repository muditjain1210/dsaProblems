package org.mudit.array_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RotateLinearArrayTest {

    @Test
    void rotateLeftKTimes() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), RotateLinearArray.rotateLeftKTimes(arr, 0));
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), RotateLinearArray.rotateLeftKTimes(arr, 6));
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), RotateLinearArray.rotateLeftKTimes(arr, 12));

        Assertions.assertEquals(List.of(2, 3, 4, 5, 6, 1), RotateLinearArray.rotateLeftKTimes(arr, 1));
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(3, 4, 5, 6, 1, 2), RotateLinearArray.rotateLeftKTimes(arr2, 2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(4, 5, 6, 1, 2, 3), RotateLinearArray.rotateLeftKTimes(arr3, 3));
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(5, 6, 1, 2, 3, 4), RotateLinearArray.rotateLeftKTimes(arr4, 4));
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(6, 1, 2, 3, 4, 5), RotateLinearArray.rotateLeftKTimes(arr5, 5));
    }

    @Test
    void rotateLeftKTimesWithStorage() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), RotateLinearArray.rotateLeftKTimesUsingStorage(arr, 0));
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), RotateLinearArray.rotateLeftKTimesUsingStorage(arr, 6));
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), RotateLinearArray.rotateLeftKTimesUsingStorage(arr, 12));

        Assertions.assertEquals(List.of(2, 3, 4, 5, 6, 1), RotateLinearArray.rotateLeftKTimesUsingStorage(arr, 1));
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(3, 4, 5, 6, 1, 2), RotateLinearArray.rotateLeftKTimesUsingStorage(arr2, 2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(4, 5, 6, 1, 2, 3), RotateLinearArray.rotateLeftKTimesUsingStorage(arr3, 3));
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(5, 6, 1, 2, 3, 4), RotateLinearArray.rotateLeftKTimesUsingStorage(arr4, 4));
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(List.of(6, 1, 2, 3, 4, 5), RotateLinearArray.rotateLeftKTimesUsingStorage(arr5, 5));
    }

    @Test
    void printKTimesLeftRotatedArrayTest() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        RotateLinearArray.printKTimesLeftRotatedArray(arr, 0);
        RotateLinearArray.printKTimesLeftRotatedArray(arr, 6);
        RotateLinearArray.printKTimesLeftRotatedArray(arr, 12);

        RotateLinearArray.printKTimesLeftRotatedArray(arr, 1);
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        RotateLinearArray.printKTimesLeftRotatedArray(arr2, 2);
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        RotateLinearArray.printKTimesLeftRotatedArray(arr3, 3);
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        RotateLinearArray.printKTimesLeftRotatedArray(arr4, 4);
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        RotateLinearArray.printKTimesLeftRotatedArray(arr5, 5);
    }
}