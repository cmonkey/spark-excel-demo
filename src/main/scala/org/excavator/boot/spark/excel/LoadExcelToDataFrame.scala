package org.excavator.boot.spark.excel

object LoadExcelToDataFrame extends SparkApp{

  def main(args: Array[String]): Unit = {
    val df = spark.read
      .format("com.crealytics.spark.excel")
      .option("dataAddress", "Sheet1")
      .option("header", "false")
      .option("treatEmptyValueAsNulls", "false")
      .option("setErrorCellsToFaillbackValues", "true")
      .option("usePlainNumberFormat", "false")
      .option("inferSchema", "false")
      .option("addColorColumns", "true")
      .option("timestampFormat", "MM-DD-yyyy HH:mm:ss")
      .option("maxRowsInMemory", 20)
      .option("excerptSize", 10)
      .option("workbookPassword", "pass")
      .schema(peopleSchema)
      .load("src/main/resources/plain_number.xlsx")
    df.show(20)
  }

}
