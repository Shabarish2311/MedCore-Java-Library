package com.medcore.billing;
/*Tests:
- Item total calculation.
- Sub total calculation.
- Discount calculation.
- Final bill calculation.
- Invalid prices.
- Invalid quantities.
- Invalid discount percentages.
- Discount exceeding sub total.
- Null values.*/

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class BillingCalculatorTest {

    @Test
    void testCalculateItemTotal() {

        BigDecimal result =BillingCalculator.calculateItemTotal(new BigDecimal("25.50"), 4);
        assertEquals(new BigDecimal("102.00"),result);
    }

    @Test
    void testCalculateItemTotalWithDecimalPrice() {

        BigDecimal result =BillingCalculator.calculateItemTotal(new BigDecimal("10.25"), 3);
        assertEquals(new BigDecimal("30.75"),result);
    }

    @Test
    void testItemTotalWithZeroPrice() {

        assertEquals(new BigDecimal("0.00"),BillingCalculator.calculateItemTotal(BigDecimal.ZERO, 5));
    }

    @Test
    void testItemTotalWithNullPrice() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateItemTotal(null, 5));
    }

    @Test
    void testItemTotalWithNegativePrice() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateItemTotal(new BigDecimal("-10"), 5));
    }

    @Test
    void testItemTotalWithInvalidQuantity() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateItemTotal(new BigDecimal("10"), 0));
    }

    @Test
    void testCalculateSubtotal() {

        BigDecimal[] items = {new BigDecimal("100.00"),new BigDecimal("50.00"),new BigDecimal("25.00")};
        assertEquals(new BigDecimal("175.00"),BillingCalculator.calculateSubtotal(items));
    }

    @Test
    void testSubtotalWithNullArray() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateSubtotal(null));
    }

    @Test
    void testSubtotalWithEmptyArray() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateSubtotal(new BigDecimal[0]));
    }

    @Test
    void testSubtotalWithNullItem() {

        BigDecimal[] items = {new BigDecimal("100.00"),null};
        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateSubtotal(items));
    }

    @Test
    void testSubtotalWithNegativeItem() {

        BigDecimal[] items = {new BigDecimal("100.00"),new BigDecimal("-20.00")};
        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateSubtotal(items));
    }

    @Test
    void testCalculateDiscount() {

        BigDecimal result =BillingCalculator.calculateDiscount(new BigDecimal("100.00"),new BigDecimal("10"));
        assertEquals(new BigDecimal("10.00"),result);
    }

    @Test
    void testZeroPercentDiscount() {

        assertEquals(new BigDecimal("0.00"),BillingCalculator.calculateDiscount(new BigDecimal("100.00"),BigDecimal.ZERO));
    }

    @Test
    void testHundredPercentDiscount() {

        assertEquals(new BigDecimal("100.00"),BillingCalculator.calculateDiscount(new BigDecimal("100.00"),new BigDecimal("100")));
    }

    @Test
    void testDiscountAboveHundredPercent() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateDiscount(new BigDecimal("100"),new BigDecimal("110")));
    }

    @Test
    void testNegativeDiscount() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateDiscount(new BigDecimal("100"),new BigDecimal("-10")));
    }

    @Test
    void testNullDiscountPercentage() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateDiscount(new BigDecimal("100"), null));
    }

    @Test
    void testCalculateFinalAmount() {

        BigDecimal result =BillingCalculator.calculateFinalAmount(new BigDecimal("100.00"),new BigDecimal("10.00"));
        assertEquals(new BigDecimal("90.00"),result);
    }

    @Test
    void testFinalAmountWithZeroDiscount() {

        assertEquals(new BigDecimal("100.00"),BillingCalculator.calculateFinalAmount(new BigDecimal("100.00"),BigDecimal.ZERO));
    }

    @Test
    void testFinalAmountWithFullDiscount() {

        assertEquals(new BigDecimal("0.00"),BillingCalculator.calculateFinalAmount(new BigDecimal("100.00"),new BigDecimal("100.00")));
    }

    @Test
    void testDiscountGreaterThanSubtotal() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateFinalAmount(new BigDecimal("100.00"),new BigDecimal("120.00")));
    }

    @Test
    void testFinalAmountWithNullSubtotal() {

        assertThrows(IllegalArgumentException.class,
            () -> BillingCalculator.calculateFinalAmount(null, BigDecimal.ZERO));
    }
}

