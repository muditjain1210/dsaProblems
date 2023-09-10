package org.mudit.arrayNString;

import java.util.ArrayList;

/**
 * Let's have some fun with 2D Matrices! Write a method findSpiral to traverse a 2D matrix of ints
 * in a clockwise spiral order and append the elements to an output ArrayList of Integers.
 * 
 * Example:
 * Input Matrix :
 * 
 * {1, 2, 3}
 * 
 * {4, 5, 6}
 * 
 * {7, 8, 9}
 * 
 * Output ArrayList:[1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 */
public class MatrixSpiral {

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
        System.out.println(findSpiral(arr));
    }

    public static ArrayList<Integer> findSpiral(int[][] a) {
        ArrayList<Integer> result = new ArrayList<>();

        int m = a.length;// ending row index
        int n = a[0].length; // ending column index
        int k = 0; // starting row index
        int l = 0;// starting column index
        int i = 0;

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                result.add(a[k][i]);
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i) {
                result.add(a[i][n - 1]);
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    result.add(a[m - 1][i]);
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    result.add(a[i][l]);
                }
                l++;
            }
        }

        return result;
    }
}
