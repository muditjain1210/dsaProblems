package org.mudit.arrayNString;
public class checkPermutation {
    public static void main(String args[]) {
        String str1 = "aab";
        String str2 = "abc";
        System.out.println(checkPermutat(str1, str2));
    }

    public static boolean checkPermutat(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] index = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int j = str1.charAt(i);
            index[j]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int j = str2.charAt(i);
            index[j]--;
            if (index[j] < 0) {
                return false;
            }
        }

        return true;
    }

}
