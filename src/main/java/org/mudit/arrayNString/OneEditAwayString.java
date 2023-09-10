package org.mudit.arrayNString;

public class OneEditAwayString {

    public static void main(String args[]) {
        String s1 = "pales";
        String s2 = "pala";
        System.out.println(checkOneEditAway(s1, s2));
    }

    static boolean checkOneEditAway(String s1, String s2) {
        int diff = s1.length() - s2.length();

        if (diff == 0) {
            // check one replacement away
            boolean founddiff = false;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (founddiff) {
                        return false;
                    }
                }
                founddiff = true;
            }
            return true;

        } else if (diff < 0) {
            return checkOneInsertAway(s1, s2);

        } else if (diff > 0) {
            return checkOneInsertAway(s2, s1);
        }

        return false;
    }

    public static boolean checkOneInsertAway(String small, String big) {
        return true;
    }
}
