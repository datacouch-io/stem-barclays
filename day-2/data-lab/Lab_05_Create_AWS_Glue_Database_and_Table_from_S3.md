# Create AWS Glue Database & Table from S3

In this tutorial, you will learn how to create a database and tables in AWS Glue using JSON data stored in an S3 bucket. AWS Glue is a fully managed ETL (Extract, Transform, Load) service that makes it easy to prepare and load data for analytics. By setting up a database and configuring tables using a crawler, you can automatically detect schemas and manage your data more efficiently, enabling seamless data integration and analysis within the AWS ecosystem.

## Why Use AWS Glue for Data Management?

AWS Glue is a powerful tool for automating data management tasks. It offers several key benefits:

-   **Automated Schema Detection:**  AWS Glue crawlers can automatically infer the schema of your data, saving you the time and effort of manually defining it.
-   **Seamless Integration:**  Glue integrates well with other AWS services like S3, making it easy to organize, transform, and analyze your data across various platforms.
-   **Cost-Effective:**  As a serverless service, Glue only charges for the resources you use, eliminating the need to manage infrastructure.
-   **Scalability:**  AWS Glue can handle data at any scale, from small datasets to large data lakes.

Using AWS Glue simplifies the process of preparing and loading data for analysis, allowing you to focus on extracting insights rather than managing data pipelines.

## Let’s get Started

Access AWS Management Console:

-   Navigate to the [AWS Management Console](https://us-west-2.console.aws.amazon.com/console/home?region=us-west-2) for the US West (Oregon) region using the provided URL


Open AWS Glue Service

-   Click on "AWS Glue" from the service menu to access the AWS Glue console where you can manage databases, crawlers, and jobs


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMtp8OVmkfl0lJ-8UsaEn4-hDfteq6KnfT4xmJheGCypDTBMCWgt-L2vFS5NwnZrRns-PmX91jYko420oYqXNIEQDzUWSd7IwHS8Udy6wCEUGr55xiXSnuxW96okGY9VohAR3omRFbFbTAnvM5VfGbUCje?key=7zJz-pKWlxiC47hfwUyH4Q)



-   Click on "Databases" to view existing databases or to create a new one


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcGvFuntBLQfWS_6_Cjoid8sy0y5koXalV_qU-R7msdLzHLAd7vSPcsd3g99XqJgtE5jcIml-e1zzxZ78X_0S_ObkTmgNgnSnc-kfwDyZnzueKpYs_EZLyZv7aKZ5LVlZoE5lnCUMwFNzw7kb0p5-1b-js?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click "Add database" to initiate the creation of a new database which will store metadata related to your data assets.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc9VbpKBhiETEHgUNGx-kv2QGnCoadprBROBBYxvUQRUixxXRU71nlyOS2-gR0O_ucgq_p0jU20YVFlSOzU1NRTRmaILd4-EEhisdD8TSv1AsgDsVDVlMrTO-ZtucXuSkYXjV6oaW0jJL8H3_Gc-k2KF2Q?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click on the "Name" field twice and enter a unique name for your database, such as "db_aws_training_exercises"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMofjs--jwNoCt9_WDgPcDkSNa54_RIi7UkVjtge5VkRSN2-O2z4f0v9dEi7leaWwS4YHY9Y9khv8ve20DKAjgfMr4OChzmdLpEDHehiqtcfo45QFepjUjwO04GUBUwzXSTk01sBNlbrLdfiU-zmtK27ay?key=7zJz-pKWlxiC47hfwUyH4Q)



-   Click the "Location-optional" field and if necessary, paste (ctrl + v) a predefined S3 path where metadata for this database should be stored.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe_Adpjr7pxIHAiIKpbov-hvMp-yVdaM1kDlJA7l3zcjM2emqKOn1nWfBjumisoqYLlDRnjRy35iAtftGelYHVB3akZhMphVKB8Ft6Km6GPpin6xRZESIg4ivLEqMy-ca9uKheI2DnaZ9tXq2Kx8J5Ji4kV?key=7zJz-pKWlxiC47hfwUyH4Q)




