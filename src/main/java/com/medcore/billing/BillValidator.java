
package com.medcore.billing;

import java.math.BigDecimal;
import java.util.List;

public final class BillValidator {

    private BillValidator() {
        // Utility class
    }

    public static boolean isValidBillAmount(BigDecimal amount) {

        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isValidBillItem(int medicineId,int quantity,BigDecimal pricePerUnit) {

        return medicineId > 0 && quantity > 0 && pricePerUnit != null && pricePerUnit.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean hasBillItems(List<?> billItems) {

        return billItems != null && !billItems.isEmpty();
    }
}
