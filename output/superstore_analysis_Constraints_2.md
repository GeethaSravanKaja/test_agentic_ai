____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Enhanced Model Data Constraints for Superstore Analysis PySpark application with comprehensive business rules
## *Version*: 2
## *Changes*: Enhanced data expectations with additional validation rules, expanded constraints for data quality, and comprehensive business rules for advanced analytics
## *Reason*: User requested updates to improve data constraints with more detailed validation patterns and enhanced business rule definitions
## *Updated on*: 
_____________________________________________

# Enhanced Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
1. **CSV File Availability**: The superstore.csv file must be accessible and readable at the specified file path with proper file permissions
2. **Header Row Presence**: The CSV file must contain a header row with standardized column names for proper schema inference and mapping
3. **Required Columns**: The dataset must contain the following mandatory columns with proper naming conventions:
   - Category (for sales analysis by category)
   - Sales (for total sales calculations and revenue analysis)
   - Region (for regional profit analysis and geographic performance)
   - Profit (for average profit calculations and profitability analysis)
   - Ship Mode (for order count analysis and logistics optimization)
   - Customer Name (for customer analysis and segmentation)
   - Order Date (for temporal analysis and trend identification)
   - Product Name (for product performance analysis)
4. **Non-null Values**: Critical fields (Category, Sales, Region, Ship Mode, Customer Name) should not contain null values for accurate aggregations and analysis
5. **Data Coverage**: Dataset should cover sufficient time periods and geographic regions for meaningful analysis

### 1.2 Data Accuracy
1. **Numeric Data Types**: Sales and Profit columns must contain valid numeric values with appropriate precision for mathematical operations
2. **Category Values**: Category field should contain consistent categorical values from predefined taxonomy (Furniture, Office Supplies, Technology)
3. **Region Values**: Region field should contain standardized region names from approved geographic classification
4. **Ship Mode Values**: Ship Mode field should contain valid shipping method names from approved logistics options
5. **Date Validation**: Order Date and Ship Date fields should contain valid date formats and logical date sequences
6. **Customer Data Integrity**: Customer Name should be consistent across multiple orders for proper customer analysis

### 1.3 Data Format
1. **CSV Format**: Input data must be in CSV format with proper delimiter separation and escape character handling
2. **Schema Inference**: Data types should be automatically inferable by Spark's inferSchema option with validation
3. **Encoding**: File should be in UTF-8 encoding for proper character handling and international support
4. **Date Format**: Date fields should follow ISO 8601 format (YYYY-MM-DD) or consistent alternative format
5. **Numeric Format**: Numeric fields should use consistent decimal notation and currency formatting

### 1.4 Data Consistency
1. **Categorical Consistency**: Category, Region, and Ship Mode values should be consistent across all records with standardized naming
2. **Numeric Precision**: Sales and Profit values should maintain appropriate decimal precision (2 decimal places for currency)
3. **Data Relationships**: Each record should represent a valid business transaction with logical field relationships
4. **Temporal Consistency**: Order dates should be chronologically consistent and within business operational periods
5. **Geographic Consistency**: Region and customer location data should be geographically consistent

### 1.5 Data Quality Metrics
1. **Completeness Rate**: Minimum 95% completeness for critical fields
2. **Accuracy Rate**: Maximum 5% error rate for data validation checks
3. **Consistency Rate**: Minimum 98% consistency for categorical values
4. **Timeliness**: Data should be current within acceptable business timeframes

## 2. Constraints

### 2.1 Mandatory Fields
1. **Category**: Required for sales analysis by category - cannot be null, empty, or contain invalid values
2. **Sales**: Required for total sales calculations - must be numeric, non-null, and non-negative
3. **Region**: Required for regional analysis - cannot be null, empty, or contain unrecognized region codes
4. **Profit**: Required for profit calculations - must be numeric (can be negative for loss scenarios)
5. **Ship Mode**: Required for shipping analysis - cannot be null, empty, or contain invalid shipping methods
6. **Customer Name**: Required for customer analysis - cannot be null or empty
7. **Order Date**: Required for temporal analysis - must be valid date format

### 2.2 Data Type Limitations
1. **Sales Column**: Must be numeric (Decimal with 2 decimal places) for sum aggregation and financial calculations
2. **Profit Column**: Must be numeric (Decimal with 2 decimal places) for average calculation and profitability analysis
3. **Category Column**: Must be string/text type with maximum length of 50 characters for grouping operations
4. **Region Column**: Must be string/text type with maximum length of 20 characters for grouping operations
5. **Ship Mode Column**: Must be string/text type with maximum length of 30 characters for grouping operations
6. **Customer Name Column**: Must be string/text type with maximum length of 100 characters
7. **Date Columns**: Must be date/timestamp type for temporal operations

### 2.3 Value Range Constraints
1. **Sales Values**: Should be non-negative values representing monetary amounts (0 to 999,999.99)
2. **Profit Values**: Can be positive or negative representing profit or loss (-99,999.99 to 99,999.99)
3. **Category Values**: Should be from predefined set: {"Furniture", "Office Supplies", "Technology"}
4. **Region Values**: Should be from predefined set: {"East", "West", "Central", "South"}
5. **Ship Mode Values**: Should be from predefined set: {"Standard Class", "Second Class", "First Class", "Same Day"}
6. **Quantity Values**: Should be positive integers (1 to 999)
7. **Discount Values**: Should be between 0 and 1 (0% to 100%)

