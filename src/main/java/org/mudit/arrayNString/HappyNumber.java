package org.mudit.arrayNString;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Write a method to determine whether a postive number is Happy.
 * A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below :
 * Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1 or loops endlessly
 * in a cycle that does not include 1.
 * 
 * For instance, 19 is a happy number. Sequence:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * @author jainm15
 *
 */
public class HappyNumber {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(isHappyNumber(9999));
        }

    }

    public static boolean isHappyNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int temp = n;
        while (true) {
            int sum = getSumOfSquares(temp);
            if (set.contains(sum)) {
                return false;
            }
            if (sum == 1) {
                return true;
            }
            set.add(sum);
            temp = sum;

        }
    }

    public static int getSumOfSquares(int n) {
        int sum = 0;
        ArrayList<Integer> al = new ArrayList<>();

        while (n > 0) {
            al.add(n % 10);
            n = n / 10;
        }

        for (int i : al) {
            sum = sum + (int) Math.pow(i, 2);
        }
        return sum;
    }

}
