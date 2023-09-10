package org.mudit.bit_manuplation;


public class BitManuplationProblems {
    static String decimalToBinary(float num) {
        int count = 1;
        StringBuilder b = new StringBuilder();

        while (num != 0 && count <= 32) {
            int i = (int) (num * 2); // Integral part in Binary representation
            b.append(i);
            num = num * 2;
            if (num >= 1) {
                num = num - 1;
            }
            count++;
        }

        if (count > 32) {
            return "ERROR";
        }
        System.out.println(b);
        System.out.println(b.length());
        return b.toString();
    }

    static String integerToBinary(int i) {
        StringBuilder b = new StringBuilder();

        while (i != 1) {
            b.append(i % 2);
            i = i / 2;
        }
        b.append("1");
        b.reverse();
        return b.toString();
    }

    static void insertBit(int n, int m, int j, int i) {
        // Insert M into N between j and i position..

        // Step1: Clear off bits of N between j and i

        // Prepare mask like, 111 000 111
        int mask1 = -1 << j + 1;
        int mask2 = (1 << i) - 1;
        int mask = mask1 | mask2;
        // CLear off bits (j-->i) in N
        int n_cleared = n & mask;

        // Step2: Left Shift M by i places, to insert into M..
        int m_shifted = m << i;

        // Step3: Insert m_shifted to n_cleared by ORing them..
        int result = n_cleared | m_shifted;

        System.out.println(Integer.toBinaryString(result));

    }

    static int getBit(int num, int i) {
        int mask = 1 << i; // 0000(1-ith position)00000
        return ((num & mask) != 0) ? 1 : 0;

    }

    static int setBit(int num, int i) {
        int mask = 1 << i;
        return num | mask;
    }
}
