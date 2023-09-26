package org.mudit.array_string;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function to check whether two given strings are Permutation of
 * each other or not. A Permutation of a string is another string that contains
 * same characters, only the order of characters can be different.
 * For example, “abcd” and “dabc” are Permutation of each other.
 */
public class CheckPermutation {

    /**
     * Time complexity O(n), n = length of input String
     * Space complexity O(1)
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean checkPermutat(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        //First add string1 all character's integer value to index array
        int[] index = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int j = str1.charAt(i);
            index[j]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int j = str2.charAt(i);
            if (index[j] == 0) {
                return false;
            }
            index[j]--;
        }
        return true;
    }

    public static boolean checkStringPermutatUsingMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            int freq = 0;
            if (charMap.containsKey(ch)) {
                freq = charMap.get(ch);
            }
            charMap.put(ch, ++freq);
        }
        System.out.println(charMap);

        for (char ch : str2.toCharArray()) {
            if (!charMap.containsKey(ch) || charMap.get(ch) == 0) {
                return false;
            }
        }
        return true;
    }

}
