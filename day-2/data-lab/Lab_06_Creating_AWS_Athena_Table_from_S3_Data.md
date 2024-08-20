# Creating AWS Athena Table from S3 Data

This lab will guide you through the steps to create a table in AWS Athena from data stored in an S3 bucket. AWS Athena is an interactive query service that makes it easy to analyze data directly in Amazon S3 using standard SQL. By the end of this lab, you will have a functioning Athena table that you can query to gain insights from your data.

## Why Use AWS Athena?

AWS Athena is a powerful tool for querying data stored in S3 without needing to set up or manage any servers. It is especially useful for:

-   **Cost-Effective Analysis:**  Athena charges only for the queries you run, allowing you to analyze data at a low cost.
-   **Serverless Architecture:**  No infrastructure to manage—just point to your data in S3 and start querying.
-   **Ease of Use:**  Standard SQL queries make it simple for users with SQL knowledge to get started quickly.
-   **Integration with AWS Services:**  Seamlessly integrates with AWS services like S3, Glue, and QuickSight for a full data processing and analysis pipeline.

Using Athena allows you to quickly and easily gain insights from your data stored in S3, making it an ideal tool for data exploration and analysis.

## Let’s get started

### Step 1: Log in to AWS Console

1. Open your web browser and navigate to the [https://us-west-2.console.aws.amazon.com/athena/home?region=us-west-2#/query-editor/history/165880e0-2c30-4392-b1a1-656be5a60d74](https://us-west-2.console.aws.amazon.com/athena/home?region=us-west-2#/query-editor/history/165880e0-2c30-4392-b1a1-656be5a60d74)

2. Log in with your AWS account credentials.

### Step 2: Navigate to Athena Query Editor

1. In the AWS Management Console, navigate to the Athena service by typing **Athena** in the search bar and selecting it from the results.

2. This will open the Athena Query Editor interface.

### Step 3: Start Table Creation

1. In the Athena Query Editor, click the **Create** button.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXey7i6T9NVU2JgSiOuI_jzFXm4kDnUiYQR2QNbAnmAAbHUjAwuXUp7i_a-bBYM4bvBEs64rYJN7oA0eoa3rlV61fgUUpQJIeOSxeWFBJ_oW9m31HtBMjXc7Irn1Jg0AmB1x5dfAi_Dz4cpGBmg3CPOD5oM?key=-3v0b-E9lTHBStVtLamqAg)

2. Select **S3 bucket data** as the source for your table.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdfIpiM8zbwDOOWJ5erfr9rNtQ3dyCUW2TOlu2s2_1dU6Ev677TdOoyErvB1B1oI32zHdTx8dR25Llz-UZaQn-pp4LsV3V_AJhwM4tTfEjhTkhSm7mPXyvZ27eheQUT8GttwA97SX08yVsTLnQ0CPxQs1Zu?key=-3v0b-E9lTHBStVtLamqAg)

### Step 4: Define Table Name

1. Click the Table name field.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdd8PSCClo6iPfNm_Im0WaWY_poiOSEXS7Tlnrq2jXA_OVK59TPI5PKxKbheA7JwrIePx9fZWZGgmvRdMC00XDKFC8Sn4amdF2AWY3syKi54to0oDvfRgbq4KD-b6Oc3ix4Xm44-Pc8bZYN-Do67hYMLG6E?key=-3v0b-E9lTHBStVtLamqAg)

2. Type `tbl_js_Customers_Order` as the table name.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeBNz7oFrxtQa06q1yOgXl7jZjMJwIJxulBuEuFypYWgR7cTzxqSSyKKEdZkG2e74MENMagF5LZMpfbuL0oo6hFs6kwsXDxEtRMX3IIWsEv0H9DvQukDh-p1M5n4dYjGfdKr7ps7ZlVVMa1nZyx4H0LHlFz?key=-3v0b-E9lTHBStVtLamqAg)

3. Click the **Description - optional** field if you wish to add a description.

### Step 5: Specify S3 Bucket Location

1. Click **Browse S3** to select the S3 bucket containing your data.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeZlPR6kKbfrXKkjYXysXRCSxaVKbOOyhuzUePdOPNLZGShDm5Ca_M8isMXZSgApcPUnb0Nhm894lPTBj08a_zptWyfXaBwIy8d2cTeHoWsuJEFn0x-KN6lkdHgVTY5O1N3Mqpm-OLg3CwwwQLWrAexRiCX?key=-3v0b-E9lTHBStVtLamqAg)

