package com.medcore.billing;

/*Tests:
- Valid bill amount.
- Invalid bill amount.
- Valid bill items.
- Invalid medicine ID.
- Invalid quantity.
- Invalid unit price.
- Empty bill items.
- Null bill items.*/

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class BillValidatorTest {

    @Test
    void testValidBillAmount() {

        assertTrue(BillValidator.isValidBillAmount(new BigDecimal("500.00")));
    }

    @Test
    void testInvalidBillAmount() {

        assertFalse(BillValidator.isValidBillAmount(null));
        assertFalse(BillValidator.isValidBillAmount(BigDecimal.ZERO));
        assertFalse(BillValidator.isValidBillAmount(new BigDecimal("-100")));
    }

    @Test
    void testValidBillItem() {

        assertTrue(BillValidator.isValidBillItem(101,5,new BigDecimal("25.50")));
    }

    @Test
    void testInvalidMedicineId() {

        assertFalse(BillValidator.isValidBillItem(0, 5, new BigDecimal("25.50")));
    }

    @Test
    void testInvalidQuantity() {

        assertFalse(BillValidator.isValidBillItem(101, 0, new BigDecimal("25.50")));
    }

    @Test
    void testNegativeQuantity() {

        assertFalse(BillValidator.isValidBillItem(101, -5, new BigDecimal("25.50")));
    }

    @Test
    void testNullUnitPrice() {

        assertFalse(BillValidator.isValidBillItem(101, 5, null));
    }

    @Test
    void testZeroUnitPrice() {

        assertFalse(BillValidator.isValidBillItem(101, 5, BigDecimal.ZERO));
    }

    @Test
    void testNegativeUnitPrice() {

        assertFalse(BillValidator.isValidBillItem(101, 5, new BigDecimal("-10")));
    }

    @Test
    void testBillWithItems() {

        List<String> items = Arrays.asList("Paracetamol","Dolo");
        assertTrue(BillValidator.hasBillItems(items));
    }

    @Test
    void testBillWithEmptyItems() {

        assertFalse(BillValidator.hasBillItems(Collections.emptyList()));
    }

    @Test
    void testBillWithNullItems() {

        assertFalse(BillValidator.hasBillItems(null));
    }
}
