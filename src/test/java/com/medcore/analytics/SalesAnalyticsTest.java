package com.medcore.analytics;

/*Tests:
- Total sales.
- Average sales.
- Total quantity sold.
- Monthly sales.
- Sales by day.
- Top-selling medicines.
- Medicine sales distribution.
- Empty sales list.
- Null sales list.
- Invalid ranking limit.*/

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class SalesAnalyticsTest {

	private List<SaleRecord> createSales() {

		return Arrays.asList(
				new SaleRecord(101,"Paracetamol",10,new BigDecimal("250.00"),LocalDate.of(2026, 1, 5)),
				new SaleRecord(102,"Dolo",5,new BigDecimal("100.00"),LocalDate.of(2026, 1, 6)),
				new SaleRecord(101,"Paracetamol",20,new BigDecimal("500.00"),LocalDate.of(2026, 2, 2)),
				new SaleRecord(103,"Cetirizine",8,new BigDecimal("160.00"),LocalDate.of(2026, 2, 3))
				);
	}

	@Test
	void testCalculateTotalSales() {

		BigDecimal result =SalesAnalytics.calculateTotalSales(createSales());
		assertEquals(new BigDecimal("1010.00"),result);
	}

	@Test
	void testCalculateTotalSalesWithEmptyList() {

		assertEquals(BigDecimal.ZERO,SalesAnalytics.calculateTotalSales(Collections.emptyList()));
	}

	@Test
	void testCalculateTotalSalesWithNullList() {

		assertThrows(IllegalArgumentException.class,
				() -> SalesAnalytics.calculateTotalSales(null));
	}

	@Test
	void testCalculateAverageSales() {

		BigDecimal result =SalesAnalytics.calculateAverageSales(createSales());
		assertEquals(new BigDecimal("252.50"),result);
	}

	@Test
	void testAverageSalesWithEmptyList() {

		assertEquals(new BigDecimal("0.00"),SalesAnalytics.calculateAverageSales(Collections.emptyList()));
	}

	@Test
	void testCalculateTotalQuantitySold() {

		assertEquals(43,SalesAnalytics.calculateTotalQuantitySold(createSales()));
	}

	@Test
	void testCalculateQuantityWithEmptyList() {

		assertEquals(0,SalesAnalytics.calculateTotalQuantitySold(Collections.emptyList()));
	}

	@Test
	void testGetMonthlySales() {

		Map<YearMonth, BigDecimal> result =SalesAnalytics.getMonthlySales(createSales());
		assertEquals(2, result.size());
		assertEquals(new BigDecimal("350.00"),result.get(YearMonth.of(2026, 1)));
		assertEquals(new BigDecimal("660.00"),result.get(YearMonth.of(2026, 2)));
	}


	@Test
	void testGetSalesByDay() {

		Map<DayOfWeek, BigDecimal> result =SalesAnalytics.getSalesByDay(createSales());
		assertEquals(new BigDecimal("750.00"),result.get(DayOfWeek.MONDAY));
		assertEquals(new BigDecimal("260.00"),result.get(DayOfWeek.TUESDAY));
	}


	@Test
	void testGetTopSellingMedicines() {

		Map<String, Integer> result =SalesAnalytics.getTopSellingMedicines(createSales(), 3);
		assertEquals(3, result.size());
		assertEquals(30,result.get("Paracetamol"));
		assertEquals(8,result.get("Cetirizine"));
		assertEquals(5,result.get("Dolo"));
	}

	@Test
	void testGetTopSellingMedicinesWithLimitOne() {

		Map<String, Integer> result =SalesAnalytics.getTopSellingMedicines(createSales(), 1);
		assertEquals(1, result.size());
		assertTrue(result.containsKey("Paracetamol"));
	}

	@Test
	void testTopSellingMedicinesWithInvalidLimit() {

		assertThrows(IllegalArgumentException.class,
				() -> SalesAnalytics.getTopSellingMedicines(createSales(), 0));
	}

	@Test
	void testGetMedicineSalesDistribution() {

		Map<String, BigDecimal> result =SalesAnalytics.getMedicineSalesDistribution(createSales());
		assertEquals(new BigDecimal("750.00"),result.get("Paracetamol"));
		assertEquals(new BigDecimal("100.00"),result.get("Dolo"));
		assertEquals(new BigDecimal("160.00"),result.get("Cetirizine"));
	}

	@Test
	void testMedicineSalesDistributionWithEmptyList() {

		Map<String, BigDecimal> result = SalesAnalytics.getMedicineSalesDistribution(Collections.emptyList());
		assertTrue(result.isEmpty());
	}

	@Test
	void testGetMonthlySalesWithNullList() {

		assertThrows(IllegalArgumentException.class,
				() -> SalesAnalytics.getMonthlySales(null));
	}
}
