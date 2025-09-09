_____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Model Data Constraints for Superstore analysis reporting requirements
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
- **Sales Data**: All sales records must contain non-null values for Sales amount, Category, Region, and Ship Mode
- **Profit Data**: Profit values must be present for all sales transactions to enable profitability analysis
- **Geographic Data**: Region information must be complete for all orders to support regional analysis
- **Product Data**: Category classification must be available for all products to enable category-based reporting
- **Shipping Data**: Ship Mode information must be present for all orders to support logistics analysis

### 1.2 Data Accuracy
- **Sales Amount**: Must be positive numeric values representing actual transaction amounts
- **Profit Amount**: Can be positive or negative numeric values reflecting actual profit/loss
- **Category Names**: Must follow standardized naming conventions (e.g., "Technology", "Furniture", "Office Supplies")
- **Region Names**: Must use consistent regional classifications (e.g., "East", "West", "Central", "South")
- **Ship Mode**: Must use standardized shipping method names

### 1.3 Data Format Consistency
- **Numeric Fields**: Sales and Profit amounts must be in decimal format with appropriate precision
- **Text Fields**: Category, Region, and Ship Mode must use consistent capitalization and spelling
- **Data Types**: All fields must maintain consistent data types across the dataset

### 1.4 Data Freshness
- **Transaction Data**: Sales and profit data should reflect current business operations
- **Reference Data**: Category and regional classifications should be up-to-date with current business structure

## 2. Constraints

### 2.1 Mandatory Fields
- **Sales**: Required for all records - cannot be null or empty
- **Category**: Required for product classification - cannot be null or empty
- **Region**: Required for geographic analysis - cannot be null or empty
- **Ship Mode**: Required for shipping analysis - cannot be null or empty
- **Profit**: Required for profitability analysis - cannot be null

### 2.2 Data Type Constraints
- **Sales**: Must be numeric (decimal/float) data type
- **Profit**: Must be numeric (decimal/float) data type, can be negative
- **Category**: Must be string/text data type
- **Region**: Must be string/text data type
- **Ship Mode**: Must be string/text data type

### 2.3 Value Range Constraints
- **Sales**: Must be greater than or equal to 0
- **Profit**: No specific range constraint (can be positive or negative)
- **Category**: Must be from predefined list of valid categories
- **Region**: Must be from predefined list of valid regions
- **Ship Mode**: Must be from predefined list of valid shipping methods

### 2.4 Uniqueness Constraints
- **Transaction Records**: Each sales transaction should be uniquely identifiable
- **Aggregation Keys**: Combination of Category, Region, and Ship Mode should allow for proper grouping

### 2.5 Referential Integrity
- **Category Values**: Must reference valid product categories in the business taxonomy
- **Region Values**: Must reference valid geographical regions served by the business
- **Ship Mode Values**: Must reference valid shipping methods offered by the business

## 3. Business Rules

### 3.1 Sales Analysis Rules
- **Total Sales Calculation**: Sum of all Sales amounts grouped by Category must equal total business revenue for the category
- **Sales Aggregation**: Sales totals must be calculated using sum function for accurate revenue reporting
- **Category Grouping**: All sales must be properly classified and grouped by product Category for meaningful analysis

### 3.2 Profitability Analysis Rules
- **Average Profit Calculation**: Average profit by Region must be calculated using mean function across all transactions in each region
- **Profit Margin Analysis**: Profit values must be analyzed in relation to Sales values for margin calculations
- **Regional Performance**: Profit analysis must be segmented by Region for geographic performance assessment

### 3.3 Operational Analysis Rules
- **Order Count Logic**: Count of orders by Ship Mode must include all transactions regardless of sales amount
- **Shipping Method Analysis**: Each order must be counted exactly once per shipping method for accurate logistics reporting
- **Operational Metrics**: Ship Mode analysis must support operational decision-making for logistics optimization

### 3.4 Data Processing Rules
- **Aggregation Standards**: All groupBy operations must maintain data integrity and prevent double-counting
- **Null Handling**: Any null values in key fields (Sales, Category, Region, Ship Mode) must be identified and handled appropriately
- **Data Validation**: All input data must be validated against business rules before processing

### 3.5 Reporting Logic Rules
- **Category Reporting**: Sales by Category reports must include all product categories with non-zero sales
- **Regional Reporting**: Average Profit by Region reports must include all regions with transaction data
- **Shipping Reporting**: Order Count by Ship Mode reports must include all shipping methods used
- **Performance Metrics**: All calculated metrics must align with business KPIs and reporting standards

### 3.6 Data Transformation Guidelines
- **Alias Usage**: Aggregated columns must use descriptive aliases (Total_Sales, Avg_Profit, Order_Count)
- **Function Application**: Use appropriate Spark SQL functions (sum, avg, count) for accurate calculations
- **Result Formatting**: All output results must be properly formatted for business consumption

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.12