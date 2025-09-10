import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SuperstoreAnalysis {
  def main(args: Array[String]): Unit = {
    // Initialize Spark Session
    val spark = SparkSession.builder
      .appName("SuperstoreAnalysis")
      .getOrCreate()

    // Path to dataset (update path if needed)
    val file_path = "superstore.csv"

    // Read CSV file
    val df = spark.read.option("header", "true").option("inferSchema", "true").csv(file_path)

    // Show schema
    println("Dataset Schema:")
    df.printSchema()

    // Show first few records
    println("Sample Data:")
    df.show(5)

    // Example 1: Total Sales by Category
    val sales_by_category = df.groupBy("Category").agg(sum("Sales").alias("Total_Sales"))
    println("Total Sales by Category:")
    sales_by_category.show()

    // Example 2: Average Profit by Region
    val avg_profit_region = df.groupBy("Region").agg(avg("Profit").alias("Avg_Profit"))
    println("Average Profit by Region:")
    avg_profit_region.show()

    // Example 3: Count of Orders by Ship Mode
    val order_count_shipmode = df.groupBy("Ship Mode").agg(count("*").alias("Order_Count"))
    println("Order Count by Ship Mode:")
    order_count_shipmode.show()

    // Stop Spark
    spark.stop()
  }
}