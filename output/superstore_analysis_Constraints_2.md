____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Enhanced data constraints for comprehensive superstore analysis reporting requirements
## *Version*: 2
## *Changes*: Enhanced constraints to include Customer and Time entities, expanded attribute constraints, added advanced business rules for comprehensive analytics
## *Reason*: To provide more comprehensive data constraints covering customer analytics, temporal analysis, and enhanced business intelligence capabilities
## *Updated on*: 
_____________________________________________

# Enhanced Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness
- **Product Entity Fields**:
  - Category field: Must be present in 100% of records for product classification analysis
  - Sub Category field: Must be present in 100% of records for granular product analysis
  - Product Name field: Must be present in 100% of records for specific product identification
  - Manufacturer field: Must be present in 90% of records (some legacy data may lack this)

- **Order Entity Fields**:
  - Sales field: Must be present in 100% of records and cannot be null for revenue calculations
  - Profit field: Must be present in 100% of records for profitability analysis
  - Quantity field: Must be present in 100% of records for volume analysis
  - Discount field: Must be present in 100% of records (0 if no discount applied)
  - Unit Price field: Must be present in 100% of records for pricing analysis

- **Region Entity Fields**:
  - Region field: Must be present in 100% of records for geographical analysis
  - State field: Must be present in 100% of records for detailed location analysis
  - City field: Must be present in 100% of records for local market analysis
  - Postal Code field: Must be present in 95% of records (some international orders may lack this)

- **Customer Entity Fields**:
  - Customer Name field: Must be present in 100% of records for customer identification
  - Customer Segment field: Must be present in 100% of records for segmentation analysis
  - Customer Type field: Must be present in 90% of records for behavior analysis

- **Time Entity Fields**:
  - Order Date field: Must be present in 100% of records for temporal analysis
  - Ship Date field: Must be present in 100% of records for logistics tracking
  - Year, Quarter, Month fields: Must be derived from Order Date with 100% completeness

- **Shipping Entity Fields**:
  - Ship Mode field: Must be present in 100% of records for shipping analysis
  - Ship Cost field: Must be present in 95% of records (some may be bundled in sales price)

### 1.2 Data Accuracy
- **Financial Values**: Sales, Profit, Unit Price, Ship Cost must be numeric and within reasonable business ranges
- **Quantity Values**: Must be positive integers greater than 0
- **Discount Values**: Must be between 0 and 1 (percentage format) or 0 and sales amount (absolute format)
- **Date Values**: Order Date must be <= Ship Date, both must be valid dates
- **Categorical Values**: All categorical fields must match predefined business taxonomies

### 1.3 Data Format
- **Currency Fields**: Sales, Profit, Unit Price, Ship Cost - Decimal format with up to 2 decimal places
- **Percentage Fields**: Discount - Decimal format between 0.00 and 1.00 for percentage representation
- **Integer Fields**: Quantity - Positive integer format
- **Date Fields**: Order Date, Ship Date - Standard date format (YYYY-MM-DD)
- **Text Fields**: All categorical fields - Standardized naming conventions with proper capitalization

### 1.4 Data Consistency
- **Cross-Entity Consistency**: Customer information must be consistent across all orders
- **Temporal Consistency**: Time-based aggregations must align across Year, Quarter, Month dimensions
- **Financial Consistency**: Profit calculations must align with Sales, Cost, and Discount relationships
- **Geographic Consistency**: Region, State, City relationships must be geographically accurate

## 2. Constraints

### 2.1 Mandatory Fields
- **Core Business Fields**: Category, Region, Ship Mode, Sales, Profit, Customer Name, Order Date
- **Analysis Fields**: Sub Category, State, City, Customer Segment, Ship Date, Quantity
- **Optional Fields**: Manufacturer, Postal Code, Customer Type, Ship Cost (with business justification for nulls)

### 2.2 Data Type Limitations
- **Numeric Fields**: Sales, Profit, Unit Price, Ship Cost, Discount - Decimal/Float data type
- **Integer Fields**: Quantity - Integer data type
- **Date Fields**: Order Date, Ship Date - Date/DateTime data type
- **Text Fields**: All categorical fields - String/Text data type with length limitations

