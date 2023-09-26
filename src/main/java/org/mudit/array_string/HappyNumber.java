package org.mudit.array_string;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;

/**
 * Write a method to determine whether a positive number is Happy.
 * A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below :
 * Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1 or loops endlessly
 * in a cycle that does not include 1.
 * <p>
 * For instance, 19 is a happy number. Sequence:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author jainm15
 */
@Log4j2
public class HappyNumber {
    /**
     * get the digits of input number, get their sum of squares, if it is 1 return true,
     * else check whether we already received that sum, if yes return false.
     * This will take some linear space, not constant space..
     *
     * @param n input number
     * @return true or false
     */
    public static boolean isHappyNumber(int n) {
        log.info("Number to be checked : {}", n);
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int temp = n;
        while (true) {

            int sum = getSumOfSquares(temp);
            if (sum == 1) {
                log.info("Number : {} is happy Number", n);
                return true;
            }
            if (set.contains(sum)) {
                log.info("Number : {} is NOT happy Number", n);
                return false;
            }
            set.add(sum);
            temp = sum;
        }
    }

    /**
     * This technique will take constant space, one for slow sum, another for fast sum
     *
     * @param n
     * @return
     */
    public static boolean isHappyNumberWithConstantSpace(int n) {
        log.info("Number to be checked : {}", n);
        int slowSum = n;
        int fastSum = getSumOfSquares(slowSum);
        fastSum = getSumOfSquares(fastSum);

        while (true) {
            if (slowSum == 1 || fastSum == 1) {
                log.info("Number : {} is happy Number==========", n);
                return true;
            }
            log.info("SlowSum is: {} fastSum is : {}", slowSum, fastSum);

            if (slowSum == fastSum) {
                log.info("Number : {} is NOT happy Number===========", n);
                return false;
            }
            slowSum = getSumOfSquares(slowSum);
            fastSum = getSumOfSquares(fastSum);
            fastSum = getSumOfSquares(fastSum);
        }
    }

    private static int getSumOfSquares(int n) {
        int number = n;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum = sum + (int) Math.pow(digit, 2);
            n = n / 10;
        }
        log.info("Sum of square of digits of Number: {} is  {}", number, sum);
        return sum;
    }
}
