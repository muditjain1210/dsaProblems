package org.mudit.array_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mudit.array_string.CheckPalindromePermutation.checkIfStringPerPalindrome;
import static org.mudit.array_string.CheckPalindromePermutation.checkIfStringPermutationIsPalindrome;

class CheckPalindromePermutationTest {

    @Test
    void checkIfStringPermutationIsPalindromeTest() {
        Assertions.assertTrue(checkIfStringPermutationIsPalindrome("aab"));
    }

    @Test
    void checkIfStringPerPalindromeTest() {
        Assertions.assertTrue(checkIfStringPerPalindrome("aabb"));
        Assertions.assertTrue(checkIfStringPerPalindrome("a"));
        Assertions.assertTrue(checkIfStringPerPalindrome("aabbc"));
        Assertions.assertFalse(checkIfStringPerPalindrome("aabbccde"));
        Assertions.assertFalse(checkIfStringPerPalindrome("aabbccef"));
        Assertions.assertFalse(checkIfStringPerPalindrome(null));
        Assertions.assertFalse(checkIfStringPerPalindrome("abcdef"));
    }
}