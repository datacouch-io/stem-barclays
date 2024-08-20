
## Configure Lifecycle Rules for Amazon S3 (Optional)

Lifecycle rules in Amazon S3 provide a powerful way to automate the management of your data by transitioning objects between different storage classes or deleting them after a specified period. This is particularly useful for optimizing storage costs, ensuring compliance with data retention policies, and managing the lifecycle of versioned objects. By configuring lifecycle rules, you can automate these tasks, reducing manual intervention and ensuring efficient use of your storage resources.

## Why Configure Lifecycle Rules in Amazon S3?

Configuring lifecycle rules in S3 is essential for several reasons:

-   **Cost Optimization:**  Automatically transition objects to lower-cost storage classes as they age, reducing storage costs without sacrificing data availability.
-   **Data Management:**  Automate the deletion of obsolete or less critical data, such as logs or old versions of documents, to prevent unnecessary storage costs and clutter.
-   **Compliance:**  Ensure compliance with data retention policies by automatically managing the retention period of critical data.
-   **Operational Efficiency:**  Reduce the need for manual data management tasks, freeing up time for other important activities.

By following this guide, you will learn how to implement lifecycle rules to manage different types of data in your S3 buckets, ensuring both cost efficiency and compliance with organizational policies.

### Table of Contents

-   [Configure Lifecycle Rule for Photos S3 Bucket](#configure-lifecycle-rule-for-photos-s3-bucket)
-   [Tag Objects and Configure Lifecycle Rule for Automation Logs](#tag-objects-and-configure-lifecycle-rule-for-automation-logs)
-   [Configure Lifecycle Rule for Versioned Files](#configure-lifecycle-rule-for-versioned-files)

Follow this guide to create Lifecycle rules that transition objects to lower-cost storage classes, tag and manage automation logs, and handle versioned files effectively, ensuring compliance and cost-efficiency for your S3 storage solutions.

## Configure Lifecycle Rule for Photos S3 Bucket

You are employed at a small financial firm currently undergoing infrastructure budget reductions. Management has directed you to review the existing storage solutions for company data stored in two S3 buckets: company-photos-<suffix> and company-documents-<suffix>.

For the company-photos-<suffix> bucket, you must retain all company photos. However, management has informed you that interest in older photos diminishes over time: after approximately 30 days, views decrease significantly, and after three months, they are rarely accessed at all.

Regarding the company-documents-<suffix> bucket, it contains automated application logs that consume substantial storage space due to being unmanaged over a long period. The application developers have indicated that these logs can be safely deleted after a few days.

Additionally, the bucket houses daily reports and their versions, which must adhere to compliance requirements. Only the latest 30 days' worth of reports need to be retained, with older versions eligible for deletion.

Management has emphasized that the company-documents-<suffix> bucket also holds critical documents that are accessed continuously and cannot be relocated or deleted.

You are now tasked with implementing Lifecycle rules as instructed. Initially, for the company-photos-<suffix> bucket, you are to create a Lifecycle rule that transitions photos to lower-cost S3 storage classes over time, considering the reduced access after 30 days and negligible viewing after three months.

1.  Please use the provided lab credentials to log in to the AWS Console via the user name, password, and the Open AWS Console button.

2.  At the top of the page, enter S3 in the search bar and click on it. You will find buckets named company-documents-<suffix> and company-photos-<suffix>.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeS9yGEN6dytIH-vEK4boN8fBVCkgRCtd4b7Y4l4PG6I_0KC6mxLBr92mdNCAlDrbSJhWT6aWFrfe_qW8z_0QNGvWK8l4euzgWP_zg5asIbuE9tAoigZBL0l4rrmMqlyRcYicgVbElfB07bi_Xn055vTA6i?key=9b9-Cn-VriFUkCqc9DFbVg)

3.  Please access the company-photos-<suffix> bucket and review the objects that represent the company's photo gallery.


Note: There are multiple objects representing the company's photo gallery in this bucket.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeotAkDG8aQTOpLj9c1KAdgCiFgl380cIkr0HfWHgMeSX1BpNyVvXEmnCLR2exJqvO88mM2tT9aOVBCDye4KcsZNIDuYUx9Oj_kmiTsElXUxAdrqD4vf_0qroazs6z-xNhcfLExfceLXGh1AEN-a76Yhrh6?key=9b9-Cn-VriFUkCqc9DFbVg)

4.  Navigate to the Management tab and proceed to click on the button labeled Create lifecycle rule.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXewKZpSTAXb4Jzv_f1EVJ6DLsENR7V34zu9U-blryfDQcnwh_DEvyKrgsZzjEH39YvBPLQ4-nqyrrEOXQdBwjq2dOheQTL6hoOHsc8WRJZAiO-Hm1amYpl-2-zxwj_oSpcSfeaaemmFD1jHZNiGsEZra_DH?key=9b9-Cn-VriFUkCqc9DFbVg)

5.  Here are the steps for configuring the lifecycle rule at the Create lifecycle rule page:


	1.  Enter a Lifecycle rule name: transfer-all-objects-to-low-class

	2.  Select rule scope: Apply to all objects in the bucket

	3.  Acknowledge that this rule will apply to all objects in the bucket by checking the box.

	4.  Define lifecycle rule actions: Move current versions of objects between storage classes

	5.  Set storage class transitions to Standard-IA (Default selection)

	6.  Specify the number of days after object creation: 30


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeW1o67vZbaM5LBvyrousLtywx96xPZQzSmCXAVyoqt507CHGtbvuhF3RvSQT1nSvM0PWSn49Yr59NSxnjqEirYfPEF-FYExUIfhFQFg5W0-2MF1wOsIMlmQ15IPtGhqBgeesedDt1E748w8SJvj1w5OGAp?key=9b9-Cn-VriFUkCqc9DFbVg)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeoIEcw1FIQ1arY3JnBDhMEhmVpoygT4599P6c7VV4l0IYFmoYaIdvCo9IrkIWPnjZRH0h-k8lK3Lbhzb75ez-mTaT1mHWImCz4vJAlcfac4T83RUDY79W0DC3HE14BSHvwrv6vdAB_bMJiVmX3_wPmYfHq?key=9b9-Cn-VriFUkCqc9DFbVg)

