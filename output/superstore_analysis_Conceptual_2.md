_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Enhanced conceptual data model for Superstore analysis reporting requirements
## *Version*: 2
## *Changes*: Enhanced entity relationships, added Customer entity, expanded attributes, improved KPI definitions
## *Reason*: To provide more comprehensive data model covering customer analytics and enhanced business intelligence capabilities
## *Updated on*: 
_____________________________________________

# Conceptual Data Model for Superstore Analysis

## 1. Domain Overview

This enhanced conceptual data model supports comprehensive retail analytics for a superstore business, focusing on sales performance, profitability analysis, customer behavior, and operational metrics across multiple business dimensions including product categories, geographical regions, shipping methods, and customer segments. The model enables advanced business intelligence and data-driven decision making.

## 2. List of Entity Name with Description

1. **Product** - Represents items sold in the superstore with detailed categorization and product information
2. **Order** - Represents individual customer transactions and purchases with comprehensive order details
3. **Region** - Represents geographical areas where business operations occur with location hierarchy
4. **Shipping** - Represents different shipping methods and logistics information with delivery details
5. **Customer** - Represents customer information and segmentation for customer analytics
6. **Time** - Represents temporal dimensions for time-based analysis and trending

## 3. List of Attributes for each Entity with Description

### Product Entity
- **Category** - Primary business classification of products (Technology, Furniture, Office Supplies)
- **Sub Category** - Detailed classification within the main category for granular analysis
- **Product Name** - Specific name or title of the product being sold
- **Manufacturer** - Company or brand that produces the product
- **Product Line** - Product series or collection grouping

### Order Entity
- **Sales** - Total monetary value of the transaction including taxes and fees
- **Profit** - Net profit generated from the order after all costs and expenses
- **Quantity** - Number of units purchased in the order
- **Discount** - Percentage or monetary amount of discount applied
- **Unit Price** - Price per individual item before discounts
- **Cost** - Total cost of goods sold for the order
- **Order Priority** - Business priority level of the order processing

### Region Entity
- **Region** - Primary geographical region (East, West, Central, South)
- **State** - State or province within the region for detailed location analysis
- **City** - City where the order was delivered for local market analysis
- **Postal Code** - Postal or ZIP code for precise geographic targeting
- **Country** - Country information for international analysis
- **Market Segment** - Regional market classification for strategic planning

### Shipping Entity
- **Ship Mode** - Method of shipping (Standard Class, Second Class, First Class, Same Day)
- **Ship Cost** - Total cost associated with shipping and handling
- **Delivery Time** - Expected or actual delivery timeframe
- **Carrier** - Shipping company or logistics provider
- **Tracking Status** - Current status of shipment tracking

### Customer Entity
- **Customer Name** - Full name of the customer for identification
- **Customer Segment** - Business classification (Consumer, Corporate, Home Office)
- **Customer Type** - Customer category based on purchase behavior
- **Customer Lifetime Value** - Total value of customer relationship
- **Purchase Frequency** - How often customer makes purchases

### Time Entity
- **Order Date** - Date when the order was placed for temporal analysis
- **Ship Date** - Date when the order was shipped for logistics tracking
- **Year** - Year component for annual analysis and trending
- **Quarter** - Quarterly period for seasonal analysis
- **Month** - Monthly component for detailed time-based reporting
- **Day of Week** - Day of the week for operational pattern analysis

## 4. KPI List

1. **Total Sales by Category** - Aggregate sales revenue grouped by product category for product performance
2. **Average Profit by Region** - Mean profit performance across geographical regions for regional analysis
3. **Order Count by Ship Mode** - Number of orders processed through each shipping method for logistics optimization
4. **Sales Growth Rate** - Period-over-period sales growth percentage for trend analysis
5. **Profit Margin by Product** - Profitability percentage for each product line
6. **Customer Acquisition Cost** - Cost to acquire new customers by segment
7. **Average Order Value** - Mean transaction value for customer behavior analysis
8. **Regional Market Share** - Percentage of total sales by geographic region
9. **Shipping Cost Efficiency** - Ratio of shipping cost to order value
10. **Customer Retention Rate** - Percentage of repeat customers over time periods
11. **Inventory Turnover** - Rate at which products are sold and replaced
12. **Seasonal Sales Patterns** - Sales performance variations across time periods

## 5. Conceptual Data Model Diagram in Tabular Form

| Source Entity | Target Entity | Relationship Key Field | Relationship Type |
|---------------|---------------|----------------------|-------------------|
| Order | Product | Category | Many-to-One |
| Order | Region | Region | Many-to-One |
| Order | Shipping | Ship Mode | Many-to-One |
| Order | Customer | Customer Name | Many-to-One |
| Order | Time | Order Date | Many-to-One |
| Product | Order | Category | One-to-Many |
| Region | Order | Region | One-to-Many |
| Shipping | Order | Ship Mode | One-to-Many |
| Customer | Order | Customer Name | One-to-Many |
| Time | Order | Order Date | One-to-Many |
| Customer | Region | Region | Many-to-One |
| Region | Customer | Region | One-to-Many |

## 6. Common Data Elements in Report Requirements

1. **Category** - Primary dimension used across product analysis and sales reporting
2. **Region** - Core geographical dimension for location-based performance analysis
3. **Ship Mode** - Key operational dimension for logistics and delivery analysis
4. **Sales** - Primary financial measure for revenue analysis and performance tracking
5. **Profit** - Essential profitability metric used in financial analysis
6. **Customer Segment** - Important dimension for customer analytics and segmentation
7. **Order Date** - Critical temporal field for time-based analysis and trending
8. **Quantity** - Volume measure used across operational and inventory reports
9. **Discount** - Pricing dimension for promotional and pricing strategy analysis
10. **Order Count** - Fundamental metric for volume analysis across all business dimensions

## 7. API Cost Calculation

– Cost for this Call: $0.03