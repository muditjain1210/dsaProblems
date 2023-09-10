package org.mudit.arrayNString;

public class RotateMatrixBy90 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        rotateMatrixAntiClockwiseUsingTransposeAndHorizontalFlip(mat);
        displayMatrix(mat);

    }

    static void rotateMatrixClockwiseUsingTransposeAndVerticalFlip(int mat[][]) {
        // First Transpose the matrix i.e change rows to columns and columns to rows..
        transposeMatrix(mat);
        // Now we will do vertical flip i.e swap values along vertical lines..
        flipAlongVerticalAxis(mat);
    }

    static void rotateMatrixAntiClockwiseUsingTransposeAndHorizontalFlip(int mat[][]) {
        // First Transpose the matrix i.e change rows to columns and columns to rows..
        transposeMatrix(mat);
        // Now we will do horizontal flip i.e swap values along horizontal lines..
        flipAlongHorizontallAxis(mat);
    }

    static void transposeMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
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

    static void flipAlongHorizontallAxis(int[][] mat) {
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
    static void displayMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(" " + mat[i][j]);
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
