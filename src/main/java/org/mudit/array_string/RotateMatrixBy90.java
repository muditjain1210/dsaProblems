package org.mudit.array_string;

import java.util.Objects;

public class RotateMatrixBy90 {

    public static void main(String[] args) {
        Long l = null;
        Long l2 = 12l;
        if (Objects.equals(l, l2)) {
            System.out.println("yes");
        }
    }

    /**
     * Rotate matrix by 90 degree anti-clockwise.
     *
     * @param mat input 2D array
     */
    public static void rotateMatrix(int[][] mat) {
        int k = 0;
        while (k < mat.length - 2) {
            int length = mat.length - 1 - k;
            for (int i = length, j = k; i > k && j < length; i--, j++) {
                int temp1 = mat[i][k];
                mat[i][k] = mat[k][j];
                int temp2 = mat[length][i];
                mat[length][i] = temp1;
                int temp3 = mat[j][length];
                mat[j][length] = temp2;
                mat[k][j] = temp3;
            }
            k++;
        }
    }

    public static void transposeMatrix2(int[][] arr) {
        int level = arr.length / 2;
        int k = 0;
        while (k < level) {
            int i = k + 1;
            int j = k;
            //Upper row
            swap(i, j, k, arr);

            //Lower row
            j = arr.length - 1 - k;
            swap(i, j, k, arr);
            k++;
        }
    }

    private static void swap(int i, int j, int k, int[][] arr) {
        while (i < arr.length - k) {
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
            i++;
        }
    }

    static void flipAlongHorizontalAxis2(int[][] mat) {
        int k = mat.length / 2;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < mat.length; j++) {
                // flip only half of the rows along horizontal axis
                int temp = mat[i][j];
                mat[i][j] = mat[mat.length - 1 - i][j];
                mat[mat.length - 1 - i][j] = temp;
            }
        }
    }

    static void rotateMatrixClockwiseUsingTransposeAndVerticalFlip(int[][] mat) {
        // First Transpose the matrix i.e change rows to columns and columns to rows..
        transposeMatrix(mat);
        // Now we will do vertical flip i.e swap values along vertical lines..
        flipAlongVerticalAxis(mat);
    }

    static void rotateMatrixAntiClockwiseUsingTransposeAndHorizontalFlip(int[][] mat) {
        // First Transpose the matrix i.e. change rows to columns and columns to rows..
        transposeMatrix(mat);
        // Now we will do horizontal flip i.e swap values along horizontal lines..
        flipAlongHorizontalAxis(mat);
    }

    static void transposeMatrix(int[][] mat) {
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < i; j++) {
                // will swap lower half with upper half along diagonal..
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    static void flipAlongVerticalAxis(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length / 2; j++) {
                // flip only half of the columns along vertical axis
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length - 1 - j];
                mat[i][mat.length - 1 - j] = temp;
            }
        }
    }

    static void flipAlongHorizontalAxis(int[][] mat) {
        for (int i = 0; i < mat.length / 2; i++) {
            for (int j = 0; j < mat.length; j++) {
                // flip only half of the rows along horizontal axis
                int temp = mat[i][j];
                mat[i][j] = mat[mat.length - 1 - i][j];
                mat[mat.length - 1 - i][j] = temp;
            }
        }
    }

    // Function to print the matrix
    static void displayMatrix(int[][] mat) {
        for (int[] ints : mat) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(" " + ints[j]);
            }
            System.out.print("\n");
        }
    }

    static void rotate(int[][] a) {
        int n = a.length;
        int totalLayers = n / 2;

        for (int l = 0; l <= totalLayers; l++) {
            for (int p = 1; p <= (n - (2 * l) - 1); p++) {
                int temp = a[l][l + p - 1];
                a[l][l + p - 1] = a[n - p - l][l];
                a[n - p - l][l] = a[n - l - 1][n - p - l];
                a[n - l - 1][n - p - l] = a[p + l - 1][n - l - 1];
                a[p + l - 1][n - l - 1] = temp;
            }
        }
    }
}
