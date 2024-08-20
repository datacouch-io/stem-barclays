# AWS S3 Bucket - Versioning

This exercise provides a step-by-step guide on enabling versioning in an AWS S3 bucket and managing file operations. Learn how to navigate the S3 console, configure bucket properties, upload, and download files, ensuring data integrity and accessibility with version control for effective data management and recovery.

## Why Enable Versioning?

Versioning in AWS S3 allows you to keep multiple versions of an object in the same bucket. This is crucial for:

-   **Data Recovery:**  If a file is accidentally deleted or overwritten, you can easily recover the previous version, ensuring that important data is never lost.
-   **Audit and Compliance:**  Maintaining different versions of files can help in meeting regulatory requirements, where keeping a history of changes is essential.
-   **Change Tracking:**  By keeping different versions, you can track changes over time, making it easier to manage updates or revert to earlier versions if needed.

Enabling versioning enhances the reliability and robustness of your data storage strategy, making it a critical feature for effective data management.

## Let’s get Started

Access AWS S3 Console:

-   Navigate to the AWS S3 console using [this](https://us-west-2.console.aws.amazon.com/s3/buckets?region=us-west-2&bucketType=general&region=us-west-2) URL. This will direct you to the S3 management page in the US West (Oregon) region (us-west-2), where you can manage your S3 buckets.


Select Your S3 Bucket:

-   Click on the bucket named as "dcawstraining-01". This bucket is where you will enable versioning and manage files.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdv2NFqrPWyVmyQ5Ndpt9iLPgbibj6JB8L_QpxuwgRyoTDZzlqI_AqNAam3gTbtgoyV7QWRFW5owYDmwaPTiBeZDfUdHYgGE0-UsPJOfzKbgb--eHnLwQiRTmprv-9pSj9GhumLN1uAYikVHSXxh-ggNxft?key=Ts3ARreTtFA-RSTQezndVw)

Open Bucket Properties:

-   Click "Properties" to view various settings related to the selected bucket, including permissions, management, and versioning settings.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXczByC6gkbDLjBjTkD7PjQKOGkkWR27APfQaUnLC_tCpsxgbLesfYSbjoJWk4y9cJ0TRUeCYo0MJLxB6ZSv3dQxfh1yC7h6ezvkcR9V96VQ69PW6OGAM6WBLIRuJMG6VR_tQVcBjL3BBZMlSXkBQWk3dHHk?key=Ts3ARreTtFA-RSTQezndVw)

Edit Bucket Settings:

-   Click "Edit" under the properties section to modify settings. This is where you can enable or adjust features like versioning


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfU2e8RtfpJ8l84dq0uOcuP5vbI9fugxBPTDVCTNwCKSo1bBrXvHWNlVQ_V7axJgQR6Awcjhvt61Q_hncvElrNFjCdMC6lpo-nmu1pgI4ORZBGFgncPlKhm318QIPMip7pK_AoPjpdQb61el9btLTyjFsSh?key=Ts3ARreTtFA-RSTQezndVw)

Enable Versioning:

-   Click the Enable radio button to enable versioning. Versioning in S3 allows you to keep multiple variants of an object in the same bucket, useful for data recovery and archival purposes.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdKrTdbjZv_l_GvvyrsW00qvV8KtB2gwDw28pYRtE_qv72gVSNx0Xak0cKyjr5zVBwJ5BAm7i6EDm8nGYPtnhghwjv3iuXdZYoMgn1erwsWpKDm-7sY1QmiYCJgGFaYOOygnV_jQl97jDEXFii42qg3DGr6?key=Ts3ARreTtFA-RSTQezndVw)

Save Changes:

-   Click "Save changes" to apply the new settings. This action confirms the activation of versioning on the bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdEfIauA2eFBQJCNrMbNfKO9EioZLAS-L1FQfMxE6zQNTh1RXUSEZxDLC6X0J-Ofk6N735VZFCLqgNBouIXRz0h0DARxN88zYdZTz8NY8FtVhu_wV_vVPynypZzXhzYZBXdGRmOlNYxqEdx6aoCXp9y4bMo?key=Ts3ARreTtFA-RSTQezndVw)

Navigate to Bucket Objects:

-   Click "Objects" to view the contents of the bucket. This area lists all the files and folders stored in the bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeP07BEjEbYOXfrKtmadUusJX2B-QMAA8GJ_U1QCWIcdmuM4TR1ScJjaqjJ6Whx7WlKbcL5s54mzRPNHV0agKgwamtOnYHPHjiQzvAXlcTx1qST2YelGAuIjbrv8CY8iP1z4rAwOcXCZSt2Vn51XLbTVeI?key=Ts3ARreTtFA-RSTQezndVw)

Access Specific Folder:

