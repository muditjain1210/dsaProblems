package org.mudit.interviews_qstns;

import java.util.HashMap;

public class Amex {

    public static void main(String[] args) {

        int N = 35;
        System.out.println(Integer.toBinaryString(N));
        int largest = 0;
        int shift = 0;

        for (int i = 1; i < 30; ++i) {
            int bit = N & 1;

            N = N >> 1;
            System.out.println(Integer.toBinaryString(N));
            if (bit != 0) {
                N = N | (1 << 29);
            }
            System.out.print(N);
            System.out.print(" shift is " + i);
            System.out.println();
            if (N > largest) {
                largest = N;
                shift = i;
            }
        }

        System.out.println(shift);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(i)) {
                return 0;
            }
            map.put(new Integer(i), 1);
        }
        return 0;
    }

    public static String solution(String S) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int charCount = 0;
        for (char c : S.toCharArray()) {
            if (c == '-' || c == ' ') {
                continue;
            }

            if (count > 2) {
                result.append("-");
                count = 0;
            }
            charCount++;
            count++;
            result.append(c);
        }
        String s = result.toString();
        if (charCount % 3 == 1) {
            System.out.println("sdfs");
            char[] ch = s.toCharArray();

            ch[s.length() - 2] = ch[s.length() - 3];
            ch[s.length() - 3] = '-';
            String newStr = new String(ch);
            return newStr;
        }
        return s;
    }

}
