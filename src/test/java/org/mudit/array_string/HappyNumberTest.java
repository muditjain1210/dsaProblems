package org.mudit.array_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    @Test
    void isHappyNumber() {
        Assertions.assertFalse(HappyNumber.isHappyNumber(999999999));
        Assertions.assertFalse(HappyNumber.isHappyNumber(14));
        Assertions.assertTrue(HappyNumber.isHappyNumber(19));
        Assertions.assertTrue(HappyNumber.isHappyNumber(100));
        Assertions.assertFalse(HappyNumber.isHappyNumber(111111111));
    }

    @Test
    void isHappyNumber2() {
        Assertions.assertFalse(HappyNumber.isHappyNumberWithConstantSpace(999999999));
        Assertions.assertFalse(HappyNumber.isHappyNumberWithConstantSpace(14));
        Assertions.assertTrue(HappyNumber.isHappyNumberWithConstantSpace(19));
        Assertions.assertTrue(HappyNumber.isHappyNumberWithConstantSpace(100));
        Assertions.assertFalse(HappyNumber.isHappyNumberWithConstantSpace(111111111));
    }
}