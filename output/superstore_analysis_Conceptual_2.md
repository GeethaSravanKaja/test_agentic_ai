_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Enhanced conceptual data model for Superstore analysis reporting requirements
## *Version*: 2
## *Changes*: Enhanced entity relationships, added customer dimension, improved attribute definitions
## *Reason*: User requested changes to improve the conceptual data model structure
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This enhanced conceptual data model supports comprehensive retail analytics for a superstore business, focusing on sales performance, profitability analysis, and operational insights across multiple business dimensions including product categories, geographical regions, shipping methods, and customer segments. The model enables detailed analysis of business performance and operational efficiency.

## 2. List of Entity Name with Description

1. **Product** - Represents items sold in the superstore with detailed categorization and product information
2. **Order** - Represents individual sales transactions with comprehensive transaction details
3. **Region** - Represents geographical areas where business operations occur with location-specific attributes
4. **Shipping** - Represents different shipping methods and logistics information for order fulfillment
5. **Customer** - Represents customers who make purchases in the superstore

## 3. List of Attributes for each Entity with Description

### Product Entity
- **Category Name** - The primary classification group of products (e.g., Furniture, Office Supplies, Technology)
- **Sub Category Name** - The secondary classification within each category for more granular analysis
- **Product Name** - The specific name or title of the individual product

### Order Entity  
- **Sales Amount** - The total monetary value of the sales transaction before any deductions
- **Profit Amount** - The net profit earned from the sales transaction after costs
- **Quantity Sold** - The number of units sold in the transaction
- **Discount Applied** - The discount percentage or amount applied to the order
- **Order Date** - The date when the order was placed
- **Ship Date** - The date when the order was shipped

### Region Entity
- **Region Name** - The primary geographical region where the business operates (e.g., East, West, Central, South)
- **State Name** - The specific state within the region
- **City Name** - The specific city where the transaction occurred

### Shipping Entity
- **Ship Mode Name** - The method used for shipping orders (e.g., Standard Class, Second Class, First Class, Same Day)
- **Shipping Cost** - The cost associated with shipping the order

### Customer Entity
- **Customer Name** - The name of the customer making the purchase
- **Customer Segment** - The business classification of the customer (e.g., Consumer, Corporate, Home Office)

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales amount grouped by product category for revenue analysis
2. **Average Profit by Region** - Mean profit amount calculated for each geographical region to assess regional performance
3. **Order Count by Ship Mode** - Total number of orders processed through each shipping method for logistics optimization
4. **Sales Growth Rate** - Period-over-period sales growth percentage for trend analysis
5. **Profit Margin by Product Category** - Profit percentage relative to sales for each product category
6. **Customer Acquisition Rate** - Rate of new customer acquisition over time

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Order | Product | Product Name | Many-to-One |
| Order | Region | Region Name | Many-to-One |
| Order | Shipping | Ship Mode Name | Many-to-One |
| Order | Customer | Customer Name | Many-to-One |
| Product | Product | Category Name | One-to-Many (Category to Products) |
| Customer | Region | Region Name | Many-to-One |

## 6. Common Data Elements in Report Requirements

1. **Category Name** - Used across multiple reports for product categorization and sales analysis
2. **Sales Amount** - Core metric used in revenue and performance reports
3. **Region Name** - Geographic dimension used for regional performance analysis
4. **Profit Amount** - Key profitability metric used across financial reports
5. **Ship Mode Name** - Operational dimension used for logistics and shipping analysis
6. **Customer Name** - Customer dimension used for customer-centric analysis
7. **Order Date** - Temporal dimension used for time-series analysis and trending

## 7. API Cost Calculation

– Cost for this Call: $0.08