
package com.medcore.inventory;

public final class InventoryCalculator {

    private InventoryCalculator() {
        // Utility class
    }

    public static int addStock(int currentStock, int quantity) {

        if (currentStock < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Invalid stock quantity");
        }

        return Math.addExact(currentStock, quantity);
    }

    public static int removeStock(int currentStock, int quantity) {

        if (currentStock < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Invalid stock quantity");
        }

        if (quantity > currentStock) {
            throw new IllegalArgumentException("Insufficient stock available");
        }

        return currentStock - quantity;
    }

    public static int calculateRemainingStock(int currentStock,int soldQuantity) {

        return removeStock(currentStock, soldQuantity);
    }

    public static boolean isAvailable(int currentStock,int requiredQuantity) {

        if (currentStock < 0 || requiredQuantity < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        return currentStock >= requiredQuantity;
    }

    public static boolean isLowStock(int currentStock,int minimumStock) {

        if (currentStock < 0 || minimumStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        return currentStock <= minimumStock;
    }
}
