package com.medcore.medicine;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class MedicineValidatorTest {

    @Test
    void testValidMedicine() {

        assertTrue(MedicineValidator.isValidMedicine("Paracetamol","Pain relief medicine",new BigDecimal("25.50"),100));
    }

    @Test
    void testInvalidMedicineName() {

        assertFalse(MedicineValidator.isValidName(null));

        assertFalse(MedicineValidator.isValidName(""));

        assertFalse(MedicineValidator.isValidName("   "));
    }

    @Test
    void testValidMedicineName() {

        assertTrue(MedicineValidator.isValidName("Paracetamol"));
    }

    @Test
    void testInvalidDescription() {

        assertFalse(MedicineValidator.isValidDescription(null));

        assertFalse(MedicineValidator.isValidDescription(""));

        assertFalse(MedicineValidator.isValidDescription("   "));
    }

    @Test
    void testValidDescription() {

        assertTrue(MedicineValidator.isValidDescription("Medicine used for fever"));
    }

    @Test
    void testInvalidPrice() {

        assertFalse(MedicineValidator.isValidPrice(null));

        assertFalse(MedicineValidator.isValidPrice(BigDecimal.ZERO));

        assertFalse(MedicineValidator.isValidPrice(new BigDecimal("-10.00")));
    }

    @Test
    void testValidPrice() {

        assertTrue(MedicineValidator.isValidPrice(new BigDecimal("25.50")));
    }

    @Test
    void testInvalidStock() {

        assertFalse(MedicineValidator.isValidStock(-10));
    }

    @Test
    void testZeroStock() {

        assertTrue(MedicineValidator.isValidStock(0));
    }

    @Test
    void testValidStock() {

        assertTrue(MedicineValidator.isValidStock(100));
    }

    @Test
    void testInvalidMedicineDetails() {

        assertFalse(MedicineValidator.isValidMedicine("","Valid description",new BigDecimal("25.50"),100));
    }
}
