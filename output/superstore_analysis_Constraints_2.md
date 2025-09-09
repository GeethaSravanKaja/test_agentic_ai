____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Enhanced Model Data Constraints for Superstore sales analysis reporting requirements
## *Version*: 2
## *Changes*: Added Customer entity constraints, enhanced Sales Transaction attributes, included additional KPIs for comprehensive business analysis, added Product and temporal dimension constraints
## *Reason*: To provide more comprehensive business insights and support advanced analytics requirements with enhanced data model
## *Updated on*: 
_____________________________________________

# Enhanced Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
- **Category field**: Must be present in 100% of records, no null values allowed
- **Sales field**: Must be present in 100% of records, no null values allowed
- **Profit field**: Must be present in 100% of records, no null values allowed
- **Region field**: Must be present in 100% of records, no null values allowed
- **Ship Mode field**: Must be present in 100% of records, no null values allowed
- **Customer Name field**: Must be present in 100% of records, no null values allowed
- **Product Name field**: Must be present in 100% of records, no null values allowed
- **Order Date field**: Must be present in 100% of records, no null values allowed
- **Ship Date field**: Must be present in 100% of records, no null values allowed
- **Quantity field**: Must be present in 100% of records, no null values allowed
- **Discount field**: Must be present in 100% of records, can be 0 but not null

### 1.2 Data Accuracy
- **Sales values**: Must be numeric (decimal/float) and greater than or equal to 0
- **Profit values**: Must be numeric (decimal/float), can be negative (indicating loss)
- **Quantity values**: Must be positive integer, minimum value of 1
- **Discount values**: Must be numeric (decimal/float) between 0 and 1 (representing percentage)
- **Category values**: Must match predefined category list (Technology, Furniture, Office Supplies)
- **Region values**: Must match predefined region list (Central, East, South, West)
- **Ship Mode values**: Must match predefined shipping methods (Standard Class, Second Class, First Class, Same Day)
- **Customer Name**: Must be valid string with proper formatting
- **Product Name**: Must be valid string with proper formatting

### 1.3 Data Format
- **Sales field**: Decimal format with up to 2 decimal places
- **Profit field**: Decimal format with up to 2 decimal places
- **Quantity field**: Integer format, positive values only
- **Discount field**: Decimal format with up to 4 decimal places (0.0000 to 1.0000)
- **Order Date field**: Date format (YYYY-MM-DD)
- **Ship Date field**: Date format (YYYY-MM-DD)
- **Customer Name field**: String format, proper case, maximum 100 characters
- **Product Name field**: String format, proper case, maximum 200 characters

### 1.4 Data Consistency
- **Aggregation consistency**: Sum of individual sales must equal total sales across all dimensions
- **Profit-Sales relationship**: Profit should not exceed Sales value for any record
- **Date consistency**: Ship Date must be greater than or equal to Order Date
- **Discount-Sales relationship**: Discount amount should be reasonable relative to sales amount
- **Quantity-Sales relationship**: Sales amount should be consistent with quantity and unit price

## 2. Constraints

### 2.1 Mandatory Fields
- **Category**: Required field, cannot be null or empty
- **Sales**: Required field, cannot be null or empty
- **Profit**: Required field, cannot be null or empty
- **Region**: Required field, cannot be null or empty
- **Ship Mode**: Required field, cannot be null or empty
- **Customer Name**: Required field, cannot be null or empty
- **Product Name**: Required field, cannot be null or empty
- **Order Date**: Required field, cannot be null or empty
- **Ship Date**: Required field, cannot be null or empty
- **Quantity**: Required field, cannot be null or empty
- **Discount**: Required field, cannot be null (can be 0)

### 2.2 Data Type Limitations
- **Sales**: Must be numeric (DECIMAL/FLOAT) data type
- **Profit**: Must be numeric (DECIMAL/FLOAT) data type
- **Quantity**: Must be integer (INT) data type
- **Discount**: Must be numeric (DECIMAL/FLOAT) data type
- **Order Date**: Must be date (DATE) data type
- **Ship Date**: Must be date (DATE) data type
- **Category**: Must be string (VARCHAR) data type, maximum 50 characters
- **Region**: Must be string (VARCHAR) data type, maximum 20 characters
- **Ship Mode**: Must be string (VARCHAR) data type, maximum 30 characters
- **Customer Name**: Must be string (VARCHAR) data type, maximum 100 characters
- **Product Name**: Must be string (VARCHAR) data type, maximum 200 characters

