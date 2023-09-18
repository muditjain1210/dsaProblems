package org.mudit.bit_manuplation;

/**
 * Given an integer 30-bit integer N, represented in binary by the array Q[29], Q[28], � , Q[0], the
 * right cyclically shifted value of N is the number resulting from shifting every one of its bits
 * to the right (i.e. its binary representation will be Q[0], Q[29], ..., Q[1]).
 * <p>
 * Find the largest possible number resulting from cyclically shifting N to the right. Your function
 * should accept the integer N and return K, the number of shifts necessary to get the largest
 * number.
 * <p>
 * For example:
 * <li>the right cyclic shift of 9,736 by one bit is 4,868
 * <li>the right cyclic shift of 9,736 by two bits is 2,434
 * <li>the right cyclic shift of 9,736 by three bits is 1,217
 * <li>the right cyclic shift of 9,736 by four bits is 268,435,760
 * <li>the right cyclic shift of 9,736 by eleven bits is 809,500,676
 * <p>
 * The function should accept N = 9736 and return K = 11;
 */
public class RightCyclicShift {

    /**
     * The function shifts the given number to the right exactly 30 positions, keeping track of the
     * maximum value and shifts needed to reach it. If the right shift would cause a 1 to be lost,
     * it is added back to the first position available (of the 30 bits) by OR-ing the shifted
     * number with 1 << 29.
     * If n = n:
     * Time Complexity: O(log n) (actually it will always do 30 iterations)
     * Space Complexity: O(1)
     *
     * @param n The input number
     * @return The number of positions to shift to the right in order to obtain the maximum value
     */
    public static int largestCyclicShift(int n) {
        int max = n;
        int maxK = 0;
        for (int i = 1; i < 30; i++) {
            int bit = n & 1;
            n = n >> 1;

            if (bit != 0) {
                n = n | (1 << 29);
                System.out.println("1 Dropping case!!");

            }
            System.out.println("Number by right shift: " + n + " Binary: " + Integer.toBinaryString(n));
            if (n > max) {
                max = n;
                maxK = i;
            }
        }
        System.out.println(max);
        return maxK;
    }

    public static void main(String[] args) {
        largestCyclicShift(32);
    }
}
