_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Conceptual data model for Superstore business analysis and reporting system
## *Version*: 1 
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

The Superstore domain encompasses retail business operations focusing on product sales, customer management, order processing, and shipping logistics. This conceptual data model supports comprehensive business analysis including sales performance tracking, profitability analysis, regional performance evaluation, and shipping efficiency monitoring across different product categories and customer segments.

## 2. List of Entity Names with Descriptions

1. **Product** - Represents individual items sold in the superstore including their categorization and specifications
2. **Customer** - Contains information about customers who purchase products from the superstore
3. **Order** - Represents individual sales transactions made by customers
4. **Region** - Geographic areas where the superstore operates and serves customers
5. **Shipping** - Information about delivery methods and shipping processes for orders
6. **Category** - Product classification system used to organize inventory

## 3. List of Attributes for Each Entity

### Product Entity
- **Product Name** - The specific name or title of the product being sold
- **Category** - The broad classification group the product belongs to (e.g., Furniture, Office Supplies, Technology)
- **Sub Category** - More specific classification within the main category
- **Product Description** - Detailed information about the product features and specifications

### Customer Entity
- **Customer Name** - Full name of the customer making purchases
- **Customer Segment** - Classification of customer type (e.g., Consumer, Corporate, Home Office)
- **Customer Address** - Physical location details of the customer
- **Customer City** - City where the customer is located
- **Customer State** - State or province of customer location
- **Customer Postal Code** - ZIP or postal code for customer address

### Order Entity
- **Order Date** - Date when the order was placed by the customer
- **Ship Date** - Date when the order was shipped to the customer
- **Sales Amount** - Total monetary value of the order
- **Profit Amount** - Net profit generated from the order after costs
- **Discount Applied** - Any discount percentage or amount applied to the order
- **Quantity Ordered** - Number of units purchased in the order

### Region Entity
- **Region Name** - Geographic region designation (e.g., East, West, Central, South)
- **Region Description** - Detailed description of the geographic area covered
- **Region Manager** - Person responsible for managing operations in the region

### Shipping Entity
- **Ship Mode** - Method of delivery used for the order (e.g., Standard Class, Second Class, First Class, Same Day)
- **Shipping Cost** - Cost associated with delivering the order
- **Delivery Time** - Expected or actual time taken for delivery

### Category Entity
- **Category Name** - Name of the product category
- **Category Description** - Detailed description of products included in the category

## 4. KPI List

1. **Total Sales by Category** - Sum of all sales amounts grouped by product category
2. **Average Profit by Region** - Mean profit amount calculated for each geographic region
3. **Order Count by Ship Mode** - Total number of orders processed through each shipping method
4. **Sales Growth Rate** - Percentage increase or decrease in sales over time periods
5. **Profit Margin by Product** - Percentage of profit relative to sales for each product
6. **Customer Acquisition Rate** - Number of new customers gained over specific time periods
7. **Regional Sales Performance** - Comparative analysis of sales across different regions
8. **Shipping Efficiency Rate** - Percentage of orders delivered within expected timeframes
9. **Category Performance Index** - Relative performance ranking of different product categories
10. **Customer Segment Profitability** - Profit analysis across different customer segments

## 5. Conceptual Data Model Diagram

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Customer | Order | Customer Name | One-to-Many |
| Product | Order | Product Name | One-to-Many |
| Category | Product | Category Name | One-to-Many |
| Region | Customer | Region Name | One-to-Many |
| Shipping | Order | Ship Mode | One-to-Many |
| Order | Region | Region Name (via Customer) | Many-to-One |

### Entity Relationship Details:
- **Customer to Order**: One customer can place multiple orders
- **Product to Order**: One product can appear in multiple orders
- **Category to Product**: One category contains multiple products
- **Region to Customer**: One region serves multiple customers
- **Shipping to Order**: One shipping mode can be used for multiple orders
- **Order to Region**: Orders are associated with regions through customer location

## 6. Common Data Elements in Report Requirements

1. **Sales** - Monetary transaction value appearing in sales analysis reports
2. **Category** - Product classification used across category performance reports
3. **Region** - Geographic identifier used in regional analysis reports
4. **Profit** - Financial metric used in profitability analysis reports
5. **Ship Mode** - Shipping method identifier used in logistics reports
6. **Order Count** - Transaction volume metric used in operational reports
7. **Customer Name** - Customer identifier used in customer analysis reports
8. **Date Fields** (Order Date, Ship Date) - Temporal dimensions used across time-based reports
9. **Quantity** - Volume metric used in inventory and sales reports
10. **Discount** - Pricing adjustment factor used in pricing analysis reports

## 7. API Cost Calculation

– Cost for this Call: $0.02