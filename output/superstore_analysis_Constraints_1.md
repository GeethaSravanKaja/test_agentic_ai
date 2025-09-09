____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Data constraints for superstore analysis reporting requirements
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
- **Category field**: Must be present in 100% of records for product classification analysis
- **Region field**: Must be present in 100% of records for geographical analysis
- **Ship Mode field**: Must be present in 100% of records for shipping analysis
- **Sales field**: Must be present in 100% of records and cannot be null for revenue calculations
- **Profit field**: Must be present in 100% of records for profitability analysis

### 1.2 Data Accuracy
- **Sales values**: Must be numeric and greater than or equal to 0
- **Profit values**: Must be numeric (can be negative for loss scenarios)
- **Category values**: Must match predefined business categories
- **Region values**: Must correspond to valid geographical regions
- **Ship Mode values**: Must match available shipping methods

### 1.3 Data Format
- **Sales field**: Decimal format with up to 2 decimal places for currency representation
- **Profit field**: Decimal format with up to 2 decimal places for currency representation
- **Category field**: Text format, standardized naming convention
- **Region field**: Text format, standardized geographical naming
- **Ship Mode field**: Text format, standardized shipping method names

### 1.4 Data Consistency
- **Category naming**: Consistent capitalization and spelling across all records
- **Region naming**: Consistent geographical naming conventions
- **Ship Mode naming**: Consistent shipping method terminology
- **Currency values**: Consistent currency denomination for Sales and Profit

## 2. Constraints

### 2.1 Mandatory Fields
- **Category**: Required for all records, cannot be null or empty
- **Region**: Required for all records, cannot be null or empty
- **Ship Mode**: Required for all records, cannot be null or empty
- **Sales**: Required for all records, cannot be null
- **Profit**: Required for all records, cannot be null

### 2.2 Data Type Limitations
- **Sales**: Must be numeric (decimal/float) data type
- **Profit**: Must be numeric (decimal/float) data type
- **Category**: Must be string/text data type
- **Region**: Must be string/text data type
- **Ship Mode**: Must be string/text data type

### 2.3 Value Range Constraints
- **Sales**: Must be >= 0 (cannot have negative sales)
- **Profit**: Can be negative (losses allowed) but must be within reasonable business range
- **Category**: Must be from predefined list of valid categories
- **Region**: Must be from predefined list of valid regions
- **Ship Mode**: Must be from predefined list of valid shipping modes

### 2.4 Referential Integrity
- **Category values**: Must reference valid product categories in business taxonomy
- **Region values**: Must reference valid geographical regions in business scope
- **Ship Mode values**: Must reference available shipping methods in logistics system

### 2.5 Dependencies
- **Sales and Profit relationship**: Profit calculations must be consistent with Sales values
- **Category and Sales relationship**: Sales aggregation by Category must be mathematically accurate
- **Region and Profit relationship**: Profit aggregation by Region must be mathematically accurate

## 3. Business Rules

### 3.1 Operational Rules
- **Sales Aggregation**: Total Sales by Category must equal sum of all individual sales records within that category
- **Profit Calculation**: Average Profit by Region must be calculated as arithmetic mean of all profit values within that region
- **Order Counting**: Order Count by Ship Mode must represent unique count of orders for each shipping method

### 3.2 Reporting Logic
- **Category Analysis**: Sales totals must be grouped by Category field for product performance analysis
- **Regional Analysis**: Profit averages must be calculated by Region field for geographical performance
- **Shipping Analysis**: Order counts must be aggregated by Ship Mode for logistics optimization

### 3.3 Transformation Guidelines
- **Aggregation Functions**: Use SUM for Sales totals, AVG for Profit averages, COUNT for order quantities
- **Grouping Logic**: Group by categorical fields (Category, Region, Ship Mode) for dimensional analysis
- **Null Handling**: Exclude null values from calculations to ensure accurate results

### 3.4 Data Quality Rules
- **Outlier Detection**: Sales and Profit values should be validated for business-reasonable ranges
- **Consistency Checks**: Category, Region, and Ship Mode values should be validated against master data
- **Completeness Validation**: All required fields must be populated before processing

### 3.5 Performance Rules
- **Indexing Requirements**: Category, Region, and Ship Mode fields should be indexed for optimal query performance
- **Partitioning Strategy**: Data should be partitioned by Region or Category for efficient processing
- **Caching Strategy**: Frequently accessed aggregations should be cached for improved response times

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.02