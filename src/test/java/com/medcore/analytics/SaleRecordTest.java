package com.medcore.analytics;
/*Tests:
- Valid sale record creation.
- All getter methods.
- Invalid medicine ID.
- Empty medicine name.
- Invalid quantity.
- Null and negative total price.
- Null sale date.*/

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class SaleRecordTest {

    @Test
    void testValidSaleRecord() {

        SaleRecord sale = new SaleRecord(101,"Paracetamol",5,new BigDecimal("127.50"),LocalDate.of(2026, 11, 3));
        assertNotNull(sale);
    }

    @Test
    void testGetMedicineId() {

        SaleRecord sale = createSaleRecord();
        assertEquals(101, sale.getMedicineId());
    }

    @Test
    void testGetMedicineName() {

        SaleRecord sale = createSaleRecord();
        assertEquals("Paracetamol",sale.getMedicineName());
    }

    @Test
    void testGetQuantity() {

        SaleRecord sale = createSaleRecord();
        assertEquals(5, sale.getQuantity());
    }

    @Test
    void testGetTotalPrice() {

        SaleRecord sale = createSaleRecord();
        assertEquals(new BigDecimal("127.50"),sale.getTotalPrice());
    }

    @Test
    void testGetSaleDate() {

        SaleRecord sale = createSaleRecord();
        assertEquals(LocalDate.of(2026, 11, 3),sale.getSaleDate());
    }

    @Test
    void testInvalidMedicineId() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(0,"Paracetamol",5,new BigDecimal("127.50"),LocalDate.now()));
    }

    @Test
    void testNullMedicineName() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(101,null,5,new BigDecimal("127.50"),LocalDate.now()));
    }

    @Test
    void testEmptyMedicineName() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(101,"   ",5,new BigDecimal("127.50"),LocalDate.now()));
    }

    @Test
    void testInvalidQuantity() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(101,"Paracetamol",0,new BigDecimal("127.50"),LocalDate.now()));
    }

    @Test
    void testNullTotalPrice() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(101,"Paracetamol",5,null,LocalDate.now()));
    }

    @Test
    void testNegativeTotalPrice() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(101,"Paracetamol",5,new BigDecimal("-100"),LocalDate.now()));
    }

    @Test
    void testNullSaleDate() {

        assertThrows(IllegalArgumentException.class,
            () -> new SaleRecord(101,"Paracetamol",5,new BigDecimal("127.50"),null));
    }

    private SaleRecord createSaleRecord() {

        return new SaleRecord(101,"Paracetamol",5,new BigDecimal("127.50"),LocalDate.of(2026, 11, 3));
    }
}

