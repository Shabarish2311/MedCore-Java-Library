# MedCore Java Library

Version: 1.0.0  
Language: Java 17  
Build Tool: Apache Maven  
Testing Framework: JUnit 5

 1. Project Overview

MedCore is a standalone, reusable Java library designed to provide commonly used functionalities for pharmacy and medical management applications.

The library provides reusable components for medicine validation, inventory management, billing calculations, sales analytics, and common data validation.

It is developed using object-oriented programming principles and a modular package structure, allowing developers to integrate its functionalities into different Java applications without depending on the original application.

 2. Problem Statement

Pharmacy management applications require several common operations, including medicine validation, stock calculations, billing, and sales analysis.

Implementing these operations repeatedly in different applications increases development effort and code duplication.

MedCore addresses this problem by providing reusable Java components that can be integrated into multiple pharmacy management applications.

 3. Key Features

# Medicine Management
- Validate medicine names and descriptions.
- Validate medicine prices.
- Validate available stock quantities.
- Validate complete medicine details.

# Inventory Management
- Add stock quantities.
- Remove stock quantities.
- Calculate remaining stock.
- Check stock availability.
- Identify low-stock medicines.

# Billing Management
- Calculate individual medicine item totals.
- Calculate bill subtotals.
- Calculate discounts.
- Calculate final bill amounts.
- Validate bill details and items.

# Sales Analytics
- Calculate total sales.
- Calculate average sales.
- Calculate total quantities sold.
- Generate monthly sales summaries.
- Analyze sales by weekday.
- Identify top-selling medicines.
- Calculate medicine-wise sales distribution.

# Common Utilities
- Validate strings.
- Validate positive and non-negative numbers.
- Validate integer values.
- Provide reusable validation methods.

 4. Technology Stack

| Technology     | Purpose                                 |
|----------------|-----------------------------------------|
| Java 17        | Core programming language               |
| Apache Maven   | Project management and build automation |
| JUnit 5        | Unit testing                            |
| BigDecimal     | Accurate financial calculations         |
| Java Time API  | Date and time handling                  |
| JavaDoc        | API documentation                       |
| Eclipse IDE    | Development environment                 |
| Git and GitHub | Version control and project hosting     |

 5. Project Structure

<img width="670" height="803" alt="image" src="https://github.com/user-attachments/assets/b73f2567-f42d-46c6-bb4c-69f4197f81d0" />


 6. Installation

# Prerequisites

Before using MedCore, ensure that the following are installed:

- Java Development Kit (JDK) 17 or later.
- Apache Maven.
- Any Java IDE, such as Eclipse or IntelliJ IDEA.

# Build the Library

Clone the repository:

git clone https://github.com/Shabarish2311/WebMedicalManagement.git

Navigate to the project directory:

cd medcore-java-library

Build the project:

mvn clean package

# Run Unit Tests

mvn clean test

# Generate JavaDoc

mvn javadoc:javadoc

# Generate JAR

After a successful Maven build, the JAR file is available at:

target/medcore-java-library-1.0.0.jar

 7. Maven Dependency

To use MedCore in another Maven project, first install it into your local Maven repository:

mvn install

Add the following dependency to the consuming application's `pom.xml`:

<dependency>
    <groupId>com.medcore</groupId>
    <artifactId>medcore-java-library</artifactId>
    <version>1.0.0</version>
</dependency>

 8. Usage Examples

# Medicine Validation

import java.math.BigDecimal;
import com.medcore.medicine.MedicineValidator;

public class MedicineExample {

    public static void main(String[] args) {

        boolean valid = MedicineValidator.isValidMedicine("Paracetamol","Pain relief medicine",new BigDecimal("25.50"),100);
        System.out.println("Valid Medicine: " + valid);
    }
}

# Inventory Calculation

import com.medcore.inventory.InventoryCalculator;

public class InventoryExample {

    public static void main(String[] args) {

        int currentStock = 100;
        int additionalStock = 50;

        int updatedStock = InventoryCalculator.addStock(currentStock, additionalStock);
        System.out.println("Updated Stock: " + updatedStock);
    }
}

# Billing Calculation

import java.math.BigDecimal;
import com.medcore.billing.BillingCalculator;

public class BillingExample {

    public static void main(String[] args) {

        BigDecimal price = new BigDecimal("25.50");
        int quantity = 4;

        BigDecimal total = BillingCalculator.calculateItemTotal(price, quantity);
        System.out.println("Item Total: " + total);
    }
}

# Sales Analytics

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.medcore.analytics.SaleRecord;
import com.medcore.analytics.SalesAnalytics;

public class SalesExample {

    public static void main(String[] args) {

        List<SaleRecord> sales = Arrays.asList(
            new SaleRecord(101,"Paracetamol",10,new BigDecimal("250.00"),LocalDate.now()),
            new SaleRecord(102,"Dolo",5,new BigDecimal("100.00"),LocalDate.now()));

        BigDecimal totalSales = SalesAnalytics.calculateTotalSales(sales);
        System.out.println("Total Sales: " + totalSales);
    }
}

 9. Unit Testing

MedCore uses JUnit 5 to verify the correctness and reliability of its functionalities.

The project includes eight test classes covering medicine validation, inventory calculations, billing calculations, sales analytics, and common validation utilities.

Test Results:

- Total test cases: 119
- Passed: 119
- Failed: 0
- Errors: 0
- Skipped: 0

Execute the following command to run all tests:

mvn clean test

 10. API Documentation

MedCore provides JavaDoc-generated API documentation describing its packages, classes, constructors, and public methods.

Generate the documentation using:

mvn javadoc:javadoc

Generated documentation:

target/site/apidocs/index.html

Open `index.html` in a web browser to explore the API.

 11. Design Principles

The library follows these development principles:

- Modularity: Functionalities are organized into separate packages.
- Reusability: Components can be integrated into different Java applications.
- Separation of Concerns: Validation, calculations, and analytics are maintained separately.
- Maintainability: Clear package organization and documentation.
- Reliability: Unit testing using JUnit 5.
- Accuracy: BigDecimal is used for financial calculations.

 12. Future Enhancements

- Additional pharmacy management utilities.
- Enhanced medicine and inventory validation.
- More advanced sales analytics.
- Additional billing and discount functionalities.
- Improved API documentation and examples.
- Support for additional integration scenarios.

---

MedCore Java Library v1.0.0

Developed as a standalone reusable Java library based on the Web Medical Management System project.
https://github.com/Shabarish2311/WebMedicalManagement.git
