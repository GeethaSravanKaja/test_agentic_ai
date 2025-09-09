from pyspark.sql import SparkSession
from pyspark.sql.functions import col, sum as _sum, avg, count

def main():
    # Initialize Spark Session
    spark = SparkSession.builder \
        .appName("SuperstoreAnalysis") \
        .getOrCreate()

    # Path to dataset (update path if needed)
    file_path = "superstore.csv"

    # Read CSV file
    df = spark.read.csv(file_path, header=True, inferSchema=True)

    # Show schema
    print("Dataset Schema:")
    df.printSchema()

    # Show first few records
    print("Sample Data:")
    df.show(5)

    # Example 1: Total Sales by Category
    sales_by_category = df.groupBy("Category").agg(_sum("Sales").alias("Total_Sales"))
    print("Total Sales by Category:")
    sales_by_category.show()

    # Example 2: Average Profit by Region
    avg_profit_region = df.groupBy("Region").agg(avg("Profit").alias("Avg_Profit"))
    print("Average Profit by Region:")
    avg_profit_region.show()

    # Example 3: Count of Orders by Ship Mode
    order_count_shipmode = df.groupBy("Ship Mode").agg(count("*").alias("Order_Count"))
    print("Order Count by Ship Mode:")
    order_count_shipmode.show()

    # Stop Spark
    spark.stop()

if __name__ == "__main__":
    main()
