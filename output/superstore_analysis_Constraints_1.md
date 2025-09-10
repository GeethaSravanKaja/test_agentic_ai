____________________________________________
## *Author*: AAVA
## *Created on*:   
## *Description*: Model Data Constraints for superstore sales and profit analysis reporting
## *Version*: 1 
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
1. **Category** - Must be present for all product records, no null values allowed
2. **Sales** - Must be present for all transaction records, cannot be null
3. **Profit** - Must be present for all transaction records, cannot be null
4. **Region** - Must be present for all customer records, no null values allowed
5. **Ship Mode** - Must be present for all order records, no null values allowed
6. **Order Date** - Must be present for all orders, cannot be null
7. **Ship Date** - Must be present for all shipped orders, cannot be null
8. **Quantity** - Must be present for all order line items, cannot be null
9. **Discount** - Must be present for all transactions, default to 0 if not specified

### 1.2 Data Accuracy
1. **Sales Amount** - Must be accurate monetary values with precision up to 2 decimal places
2. **Profit Calculation** - Must accurately reflect the difference between revenue and costs
3. **Quantity Values** - Must represent actual count of items ordered
4. **Date Values** - Must represent actual transaction and shipping dates
5. **Discount Percentages** - Must accurately reflect applied discounts

### 1.3 Data Format
1. **Sales** - Numeric format with 2 decimal precision (e.g., 1234.56)
2. **Profit** - Numeric format with 2 decimal precision, can be negative
3. **Quantity** - Integer format, positive values only
4. **Discount** - Decimal format between 0.00 and 1.00 (representing percentage)
5. **Order Date** - Date format (YYYY-MM-DD)
6. **Ship Date** - Date format (YYYY-MM-DD)
7. **Category** - Text format, standardized category names
8. **Region** - Text format, standardized region names
9. **Ship Mode** - Text format, standardized shipping method names

### 1.4 Data Consistency
1. **Category Names** - Must use consistent naming conventions across all records
2. **Region Names** - Must use standardized region identifiers
3. **Ship Mode Values** - Must use consistent shipping method terminology
4. **Currency Values** - All monetary amounts must be in the same currency unit
5. **Date Formats** - All dates must follow the same format standard

## 2. Constraints

### 2.1 Mandatory Fields
1. **Category** - Required field, cannot be empty or null
2. **Sales** - Required field, must have valid numeric value
3. **Profit** - Required field, must have valid numeric value
4. **Region** - Required field, cannot be empty or null
5. **Ship Mode** - Required field, cannot be empty or null
6. **Order Date** - Required field, must be valid date
7. **Ship Date** - Required field for shipped orders, must be valid date
8. **Quantity** - Required field, must be positive integer

### 2.2 Uniqueness Constraints
1. **Order ID** - Each order must have a unique identifier (if present in dataset)
2. **Transaction Records** - Combination of order details must create unique transaction records

### 2.3 Data Type Limitations
1. **Sales** - Must be numeric (decimal/float), cannot contain text or special characters
2. **Profit** - Must be numeric (decimal/float), can be positive or negative
3. **Quantity** - Must be integer, positive values only (>= 1)
4. **Discount** - Must be numeric (decimal), between 0.00 and 1.00
5. **Order Date** - Must be valid date format
6. **Ship Date** - Must be valid date format
7. **Category** - Must be text/string format
8. **Region** - Must be text/string format
9. **Ship Mode** - Must be text/string format

### 2.4 Data Quality Validation Rules
1. **Sales Validation** - Sales amount must be greater than 0
2. **Profit Validation** - Profit can be negative but must be within reasonable range relative to sales
3. **Quantity Validation** - Quantity must be positive integer (minimum value: 1)
4. **Discount Validation** - Discount percentage must not exceed 100% (value <= 1.00)
5. **Date Validation** - Ship Date must be equal to or after Order Date
6. **Numeric Range Validation** - All numeric fields must be within acceptable business ranges

### 2.5 Dependencies
1. **Ship Date Dependency** - Ship Date must be greater than or equal to Order Date
2. **Profit Dependency** - Profit calculation should be consistent with Sales and Cost relationship
3. **Category Dependency** - Product categories must align with business product classification
4. **Regional Dependency** - Region values must correspond to valid geographical areas

### 2.6 Referential Integrity
1. **Category Reference** - All category values must exist in the approved category master list
2. **Region Reference** - All region values must exist in the geographical reference data
3. **Ship Mode Reference** - All shipping modes must exist in the logistics reference data

## 3. Business Rules

### 3.1 Operational Rules
1. **Sales Aggregation Rule** - Total sales by category must sum all individual transaction sales within each category
2. **Profit Calculation Rule** - Average profit by region must calculate the mean of all profit values within each geographical region
3. **Order Counting Rule** - Order count by ship mode must count distinct orders for each shipping method
4. **Date Processing Rule** - All date-based calculations must consider business calendar and exclude invalid dates
5. **Discount Application Rule** - Discounts must be applied consistently across all transaction calculations

### 3.2 Reporting Logic
1. **Category Grouping** - Sales analysis must group transactions by product category for meaningful insights
2. **Regional Analysis** - Profit analysis must be segmented by geographical regions for location-based performance
3. **Shipping Analysis** - Order volume analysis must be categorized by shipping methods for logistics insights
4. **Aggregation Logic** - All summary calculations must use appropriate aggregation functions (sum, average, count)
5. **Filtering Logic** - Reports must exclude invalid or incomplete records from calculations

### 3.3 Transformation Guidelines
1. **Data Standardization** - All text fields must be standardized for consistent reporting
2. **Null Handling** - Missing values must be handled according to business rules (default values or exclusion)
3. **Currency Formatting** - All monetary values must be formatted consistently for reporting
4. **Date Formatting** - All dates must be formatted according to business standards
5. **Percentage Calculation** - Discount percentages must be calculated and displayed consistently

### 3.4 Data Quality Business Rules
1. **Numeric Field Validation** - All numeric fields (Sales, Profit, Quantity, Discount) must pass data quality checks before processing
2. **Date Consistency Rule** - Ship Date must always be after or equal to Order Date to ensure logical order fulfillment sequence
3. **Discount Limit Rule** - Discount percentage must not exceed 100% to prevent negative pricing scenarios
4. **Sales Positivity Rule** - Sales amounts must be positive values to represent valid transactions
5. **Quantity Minimum Rule** - Quantity must be at least 1 to represent valid order line items

### 3.5 Exception Handling Rules
1. **Invalid Date Handling** - Records with Ship Date before Order Date must be flagged for review
2. **Excessive Discount Handling** - Transactions with discounts over 100% must be rejected or flagged
3. **Negative Sales Handling** - Records with negative sales must be investigated as potential returns or errors
4. **Zero Quantity Handling** - Orders with zero quantity must be excluded from analysis
5. **Missing Data Handling** - Records with missing critical fields must be excluded from calculations

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.03