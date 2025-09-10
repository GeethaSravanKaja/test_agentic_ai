_____________________________________________
## *Author*: AAVA
## *Created on*:   
## *Description*: Conceptual data model for superstore sales and profit analysis reporting
## *Version*: 1 
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This conceptual data model supports retail analytics for a superstore business, focusing on sales performance, profitability analysis, and operational metrics across different product categories, geographical regions, and shipping methods. The model enables comprehensive reporting on business performance indicators to support strategic decision-making.

## 2. List of Entity Name with Description

1. **Product** - Represents items sold by the superstore with categorization information
2. **Order** - Represents individual customer transactions and purchase records
3. **Customer** - Represents individuals or organizations who make purchases
4. **Region** - Represents geographical areas where business operations occur
5. **Shipping** - Represents delivery methods and logistics information

## 3. List of Attributes for each Entity with Description

### Product Entity
1. **Category** - Primary classification of products (e.g., Furniture, Office Supplies, Technology)
2. **Sub Category** - Secondary classification providing more specific product grouping
3. **Product Name** - Specific name or title of the individual product item

### Order Entity
1. **Sales** - Total monetary value of the transaction or order
2. **Profit** - Net profit amount generated from the order after costs
3. **Quantity** - Number of units purchased in the order
4. **Discount** - Percentage or amount of price reduction applied
5. **Order Date** - Date when the order was placed by the customer
6. **Ship Date** - Date when the order was dispatched for delivery

### Customer Entity
1. **Customer Name** - Full name of the customer who placed the order
2. **Segment** - Customer classification (e.g., Consumer, Corporate, Home Office)

### Region Entity
1. **Region** - Geographical region name (e.g., East, West, Central, South)
2. **State** - State or province where the customer is located
3. **City** - City where the customer is located
4. **Postal Code** - ZIP or postal code of the customer location

### Shipping Entity
1. **Ship Mode** - Method of delivery (e.g., Standard Class, Second Class, First Class, Same Day)

## 4. KPI List

1. **Total Sales by Category** - Sum of sales revenue grouped by product category
2. **Average Profit by Region** - Mean profit amount calculated for each geographical region
3. **Order Count by Ship Mode** - Total number of orders grouped by shipping method
4. **Sales Performance** - Overall revenue generation metrics
5. **Profitability Analysis** - Profit margins and profit distribution across dimensions
6. **Regional Performance** - Sales and profit metrics by geographical areas
7. **Shipping Efficiency** - Order volume and performance by delivery methods

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Order | Product | Product Name | Many-to-One |
| Order | Customer | Customer Name | Many-to-One |
| Order | Region | Region | Many-to-One |
| Order | Shipping | Ship Mode | Many-to-One |
| Customer | Region | Region | Many-to-One |
| Product | Order | Product Name | One-to-Many |

## 6. Common Data Elements in Report Requirements

1. **Category** - Used across multiple reports for product-based analysis
2. **Region** - Common dimension for geographical performance analysis
3. **Ship Mode** - Shared field for logistics and delivery analysis
4. **Sales** - Primary measure used in revenue calculations
5. **Profit** - Key financial metric used in profitability analysis
6. **Order Count** - Common metric for volume analysis across different dimensions

## 7. API Cost Calculation

– Cost for this Call: $0.02