package org.mudit.array_string;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Check whether input string's any permutation is a palindrome
 * e.g. abaaa(-->aabaa) is palindrome.
 * Assuming non null string as input
 */
public class CheckPalindromePermutation {

    /**
     * This function will check there should be at most one character which has
     * odd frequency. If all characters have even frequency, will return true
     *
     * @param string
     * @return
     */
    public static boolean checkIfStringPerPalindrome(String string) {
        if (string == null) {
            System.out.println("Null string passed..");
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char c : string.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() || set.size() == 1;
    }


    /**
     * Check if any of string permutation is a palindrome.
     * It will be only iff it has at most one odd character.
     *
     * @param str input string to be checked
     * @return True if any of string permutation is palindrome, else false
     */
    public static boolean checkIfStringPermutationIsPalindrome(@NotNull String str) {
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.get(c) != null) {
                int count = map.get(c);
                count++;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
            if (map.get(c) % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }

        }
        System.out.println(map);
        return oddCount <= 1;

    }
}