_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Conceptual data model for Superstore analysis reporting requirements
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This conceptual data model supports retail analytics for a superstore business, focusing on sales performance, profitability analysis, and operational metrics across different business dimensions including product categories, geographical regions, and shipping methods.

## 2. List of Entity Name with Description

1. **Product** - Represents items sold in the superstore with categorization information
2. **Order** - Represents individual customer transactions and purchases
3. **Region** - Represents geographical areas where business operations occur
4. **Shipping** - Represents different shipping methods and logistics information

## 3. List of Attributes for each Entity with Description

### Product Entity
- **Category** - Business classification of products (e.g., Technology, Furniture, Office Supplies)
- **Product Name** - Specific name or title of the product being sold
- **Sub Category** - More granular classification within the main category

### Order Entity
- **Sales** - Total monetary value of the transaction or order
- **Profit** - Net profit generated from the order after costs
- **Quantity** - Number of items purchased in the order
- **Discount** - Percentage or amount of discount applied to the order
- **Order Date** - Date when the order was placed
- **Ship Date** - Date when the order was shipped

### Region Entity
- **Region** - Geographical region name (e.g., East, West, Central, South)
- **State** - State or province within the region
- **City** - City where the order was delivered
- **Postal Code** - Postal or ZIP code for delivery location

### Shipping Entity
- **Ship Mode** - Method of shipping (e.g., Standard Class, Second Class, First Class, Same Day)
- **Ship Cost** - Cost associated with shipping the order

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales revenue grouped by product category
2. **Average Profit by Region** - Mean profit performance across different geographical regions
3. **Order Count by Ship Mode** - Number of orders processed through each shipping method
4. **Sales Performance** - Overall revenue generation metrics
5. **Profitability Analysis** - Profit margins and profit distribution analysis
6. **Regional Performance** - Geographic performance comparison metrics
7. **Shipping Efficiency** - Logistics and delivery method performance indicators

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Order | Product | Category | Many-to-One |
| Order | Region | Region | Many-to-One |
| Order | Shipping | Ship Mode | Many-to-One |
| Product | Order | Category | One-to-Many |
| Region | Order | Region | One-to-Many |
| Shipping | Order | Ship Mode | One-to-Many |

## 6. Common Data Elements in Report Requirements

1. **Category** - Used across multiple reports for product-based analysis
2. **Region** - Common dimension for geographical performance analysis
3. **Ship Mode** - Shared field for logistics and operational reporting
4. **Sales** - Primary measure used in revenue analysis
5. **Profit** - Key financial metric for profitability analysis
6. **Order Count** - Common metric for volume analysis across different dimensions

## 7. API Cost Calculation

– Cost for this Call: $0.02