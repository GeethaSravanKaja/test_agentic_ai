_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Conceptual data model for Superstore sales analysis reporting requirements
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This conceptual data model supports retail sales analysis for a superstore business. The model focuses on analyzing sales performance, profitability, and order fulfillment across different business dimensions including product categories, geographical regions, and shipping methods.

## 2. List of Entity Name with Description

1. **Sales Transaction** - Represents individual sales records containing transaction details, financial metrics, and associated business dimensions
2. **Product Category** - Represents different product categories available in the superstore
3. **Geographic Region** - Represents different geographical regions where sales occur
4. **Shipping Method** - Represents different modes of product delivery and shipment

## 3. List of Attributes for each Entity with Description

### Sales Transaction Entity
- **Category** - Product category classification for the sold item
- **Sales** - Total sales amount/revenue generated from the transaction
- **Profit** - Net profit earned from the sales transaction
- **Region** - Geographical region where the sale occurred
- **Ship Mode** - Method used for shipping/delivering the product

### Product Category Entity
- **Category Name** - Name of the product category
- **Category Description** - Detailed description of the product category

### Geographic Region Entity
- **Region Name** - Name of the geographical region
- **Region Description** - Detailed description of the geographical area

### Shipping Method Entity
- **Ship Mode Name** - Name of the shipping method
- **Ship Mode Description** - Description of the shipping/delivery method

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales amount grouped by product category
2. **Average Profit by Region** - Mean profit value calculated for each geographical region
3. **Order Count by Ship Mode** - Total number of orders processed through each shipping method

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Table | Target Table | Relationship Key Field | Relationship Type |
|--------------|--------------|----------------------|------------------|
| Sales Transaction | Product Category | Category | Many-to-One |
| Sales Transaction | Geographic Region | Region | Many-to-One |
| Sales Transaction | Shipping Method | Ship Mode | Many-to-One |

## 6. Common Data Elements in Report Requirements

1. **Category** - Referenced across sales analysis and product categorization reports
2. **Region** - Used in geographical performance analysis and regional profitability reports
3. **Ship Mode** - Common element for logistics and order fulfillment analysis
4. **Sales** - Core financial metric used across all revenue-related reports
5. **Profit** - Key profitability metric referenced in financial performance reports

## 7. API Cost Calculation

– Cost for this Call: $0.02