6.  Click Add transition, and in the fields that appear, enter the following information:


	1.  Storage class transitions: Glacier Flexible Retrieval

	2.  Days after object creation: 90

	3.  I acknowledge that this lifecycle rule will increase the one-time lifecycle request cost if it transitions small objects: Check this box


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfPIh5cG8JsHFiwHCqhuF9P-1SQ295j2QUdKHnOStftM-pdhHt6XQrpJ4bEwGIEy2EALhJhVOJctgXq4QQNwC8aMbX0UVByY_WFWO1oe_ef2dGqapdwSEqOQJuijsLdqYVsm5xKtt7_ix3iGUTPMV_Sl-0F?key=9b9-Cn-VriFUkCqc9DFbVg)

7.  Click Create rule at the bottom of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfi87EP2etDTo32j_527RoT8FZPLwd0mXfO032GH5nURibHEWkmy98i5UWUwixRdSSYfohUfSkqdU3S0wSTh1r7DQGga8-vB8v3l3Jd48rZGa8NgRDDxPMBLMPne9abhhLHPSJHKYr6Zc3fvif5q1c62nmf?key=9b9-Cn-VriFUkCqc9DFbVg)

You will return to the Lifecycle configuration page, where the transfer-all-objects-to-low-class rule will be listed.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcPcM4s044-_jwgfidUFBAEV060ZJKbiIbHP-vItNlpnOBnGh6xpJH5bfQUw0CQQTgn0vNVMhC-fSd6C7pVUSnjAI88EPj1PX6bAUIRY4LT0_l0u98RiY-zvUIc4ItHNSjNw5D9JUP6Nuze5z8JWlaCKstq?key=9b9-Cn-VriFUkCqc9DFbVg)

Note:

-   The new rule will transfer company photos in the entire bucket from the S3 Standard storage class to S3 Standard–Infrequent Access (IA) after 30 days, and then to Glacier after 90 days. This configured Lifecycle rule will effectively reduce storage costs over time.




-   It is important to note that the entire transition from S3 Standard to Glacier will take 90 days. The transition from S3 Standard to S3 Standard–IA takes 30 days, followed by a 60-day period from S3 Standard–IA to Glacier.




## Tag Objects and Configure Lifecycle Rule for Automation Logs

Now you need to create Lifecycle rules for automation logs in the company-documents-<suffix> bucket. Unfortunately, the application uploads these logs with random 20-digit filenames, lacking any additional identifiers, making it impossible to use a prefix for identification. Therefore, you will need to add tags to these objects so that the Lifecycle rule can identify them.

1.  Navigate back to the S3 Buckets page.


Note: To do this, just like before, type S3 in the search bar at the top of the page and click on the result.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXerLkawmE-KZHLcKEPlXpgbxuWRj2rU0_7uXoBFahnfMM9cqNb3w1N8hQ4DopCrRZ1ZfQBiMkIYrKUhLnc1UH4Cn8EIKRJbeMTC9cHHRxFp9RYfu6PlkBJRZjAKiF-XGXpaPL3fq5FDDdZHmE482uv3vGMo?key=9b9-Cn-VriFUkCqc9DFbVg)

2.  Click on the company-documents-<suffix> link and examine the objects listed. There are multiple types of objects:


-   Objects with names consisting of 20 digits are the automation logs.

