package org.mudit.array_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MatrixSpiralTest {

    @Test
    void findSpiral() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Assertions.assertEquals(List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), MatrixSpiral.findSpiral(arr));

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assertions.assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), MatrixSpiral.findSpiral(arr2));

        int[][] arr3 = {{1}};
        Assertions.assertEquals(List.of(1), MatrixSpiral.findSpiral(arr3));

        int[][] arr4 = {{1, 2}, {3, 4}};
        Assertions.assertEquals(List.of(1, 2, 4, 3), MatrixSpiral.findSpiral(arr4));

        int[][] arr5 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13), MatrixSpiral.findSpiral(arr5));
    }

    @Test
    void find2DArraySpiral() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Assertions.assertEquals(List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), MatrixSpiral.find2DArraySpiral(arr));

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assertions.assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), MatrixSpiral.find2DArraySpiral(arr2));

        int[][] arr3 = {{1}};
        Assertions.assertEquals(List.of(1), MatrixSpiral.find2DArraySpiral(arr3));

        int[][] arr4 = {{1, 2}, {3, 4}};
        Assertions.assertEquals(List.of(1, 2, 4, 3), MatrixSpiral.find2DArraySpiral(arr4));

        int[][] arr5 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13), MatrixSpiral.find2DArraySpiral(arr5));
    }
}