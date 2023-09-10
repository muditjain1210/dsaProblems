package org.mudit.bit_manuplation;

/**
 * Given two input integers a and b, write a method to determine the number of bits required to
 * be swapped to convert a to b.
 * 
 * Example:
 * 
 * a = 21, Binary code = 10101
 * b = 31, Binary code = 11111
 * 
 * @author jainm15
 *
 */

public class BitSwappedRequired {

    public static void main(String[] args) {
        bitSwapRequired(2111111111, 311111111);
        bitSwapRequiredOptmized(2111111111, 311111111);

    }

    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        String str1 = Integer.toBinaryString(a);
        String str2 = Integer.toBinaryString(b);

        if (str1.length() < str2.length()) {
            int diff = str2.length() - str1.length();
            StringBuilder bui = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                bui.append("0");
            }
            bui.append(str1);
            str1 = bui.toString();
        }
        if (str1.length() > str2.length()) {
            int diff = str1.length() - str2.length();
            StringBuilder bui = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                bui.append("0");
            }
            bui.append(str2);
            str2 = bui.toString();
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int bitSwapRequiredOptmized(int a, int b) {
        // XOR operation will set bits( to 1) when there is difference in bit of a and b
        int c = a ^ b;
        // Now we have to just calculate number 1's in c..
        // This can be done either counting linearly..complexity O(N), N is number
        // of bits in c.
        // Another trick is to do c= c & (c-1), until c becomes zero, and count++ at each iteration..
        // this will take exactly K iterations, where is number of 1's in C!!!

        int count = 0;
        for (; c > 0; c = c & (c - 1)) {
            count++;
        }
        System.out.println(count);
        return count;
    }
}
