____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Model Data Constraints for Superstore sales analysis reporting requirements
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
- **Category field**: Must be present in 100% of records, no null values allowed
- **Sales field**: Must be present in 100% of records, no null values allowed
- **Profit field**: Must be present in 100% of records, no null values allowed
- **Region field**: Must be present in 100% of records, no null values allowed
- **Ship Mode field**: Must be present in 100% of records, no null values allowed

### 1.2 Data Accuracy
- **Sales values**: Must be numeric (decimal/float) and greater than or equal to 0
- **Profit values**: Must be numeric (decimal/float), can be negative (indicating loss)
- **Category values**: Must match predefined category list (Technology, Furniture, Office Supplies)
- **Region values**: Must match predefined region list (Central, East, South, West)
- **Ship Mode values**: Must match predefined shipping methods (Standard Class, Second Class, First Class, Same Day)

### 1.3 Data Format
- **Sales field**: Decimal format with up to 2 decimal places
- **Profit field**: Decimal format with up to 2 decimal places
- **Category field**: String format, proper case
- **Region field**: String format, proper case
- **Ship Mode field**: String format, proper case

### 1.4 Data Consistency
- **Aggregation consistency**: Sum of individual sales must equal total sales across all dimensions
- **Profit-Sales relationship**: Profit should not exceed Sales value for any record
- **Category grouping**: All records with same category must have consistent category spelling

## 2. Constraints

### 2.1 Mandatory Fields
- **Category**: Required field, cannot be null or empty
- **Sales**: Required field, cannot be null or empty
- **Profit**: Required field, cannot be null or empty
- **Region**: Required field, cannot be null or empty
- **Ship Mode**: Required field, cannot be null or empty

### 2.2 Data Type Limitations
- **Sales**: Must be numeric (DECIMAL/FLOAT) data type
- **Profit**: Must be numeric (DECIMAL/FLOAT) data type
- **Category**: Must be string (VARCHAR) data type, maximum 50 characters
- **Region**: Must be string (VARCHAR) data type, maximum 20 characters
- **Ship Mode**: Must be string (VARCHAR) data type, maximum 30 characters

### 2.3 Value Range Constraints
- **Sales**: Minimum value >= 0, Maximum value <= 999999.99
- **Profit**: Minimum value >= -999999.99, Maximum value <= 999999.99
- **Category**: Must be one of: 'Technology', 'Furniture', 'Office Supplies'
- **Region**: Must be one of: 'Central', 'East', 'South', 'West'
- **Ship Mode**: Must be one of: 'Standard Class', 'Second Class', 'First Class', 'Same Day'

### 2.4 Referential Integrity
- **Category-Sales relationship**: Each category must have at least one sales record
- **Region-Sales relationship**: Each region must have at least one sales record
- **Ship Mode-Sales relationship**: Each ship mode must have at least one sales record

### 2.5 Uniqueness Constraints
- **Record level**: No duplicate records allowed (combination of all fields)
- **Aggregation level**: Category totals must be unique per category
- **Regional level**: Region totals must be unique per region

## 3. Business Rules

### 3.1 Operational Rules
- **Sales calculation**: Total sales by category must equal sum of individual sales records within that category
- **Profit calculation**: Average profit by region must be calculated as sum of profits divided by count of records in that region
- **Order counting**: Order count by ship mode must count each record as one order

### 3.2 Reporting Logic
- **Category analysis**: Sales must be grouped by Category field for category-wise reporting
- **Regional analysis**: Profit must be grouped by Region field for regional performance reporting
- **Shipping analysis**: Records must be grouped by Ship Mode field for logistics reporting

### 3.3 Transformation Guidelines
- **Aggregation method**: Use SUM function for sales totals, AVG function for profit averages, COUNT function for order counts
- **Grouping method**: Use GROUP BY clause on respective dimension fields (Category, Region, Ship Mode)
- **Null handling**: Exclude records with null values in key fields from aggregations

### 3.4 Data Processing Rules
- **File format**: Input data must be in CSV format with header row
- **Schema inference**: Data types should be automatically inferred during data loading
- **Error handling**: Invalid records should be logged but not stop the processing

### 3.5 Performance Rules
- **Data loading**: CSV file must be loaded with header=True and inferSchema=True options
- **Processing efficiency**: Use Spark DataFrame operations for optimal performance
- **Memory management**: Ensure proper Spark session management with explicit stop() call

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.02