### 2.3 Value Range Constraints
- **Sales**: Minimum value >= 0, Maximum value <= 999999.99
- **Profit**: Minimum value >= -999999.99, Maximum value <= 999999.99
- **Quantity**: Minimum value >= 1, Maximum value <= 10000
- **Discount**: Minimum value >= 0.0000, Maximum value <= 1.0000
- **Order Date**: Must be within reasonable business date range (2010-2025)
- **Ship Date**: Must be within reasonable business date range (2010-2025)
- **Category**: Must be one of: 'Technology', 'Furniture', 'Office Supplies'
- **Region**: Must be one of: 'Central', 'East', 'South', 'West'
- **Ship Mode**: Must be one of: 'Standard Class', 'Second Class', 'First Class', 'Same Day'

### 2.4 Referential Integrity
- **Category-Sales relationship**: Each category must have at least one sales record
- **Region-Sales relationship**: Each region must have at least one sales record
- **Ship Mode-Sales relationship**: Each ship mode must have at least one sales record
- **Customer-Sales relationship**: Each customer must have at least one sales record
- **Product-Sales relationship**: Each product must have at least one sales record
- **Date relationship**: Ship Date must be >= Order Date for each record

### 2.5 Uniqueness Constraints
- **Record level**: No duplicate records allowed (combination of all fields)
- **Transaction level**: Each transaction should have unique identifier
- **Customer level**: Customer names should be consistent across records
- **Product level**: Product names should be consistent across records

## 3. Business Rules

### 3.1 Operational Rules
- **Sales calculation**: Total sales by category must equal sum of individual sales records within that category
- **Profit calculation**: Average profit by region must be calculated as sum of profits divided by count of records in that region
- **Order counting**: Order count by ship mode must count each record as one order
- **Customer analysis**: Customer acquisition rate must be calculated based on first order date per customer
- **Product analysis**: Product performance must be measured by sales, profit, and quantity metrics

### 3.2 Reporting Logic
- **Category analysis**: Sales must be grouped by Category field for category-wise reporting
- **Regional analysis**: Profit must be grouped by Region field for regional performance reporting
- **Shipping analysis**: Records must be grouped by Ship Mode field for logistics reporting
- **Customer analysis**: Records must be grouped by Customer Name for customer behavior analysis
- **Product analysis**: Records must be grouped by Product Name for product performance analysis
- **Temporal analysis**: Records must be grouped by Order Date for time-series analysis

### 3.3 Transformation Guidelines
- **Aggregation method**: Use SUM function for sales totals, AVG function for profit averages, COUNT function for order counts
- **Grouping method**: Use GROUP BY clause on respective dimension fields (Category, Region, Ship Mode, Customer Name, Product Name)
- **Date calculations**: Use date functions for calculating delivery time, sales growth rate, and temporal trends
- **KPI calculations**: Calculate profit margin as (Profit/Sales)*100, average order value as Sales/Quantity
- **Null handling**: Exclude records with null values in key fields from aggregations

### 3.4 Data Processing Rules
- **File format**: Input data must be in CSV format with header row
- **Schema inference**: Data types should be automatically inferred during data loading
- **Error handling**: Invalid records should be logged but not stop the processing
- **Data validation**: Implement data quality checks before processing
- **Incremental loading**: Support for incremental data updates based on Order Date

### 3.5 Performance Rules
- **Data loading**: CSV file must be loaded with header=True and inferSchema=True options
- **Processing efficiency**: Use Spark DataFrame operations for optimal performance
- **Memory management**: Ensure proper Spark session management with explicit stop() call
- **Partitioning**: Consider partitioning data by Region or Category for better performance
- **Caching**: Cache frequently accessed DataFrames for improved performance

### 3.6 Enhanced KPI Rules
- **Sales Growth Rate**: Calculate period-over-period growth using Order Date
- **Profit Margin by Category**: Calculate as (Total Profit / Total Sales) * 100 per category
- **Customer Acquisition Rate**: Track new customers based on first appearance in dataset
- **Average Order Value**: Calculate as Total Sales / Total Orders
- **Shipping Performance**: Calculate delivery time as Ship Date - Order Date
- **Product Performance**: Rank products by sales, profit, and quantity metrics

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.03