-   Click on the "Description-optional" field and type a brief description, such as "This is the metadata database"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfc9mn3Js_cOcsi8K_CYZg7gVxF_r39dghjhGnE4BHZZz5QAnuLJ2jZJ4FYR3bImvw4AYTNiHs20wrtJzYZgYh_-o8Xyj6r1RiIFSTIMvuNEfXzA2pNknuyRgF0hHJrh-WqkQLYM_KYwmSw-khuwO_beC0P?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click the "Create database" button to finalize the creation of the Glue database.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcHJGKDygvYie9ZUD86tjnzxNAEJHtOedbxRbvwBX1VaO2CbEPPL-2waKR_j0Fcp47xem13Ce7KOqx1RjzVbQP4JBsk_R4F7zCCY9J9GIq3aEcbJzfaRhZsD9qt3dpS3SBC1M6G_AYGb_ryG4NgeyK6MRxZ?key=7zJz-pKWlxiC47hfwUyH4Q)




-   Click on the newly created database "db_aws_training_exercises" to start adding tables.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcVTKme_18INP3Ag9JsW_LhzOON-91g0Ep8xqH2v8QB4bj_iaGelZHR3QnuMYdnA9ZLMJNTLho89-gAB5cGo_p9jKuCx3rDTgGI8PcWDI4TXI_sZ8miDLmgDQzxiPpzXAmyrOWPa4jSKyYtjjk0x-Wk_Dw?key=7zJz-pKWlxiC47hfwUyH4Q)



-   Click "Add tables using crawler" to set up a crawler that will explore your data and automatically propose table structures.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfhz7otmzbfP_ViO4gxmiFSjhiICylcJ7rDU9waDMosng9p3PYmBteTfuzDDysjKlpORS2MVny7NEh5mjZT_8m24usMujYtygGk6pSE9pycv7ApmPytCjlo10DStT638McLHE-JkVEPm50xBxyEp7XvWPr9?key=7zJz-pKWlxiC47hfwUyH4Q)




-   Click the "Name" field and enter a name for the crawler, e.g., "crwl_Customers_Orders".


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeZE-kqdWscTSigJMzoB7DHaaxVM7GSEpNWCDRzjTNt_MtYgdzT8cMoGasoPCyelpklHk4SFxo3TtIPOMj5Ww502gWGBNEcoTdlQqAVgn79dTsTAffLl8ho50QCzjzsP8a5CyHleMjkvilkwuJezNfXtw4?key=7zJz-pKWlxiC47hfwUyH4Q)

Add Data Source:

-   Click "Add a data source" and then "Browse S3" to select the bucket and folder where your JSON files are stored.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfKOoCD-QXx2vNW9Qv1Ihn5f1nzgOiOXP5zUAdm5rt4FexjPPY6k9WssT9roTe2He05fArYDPkYUC66kqahUX6hO7O5yUs3ZyjcQZma-L4eqMQkjl72jbEgeaBZGHtS1F3VwUypK1UM8fIuzfu8mfolPvqc?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Navigate through “Browse S3” > "dcawstraining-01" > "Input_Data/" > "Json/" and select this path.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdRCe4ih4i51JFAAZMTJ7S4YKXsHUaJ2MfFCBv-DFtPGYBcNgf_KGWpDAiEAl30TvsbaNc6hy5bV_8A1qD6eC03qJ0OPEvrc0kCIARascqzR3Lv66T3TJsK07J75MczlgA8JrfdYMkBWU8Tr4w6jvWHPDI?key=7zJz-pKWlxiC47hfwUyH4Q)



