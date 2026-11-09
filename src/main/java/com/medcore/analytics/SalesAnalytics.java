
package com.medcore.analytics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class SalesAnalytics {

    private SalesAnalytics() {
        // Utility class
    }

    // Calculate total sales revenue
    public static BigDecimal calculateTotalSales(List<SaleRecord> sales) {

        validateSales(sales);

        return sales.stream()
                .map(SaleRecord::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Calculate average sales value
    public static BigDecimal calculateAverageSales(List<SaleRecord> sales) {

        validateSales(sales);

        if (sales.isEmpty()) {
            return BigDecimal.ZERO.setScale(2);
        }

        return calculateTotalSales(sales).divide(BigDecimal.valueOf(sales.size()),2,RoundingMode.HALF_UP);
    }

    // Calculate total quantity sold
    public static int calculateTotalQuantitySold(List<SaleRecord> sales) {

        validateSales(sales);

        return sales.stream()
                .mapToInt(SaleRecord::getQuantity)
                .reduce(0, Math::addExact);
    }

    // Monthly sales summary
    public static Map<YearMonth, BigDecimal> getMonthlySales(List<SaleRecord> sales) {

        validateSales(sales);

        return sales.stream()
                .collect(Collectors.groupingBy(
                    sale -> YearMonth.from(sale.getSaleDate()),
                    java.util.TreeMap::new,
                    Collectors.reducing(
                        BigDecimal.ZERO,
                        SaleRecord::getTotalPrice,
                        BigDecimal::add
                    )
                ));
    }

    // Sales grouped by day of the week
    public static Map<DayOfWeek, BigDecimal> getSalesByDay(List<SaleRecord> sales) {

        validateSales(sales);

        Map<DayOfWeek, BigDecimal> result =
                sales.stream()
                .collect(Collectors.groupingBy(
                    sale -> sale.getSaleDate().getDayOfWeek(),
                    Collectors.reducing(
                        BigDecimal.ZERO,
                        SaleRecord::getTotalPrice,
                        BigDecimal::add
                    )
                ));

        Map<DayOfWeek, BigDecimal> orderedResult =new LinkedHashMap<>();

        for (DayOfWeek day : DayOfWeek.values()) {
            if (result.containsKey(day)) {
                orderedResult.put(day, result.get(day));
            }
        }

        return orderedResult;
    }

    // Top-selling medicines based on quantity sold
    public static Map<String, Integer> getTopSellingMedicines(List<SaleRecord> sales,int limit) {

        validateSales(sales);

        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be positive");
        }

        return sales.stream()
                .collect(Collectors.groupingBy(
                    SaleRecord::getMedicineName,
                    Collectors.summingInt(
                        SaleRecord::getQuantity
                    )
                ))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .limit(limit)
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (a, b) -> a,
                    LinkedHashMap::new
                ));
    }

    // Medicine-wise sales revenue
    public static Map<String, BigDecimal> getMedicineSalesDistribution(List<SaleRecord> sales) {

        validateSales(sales);

        return sales.stream()
                .collect(Collectors.groupingBy(
                    SaleRecord::getMedicineName,
                    Collectors.reducing(BigDecimal.ZERO,SaleRecord::getTotalPrice,BigDecimal::add)
                    ));
    }

    private static void validateSales(List<SaleRecord> sales) {

        if (sales == null) {
            throw new IllegalArgumentException("Sales list cannot be null");
        }
    }
}
