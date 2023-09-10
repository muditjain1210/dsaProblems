package org.mudit.interviews_qstns;

public class GolmanSchs {

    public static void main(String[] args) {
        secureChannel(2, "oppeeen", "123");

    }

    static int[] convertToDigitArray(String key) {

        int temp = Integer.valueOf(key);
        int[] tt = new int[key.length()];
        int i = tt.length - 1;
        do {
            tt[i] = temp % 10;
            temp /= 10;
            i--;
        } while (temp > 0);
        return tt;
    }

    static int nonRepeatingDigitProductCount(int x, int y, int z) {
        int count = 0;
        for (int i = y; i <= z; i++) {

            if (checkIfRepeating(i, i * x)) {
                count++;
            }
        }
        return count;
    }

    static boolean checkIfRepeating(int n, int pr) {
        char[] c1 = String.valueOf(n).toCharArray();

        char[] c2 = String.valueOf(pr).toCharArray();

        for (char c : c1) {
            for (char temp : c2) {
                if (temp == c) {

                    return false;
                }
            }
        }
        return true;
    }

    static String secureChannel(int operation, String message, String key) {
        int[] keydigits = null;
        try {
            keydigits = convertToDigitArray(key);
        } catch (NumberFormatException e) {
            return "-1";
        }
        char[] ch = message.toCharArray();
        if (operation == 1) {
            // Encoding
            StringBuilder b = new StringBuilder();
            int i = 0;
            for (; i < keydigits.length && i < ch.length; i++) {
                for (int rep = keydigits[i]; rep > 0; rep--) {
                    b.append(ch[i]);
                }
            }
            while (i < ch.length) {
                b.append(ch[i]);
                i++;
            }
            System.out.println(b);
        }

        if (operation == 2) {
            // decoding
            StringBuilder b = new StringBuilder();
            int i = 0;
            int j = 0;
            for (; i < keydigits.length && j < ch.length; i++) {
                b.append(ch[j]);
                for (int rep = keydigits[i]; rep > 0; rep--) {
                    j++;
                }
            }
            while (j < ch.length) {
                b.append(ch[j]);
                j++;
            }
            System.out.println(b);
        }
        return null;
    }
}