![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdnoQB0Ryfk-aty2rGLlZ9b2DmwRr6wIIMp5_qQaB4_jkvPydJ7dZ_1AeGTBv5HTLwDX_nNu3zbIq3ppW6O3nxL-N_E8SxO3yvv81hV8WWbf9qvIfjlNzQ3jMSeJBodpSfieHJENrL0tjZQJ0Jtrq5RyRw?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click "Choose an IAM role" and select "role_Glue_Training" which has the necessary permissions to access the S3 data and create resources


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdtbFIPm3BWQSQBwrnetSHSWstp7xE7JzjwVqJ7i3EZ0NfK-rcO1_TEuPlzuGpyyy7tvOTTO-MYbhjU2IO2Qf8K1dFUFxhT5tTGsLSLh8WASQoYv14SV41J_U1eZeeaAdI72aVcY9qpKoQzpI8e_AWJSbg?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click "Next"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd91xiJfFBT0PH-R7AL3OFiVejJV78WtBG2pFvmV0hU62ULGlpLOTXAFFA5um_MLl4TYU3dLG2WFEKlYIqasLrgyHNF1OGHStMpRgoSflkO_mfXa9an_f8vLRoy8Jq-1kSGQbqwgZTm6OkHk_FGgq-LMqw?key=7zJz-pKWlxiC47hfwUyH4Q)



-   Click "Choose a database" and select "db_aws_training_exercises" to specify where the new tables should be created


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeD78J9LRs_U63Kvg0pT8sEauR2TOtcC-OYVDFYET1WCoeAbbqzm833XXEpB8Vvn6y4avQtpJ7MQuviImI2wrgdKA3wpQfUR9K9QsY9UlFxsse_qieq2uiPUP2M9blq3m0fTUTpvS9HcOmUopXAFXRhOkw?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click the "Table name prefix - optional" field and type "tbl_" to prefix all created table names for easier identification.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXetVkWUYKyIbpY6fj9e9LfdHLVmUKKfFvwnVlMiOUvoJo15WHi-6pleSGWnWIL-2yBk5GbsczE5E3cAoOu3neuE6nfqV_NmL_jwx1Jc5EB6nfsi0MCTp9euOMDlIISaJ7MOizt-ng_saERh3gdq86klXKiw?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click "Next"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXciE8EVKeVrua_ga_EZ7dvSiS6gZNxXOnEn3uI11LTzv1W51ND2WJEXeiqeyxwSJEYpLtKFxz6Qj5_6w78yLvr_Hd9zqefQCi1NkCz5creeBdHUbq0ysqBbrL-gt6ozYG9E2-g9aWrxVL5sjApv3isc2CBh?key=7zJz-pKWlxiC47hfwUyH4Q)

Create and Run the Crawler:

-   Click "Create crawler"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdE3KZw8w3vgCJJCBKCZ8-5UqsKIV5C47Gc2tp4e2k0c7XnmvpyBVXlEMEbSVXYQ3umKVyASsjj2GNZ_Woqffy2syM_oWXacEpSNv-6ysL2DzWXFj8_UE3oTIeUCH1PLRw6Qv7c3knm-Ooj5mI7gc-ym2QL?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Navigate to crawler created and then "Run crawler" to start the process of crawling the S3 JSON data and creating table schemas based on its structure


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfrVIL79likORtW-5Y9rJ0-ebeJKTc873oZuHmiMMiLe8Tfh97Lnd3PHbQ4ySHmukiaLSsJiV6MLV4ybFxtuDoPTcfqShaJfJdD_pKsM9GXwceGR6uJpvRMzr22RSuV7ddZvPBsZeaFt7OENF2wiie_oTM?key=7zJz-pKWlxiC47hfwUyH4Q)

Review Created Tables:

