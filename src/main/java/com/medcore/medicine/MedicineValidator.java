
package com.medcore.medicine;

import java.math.BigDecimal;

public final class MedicineValidator {

    private MedicineValidator() {
        // Utility class
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidDescription(String description) {
        return description != null && !description.trim().isEmpty();
    }

    public static boolean isValidPrice(BigDecimal price) {
        return price != null && price.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isValidStock(int stock) {
        return stock >= 0;
    }

    public static boolean isValidMedicine(String name,String description,BigDecimal price,int stock) {

        return isValidName(name)
                && isValidDescription(description)
                && isValidPrice(price)
                && isValidStock(stock);
    }
}