2. Navigate to and select the S3 bucket (e.g., `dcawstraining-01`).

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdbrotP5M_MnHMSYmfLUMlYnbljUxlueAQckFN5gIYVFv49P88NI96XPDKVYZUkZTYWxBoHMGhkgoHoQT6kwyPknc3KUBz6Ux5k3AlL3Yx897P2L-xFR4y-xYCVlnpuFoyHucVlhHGcgKaJmjwcLTh4fOup?key=-3v0b-E9lTHBStVtLamqAg)

3. Choose the appropriate folder within the bucket (e.g., `Input_Data`).

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfslnABcAb48oDvxshl1O0sfFrsShdiDWE305TPRfOBJJhCw4Z6sVsy4SwaphUpFxg5tR-_eV6sA8MWD1b9lIvylgGvVuaXPtgNUIhZ3Ay_0hsSO-ftQKytQbl78CA7SAM2jOUkpBFB8Z7lvCTXKVGB3uc?key=-3v0b-E9lTHBStVtLamqAg)



### Step 6: Select File Format

1. Choose the file format of your data. For example, select **JSON** if your data is in JSON format

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfHlXFk5vpLHkPZ1L_1skWu5jPdyuA4510MqP4Yfqxch0d8SmfqHxYqiVSU1_LMHRzyDtWOf4adyOuVH2vKnpJSWhNyBBhhaXq3JXly4JLbZh8nNkndt4RyoDyvvNs3Fa7qNwF3SJPdMbka_3sjTjD3BjCq?key=-3v0b-E9lTHBStVtLamqAg).

2. If your data is in a different format like Parquet, select **Apache Parquet**.



### Step 7: Define Columns and Data Types

1. Switch to the **Table Detail - AWS Glue Console** tab to copy column names and data types.

2. Double-click the first column name (e.g., `order_id`) and press `Ctrl + C` to copy it.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfvJu3UBrfhtJlhQxJQXpsqCJjQ1oTqU-eiu7eULiCyt62Vj1Wc8Ld53CliCVrcYLKvoNeSAPt622HPZwo9mdIF10imamCvuyQOhgQn9grQhQqRXs9ydesxMJY7uneVGmRd9Yymq8UD1asqbWzYRy_29C8?key=-3v0b-E9lTHBStVtLamqAg)

3. Switch back to the Athena Query Editor.

4. Click the **Column name** field and press `Ctrl + V` to paste the column name.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfseoSWetiW7pGq3famEqweW1rJfF5lq4TaGlpar0M0gd8M0iVDjPDQW_sRy5-7EuyouLUkr4SEIfjPTEuOSK538RDXDjV3fOGO8eTunlpkYiRFhm5bSjbtCDhI6xKVlqEVu7GkUKJQk-2sOotSv03dRsQT?key=-3v0b-E9lTHBStVtLamqAg)

5. Select the appropriate data type for the column (e.g., `int` for integer).

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcBO8Fe-1aSy9nGzyJww9yTpx1k7foAn9Wx2PknvbaFdSpU-Ijfs4EdUgxyF0yyvUQQCdD4s3gz2bWYuejF37GoRSTWh3oDbHI4bYqu1pJpGq9hL42s2LGR9KahbTkrtNuNAW5DOCf3GO4sNklhK-CwEY0D?key=-3v0b-E9lTHBStVtLamqAg)

6. Repeat steps 1-5 for each column in your data:

- **customer_id**: `string`

- **total_amount**: `string`

- **order_date**: `string`

- **address**: `array<string>`

### Step 8: Complete Table Creation

1. Once all columns are defined, click the **Create table** button at the bottom of the page.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf86GOyMuveSroTP5iEJuY4CMbSY7jv9rKOCaNESV1_Yoe0P3o8XsKko60Uo3lUiOAhWG40nOmFEeGQdAhdyCgxNXzob3_JmJmsPxsR3XZiNsPcVHbJdybTNGLOOG4chBFLN-yRVyDGEmQxuCUi75m8ucM?key=-3v0b-E9lTHBStVtLamqAg)

### Step 9: Verify Table Creation

1. After the table is created, you will be returned to the Athena Query Editor.

2. Click **Preview Table** to see a sample of the data from the table.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcuGWfqRTY48laJjHllCTkAfWfGeWmO2XSVhyIx1wJVV6k1XIn4kPdikufvYxGCCPzaa3RObiyGzVMfqW-QXzi6AifIOruN5J3eU6uGP1DfUnB72o2OKmYVHvoLSsi-wZAp4SFpjTXsDolVoDwr1LE9muyF?key=-3v0b-E9lTHBStVtLamqAg)




Voila!! We have successfully completed this exercise.
