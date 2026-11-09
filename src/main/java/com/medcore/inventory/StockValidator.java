
package com.medcore.inventory;

public final class StockValidator {

    private StockValidator() {
        // Utility class
    }

    public static boolean isValidStock(int stock) {
        return stock >= 0;
    }

    public static boolean isValidStockAddition(int quantity) {
        return quantity > 0;
    }

    public static boolean isValidStockRemoval(int availableStock,int requestedQuantity) {

        return availableStock >= 0 && requestedQuantity > 0 && requestedQuantity <= availableStock;
    }
}
