
    val inputJsonDf = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", BROKERS)
      .option("subscribe", INPUT_TOPIC_JSON)
      .option("startingOffsets", "earliest") // going to replay from the beginning each time
      .load()
      .selectExpr("CAST(value AS STRING)")
      .select(from_json($"value", structCricket).as("cricket"))