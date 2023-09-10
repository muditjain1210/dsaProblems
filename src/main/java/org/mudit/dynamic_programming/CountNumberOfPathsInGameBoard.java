package org.mudit.dynamic_programming;

import org.mudit.user_defined_data_structures.Square;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPathsInGameBoard {

    static Map<Square, Integer> map = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        countPathsFromThisSquareDynamic(1, 1, 15, 15);
        System.out.println(map.get(new Square(1, 1)));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("================================");
        start = System.currentTimeMillis();
        countPathsFromThisSquareNormal(1, 1, 15, 15); // will take ~2.5 minutes for 19,20!!!
        System.out.println(count);
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static int countPathsFromThisSquareDynamic(int x, int y, int m, int n) {
        if (x == m && y == n) {
            return 1;
        }
        Square s = new Square(x, y);
        if (map.get(s) != null) {
            return map.get(s);
        }
        int rpaths = 0;
        if (x < m) {
            rpaths = countPathsFromThisSquareDynamic(x + 1, y, m, n);
        }
        int dpaths = 0;
        if (y < n) {
            dpaths = countPathsFromThisSquareDynamic(x, y + 1, m, n);
        }
        map.put(s, rpaths + dpaths);
        return rpaths + dpaths;
    }

    public static void countPathsFromThisSquareNormal(int x, int y, int m, int n) {
        if (x == m && y == n) {
            count++;
            return;
        }
        if (x < m) {
            countPathsFromThisSquareNormal(x + 1, y, m, n);
        }
        if (y < n) {
            countPathsFromThisSquareNormal(x, y + 1, m, n);
        }
    }

}
