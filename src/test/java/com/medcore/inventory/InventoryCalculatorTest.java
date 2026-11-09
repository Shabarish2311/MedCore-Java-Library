package com.medcore.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryCalculatorTest {

    @Test
    void testAddStock() {

        assertEquals(150,InventoryCalculator.addStock(100, 50));
    }

    @Test
    void testAddStockWithZeroCurrentStock() {

        assertEquals(50,InventoryCalculator.addStock(0, 50));
    }

    @Test
    void testAddStockWithNegativeCurrentStock() {

        assertThrows(IllegalArgumentException.class,
            () -> InventoryCalculator.addStock(-10, 50));
    }

    @Test
    void testAddStockWithInvalidQuantity() {

        assertThrows(IllegalArgumentException.class,
            () -> InventoryCalculator.addStock(100, 0));
    }

    @Test
    void testAddStockOverflow() {

        assertThrows(ArithmeticException.class,
            () -> InventoryCalculator.addStock(Integer.MAX_VALUE, 1));
    }

    @Test
    void testRemoveStock() {

        assertEquals(85,InventoryCalculator.removeStock(100, 15));
    }

    @Test
    void testRemoveEntireStock() {

        assertEquals(0,InventoryCalculator.removeStock(100, 100));
    }

    @Test
    void testRemoveInsufficientStock() {

        assertThrows(IllegalArgumentException.class,
            () -> InventoryCalculator.removeStock(10, 20));
    }

    @Test
    void testRemoveStockWithZeroQuantity() {

        assertThrows(IllegalArgumentException.class,
            () -> InventoryCalculator.removeStock(100, 0));
    }

    @Test
    void testCalculateRemainingStock() {

        assertEquals(75,InventoryCalculator.calculateRemainingStock(100, 25));
    }

    @Test
    void testStockAvailable() {

        assertTrue(InventoryCalculator.isAvailable(100, 50));
    }

    @Test
    void testStockNotAvailable() {

        assertFalse(InventoryCalculator.isAvailable(10, 20));
    }

    @Test
    void testAvailabilityWithExactStock() {

        assertTrue(InventoryCalculator.isAvailable(50, 50));
    }

    @Test
    void testAvailabilityWithZeroRequiredQuantity() {

        assertTrue(InventoryCalculator.isAvailable(50, 0));
    }

    @Test
    void testAvailabilityWithNegativeStock() {

        assertThrows(IllegalArgumentException.class,
            () -> InventoryCalculator.isAvailable(-10, 5));
    }

    @Test
    void testLowStock() {

        assertTrue(InventoryCalculator.isLowStock(5, 10));
    }

    @Test
    void testStockNotLow() {

        assertFalse(InventoryCalculator.isLowStock(50, 10));
    }

    @Test
    void testLowStockAtThreshold() {

        assertTrue(InventoryCalculator.isLowStock(10, 10));
    }

    @Test
    void testLowStockWithInvalidValues() {

        assertThrows(IllegalArgumentException.class,
            () -> InventoryCalculator.isLowStock(-5, 10));
    }
}

