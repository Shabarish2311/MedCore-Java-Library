package com.medcore.common;
/*Tests:
- Empty string validation.
- Null string validation.
- Positive numbers.
- Zero and negative numbers.
- Positive integers.
- Non-negative integers.*/

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void testNotEmptyString() {

        assertTrue(ValidationUtils.isNotEmpty("Paracetamol"));
    }

    @Test
    void testEmptyString() {

        assertFalse(ValidationUtils.isNotEmpty(""));
    }

    @Test
    void testNullString() {

        assertFalse(ValidationUtils.isNotEmpty(null));
    }

    @Test
    void testWhitespaceString() {

        assertFalse(ValidationUtils.isNotEmpty("   "));
    }

    @Test
    void testPositiveNumber() {

        assertTrue(ValidationUtils.isPositiveNumber(new BigDecimal("100.50")));
    }

    @Test
    void testZeroIsNotPositiveNumber() {

        assertFalse(ValidationUtils.isPositiveNumber(BigDecimal.ZERO));
    }

    @Test
    void testNegativeNumber() {

        assertFalse(ValidationUtils.isPositiveNumber(new BigDecimal("-10")));
    }

    @Test
    void testNullPositiveNumber() {

        assertFalse(ValidationUtils.isPositiveNumber(null));
    }

    @Test
    void testNonNegativeNumber() {

        assertTrue(ValidationUtils.isNonNegativeNumber(new BigDecimal("100.50")));
        assertTrue(ValidationUtils.isNonNegativeNumber(BigDecimal.ZERO));
    }

    @Test
    void testNegativeNonNegativeNumber() {

        assertFalse(ValidationUtils.isNonNegativeNumber(new BigDecimal("-10")));
    }

    @Test
    void testNullNonNegativeNumber() {

        assertFalse(ValidationUtils.isNonNegativeNumber(null));
    }

    @Test
    void testPositiveInteger() {

        assertTrue(ValidationUtils.isPositiveInteger(100));
    }

    @Test
    void testZeroIsNotPositiveInteger() {

        assertFalse(ValidationUtils.isPositiveInteger(0));
    }

    @Test
    void testNegativeInteger() {

        assertFalse(ValidationUtils.isPositiveInteger(-10));
    }

    @Test
    void testNonNegativeInteger() {

        assertTrue(ValidationUtils.isNonNegativeInteger(100));
        assertTrue(ValidationUtils.isNonNegativeInteger(0));
    }

    @Test
    void testNegativeNonNegativeInteger() {

        assertFalse(ValidationUtils.isNonNegativeInteger(-10));
    }
}

