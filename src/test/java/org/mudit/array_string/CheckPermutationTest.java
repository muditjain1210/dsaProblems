package org.mudit.array_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckPermutationTest {

    @Test
    void checkPermutat() {
        Assertions.assertTrue(CheckPermutation.checkPermutat("abc", "bca"));
        Assertions.assertFalse(CheckPermutation.checkPermutat("abc", "def"));
        Assertions.assertFalse(CheckPermutation.checkPermutat("abc", "bcaa"));
        Assertions.assertFalse(CheckPermutation.checkPermutat("abc", "aabbcc"));
    }

    @Test
    void checkStringPermutatUsingMapTest(){
        Assertions.assertTrue(CheckPermutation.checkStringPermutatUsingMap("abc", "bca"));
        Assertions.assertTrue(CheckPermutation.checkStringPermutatUsingMap("aabbcc", "cbbcaa"));
        Assertions.assertFalse(CheckPermutation.checkStringPermutatUsingMap("abc", "def"));
        Assertions.assertFalse(CheckPermutation.checkStringPermutatUsingMap("abc", "bcaa"));
        Assertions.assertFalse(CheckPermutation.checkStringPermutatUsingMap("abc", "aabbcc"));
    }
}