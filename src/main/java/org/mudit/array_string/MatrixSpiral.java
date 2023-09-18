package org.mudit.array_string;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

/**
 * Let's have some fun with 2D Matrices! Write a method findSpiral to traverse a 2D matrix of ints
 * in a clockwise spiral order and append the elements to an output ArrayList of Integers.
 * <p>
 * Example:
 * Input Matrix :
 * <p>
 * {1, 2, 3}
 * <p>
 * {4, 5, 6}
 * <p>
 * {7, 8, 9}
 * <p>
 * Output ArrayList:[1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
@Log4j2
public class MatrixSpiral {

    public static ArrayList<Integer> findSpiral(int[][] a) {
        ArrayList<Integer> result = new ArrayList<>();

        int m = a.length;// ending row index
        int n = a[0].length; // ending column index
        int k = 0; // starting row index
        int l = 0;// starting column index
        int i;

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


    public static List<Integer> find2DArraySpiral(int[][] arr) {

        List<Integer> result = new ArrayList<>();
        int st_row = 0;
        int end_row = arr.length - 1;
        int st_col = 0;
        int end_col = arr[0].length - 1;

        while (st_row <= end_row && st_col <= end_col) {

            if ((st_col == end_col) && (st_row == end_row)) {
                result.add(arr[st_row][st_col]);
                break;
            }

            //From top left to right, row will be fix
            for (int i = st_col; i <= end_col; i++) {
                result.add(arr[st_row][i]);
            }
            log.info(result);

            //From top right to bottom right, column will be fix
            for (int i = st_row + 1; i <= end_row; i++) {
                result.add(arr[i][end_col]);
            }
            log.info(result);

            //From bottom right to bottom left, row will be fix
            for (int i = end_col - 1; i >= st_col; i--) {
                result.add(arr[end_row][i]);
            }
            log.info(result);

            //From bottom left to top right, column will be fix
            for (int i = end_row - 1; i > st_row; i--) {
                result.add(arr[i][st_col]);
            }
            log.info(result);

            st_row++;
            end_row--;
            st_col++;
            end_col--;
        }
        return result;
    }
}
