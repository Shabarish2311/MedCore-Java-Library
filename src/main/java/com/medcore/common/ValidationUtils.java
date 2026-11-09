
package com.medcore.common;

import java.math.BigDecimal;

public final class ValidationUtils {

    private ValidationUtils() {
        // Utility class
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isPositiveNumber(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isNonNegativeNumber(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isPositiveInteger(int value) {
        return value > 0;
    }

    public static boolean isNonNegativeInteger(int value) {
        return value >= 0;
    }
}
