_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Conceptual data model for Superstore retail analytics reporting system
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This conceptual data model supports a retail analytics system focused on superstore operations. The model encompasses sales transactions, product categorization, customer segmentation by region, and shipping logistics. The primary purpose is to enable comprehensive business intelligence reporting on sales performance, profitability analysis, and operational efficiency across different dimensions such as product categories, geographical regions, and shipping methods.

## 2. List of Entity Name with Description

1. **Order** - Represents individual sales transactions containing details about purchases made by customers
2. **Product** - Contains information about items sold in the superstore including categorization details
3. **Customer** - Stores customer information and geographical segmentation data
4. **Shipping** - Manages shipping and delivery information for orders including shipping methods and logistics

## 3. List of Attributes for each Entity with Description

### Order Entity
1. **Sales Amount** - The total monetary value of the sales transaction
2. **Profit Amount** - The profit generated from the sales transaction after deducting costs
3. **Order Date** - The date when the order was placed by the customer
4. **Ship Date** - The date when the order was shipped to the customer

### Product Entity
1. **Category Name** - The main product category classification (e.g., Furniture, Office Supplies, Technology)
2. **Sub Category Name** - The detailed sub-classification within the main category
3. **Product Name** - The specific name or title of the individual product
4. **Product Price** - The selling price of the individual product

### Customer Entity
1. **Customer Name** - The full name of the customer who placed the order
2. **Customer Segment** - The business classification of the customer (e.g., Consumer, Corporate, Home Office)
3. **Region Name** - The geographical region where the customer is located
4. **State Name** - The specific state within the region where the customer resides
5. **City Name** - The city where the customer is located

### Shipping Entity
1. **Ship Mode** - The method of shipping selected for the order (e.g., Standard Class, Second Class, First Class, Same Day)
2. **Ship Cost** - The cost associated with shipping the order
3. **Delivery Status** - The current status of the shipment delivery

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales amount grouped by product category to identify top-performing product lines
2. **Average Profit by Region** - Mean profit calculation across different geographical regions to assess regional performance
3. **Order Count by Ship Mode** - Total number of orders processed through each shipping method to analyze shipping preferences
4. **Sales Growth Rate** - Period-over-period sales growth percentage to track business expansion
5. **Profit Margin by Category** - Profit percentage relative to sales for each product category
6. **Regional Sales Distribution** - Percentage breakdown of total sales across different regions
7. **Customer Segment Performance** - Sales and profit metrics segmented by customer types

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Order | Product | Product Name | Many-to-One |
| Order | Customer | Customer Name | Many-to-One |
| Order | Shipping | Ship Mode | Many-to-One |
| Customer | Order | Customer Name | One-to-Many |
| Product | Order | Product Name | One-to-Many |
| Shipping | Order | Ship Mode | One-to-Many |

## 6. Common Data Elements in Report Requirements

1. **Sales Amount** - Referenced across all sales performance reports and category analysis
2. **Profit Amount** - Used in profitability analysis and regional performance reports
3. **Category Name** - Common dimension for product-based reporting and analysis
4. **Region Name** - Shared geographical dimension across multiple regional reports
5. **Ship Mode** - Common field for shipping and logistics analysis reports
6. **Customer Name** - Linking field for customer-centric reporting and segmentation
7. **Order Date** - Time dimension used across all temporal analysis and trending reports

## 7. API Cost Calculation

– Cost for this Call: $0.15