-   Objects with the prefix work-project- are the versioned reports.

-   The remaining objects are important company documents. As specified, these cannot be modified by Lifecycle rules.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfxI35ARAQ3prq3xWAQIbGFdzmIKFTssxp8ih-9Y2Hc6c-hLkQCR3K8IRq_9VExbquyWz7xZAjvKva8pI0f1xsAwj1Bw_wfCxl9uZ_aRT8-H4Bj6UvwUET5NTv4PjHlII94YiNsAJmqWRPV5wkEPrKvN8Q?key=9b9-Cn-VriFUkCqc9DFbVg)

3.  Click on the Name link for one of the objects with a 20-digit identifier.


Note: This signifies an automation log. For example, the name might look like 2345982744578927567.log.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeLKXrypE7PAZU9bHoVQ6tnaNXmAVE_gaVWM7PimCQ0n09CS96Fnf6YYkQCYMSsJwE1BeROjWxPDc7liwd-vMgXYGD296Ao6KRgxIz-A_qwzNZ0rkt5vpbH9LW0DLLeIm6yTZ4SqjA8SZxpqX88PWI0Vg7D?key=9b9-Cn-VriFUkCqc9DFbVg)

4.  Scroll down to Tags section, and click Edit.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcoo9vQBwZkXgopYI1a_QJYFRjrKOTHqSSmrclnfsU229v96vzVdV_zkG1Pnormn9Eb-VXew6mxiyafVudqonLj9z_xREgG02P0Z2pYyNu-HXuShBL9x1cz-UZitgeTHxYvGvpGahscuimpIQU4zMjdsKtZ?key=9b9-Cn-VriFUkCqc9DFbVg)

5.  Click on Add tag, and complete the configuration using the following values:


	1.  Key: Automation

	2.  Value: true


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcJTagomHsMsPM0y3-vfcuo3I7KdEeOI4-k2o8Qj_MCwhKaOFMJtYvlfDbTYZHlTCQTnU4DwUkqgO5qicKdGIjFP-q2LC4NceWXbqrM19c_qR0MZzc5e0LK8omDlWvn5PZ12fomYQs-JvNAx4lNNtU9OaNw?key=9b9-Cn-VriFUkCqc9DFbVg)

6.  Scroll to the bottom of the page and click Save changes.


Note: While you can perform this action for all automation logs, it is not required for this lab.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd3OHtfbvyR4tpdDEZ8G08zK-Lm29huM0Ldu0MmYGiED1ZuSrkWMFL9D0iP7SkpBhp0oOCUdW3JQ2FYTV9E4hZBxaHXwVs8Qb95GP25uh5YiSjQ81vnS3R1lnpf_yJtw82vqHXc9wUcsIs9tERs9onERMu8?key=9b9-Cn-VriFUkCqc9DFbVg)

7.  In the top-right corner of the page, click Close, then navigate back to the company-documents-<suffix> bucket.

8.  Click on the Management tab, then select the Create lifecycle rule button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdIGzKkDRwag-a_jzINUCYAH-5tKHCLzLUByoQYwoCMWkOPoeB5Mh6mHhitRmQhLyi0H3SN0Jg9hUYDwi4LnQJQ7w4wcXrl8PJejiukGx_7g77pCkdwQVKaMraynTx1OHhcsNxawgATnUfuP-MNS8ehv4l4?key=9b9-Cn-VriFUkCqc9DFbVg)

9.  On the Create Lifecycle Rule page, enter delete-automation-logs for the Lifecycle rule name.

10.  Click Add Tag and proceed to enter the following information:


		1.  Key: Automation

		2.  Value: true

		3.  Lifecycle rule actions: Expire current versions of objects

		4.  Days after object creation: 5


At the bottom of the page, click Create rule.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfPi_lgFWm_e2m0W5Im8XnxZ62_3jNx5PLnd6TfIBCLmqKkIrxmFZwrhAmRtYgXpA0YK31YMNCuLg7-kku0-k3bpuBb-vIudP_nGhH1TXDFuzJ2QRZT6EIuAAjeC5a05GBTYYO-qFNNjPF0MvqVLtIde2L9?key=9b9-Cn-VriFUkCqc9DFbVg)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXclKIwr2jG8oYfsXm7AXbqU9CcdbBshOQ6q-B-__PcMDyWOp2QNptqq84BK0iJmu31pYgGYqiYYFrR0AXWp1WlXoDrKJGSN5QSJ_nmbBYpWtigMwovXFc0Jz9GKjS9JWmENOTGhOIG_s7PjgTqF1o_kHXs?key=9b9-Cn-VriFUkCqc9DFbVg)