### 2.3 Value Range Constraints
- **Sales**: Must be > 0 (cannot have zero or negative sales)
- **Profit**: Can be negative but must be within reasonable range (-10000 to +10000)
- **Quantity**: Must be >= 1 (minimum one unit per order)
- **Discount**: Must be >= 0 and <= Sales amount
- **Unit Price**: Must be > 0
- **Ship Cost**: Must be >= 0

### 2.4 Referential Integrity
- **Product Hierarchy**: Sub Category must be valid within its parent Category
- **Geographic Hierarchy**: City must be valid within its State, State within Region
- **Customer Consistency**: Customer Name must consistently map to same Customer Segment
- **Temporal Integrity**: Year, Quarter, Month must correctly derive from Order Date

### 2.5 Dependencies
- **Financial Relationships**: Profit = (Unit Price * Quantity * (1 - Discount)) - Cost - Ship Cost
- **Temporal Relationships**: Ship Date >= Order Date
- **Geographic Relationships**: Postal Code must align with City and State
- **Customer Relationships**: Customer Type must align with Customer Segment business rules

### 2.6 Uniqueness Constraints
- **Order Identification**: Each order must have unique identifier or combination of fields
- **Customer Identification**: Customer Name should uniquely identify customers (or use Customer ID)
- **Product Identification**: Product Name should be unique within Sub Category

## 3. Business Rules

### 3.1 Operational Rules
- **Sales Aggregation**: Total Sales by Category must equal sum of all individual sales records within that category
- **Profit Calculation**: Average Profit by Region must be calculated as arithmetic mean of all profit values within that region
- **Order Counting**: Order Count by Ship Mode must represent unique count of orders for each shipping method
- **Customer Analytics**: Customer Lifetime Value must be calculated as sum of all Sales for each customer
- **Temporal Analysis**: Sales Growth Rate must be calculated period-over-period using consistent time periods

### 3.2 Reporting Logic
- **Multi-dimensional Analysis**: Support analysis across Product, Customer, Geographic, and Time dimensions
- **KPI Calculations**: Support calculation of all 12 defined KPIs with proper aggregation logic
- **Drill-down Capability**: Enable drill-down from Category to Sub Category to Product Name
- **Time-series Analysis**: Support trending analysis across Year, Quarter, Month dimensions

### 3.3 Transformation Guidelines
- **Aggregation Functions**: Use SUM for Sales/Profit totals, AVG for averages, COUNT for quantities, MIN/MAX for ranges
- **Grouping Logic**: Support multi-level grouping across all dimensional entities
- **Calculated Fields**: Derive Profit Margin, Average Order Value, and other calculated metrics
- **Time Calculations**: Properly handle fiscal vs calendar year calculations

### 3.4 Data Quality Rules
- **Outlier Detection**: Implement statistical outlier detection for Sales, Profit, and Quantity values
- **Consistency Validation**: Cross-validate Customer, Product, and Geographic master data
- **Completeness Monitoring**: Track and report data completeness percentages by entity
- **Accuracy Verification**: Implement business rule validation for financial calculations

### 3.5 Performance Rules
- **Indexing Strategy**: Index all dimensional fields (Category, Region, Customer Segment, Ship Mode, dates)
- **Partitioning Strategy**: Partition by Order Date for temporal queries, by Region for geographic analysis
- **Caching Strategy**: Cache frequently accessed aggregations and KPI calculations
- **Query Optimization**: Optimize for common analytical query patterns

### 3.6 Advanced Analytics Rules
- **Customer Segmentation**: Support RFM analysis (Recency, Frequency, Monetary) calculations
- **Seasonal Analysis**: Enable seasonal pattern detection and forecasting
- **Profitability Analysis**: Support product and customer profitability ranking
- **Market Analysis**: Enable market share and competitive analysis by region and product

### 3.7 Compliance Rules
- **Data Privacy**: Ensure customer data handling complies with privacy regulations
- **Financial Reporting**: Ensure financial calculations comply with accounting standards
- **Audit Trail**: Maintain audit trail for all data transformations and calculations
- **Data Retention**: Implement appropriate data retention policies for different data types

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.04