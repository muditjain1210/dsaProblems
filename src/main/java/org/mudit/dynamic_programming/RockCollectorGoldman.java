package org.mudit.dynamic_programming;

import org.mudit.user_defined_data_structures.Square;

import java.util.HashMap;
import java.util.Map;

/**
 * You are an avid rock collector who lives in southern California. Some rare and desirable rocks just became available in New York, so you
 * are planning a cross-country road trip. There are several other rare rocks that you could pick up along the way. You have been given a
 * grid filled with numbers, representing the number of rare rocks available in various cities across the country. Your objective is to find
 * the optimal path from So_Cal to New_York that would allow you to accumulate the most rocks along the way.
 * <p>
 * Note: You can only travel either north (up) or east (right).
 * b) Consider adding some additional tests in doTestsPass().
 * c) Implement optimalPath() correctly.
 * d) Here is an example:
 * ^
 * {{0, 0, 0, 0, 5}, New_York (finish) N
 * {0, 1, 1, 1, 0},
 * So_Cal (start) {2, 0, 0, 0, 0}} S
 * v
 * The total for this example would be 10 (2+0+1+1+1+0+5).
 *
 * @author jainm15
 */
public class RockCollectorGoldman {

    static int maxWeight = 0;
    static Map<Square, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 5, 3, 4, 56, 6, 8, 9, 10},
                {0, 1, 1, 1, 0, 5, 6, 2, 3, 1, 8, 9,},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {0, 1, 1, 1, 0, 5, 6, 2, 3, 1, 8, 9,},
                {2, 0, 0, 0, 0, 7, 2, 34, 7, 89, 1, 23},
                {0, 1, 1, 1, 0, 5, 6, 2, 3, 1, 8, 9,},
                {0, 1, 1, 1, 0, 5, 6, 2, 3, 1, 8, 9,},

        };
        int starti = grid.length - 1;
        int startj = 0;
        int endi = 0;
        int endj = grid[0].length - 1;

        long startTime = System.currentTimeMillis();
        countPathWeightNormal(grid, starti, startj, endi, endj, 0);
        System.out.println(maxWeight);
        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

        System.out.println("===================================");

        startTime = System.currentTimeMillis();
        countPathWeightDynamic(grid, starti, startj, endi, endj);

        System.out.println(map.get(new Square(starti, startj)));
        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    public static void countPathWeightNormal(int[][] grid, int x, int y, int m, int n, int weight) {
        if (x < 0 || y > grid[0].length - 1) {
            return;
        }
        if (x == m && y == n) {
            weight += grid[x][y];
            if (weight > maxWeight) {
                maxWeight = weight;
            }
            return;
        }
        weight += grid[x][y];
        if (x > 0) {
            countPathWeightNormal(grid, x - 1, y, m, n, weight);
        }
        if (y < grid[0].length - 1) {
            countPathWeightNormal(grid, x, y + 1, m, n, weight);
        }
    }

    public static int countPathWeightDynamic(int[][] grid, int x, int y, int m, int n) {
        if (x < 0 || y > grid[0].length - 1) {
            return 0;
        }

        Square s = new Square(x, y);
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int weight = 0;

        if (x == m && y == n) {
            weight = grid[x][y];
            map.put(s, weight);
            return weight;
        }

        weight = grid[x][y];

        int upPathWeight = 0;
        if (x > 0) {
            upPathWeight = countPathWeightDynamic(grid, x - 1, y, m, n);
        }

        int rightPathWeight = 0;

        if (y < grid[0].length - 1) {
            rightPathWeight = countPathWeightDynamic(grid, x, y + 1, m, n);
        }

        map.put(s, weight + Math.max(upPathWeight, rightPathWeight));
        return weight + Math.max(upPathWeight, rightPathWeight);
    }
}
