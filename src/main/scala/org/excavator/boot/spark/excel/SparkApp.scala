package org.excavator.boot.spark.excel

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}

trait SparkApp {

  val spark = SparkSession.builder().master("local[*]").appName("SparkApp").getOrCreate()

  val peopleSchema = StructType(Array(
    StructField("only_numbers", StringType, nullable = false),
    StructField("numbers_and_text", DoubleType, nullable = false),
    StructField("date_formula", StringType, nullable = false),

  ))

}
