import sys
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.job import Job

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

# Perform the join
joined_dyf = Join.apply(customer_dyf, orders_dyf, 'customer_id', 'customer_id')

# Write the result to a target, e.g., S3
glueContext.write_dynamic_frame.from_options(
    frame=joined_dyf,
    connection_type="s3",
    connection_options={"path": "s3://your-bucket/your-prefix/"},
    format="parquet"
)

job.commit()
