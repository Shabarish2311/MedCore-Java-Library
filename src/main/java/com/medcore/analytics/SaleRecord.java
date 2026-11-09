
package com.medcore.analytics;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleRecord {

    private final int medicineId;
    private final String medicineName;
    private final int quantity;
    private final BigDecimal totalPrice;
    private final LocalDate saleDate;

    public SaleRecord(
            int medicineId,
            String medicineName,
            int quantity,
            BigDecimal totalPrice,
            LocalDate saleDate) {

        if (medicineId <= 0) {
            throw new IllegalArgumentException("Medicine ID must be positive");
        }

        if (medicineName == null || medicineName.trim().isEmpty()) {
            throw new IllegalArgumentException("Medicine name is required");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (totalPrice == null || totalPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid total price");
        }

        if (saleDate == null) {
            throw new IllegalArgumentException("Sale date is required");
        }

        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.saleDate = saleDate;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }
}