You will return to the Lifecycle configuration page, where the delete-automation-logs rule will be listed.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfWxAM2J2bPA3TyYiug3HsB7Hjcg7Q3sXy_4JNypL8fUWf6YqJC8SvKN2zkrpQVDrz4spJ1neV_tTFOD2Yietkv_wV0T67Nus-ovjw1w2-MvQHK78rCOUxKyC6hXWc7nzd_UrHe1IdkUjMF1U7f1XFPW6L5?key=9b9-Cn-VriFUkCqc9DFbVg)

Note:

Improperly configuring Lifecycle rules for deleting objects can have serious consequences. For instance, if you fail to specify the correct scope, the rule might delete all items in the bucket that are older than five days. Although buckets should ideally not store important company documents, automation logs, and other critical files together, many legacy systems do so. Therefore, it is crucial to exercise caution when setting up these rules.



## Configure Lifecycle Rule for Versioned Files

The managers instructed you to create a Lifecycle rule for versioned reports located in company-documents-<suffix>. These versioned objects will have names starting with the work-project- prefix. Any object versions older than 30 days can be deleted, as only 30 days' worth of reports are required for compliance purposes.

1.  Return to the S3 Buckets and locate company-documents-<suffix>.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcvE2XI6amA7HsMYw4bPTtBD9ygTz7sZTUCPOPel_IE3qcwZLZ-CUOFHAcittnjZa3lF01Ggi6wJUHSwHS_AjQDJFWrucZf_ycAXLrpNzvDWQcducNWik4TZy8UvflmaJquUG8mM7unKbyWe0Oc23lADKDW?key=9b9-Cn-VriFUkCqc9DFbVg)

2.  To view versions of an object prefixed with work-project-, select one, and then click on Versions in the top panel.


Note: There are three versions available for each object, including the current version and two older versions. It's important to manage the older versions of the object using Lifecycle rules.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcw8Nb6p4-4gibxohaolbRVUVdVtFuParNdqRUIbVc7Ip0_cs2B1HQwpfCR7K04lUbEttAC-JDjrMZQtks43JNScPhJNKLN8XAwnFocEHuutFTDNtjpAE6aFol0PskJ0zecF7CDZMwoMMTtaaFQy5fSxLEo?key=9b9-Cn-VriFUkCqc9DFbVg)

3.  Navigate back to the Management tab, select Create lifecycle rule, and on the subsequent page, input the following details:


	1.  Rule Name: delete-versioned-reports

	2.  Prefix: work-project-

	3.  Rule Actions: Permanently delete noncurrent versions of objects

	4.  Number of days after objects become noncurrent: 30


At the bottom of the page, click Create  rule.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfv1qWRXKcwrbJUNZOguek8dKQ418k93h6WH1l3q3Mqqf8TwEkzaNfGROmtCzqb9wZABt5miDGa7CwjXUQBJJ4HduYmmY8kf4G9kdreFSfFzNpg_heoqcyGksRaZCg9mKrbW2fxJMyvKA1KZbr4t7Kxied2?key=9b9-Cn-VriFUkCqc9DFbVg)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcGR4rL0CiR7vaMKU3CNUW96iUAebaQtNBqJny4TqHMVqFOrZMv-ImFlWIU5l48rVUC4U134Ywkz3Cfu_hkA_Vf7N0T76SdJ0i1RENpeQ9bPEaczWrjp7dsMcBzioC4KxO7PUsRV5R8-7YuCs_rC8PYW86V?key=9b9-Cn-VriFUkCqc9DFbVg)

Afterwards, you'll return to the Lifecycle configuration page, where you'll now see the delete-versioned-reports rule listed as well.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcXO1zuLvpHWswbE-C08zW9TgAGimRmtIEWkLmqzRA-eoPZoAX0j2T8yeQn5XTTScAyMqhC1CzNo2nhvUJUG0-WLXeH0bUTLmfaUybUIItCVx60GQ2CSH-xe9FHZUmdtpo0d2JO_XSKuD2ooMKaf5PHTyI?key=9b9-Cn-VriFUkCqc9DFbVg)



Note:

-   Please note that you may not be able to observe these Lifecycle rules in action immediately. Currently, the bucket company-documents-<suffix> is governed by two Lifecycle rules: one deletes automation logs tagged with Automation: true that are older than five days, and another removes versions of reports prefixed with work-project- after 30 days. Other objects in the bucket remain unaffected.
-   The bucket company-photos-<suffix> is configured with a Lifecycle rule to transition its entire contents across multiple S3 storage classes. This strategy is designed to optimize costs by leveraging lower-cost storage classes, thereby offering long-term savings effortlessly.

-   As emphasized earlier, exercise caution when configuring Lifecycle rules. Ensure accuracy in defining scope and actions, particularly in shared buckets like company-documents-<suffix>.
-   Furthermore, assign meaningful names to your Lifecycle rules as demonstrated in this lab. This practice helps mitigate the risk of accidental rule deletion or modification.
