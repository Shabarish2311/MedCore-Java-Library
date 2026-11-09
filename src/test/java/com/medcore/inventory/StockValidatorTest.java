package com.medcore.inventory;

/*Tests:
- Valid stock.
- Negative stock.
- Valid stock addition.
- Invalid stock addition.
- Valid stock removal.
- Insufficient stock removal.*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockValidatorTest {

    @Test
    void testValidStock() {

        assertTrue(StockValidator.isValidStock(100));
    }

    @Test
    void testZeroStock() {

        assertTrue(StockValidator.isValidStock(0));
    }

    @Test
    void testNegativeStock() {

        assertFalse(StockValidator.isValidStock(-10));
    }

    @Test
    void testValidStockAddition() {

        assertTrue(StockValidator.isValidStockAddition(50));
    }

    @Test
    void testInvalidStockAddition() {

        assertFalse(StockValidator.isValidStockAddition(0));

        assertFalse(StockValidator.isValidStockAddition(-10));
    }

    @Test
    void testValidStockRemoval() {

        assertTrue(StockValidator.isValidStockRemoval(100, 20));
    }

    @Test
    void testStockRemovalWithExactQuantity() {

        assertTrue(StockValidator.isValidStockRemoval(50, 50));
    }

    @Test
    void testStockRemovalWithInsufficientStock() {

        assertFalse(StockValidator.isValidStockRemoval(10, 20));
    }

    @Test
    void testStockRemovalWithZeroQuantity() {

        assertFalse(StockValidator.isValidStockRemoval(100, 0));
    }

    @Test
    void testStockRemovalWithNegativeQuantity() {

        assertFalse(StockValidator.isValidStockRemoval(100, -5));
    }

    @Test
    void testStockRemovalWithNegativeAvailableStock() {

        assertFalse(StockValidator.isValidStockRemoval(-10, 5));
    }
}