### 2.4 Referential Integrity
1. **Category Consistency**: All category values should be consistent across the dataset and match master category list
2. **Region Consistency**: All region values should be consistent across the dataset and match geographic master data
3. **Ship Mode Consistency**: All ship mode values should be consistent across the dataset and match logistics options
4. **Customer Consistency**: Customer names should be consistent across multiple orders for proper customer tracking
5. **Product Consistency**: Product names should be consistent and match product master data

### 2.5 Performance Constraints
1. **File Size**: CSV file should be within reasonable size limits (max 10GB) for Spark processing
2. **Memory Usage**: Dataset should fit within available Spark cluster memory for processing (consider partitioning for large datasets)
3. **Processing Time**: Aggregation operations should complete within acceptable time limits (max 30 minutes for large datasets)
4. **Concurrent Access**: System should handle multiple concurrent read operations efficiently

### 2.6 Security Constraints
1. **Data Access**: Only authorized users should have access to sensitive customer and financial data
2. **Data Masking**: Customer names and sensitive information should be masked in non-production environments
3. **Audit Trail**: All data access and modifications should be logged for compliance

## 3. Business Rules

### 3.1 Sales Analysis Rules
1. **Total Sales by Category**: Sales amounts must be summed by category grouping for category performance analysis with trend comparison
2. **Sales Aggregation**: Only valid, non-null sales values should be included in total calculations with data quality validation
3. **Category Grouping**: All records with the same category value should be grouped together for analysis with case-insensitive matching
4. **Sales Reporting**: Total sales results should be displayed in descending order by sales amount with percentage contribution
5. **Sales Validation**: Sales totals should be cross-validated against expected business ranges
6. **Currency Handling**: All sales amounts should be in consistent currency units (USD)

### 3.2 Profit Analysis Rules
1. **Average Profit by Region**: Profit values must be averaged by region grouping for regional performance analysis with statistical significance
2. **Profit Calculation**: Both positive and negative profit values should be included in average calculations with outlier detection
3. **Regional Grouping**: All records with the same region value should be grouped together for analysis with geographic validation
4. **Profit Reporting**: Average profit results should show regional performance comparisons with variance analysis
5. **Profitability Metrics**: Calculate profit margins, profit ratios, and profitability trends
6. **Loss Analysis**: Identify and analyze loss-making transactions for business insights

### 3.3 Shipping Analysis Rules
1. **Order Count by Ship Mode**: Records must be counted by ship mode grouping for logistics analysis with efficiency metrics
2. **Count Aggregation**: All records with valid ship mode values should be included in count calculations with validation
3. **Ship Mode Grouping**: All records with the same ship mode value should be grouped together for analysis with cost analysis
4. **Shipping Reporting**: Order count results should show distribution across shipping methods with performance metrics
5. **Logistics Optimization**: Analyze shipping patterns for cost and time optimization opportunities
6. **Delivery Performance**: Track and analyze delivery performance by shipping mode

### 3.4 Data Processing Rules
1. **Schema Display**: Dataset schema must be displayed before processing for validation and documentation
2. **Sample Data Display**: First 5 records must be shown for data quality verification and format validation
3. **Result Display**: All aggregation results must be displayed with appropriate column aliases and formatting
4. **Session Management**: Spark session must be properly initialized with optimal configuration and stopped after processing
5. **Error Logging**: All processing errors should be logged with detailed error messages and timestamps
6. **Performance Monitoring**: Track and log processing performance metrics for optimization

### 3.5 Error Handling Rules
1. **File Access**: System should handle file not found errors gracefully with informative error messages
2. **Schema Validation**: System should validate that required columns exist before processing with detailed validation reports
3. **Data Type Validation**: System should handle data type conversion errors appropriately with data cleansing options
4. **Null Value Handling**: System should handle null values in aggregation operations properly with configurable null handling strategies
5. **Exception Management**: Implement comprehensive exception handling with recovery mechanisms
6. **Data Quality Alerts**: Generate alerts for data quality issues that exceed acceptable thresholds

### 3.6 Performance Optimization Rules
1. **Lazy Evaluation**: Spark transformations should use lazy evaluation for optimal performance with query optimization
2. **Caching Strategy**: Frequently accessed DataFrames should be cached when appropriate with memory management
3. **Partitioning**: Data should be properly partitioned for optimal aggregation performance based on query patterns
4. **Resource Management**: Spark resources should be efficiently utilized and properly released with monitoring
5. **Query Optimization**: Use Spark SQL optimization techniques for complex aggregations
6. **Memory Management**: Implement efficient memory usage patterns to prevent out-of-memory errors

### 3.7 Advanced Analytics Rules
1. **Trend Analysis**: Implement time-series analysis for sales and profit trends with seasonal adjustments
2. **Customer Segmentation**: Analyze customer behavior patterns for segmentation and targeting
3. **Product Performance**: Evaluate product performance across categories and regions
4. **Predictive Analytics**: Implement forecasting models for sales and demand prediction
5. **Comparative Analysis**: Enable year-over-year and period-over-period comparisons
6. **Statistical Analysis**: Implement statistical measures (median, standard deviation, percentiles) for comprehensive analysis

### 3.8 Compliance and Governance Rules
1. **Data Retention**: Implement data retention policies according to business and regulatory requirements
2. **Data Privacy**: Ensure compliance with data privacy regulations (GDPR, CCPA) for customer data
3. **Audit Requirements**: Maintain audit trails for all data processing activities
4. **Data Lineage**: Track data lineage from source to final reports for transparency
5. **Quality Assurance**: Implement data quality checks and validation processes
6. **Documentation**: Maintain comprehensive documentation for all business rules and processes

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.08