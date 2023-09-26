package org.mudit.array_string;

import lombok.extern.log4j.Log4j2;

/**
 * An edit between two strings is one of the following changes.
 * <p>
 * 1. Add a character
 * 2. Delete a character
 * 3. Change a character
 * </p>
 * Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
 * Expected time complexity is O(m+n) where m and n are lengths of two strings.
 * <p>
 * Examples:
 * <p>
 * Input:  s1 = "geeks", s2 = "geek"
 * Output: yes
 * Number of edits is 1
 * <p>
 * Input:  s1 = "geeks", s2 = "geeks"
 * Output: no
 * Number of edits is 0
 * <p>
 * Input:  s1 = "geaks", s2 = "geeks"
 * Output: yes
 * Number of edits is 1
 * <p>
 * Input:  s1 = "peaks", s2 = "geeks"
 * Output: no
 * Number of edits is 2
 */
@Log4j2
public class OneEditAwayString {

    public static void main(String[] args) {
        String s1 = "zudot";
        String s2 = "mudit";
        System.out.println(checkOneEditAwayString(s1, s2));
    }

    static boolean checkOneEditAwayString(String s1, String s2) {

        boolean oneEdit = false;
        //Check if s1 string is one change away
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                }
                if (oneEdit) {
                    log.debug("Change of one character already done");
                    return false;
                }
                log.debug("Change of character: {}", s1.charAt(i));
                oneEdit = true;
            }
            return true;
        }

        //Check if s1 is one add character away
        if ((s2.length() - s1.length()) == 1) {
            for (int i = 0, j = 0; i < s1.length() && j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    continue;
                }
                if (oneEdit) {
                    log.debug("ADD of one character already done");
                    return false;
                }
                log.debug("Add of one character: {} in s1", s2.charAt(i));
                oneEdit = true;
            }
            return true;
        }

        //Check if s1 is one delete character away
        if ((s1.length() - s2.length()) == 1) {
            for (int i = 0, j = 0; i < s2.length() && j < s1.length(); j++) {
                if (s2.charAt(i) == s1.charAt(j)) {
                    i++;
                    continue;
                }
                if (oneEdit) {
                    log.debug("ADD of one character already done");
                    return false;
                }
                log.debug("Delete of one character: {} in s1", s1.charAt(j));
                oneEdit = true;
            }
            return true;
        }
        return false;
    }
}
