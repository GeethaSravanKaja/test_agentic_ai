____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Model Data Constraints for Superstore Analysis PySpark application
## *Version*: 1
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
1. **CSV File Availability**: The superstore.csv file must be accessible and readable at the specified file path
2. **Header Row Presence**: The CSV file must contain a header row with column names for proper schema inference
3. **Required Columns**: The dataset must contain the following mandatory columns:
   - Category (for sales analysis by category)
   - Sales (for total sales calculations)
   - Region (for regional profit analysis)
   - Profit (for average profit calculations)
   - Ship Mode (for order count analysis)
4. **Non-null Values**: Critical fields (Category, Sales, Region, Ship Mode) should not contain null values for accurate aggregations

### 1.2 Data Accuracy
1. **Numeric Data Types**: Sales and Profit columns must contain valid numeric values for mathematical operations
2. **Category Values**: Category field should contain consistent categorical values without typos or variations
3. **Region Values**: Region field should contain standardized region names for proper grouping
4. **Ship Mode Values**: Ship Mode field should contain valid shipping method names

### 1.3 Data Format
1. **CSV Format**: Input data must be in CSV format with proper delimiter separation
2. **Schema Inference**: Data types should be automatically inferable by Spark's inferSchema option
3. **Encoding**: File should be in UTF-8 encoding for proper character handling

### 1.4 Data Consistency
1. **Categorical Consistency**: Category, Region, and Ship Mode values should be consistent across all records
2. **Numeric Precision**: Sales and Profit values should maintain appropriate decimal precision
3. **Data Relationships**: Each record should represent a valid business transaction

## 2. Constraints

### 2.1 Mandatory Fields
1. **Category**: Required for sales analysis by category - cannot be null or empty
2. **Sales**: Required for total sales calculations - must be numeric and non-null
3. **Region**: Required for regional analysis - cannot be null or empty
4. **Profit**: Required for profit calculations - must be numeric (can be negative)
5. **Ship Mode**: Required for shipping analysis - cannot be null or empty

### 2.2 Data Type Limitations
1. **Sales Column**: Must be numeric (Integer or Decimal) for sum aggregation
2. **Profit Column**: Must be numeric (Integer or Decimal) for average calculation
3. **Category Column**: Must be string/text type for grouping operations
4. **Region Column**: Must be string/text type for grouping operations
5. **Ship Mode Column**: Must be string/text type for grouping operations

### 2.3 Value Range Constraints
1. **Sales Values**: Should be non-negative values representing monetary amounts
2. **Profit Values**: Can be positive or negative representing profit or loss
3. **Category Values**: Should be from a predefined set of valid categories
4. **Region Values**: Should be from a predefined set of valid regions
5. **Ship Mode Values**: Should be from a predefined set of valid shipping methods

### 2.4 Referential Integrity
1. **Category Consistency**: All category values should be consistent across the dataset
2. **Region Consistency**: All region values should be consistent across the dataset
3. **Ship Mode Consistency**: All ship mode values should be consistent across the dataset
4. **Record Completeness**: Each record should have values for all required analysis fields

### 2.5 Performance Constraints
1. **File Size**: CSV file should be within reasonable size limits for Spark processing
2. **Memory Usage**: Dataset should fit within available Spark cluster memory for processing
3. **Processing Time**: Aggregation operations should complete within acceptable time limits

## 3. Business Rules

### 3.1 Sales Analysis Rules
1. **Total Sales by Category**: Sales amounts must be summed by category grouping for category performance analysis
2. **Sales Aggregation**: Only valid, non-null sales values should be included in total calculations
3. **Category Grouping**: All records with the same category value should be grouped together for analysis
4. **Sales Reporting**: Total sales results should be displayed in descending order by sales amount

### 3.2 Profit Analysis Rules
1. **Average Profit by Region**: Profit values must be averaged by region grouping for regional performance analysis
2. **Profit Calculation**: Both positive and negative profit values should be included in average calculations
3. **Regional Grouping**: All records with the same region value should be grouped together for analysis
4. **Profit Reporting**: Average profit results should show regional performance comparisons

### 3.3 Shipping Analysis Rules
1. **Order Count by Ship Mode**: Records must be counted by ship mode grouping for logistics analysis
2. **Count Aggregation**: All records with valid ship mode values should be included in count calculations
3. **Ship Mode Grouping**: All records with the same ship mode value should be grouped together for analysis
4. **Shipping Reporting**: Order count results should show distribution across shipping methods

### 3.4 Data Processing Rules
1. **Schema Display**: Dataset schema must be displayed before processing for validation
2. **Sample Data Display**: First 5 records must be shown for data quality verification
3. **Result Display**: All aggregation results must be displayed with appropriate column aliases
4. **Session Management**: Spark session must be properly initialized and stopped after processing

### 3.5 Error Handling Rules
1. **File Access**: System should handle file not found errors gracefully
2. **Schema Validation**: System should validate that required columns exist before processing
3. **Data Type Validation**: System should handle data type conversion errors appropriately
4. **Null Value Handling**: System should handle null values in aggregation operations properly

### 3.6 Performance Optimization Rules
1. **Lazy Evaluation**: Spark transformations should use lazy evaluation for optimal performance
2. **Caching Strategy**: Frequently accessed DataFrames should be cached when appropriate
3. **Partitioning**: Data should be properly partitioned for optimal aggregation performance
4. **Resource Management**: Spark resources should be efficiently utilized and properly released

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.05