-   Click "Input_Data/" to open a specific folder within the bucket. This folder is likely used for storing input files for processing or analysis.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcTInDaAH2OiopK2MFx5E1aCz4gI39C3Wm4rFp-gkRNzEC1p-Fjji5Wb-Cae6cPJ3wmg1sh0UmC-c_8xncGdsjzIKZiIgKRO1SeXfiFDHGkox5mwTZ8_yO3KmpfYRNn4FH21SZN5ghRy6xJmp-jQ50fnDE?key=Ts3ARreTtFA-RSTQezndVw)

Select Sub-folder:

-   Go to Actions and  Click "csv/" to access a sub-folder that contains CSV files. This step navigates deeper into the bucket's directory structure.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdiHk3b9cmL3W2qRFX6Z7bNINV5wne2s8sumGu3n6QHWX2rtc8_6KOb3PJSYdg7TupG_Exaj7Eh-4wYLNenFy2AVfdNRVAXSWcSlnYQG2VDt5ef8SE2239kHufHud9CnlNv58Hh9RhKVrZBJnTDZIX47Mui?key=Ts3ARreTtFA-RSTQezndVw)

Prepare to Upload Files:

-   Click the Show Version radio button next to the folder or file you want to manage. This action selects the specific items for further operations like upload, download, or delete.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdyYPdJvrPnzPogpiSH4D5f_7ihqbGgof59uNZc-Q2WK_swVTwA_rAhovkWaBxPmdxhzELyvpEM4c4xdy51YlB-0HYRM0Q2vt7X41hp2SYmxnTzpQMYFtUP82_lgCrf9zlVBzfV_t35gV9ZqSrAYwCasURw?key=Ts3ARreTtFA-RSTQezndVw)

-   Click "Upload" to start the process of uploading new files into the selected folder.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdxAXG0uR3ZgxT5kAQOPU7rKSM2d-Mzr03y565B9l6j7FPstOaWY6kXFuRfh3M3pVZD1DJ_rxzYfvfXqL3IBa5bV82yJHHiuW5c033nAllEsQabHotU2u-jm18NyDmB5l4nCLx6-zhqQeZbZ6E2l6AeS1Y?key=Ts3ARreTtFA-RSTQezndVw)

Add Files to Upload:

-   Click "Add files" to choose files from your local computer that you want to upload to the S3 bucket




![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd0c7Jj6tPXtKHBz7ES2wywWR7SlXm6P_2Px07GVIw8UPAwp1f__Yvw7xmbofBOgsM7lFXlI_mkdjf5Bitkm1JzwaXwcSnWfDIq1SIN0HhuKlB3ZKs_qxlOObQoPUSGj0E0XnfIPAnsOxIfbho7pBjID-_i?key=Ts3ARreTtFA-RSTQezndVw)

-   Click "Upload" again after selecting the files to finalize the uploading process. This will transfer the files from your computer to the S3 bucket


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf5vXLK4-rBqvYXZB8nobWqEGvY1pwGzl4_EYsXh69S15gO5EbUO8HlcuOXKhmBdlevfxOWP6V_BlTg0ORsERF-YMJ27UKSssdAZZI2iYq9dCMwH8mpyaNvcsq0v92fILt8xXnp_bPeWR1hZjJfw8nA5rg?key=Ts3ARreTtFA-RSTQezndVw)

Close the Upload Window:

-   Click "Close" after the upload completes. This action closes the upload interface


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdRzDdmzguij9c6DrV0E-mmzy5BW6ZbASKBMUpt7usOU7sCdOXRsxbnyYT_YXrMx4GYpmagCGfHPJl7jyp635tcDUcVSm2OAnDaEq_7JTNQYpDiYtTG16jTk2e3QIPCfEXBW4lWi8cuC5CYlYnIXxV27ad5?key=Ts3ARreTtFA-RSTQezndVw)

Select File for Download:

-   Click the checkbox next to the newly uploaded file. This selection is necessary to perform operations like downloading.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc00JrJyBPvteMycXwODuAVDZkGug3lj9vvZrWX0_pdRUYudPy9kuRx0bzph0YVQwBDGXNFRQOgo--qJpUFJEPIWWz_8FwKSB1UbkKsm0H-xBuFxeV1CeivpG_CydqubRNAjBgiS6ycScspzN3lQXZGxQ?key=Ts3ARreTtFA-RSTQezndVw)



-   Click on the Download button to save the selected file back to your local computer. This is useful for retrieving or verifying uploaded data


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfOw0lEOKzDYMqAl0EtWP6v-8eo8LoAA63wKRh-_Lfs-8uQYVcnB1q7DE2G9BaJ9zm8F3s0FMmOun95MXkMPc8ANyX9fAhJTFtpAptUbtOLaO1FbZpmG9QLnBippGS4IRChXalGDzsNrhGEgQ3G4VYCY-8?key=Ts3ARreTtFA-RSTQezndVw)

Voila!! We are done with this exercise
