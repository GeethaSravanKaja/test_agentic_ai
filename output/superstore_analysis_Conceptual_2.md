_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Enhanced conceptual data model for Superstore sales analysis reporting requirements
## *Version*: 2
## *Changes*: Added Customer entity, enhanced Sales Transaction attributes, included additional KPIs for comprehensive business analysis
## *Reason*: To provide more comprehensive business insights and support advanced analytics requirements
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This enhanced conceptual data model supports comprehensive retail sales analysis for a superstore business. The model focuses on analyzing sales performance, customer behavior, profitability, and order fulfillment across multiple business dimensions including product categories, geographical regions, shipping methods, and customer segments. This expanded model enables deeper business insights and advanced analytics capabilities.

## 2. List of Entity Name with Description

1. **Sales Transaction** - Represents individual sales records containing transaction details, financial metrics, and associated business dimensions
2. **Product Category** - Represents different product categories available in the superstore
3. **Geographic Region** - Represents different geographical regions where sales occur
4. **Shipping Method** - Represents different modes of product delivery and shipment
5. **Customer** - Represents customer information and segmentation data
6. **Product** - Represents individual products sold in the superstore

## 3. List of Attributes for each Entity with Description

### Sales Transaction Entity
- **Category** - Product category classification for the sold item
- **Sales** - Total sales amount/revenue generated from the transaction
- **Profit** - Net profit earned from the sales transaction
- **Region** - Geographical region where the sale occurred
- **Ship Mode** - Method used for shipping/delivering the product
- **Quantity** - Number of units sold in the transaction
- **Discount** - Discount amount applied to the transaction
- **Order Date** - Date when the order was placed
- **Ship Date** - Date when the order was shipped

### Product Category Entity
- **Category Name** - Name of the product category
- **Category Description** - Detailed description of the product category
- **Category Manager** - Business manager responsible for the category

### Geographic Region Entity
- **Region Name** - Name of the geographical region
- **Region Description** - Detailed description of the geographical area
- **Country** - Country where the region is located
- **State** - State or province within the region
- **City** - City within the region

### Shipping Method Entity
- **Ship Mode Name** - Name of the shipping method
- **Ship Mode Description** - Description of the shipping/delivery method
- **Delivery Time** - Expected delivery timeframe for the shipping method
- **Shipping Cost** - Cost associated with the shipping method

### Customer Entity
- **Customer Name** - Name of the customer
- **Customer Segment** - Business segment classification of the customer
- **Customer Type** - Type of customer (individual, business, etc.)

### Product Entity
- **Product Name** - Name of the individual product
- **Sub Category** - Sub-category classification of the product
- **Product Description** - Detailed description of the product
- **Unit Price** - Price per unit of the product

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales amount grouped by product category
2. **Average Profit by Region** - Mean profit value calculated for each geographical region
3. **Order Count by Ship Mode** - Total number of orders processed through each shipping method
4. **Sales Growth Rate** - Period-over-period sales growth percentage
5. **Profit Margin by Category** - Profit margin percentage for each product category
6. **Customer Acquisition Rate** - Rate of new customer acquisition over time
7. **Average Order Value** - Mean value of orders across different dimensions
8. **Shipping Performance** - On-time delivery rate by shipping method

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Table | Target Table | Relationship Key Field | Relationship Type |
|--------------|--------------|----------------------|------------------|
| Sales Transaction | Product Category | Category | Many-to-One |
| Sales Transaction | Geographic Region | Region | Many-to-One |
| Sales Transaction | Shipping Method | Ship Mode | Many-to-One |
| Sales Transaction | Customer | Customer Name | Many-to-One |
| Sales Transaction | Product | Product Name | Many-to-One |
| Product | Product Category | Category | Many-to-One |

## 6. Common Data Elements in Report Requirements

1. **Category** - Referenced across sales analysis and product categorization reports
2. **Region** - Used in geographical performance analysis and regional profitability reports
3. **Ship Mode** - Common element for logistics and order fulfillment analysis
4. **Sales** - Core financial metric used across all revenue-related reports
5. **Profit** - Key profitability metric referenced in financial performance reports
6. **Customer Name** - Customer identification used across customer analytics reports
7. **Product Name** - Product identification used across product performance reports
8. **Order Date** - Temporal dimension used for time-series analysis and trending
9. **Quantity** - Volume metric used for inventory and demand analysis

## 7. API Cost Calculation

– Cost for this Call: $0.03