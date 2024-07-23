from pyspark.sql.functions import udf
from pyspark.sql.types import StringType

# Define a custom UDF
def uppercase_name(name):
    return name.upper() if name else None

uppercase_name_udf = udf(uppercase_name, StringType())

# Apply the UDF in a custom transformation
def transform_customer_names(dynamic_frame):
    df = dynamic_frame.toDF()
    transformed_df = df.withColumn("customer_name", uppercase_name_udf(col("customer_name")))
    return DynamicFrame.fromDF(transformed_df, glueContext, "transformed_customer_names")

transformed_customer_dyf = transform_customer_names(customer_dyf)
