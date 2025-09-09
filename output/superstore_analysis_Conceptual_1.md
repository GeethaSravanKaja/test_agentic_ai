_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Conceptual data model for Superstore analysis reporting requirements
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This conceptual data model supports retail analytics for a superstore business, focusing on sales performance, profitability analysis, and operational insights across different business dimensions including product categories, geographical regions, and shipping methods.

## 2. List of Entity Name with Description

1. **Product** - Represents items sold in the superstore with categorization information
2. **Order** - Represents individual sales transactions in the superstore
3. **Region** - Represents geographical areas where business operations occur
4. **Shipping** - Represents different shipping methods available for order fulfillment

## 3. List of Attributes for each Entity with Description

### Product Entity
- **Category Name** - The classification group of products (e.g., Furniture, Office Supplies, Technology)

### Order Entity  
- **Sales Amount** - The monetary value of the sales transaction
- **Profit Amount** - The profit earned from the sales transaction

### Region Entity
- **Region Name** - The geographical region where the business operates (e.g., East, West, Central, South)

### Shipping Entity
- **Ship Mode Name** - The method used for shipping orders (e.g., Standard Class, Second Class, First Class, Same Day)

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales amount grouped by product category
2. **Average Profit by Region** - Mean profit amount calculated for each geographical region
3. **Order Count by Ship Mode** - Total number of orders processed through each shipping method

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Order | Product | Category Name | Many-to-One |
| Order | Region | Region Name | Many-to-One |
| Order | Shipping | Ship Mode Name | Many-to-One |

## 6. Common Data Elements in Report Requirements

1. **Category Name** - Used in Total Sales by Category report
2. **Sales Amount** - Used in Total Sales by Category report
3. **Region Name** - Used in Average Profit by Region report
4. **Profit Amount** - Used in Average Profit by Region report
5. **Ship Mode Name** - Used in Order Count by Ship Mode report

## 7. API Cost Calculation

– Cost for this Call: $0.05