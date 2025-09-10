____________________________________________
## *Author*: AAVA
## *Created on*: 
## *Description*: Model Data Constraints for Superstore retail analytics reporting system
## *Version*: 1 
## *Updated on*: 
_____________________________________________

# Model Data Constraints for Superstore Analysis

## 1. Data Expectations

### 1.1 Data Completeness Expectations
1. **Sales Amount** - Must be present for all order records; no null values allowed as it's essential for sales analysis
2. **Profit Amount** - Must be present for all order records to enable profitability calculations
3. **Category** - Must be populated for all product records to support category-based analysis
4. **Region** - Must be present for all customer records to enable regional performance analysis
5. **Ship Mode** - Must be specified for all orders to support shipping analysis
6. **Order Date** - Must be present for all orders to enable temporal analysis
7. **Ship Date** - Must be present and should be equal to or after Order Date

### 1.2 Data Accuracy Expectations
1. **Sales Amount** - Must be positive numeric values; negative sales not permitted
2. **Profit Amount** - Can be positive or negative numeric values to reflect actual business outcomes
3. **Order Date and Ship Date** - Must follow valid date format (YYYY-MM-DD) and be within reasonable business date ranges
4. **Category Names** - Must match predefined category values (Furniture, Office Supplies, Technology)
5. **Region Names** - Must correspond to valid geographical regions in the business scope
6. **Ship Mode** - Must match predefined shipping methods (Standard Class, Second Class, First Class, Same Day)

### 1.3 Data Format Expectations
1. **Numeric Fields** - Sales, Profit amounts must be in decimal format with appropriate precision (2 decimal places)
2. **Date Fields** - Order Date and Ship Date must be in consistent date format
3. **Text Fields** - Category, Region, Ship Mode must be in consistent case format (Title Case)
4. **Customer Names** - Must follow standard naming conventions without special characters

### 1.4 Data Consistency Expectations
1. **Cross-Entity Consistency** - Customer information must be consistent across all related orders
2. **Temporal Consistency** - Ship Date must be on or after Order Date
3. **Category Hierarchy** - Sub-categories must align with their parent categories
4. **Regional Consistency** - State and City must correspond to the correct Region

## 2. Constraints

### 2.1 Mandatory Field Constraints
1. **Order Entity**
   - Sales Amount: NOT NULL, NUMERIC, > 0
   - Profit Amount: NOT NULL, NUMERIC
   - Order Date: NOT NULL, DATE FORMAT
   - Ship Date: NOT NULL, DATE FORMAT

2. **Product Entity**
   - Category Name: NOT NULL, VARCHAR(50)
   - Sub Category Name: NOT NULL, VARCHAR(100)
   - Product Name: NOT NULL, VARCHAR(200)
   - Product Price: NOT NULL, NUMERIC, > 0

3. **Customer Entity**
   - Customer Name: NOT NULL, VARCHAR(100)
   - Customer Segment: NOT NULL, VARCHAR(50)
   - Region Name: NOT NULL, VARCHAR(50)
   - State Name: NOT NULL, VARCHAR(50)
   - City Name: NOT NULL, VARCHAR(50)

4. **Shipping Entity**
   - Ship Mode: NOT NULL, VARCHAR(50)
   - Ship Cost: NOT NULL, NUMERIC, >= 0
   - Delivery Status: NOT NULL, VARCHAR(50)

### 2.2 Uniqueness Constraints
1. **Order Identification** - Each order must have a unique identifier combination
2. **Product Identification** - Product Name must be unique within the same category
3. **Customer Identification** - Customer Name combined with location should be unique

### 2.3 Data Type Limitations
1. **Numeric Constraints**
   - Sales Amount: DECIMAL(15,2), Range: 0.01 to 999999999.99
   - Profit Amount: DECIMAL(15,2), Range: -999999999.99 to 999999999.99
   - Product Price: DECIMAL(10,2), Range: 0.01 to 99999999.99
   - Ship Cost: DECIMAL(10,2), Range: 0.00 to 99999999.99

2. **Text Constraints**
   - Category Name: Maximum 50 characters
   - Product Name: Maximum 200 characters
   - Customer Name: Maximum 100 characters
   - Region/State/City: Maximum 50 characters each

3. **Date Constraints**
   - Order Date: Must be within business operational date range (2010-01-01 to current date)
   - Ship Date: Must be >= Order Date and <= current date + 30 days

### 2.4 Dependencies and Referential Integrity
1. **Order-Product Dependency** - Every order must reference a valid existing product
2. **Order-Customer Dependency** - Every order must reference a valid existing customer
3. **Order-Shipping Dependency** - Every order must have corresponding shipping information
4. **Geographic Hierarchy** - City must exist within the specified State, State within Region
5. **Category Hierarchy** - Sub-category must belong to the specified main Category

## 3. Business Rules

### 3.1 Operational Rules
1. **Sales Processing Rules**
   - Sales amount must be calculated as (Product Price × Quantity)
   - Profit must be calculated as (Sales Amount - Cost of Goods Sold - Shipping Cost)
   - Discount applications must be reflected in final sales amount

2. **Shipping Rules**
   - Same Day shipping only available for orders placed before 2 PM
   - Ship Date cannot be more than 30 days after Order Date
   - Ship Cost must be calculated based on Ship Mode and delivery location

3. **Customer Segmentation Rules**
   - Consumer: Individual customers making personal purchases
   - Corporate: Business customers with corporate accounts
   - Home Office: Small business/home office customers

### 3.2 Reporting Logic Rules
1. **Sales Analysis Rules**
   - Total Sales by Category: SUM(Sales Amount) GROUP BY Category
   - Regional performance calculated using customer's region, not shipping destination
   - Profit margins calculated as (Profit Amount / Sales Amount) × 100

2. **Temporal Analysis Rules**
   - Sales growth rate calculated using Order Date, not Ship Date
   - Quarterly analysis based on calendar quarters
   - Year-over-year comparisons use same calendar periods

3. **Performance Metrics Rules**
   - Average calculations exclude null values
   - Percentage calculations rounded to 2 decimal places
   - Top-performing categories determined by total sales volume

### 3.3 Transformation Guidelines
1. **Data Aggregation Rules**
   - Group by operations must maintain data integrity
   - Sum operations only on numeric fields
   - Average calculations exclude zero and null values where business-appropriate

2. **Data Quality Rules**
   - Duplicate records must be identified and resolved before analysis
   - Outlier detection for sales amounts exceeding 3 standard deviations
   - Data validation checks must be performed before each analysis run

3. **Compliance Rules**
   - Customer data must comply with privacy regulations
   - Financial data must maintain audit trail
   - Regional data must align with business territory definitions

### 3.4 Data Processing Rules
1. **ETL Processing Rules**
   - Source data validation must occur before transformation
   - Failed records must be logged and quarantined
   - Data lineage must be maintained throughout processing

2. **Analysis Execution Rules**
   - Spark session must be properly initialized before analysis
   - Schema validation must be performed on data load
   - Results must be cached for frequently accessed aggregations

3. **Output Generation Rules**
   - Analysis results must include record counts for verification
   - Null handling must be explicitly defined for each calculation
   - Output format must be consistent across all analysis types

## 4. API Cost Calculation

– Cost for this particular Api Call to LLM model: $0.25