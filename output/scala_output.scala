import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, sum, avg, count}

object SuperstoreAnalysis {
  def main(args: Array[String]): Unit = {
    // Initialize Spark Session
    val spark = SparkSession.builder()
      .appName("SuperstoreAnalysis")
      .getOrCreate()

    // Path to dataset (update path if needed)
    val filePath = "superstore.csv"

    // Read CSV file
    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(filePath)

    // Show schema
    println("Dataset Schema:")
    df.printSchema()

    // Show first few records
    println("Sample Data:")
    df.show(5)

    // Example 1: Total Sales by Category
    val salesByCategory = df.groupBy("Category")
      .agg(sum("Sales").alias("Total_Sales"))
    println("Total Sales by Category:")
    salesByCategory.show()

    // Example 2: Average Profit by Region
    val avgProfitRegion = df.groupBy("Region")
      .agg(avg("Profit").alias("Avg_Profit"))
    println("Average Profit by Region:")
    avgProfitRegion.show()

    // Example 3: Count of Orders by Ship Mode
    val orderCountShipmode = df.groupBy("Ship Mode")
      .agg(count("*").alias("Order_Count"))
    println("Order Count by Ship Mode:")
    orderCountShipmode.show()

    // Stop Spark
    spark.stop()
  }
}