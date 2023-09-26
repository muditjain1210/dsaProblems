package org.mudit.array_string;

import org.junit.jupiter.api.Test;

import static org.mudit.array_string.RotateMatrixBy90.*;

class RotateMatrixBy90Test {

    @Test
    void rotateMatrixTest() {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] mat2 = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26}};

        rotateMatrix(mat);
        displayMatrix(mat);
        rotateMatrix(mat2);
        displayMatrix(mat2);
    }

    @Test
    void transposeMatrixTest() {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] mat2 = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        //transposeMatrix2(mat);
        transposeMatrix2(mat2);
    }

    @Test
    void rotateMatrixTestUsingTranspose() {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] mat2 = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        transposeMatrix2(mat2);
        displayMatrix(mat2);
        System.out.println();
        flipAlongHorizontalAxis2(mat2);
        displayMatrix(mat2);
    }
}