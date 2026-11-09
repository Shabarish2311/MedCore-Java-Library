
package com.medcore.billing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class BillingCalculator {

    private static final int SCALE = 2;

    private BillingCalculator() {
        // Utility class
    }

    public static BigDecimal calculateItemTotal(BigDecimal unitPrice,int quantity) {

        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) < 0 || quantity <= 0) {

            throw new IllegalArgumentException("Invalid price or quantity");
        }

        return unitPrice.multiply(BigDecimal.valueOf(quantity)).setScale(SCALE, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateSubtotal(BigDecimal[] itemTotals) {

        if (itemTotals == null || itemTotals.length == 0) {
            throw new IllegalArgumentException("Bill must contain at least one item");
        }

        BigDecimal subtotal = BigDecimal.ZERO;

        for (BigDecimal itemTotal : itemTotals) {

            if (itemTotal == null || itemTotal.compareTo(BigDecimal.ZERO) < 0) {

                throw new IllegalArgumentException("Invalid item total");
            }

            subtotal = subtotal.add(itemTotal);
        }

        return subtotal.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateDiscount(BigDecimal subtotal,BigDecimal discountPercentage) {

        validateAmount(subtotal);

        if (discountPercentage == null || discountPercentage.compareTo(BigDecimal.ZERO) < 0
                || discountPercentage.compareTo(BigDecimal.valueOf(100)) > 0) {

            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }

        return subtotal.multiply(discountPercentage).divide(BigDecimal.valueOf(100),SCALE,RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateFinalAmount(BigDecimal subtotal,BigDecimal discountAmount) {

        validateAmount(subtotal);
        validateAmount(discountAmount);

        if (discountAmount.compareTo(subtotal) > 0) {
            throw new IllegalArgumentException("Discount cannot exceed subtotal");
        }

        return subtotal.subtract(discountAmount).setScale(SCALE, RoundingMode.HALF_UP);
    }

    private static void validateAmount(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException("Amount cannot be null or negative");
        }
    }
}
