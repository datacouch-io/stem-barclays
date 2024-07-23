import sys
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.job import Job
from pyspark.sql.functions import col

# Initialize Glue Context and Spark Context
args = getResolvedOptions(sys.argv, ['JOB_NAME'])
sc = SparkContext()
glueContext = GlueContext(sc)
spark = glueContext.spark_session
job = Job(glueContext)
job.init(args['JOB_NAME'], args)

# Load the data into DynamicFrames
customer_dyf = glueContext.create_dynamic_frame.from_catalog(database="your_database", table_name="customer")
orders_dyf = glueContext.create_dynamic_frame.from_catalog(database="your_database", table_name="orders")

# Apply mapping (if necessary)
mapped_customer_dyf = ApplyMapping.apply(
    frame=customer_dyf, 
    mappings=[("customer_id", "string", "customer_id", "string"), 
              ("customer_name", "string", "customer_name", "string")]
)

# Select specific fields
selected_orders_dyf = orders_dyf.select_fields(["order_id", "customer_id", "order_date", "order_amount"])

# Join the DynamicFrames
joined_dyf = Join.apply(mapped_customer_dyf, selected_orders_dyf, 'customer_id', 'customer_id')

# Filter the joined DynamicFrame (example: filter orders above a certain amount)
filtered_dyf = Filter.apply(frame=joined_dyf, f=lambda x: x["order_amount"] > 100)

# Resolve choice (example: handle ambiguous data types)
resolved_dyf = ResolveChoice.apply(frame=filtered_dyf, choice="make_struct")

# Convert to Spark DataFrame for additional Spark transformations (if needed)
spark_df = resolved_dyf.toDF()

# Example Spark transformation: adding a new column
spark_df = spark_df.withColumn("order_year", col("order_date").substr(0, 4))

# Convert back to DynamicFrame
final_dyf = DynamicFrame.fromDF(spark_df, glueContext, "final_dyf")

# Write the result to a target, e.g., S3
glueContext.write_dynamic_frame.from_options(
    frame=final_dyf,
    connection_type="s3",
    connection_options={"path": "s3://your-bucket/your-prefix/"},
    format="parquet"
)

job.commit()
