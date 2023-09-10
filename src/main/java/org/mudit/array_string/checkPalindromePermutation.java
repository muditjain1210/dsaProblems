package org.mudit.array_string;

import java.util.HashMap;
import java.util.Map;

public class checkPalindromePermutation {
    public static void main(String[] args) {
        String str = "aabaacceeqqhhooh";
        System.out.println(checkPermutat(str));

    }

    /**
     * Check if any of string permutation is a palindrome.
     * It will be only iff it has at most one odd character.
     *
     * @param str
     * @return
     */
    public static boolean checkPermutat(String str) {
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