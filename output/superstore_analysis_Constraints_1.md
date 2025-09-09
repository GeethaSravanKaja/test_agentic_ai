____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Data constraints and business rules for Superstore sales analysis and reporting system
## *Version*: 1 
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
1. **Sales Data Completeness**: All sales records must contain non-null values for Sales, Category, Region, and Ship Mode fields
2. **Category Field Completeness**: Category field must be populated for all records to enable sales aggregation by product categories
3. **Region Field Completeness**: Region field must be populated for all records to enable profit analysis by geographical regions
4. **Ship Mode Completeness**: Ship Mode field must be populated for all records to enable order count analysis by shipping methods

### 1.2 Data Accuracy
1. **Sales Amount Accuracy**: Sales values must be positive numeric values representing actual transaction amounts
2. **Profit Value Accuracy**: Profit values must be numeric and can be positive or negative representing actual profit/loss
3. **Category Value Accuracy**: Category values must match predefined product category classifications
4. **Region Value Accuracy**: Region values must correspond to valid geographical business territories

### 1.3 Data Format Consistency
1. **Numeric Format Consistency**: Sales and Profit fields must maintain consistent decimal precision for accurate calculations
2. **Text Format Consistency**: Category, Region, and Ship Mode fields must follow consistent naming conventions
3. **Data Type Consistency**: All fields must maintain their expected data types throughout the dataset

### 1.4 Data Freshness
1. **Dataset Currency**: Superstore data must be current and regularly updated to reflect recent business transactions
2. **Analysis Relevance**: Data used for analysis must be within the relevant business reporting period

## 2. Constraints

### 2.1 Mandatory Field Constraints
1. **Sales Field Constraint**: Sales field is mandatory and cannot be null or empty
2. **Category Field Constraint**: Category field is mandatory for product classification and aggregation
3. **Region Field Constraint**: Region field is mandatory for geographical analysis and reporting
4. **Ship Mode Field Constraint**: Ship Mode field is mandatory for logistics and shipping analysis

### 2.2 Data Type Constraints
1. **Sales Data Type**: Sales field must be numeric (integer or decimal) data type
2. **Profit Data Type**: Profit field must be numeric (integer or decimal) data type allowing negative values
3. **Category Data Type**: Category field must be string/text data type
4. **Region Data Type**: Region field must be string/text data type
5. **Ship Mode Data Type**: Ship Mode field must be string/text data type

### 2.3 Value Range Constraints
1. **Sales Value Range**: Sales values must be greater than zero for valid transactions
2. **Profit Value Range**: Profit values can be positive or negative but must be within reasonable business ranges
3. **Category Value Range**: Category values must be from predefined list of valid product categories
4. **Region Value Range**: Region values must be from predefined list of valid business regions
5. **Ship Mode Value Range**: Ship Mode values must be from predefined list of valid shipping methods

### 2.4 Uniqueness Constraints
1. **Transaction Uniqueness**: Each sales transaction should have unique identifying characteristics
2. **Aggregation Uniqueness**: Grouped results by Category, Region, and Ship Mode must maintain distinct groupings

### 2.5 Referential Integrity Constraints
1. **Category Reference Integrity**: Category values must reference valid product category master data
2. **Region Reference Integrity**: Region values must reference valid geographical region master data
3. **Ship Mode Reference Integrity**: Ship Mode values must reference valid shipping method master data

## 3. Business Rules

### 3.1 Sales Analysis Rules
1. **Sales Aggregation Rule**: Total sales by category must be calculated as the sum of all individual sales amounts within each product category
2. **Sales Calculation Rule**: Sales amounts must represent the actual monetary value of goods sold excluding taxes and discounts unless specified
3. **Sales Reporting Rule**: Sales analysis must group transactions by distinct category values to provide meaningful business insights

### 3.2 Profit Analysis Rules
1. **Profit Calculation Rule**: Average profit by region must be calculated as the arithmetic mean of all profit values within each geographical region
2. **Profit Reporting Rule**: Profit analysis must account for both positive profits and negative losses in regional calculations
3. **Profit Validation Rule**: Profit values must be validated against sales amounts to ensure business logic consistency

### 3.3 Order Processing Rules
1. **Order Count Rule**: Order count by ship mode must represent the total number of distinct orders processed through each shipping method
2. **Ship Mode Classification Rule**: All shipping methods must be properly classified and grouped for accurate order volume analysis
3. **Order Validation Rule**: Order counts must be positive integers representing actual processed orders

### 3.4 Data Processing Rules
1. **Schema Validation Rule**: Dataset schema must be validated before processing to ensure all required fields are present
2. **Data Quality Rule**: Data quality checks must be performed to identify and handle missing or invalid values
3. **Aggregation Rule**: All aggregation operations must handle null values appropriately to prevent calculation errors

### 3.5 Reporting Logic Rules
1. **Category Reporting Rule**: Sales by category reporting must include all product categories present in the dataset
2. **Regional Reporting Rule**: Profit by region reporting must include all geographical regions present in the dataset
3. **Shipping Reporting Rule**: Order count by ship mode reporting must include all shipping methods present in the dataset

### 3.6 Data Transformation Rules
1. **Grouping Rule**: Data grouping operations must maintain data integrity and prevent duplicate aggregations
2. **Calculation Rule**: All mathematical calculations must handle edge cases such as division by zero or null values
3. **Output Format Rule**: Analysis results must be presented in a clear, readable format with appropriate column aliases

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.03