_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Conceptual data model for Superstore sales analysis and reporting system
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

The Superstore domain encompasses retail sales operations, focusing on product sales across different categories, regions, and shipping methods. The system supports analysis of sales performance, profitability metrics, and operational efficiency through various reporting dimensions including product categories, geographical regions, and shipping modes.

## 2. List of Entity Names with Descriptions

1. **Sales Transaction** - Core entity representing individual sales records in the superstore system
2. **Product** - Entity representing products sold in the superstore with categorization information
3. **Customer** - Entity representing customers who make purchases
4. **Geographic Region** - Entity representing different geographical areas where sales occur
5. **Shipping** - Entity representing shipping and delivery information for orders

## 3. List of Attributes for Each Entity with Descriptions

### Sales Transaction Entity
1. **Sales Amount** - The monetary value of the sales transaction
2. **Profit Amount** - The profit generated from the sales transaction
3. **Order Date** - The date when the order was placed
4. **Ship Date** - The date when the order was shipped

### Product Entity
1. **Product Name** - The name of the product being sold
2. **Category** - The main product category (e.g., Furniture, Office Supplies, Technology)
3. **Sub Category** - The detailed product subcategory within the main category

### Customer Entity
1. **Customer Name** - The name of the customer making the purchase
2. **Customer Segment** - The business segment classification of the customer

### Geographic Region Entity
1. **Region** - The geographical region where the sale occurred
2. **State** - The state where the customer is located
3. **City** - The city where the customer is located
4. **Postal Code** - The postal code of the customer location

### Shipping Entity
1. **Ship Mode** - The method of shipping used for the order
2. **Shipping Cost** - The cost associated with shipping the order

## 4. KPI List

1. **Total Sales by Category** - Sum of all sales amounts grouped by product category
2. **Average Profit by Region** - Mean profit amount calculated for each geographical region
3. **Order Count by Ship Mode** - Total number of orders grouped by shipping method
4. **Sales Performance** - Overall sales metrics and trends
5. **Profitability Analysis** - Profit margins and profitability metrics
6. **Regional Performance** - Sales and profit performance across different regions
7. **Shipping Efficiency** - Analysis of shipping methods and their usage patterns

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Sales Transaction | Product | Product Name | Many-to-One |
| Sales Transaction | Customer | Customer Name | Many-to-One |
| Sales Transaction | Geographic Region | Region | Many-to-One |
| Sales Transaction | Shipping | Ship Mode | Many-to-One |
| Product | Sales Transaction | Product Name | One-to-Many |
| Customer | Sales Transaction | Customer Name | One-to-Many |
| Geographic Region | Sales Transaction | Region | One-to-Many |
| Shipping | Sales Transaction | Ship Mode | One-to-Many |

## 6. Common Data Elements in Report Requirements

1. **Category** - Used across multiple reports for product categorization and sales analysis
2. **Region** - Common dimension for geographical analysis and regional performance reporting
3. **Ship Mode** - Shared across shipping and operational efficiency reports
4. **Sales Amount** - Core metric used in various sales performance calculations
5. **Profit Amount** - Key financial metric used across profitability reports
6. **Customer Name** - Common identifier for customer-related analysis
7. **Order Date** - Temporal dimension used for time-based analysis and trending
8. **Product Name** - Product identifier used across product performance reports

## 7. API Cost Calculation

– Cost for this Call: $0.02