-   After the crawler completes, navigate to "Tables" and view the created tables, such as "tbl_customer_orders_with_addresses_json"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdGAaQKp7Y0YxuzhkvU9bnoXpL07qKiM8DoTrQN91BGtCg6gcJowHpcH-MzW6xnvaJSsD_yRQmGZLYO2dwgCchYzv1MXN-4cDWo6xSPITtDW1FkoxTRX-Ya1ZQFu05RlIJbrpPoV3GZQn6NxPxrxKxn8CX6?key=7zJz-pKWlxiC47hfwUyH4Q)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfzyqibgNld9Bd0iMmur673PwUzqXSOYvQYZYiZFT9NOtk45Av29PKUhM1fpwsga9Vs064WLEKbtJ9GXK9tA-iNNi_f44xyA-PNLtQhFQShGWkxFhRfjkqIHj80jLLJNZ7B-zYY5D2fKm-oa0ubdfNNH-5-?key=7zJz-pKWlxiC47hfwUyH4Q)

Edit Table Schema:

-   Select a table and click "Edit schema" to make necessary adjustments to the data types and fields to accurately reflect the data structure and requirements.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdD-n0ZQC7lqKi6smO_6MOAMXYgSPVlh5cj_87QN1eNh3du-ePAzZPAhkpB5N8Qr1RknIYuWP2O3TRoGqi6qINck1iQxckyLMArvUORd7PlJRSrw_CM7DnkbE9wxBknQ4tWOHoOUpHxmyKtBwZpbjVyskG-?key=7zJz-pKWlxiC47hfwUyH4Q)

Final Adjustments and Save:

-   Make final adjustments like changing data types from "string" to "int", "double", or "date" as necessary for each field, ensuring that the schema accurately represents the data types contained in the JSON files by clicking on Edit button


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcMKo1CRheHcPCO0gmRyvgbaldldgTFfM2xSCGdKrT5Mgnsz1c47kFRpsKbnA1PPiy19D375Zvzhwfj1wq0Z5hF7ucqezXXO_R_tu5cNNvyoPpbw17U3MnRxVqNk0oh39o46pzFy55l9rFTjg_OYv5uIyzG?key=7zJz-pKWlxiC47hfwUyH4Q)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdt_XYdpx6APY232gZNwOZuB4PsPJqH7ChbXFzqGj7_TAaANS55pEA6j9WQBRllVwA4jrcLZe5F7j5hQKbLMmzDBb2cRbYp-hNgKAAH3XodmszUyztWKuEpM7MidjKwJ8bJf2EkmQxsI_Z7iNFK6lhC4nj2?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Click "Save" and then "Save as new table version" to preserve these changes.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeWBeySt2HS3Nf90jAm4hZQtDsL3Ex1OlCoENGspiPo4mmhgyO7nPjbF_Xs70lbryF4dHU-GCN9U9OjJIXvmewswTCiy6gy9lgo6yT1EEKUoWkXFTC6XSYa34GhOY_bUc3K0VSgaTdauZ2qvUm0jqDnuljl?key=7zJz-pKWlxiC47hfwUyH4Q)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcvQ5U1H0ZRrrgwMcmvZcdx4yz0BCU_UMWBDWtgt4xeeo1DdmgOStS8awD-eAwVYwfityKmYJSLqfSRNNNHZcD5XUcYjyw6MZhoCJcvA_89DmMfUkRIkCF8yvaFhkQROd6Pu2KFfmhCvgkU_eXLJ_nYSDn2?key=7zJz-pKWlxiC47hfwUyH4Q)

-   Go to "tbl_customer_orders_with_addresses_json" table again


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeKUkPDbyTqVtVpibfO7lCKf4oklEBKiuYcZJJhl4P0JQHZP4y5XBPgiDgI7OyDMQ05TDJfHYiLo7jMxoS8b8bpsa57_t-_G25Xi8w8y6xFkpTHjyK7Gj7bTZyU-1xNu5roTWeoyIO6AteGv_8Zn1GPfLc8?key=7zJz-pKWlxiC47hfwUyH4Q)



Voila!! We have successfully completed this exercise
