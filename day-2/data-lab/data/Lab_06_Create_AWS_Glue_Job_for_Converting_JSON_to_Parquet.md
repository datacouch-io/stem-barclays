# Create AWS Glue Job For Converting Json to Parquet File

This exercise demonstrates how to create an AWS Glue job to convert JSON files into Parquet format, optimizing data storage and query performance. Using AWS Glue, you will configure a job to transform and load data efficiently, leveraging the service's managed ETL capabilities for seamless data integration.

## Let’s get Started

Access AWS Glue Console:

-   Navigate to the AWS Glue Console using the provided URL, which directs you to the specific data catalog table tbl_customer_orders_with_addresses_json in the db_aws_training_exercises database within the AWS region us-west-2: [https://us-west-2.console.aws.amazon.com/glue/home?region=us-west-2#/v2/data-catalog/tables/view/tbl_customer_orders_with_addresses_json?database=db_aws_training_exercises&catalogId=786461327180&versionId=latest](https://us-west-2.console.aws.amazon.com/glue/home?region=us-west-2#/v2/data-catalog/tables/view/tbl_customer_orders_with_addresses_json?database=db_aws_training_exercises&catalogId=786461327180&versionId=latest)


Initiate Job Creation:

-   Click on "Data Integration and ETL" to access ETL features and then select "ETL jobs" to view existing jobs or create a new one.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXff8P4pE-RKXEFdhPuFAXCfqzrrH-ZW7hGGogBiIpWI09RIIC3U1zJPukrL-mwKX2sMb6V4rR4XCo4n8f99Ik71Gci-pRNk79XhIsRLnAgKcSaoMcKZdfxej6R1rb7CcpUbLNVNPuTkcxz0eBIAlIMGb2ze?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click "Create job from a blank graph" to start configuring a new Glue job from scratch, allowing for custom job setup.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc8DeoF29TQ7H4_qawsTC02tLAzB1h3HE8hNWRmJ8d90w5NESeETtuE4jUnwybT2uZyF4wjcPokYiZgC635UMug0Q082evk0j8brYkNshmaGD6C0dBkSU5LkVIEMojoZv81t054Lr0kIYVQ5vgPS-KjS7c9?key=nKqg6ggY2dHhJPMO-ufaCw)



Specify Data Source:

-   Choose "AWS Glue Data Catalog table as the data source" to use tables defined in the Glue Data Catalog.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeAEjg3a3A5MMgq_WjcYaEIH9YllFcGY1GVAN1sDvQWTPgrS_O-oSYX4ciOAfEdPHH8lvqJ70Fx28vc1gdSc1foOwx032Da_1y9ftbYfJPHci1J_esiZtIFxt0C-OkD0zTfWwDrRplx9xnDtnz0YdnOnhrv?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Select "Data source - Data Catalog"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdVzKSb07VoM7CvSD5-TJkQp2vzjOa-8_4o8jd31dZDVgkHspZ54iJlnKIAHdhlr4c8C5Qel9FnAiaHzt-4gZQrXQ-t5BjHvvBkitDF9eHMr7UyV-R2shMhQl4hkGdPgBo9SPchY7p8JLh8CkKoDQEz9cc_?key=nKqg6ggY2dHhJPMO-ufaCw)



-   Navigate through the catalog, and select the database db_aws_training_exercises


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXegX75W3ZtN-xsdpH_hbUGCpGb7jc5mLCX028yB7MDsuoCoSPK8aA55rYnIfWVvW-c2r-igmh5AhFktZ8zGP8GFaanFZI-6bFEoJbXQOY-LJw54IjCZyFf0DWYpt5OZ_m8JJk92hpkJ38nkzial574tsvFT?key=nKqg6ggY2dHhJPMO-ufaCw)



-   Then select the table tbl_customer_orders_with_addresses_json. This table contains your JSON data


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc_kRxlIMBNGi0Fz6-Ftt96yGv7HcQJBpOMTo28X6DVEXjhfH7Fy7VDiucF0JBkl8xyE7KNsKmwBio69q1CITxqoYOPDybxeSYt0n7gembNG5lC0Fh89UmS7n6lbvyviG-22QjsM_vrN2xMXepNFBQ356Fs?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on the expand icon, present on the top right corner of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcRu2kwEfAwq5uMpu1TWSMI_sf7DaoC2a6cl2dKM1NhQASdsWh8tR1tyDACtAVrz_dJQVFlyTlEzhAT5QLS_BrtIHlqQ6xz0l9xynzlBtZMB1AlK0X9pDOyir6-zIB2AVY82AYpmVhR-LN9MSMVW72qJS1j?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on the Data Preview icon available on the top right corner of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdPdTdCHkan-qVWly4HLeuzoLv4MI8zW1N058gl5kO7T85ucGUukbYIuGnPfGJPY4iJsNklSL-vf1QOJmJk3RSRIpdulZo6nuQH_aLSPVpxo1liWLTfmnLrPDe2y_ejiU7I20B8TnFtKgOg_x2aLTtzwpux?key=nKqg6ggY2dHhJPMO-ufaCw)



Configure Job Properties:

-   Assign the role role_Glue_Training to the job, which should have necessary permissions for Glue operations and access to your S3 resources.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeWa-WNQQXrVyORvFv8HSY_dBhPI_AWoyjgPSUNPCDJxRVSB0FPPYCARfp8HRZXBiufRzz1V5M7p3t8CpUjnranJHvIz9cK6cXidB5iaTVh57pi9vA9jIQv39x77DAzEfH8qEpJ85e5ZZsX22AHGaXREbh5?key=nKqg6ggY2dHhJPMO-ufaCw)

Define Transformation:

-   Click on the + icon present on the top left corner of the page to add the transformation


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeVgTABevN8s-GlDT5z87V7VJjN8tZGlm6JhEiqcyAWeDU3dYrVOZ6De20oWJBoD_KDMSZO8alQwzbwXH4fKYtFCBVCWmV3MdDy3MchDV6_EEfkTxIwZ85T-Vc0ABKRmVztd-McKGT1wZj1RjD6XtPS2dg?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click "Add Transforms" to add data transformation steps. Here, you would define the conversion from JSON to Parquet format.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfV0bPRfHZHUHqKhFjXgNTqZyrv3s9ETot1RYiE_G0cSlC0QE4Jg3MbG0fu3iTVtzioY5duEAOF_VKHhhSFp0_GCerjUrg7f1c-62C1tRv_v2COJJqPbpPlWwVQmThnO3uFjxdwS3SYnlAXHixW_BBP9E76?key=nKqg6ggY2dHhJPMO-ufaCw)



Set the Target:

-   Go to Targets section


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd33yclY8yYVnaCG6cNer4vb05LZCtVsylvI2Mfsa21Tj3CNg5dWyfft7Md31b9ueXj27Xb7qNtw51VeeFdfA93IhkQKDWXBOIK0akxH0iadQwUkvF5WciJLbL6jSufnlr31aO80YH9Vegk0PHFwQOK6pQ?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Select "S3 bucket” by specifying a bucket path as the data target to define where the transformed Parquet files will be stored.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdSuSPK1AikXL3YYC8M3Ip6EbCHG2cTbXd1jiUHHr3Mx-At91EdjZsImdXyJopBpe0HNSD5dOnuKHFnPdyJYgzz1jvSPCx2JyHxJWbwyVt2TbiU2JcHG1vjMWsj_aYqKZQhsS7c8JhhWf_s4WNgCqVaFhDL?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Now click on the “S3 bucket” card.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfaL_m_z71vcZaimbTc5twFZm5UGN-ELX5fhWFrIx9gmxuyeTrBD46xKdKmlnyeqaxqjpS0uydbSRJ37XvawOglOT_PAQSSI2fWIVFlyf_T9P-OHmQyO0EjhCSg5GhIPvavm8aSAXBlxb25ztRkFrOyDxId?key=nKqg6ggY2dHhJPMO-ufaCw)

-   From “Data Target Properties” tab, select AWS Glue Data Catalog as Node Parents


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcP87r12VaKMOuUR52sVsYIbFkxWLU75J2XyqQy-8jrOam7O-TWZ4aUEiil2zizGlaf5uBiKny0HQKXMbuag1ZxfgLERVyfxYXnlH-t5PZjSvPUDY7568ctZ5k7QB6fbgq70b5BwNl8Z-HujBTXtGeo8rw?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Navigate to and select the S3 bucket dcawstraining-01 and specify the path where you want the Parquet files to be output.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdBty0G6gv8KngETHrlH2hipQUvj-OqW-M9wT0n7hWYBCgmoLG25Xwb-LTiDis-jhSrHWlAVVjGUxMziJTkxB1NLU8AqSUGI4JNiUGLVPnGmNsKhmJFgYA69iAjJLrNZXtXERj9pUKY9uhW89gomKFTPvTF?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Select Output_Data/


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeqcajDJ39vFtRWgNwtMNphnO2SmcKTt6sgqfaqi8g6g6PG_JPwe3g7prmYurARMleBJYfOhhG5ggxtlwZrTD_lEFfcy4k4vQKhGW-RfwXsWu23WiRhTh7mk8mVTmDHoTtB27lPpZu-zfy7BXU8ldfK_v4C?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on the “Choose” button, present on the bottom right corner of the page


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeKwRuIyzS_tVPUltiY6H79DO7peZdofV_jj8den6i4i9M2ytJP_DiNi10XAAqR0b3Ky6SzDaEUQP6ENaSVGOWMMFZ_ucXyiln894t69n5B6PTvgF2VwmZexSCMesvX9RRyCBwFKo7oHD36AAjEtrzD8ikK?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Goto Output Schema tab, present on the bottom of the page




![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc7wQFe3gNhggKG9lfZlKEt7_NZJvHCcrnnoV9pmn_WcHEZDs5DQ88W-GdUfdGc2Upy6wGxujaDgkQeWKVXjwLudS_vYX0pgpmpnkC4eWzr3te6Dwx1Czzfz7B4SVjCed6PMarxWvHtbCCyxhzUBcdjgdE?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on the Actions dropdown, present on the top of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc8juZjUAZwWxlDG0aYvy6XTsRXQzt9nYDhw80pmFLpvMxumjk4sNhm-kcSBYm0sYQXLLDq6nmtXHmcnxHEXFh3y-4O38D6zIREUOaVcMkcViG8YFxpJXnM9zI61BQUmTXnp4BzzbDH0iu2NSjY-QRVsL9y?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on “Job”


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcekFI4kfoVVlu_0qFKF6OIQqNM_aBPOsvfo2MGQ6djpYk6srwP4b2Ew5-kiF2RMis58xpLmmX8BaXLOQsEmZ5_D5sxva0HhPxu-4RGkvhXbSvnAgBH4fR__w-Ni9PuvIo8d9ZxJ7FvcK6X9mOxfBmOjFa3?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on Job details tab


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdEFF6hGPIsrxv1my2MOIeXMPsc9v9hgmHCT78MR3MKxVkZ0tpym4knazXo0WCJJk-obOLRqgvd-57TNq1ZcDRx6dK77Va0QU_MqjsFjMzYnP8w69Wvtx3e_yFqlUppoEGa_si6SZWQRhb6Q4j9cGVQhO4?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Rename the job as "job_json_2_parquet"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdJ84rsdcn4zBMMfeeGwT8JhuP8ZXcXjevcNcE68bf21TRngvNwYxLln7ww7WIGrvl0FmZCYn2t5icyS0FOobQq8Q4JqeXaIh7UhYxmMDpmRAqnHm2y00vashUhmjwnepGP6DwPFgR0iSWeySFYnU2HCZg?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click the "Requested number of workers" field and change it as 5.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe913Qr72Ws3lG70KVH0pgLymx9Wom_7ShFw3ITbvQnwYfasPbc5gn1O4JnTz1US5oaleYSL8qRndLUV2OmE0Pln21jGvu90G2xl_VVaDydeKbYU_gec5tcbgMSeMbkUZT964JXB1fdIA2nHlGNBuLsiy0d?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on Number of Retries and change it to 2


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcyzHXv2NVFcIRDXHu0gToSCx5xkWlJ4Cp55XAhOzeeIXYHMWdwlZOyYhxL_0InVLl63nW4NwoOp7KL2uzzcmrxuoWbk7fNPQau8CjCQdRLyqsG03S0nTsegS3aplsnum3SMrT84VntCtSxuRfuqUQJ7bo?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click the "Script filename" field and change it to _2_parquet_file.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc1Oo3mJfMZvQLkOp_pXxGplglJBU-qmrNhRI1CEqQT0BhnVZ7bZzPj8OFURywEc-iBcXwvAyGRU5v9QNmyMcDpLle7HFBPP5gAz00U6bEvsyDYmhMXDy7U7Y7CdPTah1DWZbqExjPeKf5SyjTo8KyWFCBY?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Set the script path field


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcezvhHLDxsaS9G_KcKqyTlT4S5NVQFpfqx25TXlf4bq9WH4cbv_B3Z2mj1rorRRMO-tPFrDUB8E_Q0d1S_WgoU-PKRHRO-VGY5_PlNEg825O5t9XZCBq0qusclFXtGpWIyrwLPpdtbbpY5C6giklKznMDa?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Set the Spark UI logs path


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdfIf22MfMI3ob97xqaMEQGvcfdehvbZDJ1ZxRocu6QCVzZcySwqbaa_npi8M033jxkV1KgRgfBcH584o0vbzjJl5TWrxbHOICFatqNfrfOL3D0Got9snqc5qOK8e4sgnbkoiT-Hr-OWUBWFNjRvJPRUneU?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click the "Maximum concurrency" field and set it as 1.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcVKTdiGguswuocMPim-Vx_3qiNmWEpLKFgOtJt-kEUHxwE_CqtaN-gIni1j-F3d7UQitzt3ZIpjXADMcR5Dnpf8AcJDzaiCfETc-PcCUVsvj9RTLV6tKVb5YpOMsKNgKQPtB_hUaEa5rqGsE-DuZKAp3yS?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Configure the Temporary path


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdBgbF0ZLJYmUfxY91Csgeoh0FZKy650xTZMnl77fvdHwN51ECSaIYpSoRLrJKcuR-gd04IPJtDK44COLedGGb7doMvkpdqoBYvIe7gP87vU61UOOPDNWmYfOb1k5FmwvwZVcE6EJ8j95yAgGt4Ki6vIYdD?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on the Save button, present on the top right corner of the page


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd-G9UiWkHTSzjk1rQVvx8868uYBqRqs5_8a3h6fgS2mooNXPOagrSMAwQRW_O2PhyQ7GyA4VdVpJPALX__vYp8MIXlzOoCoxU0JgIjYdJHdeF3xljHV47EX5CzFsH0mtsEDCHqaE0mcJYe2wIO-U3RbP2c?key=nKqg6ggY2dHhJPMO-ufaCw)

Run the Job:

-   After saving all configurations, click "Run" to start the job.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd7fXpt6gsibYhJuNeEySyanD3K1LTzeALL8Gl_toe2sbnYALJpdVLik4kRom_KrMQI56oTe2wDEQGpiv8JTgJHYXh2UiZUjxT2DeB7lltECPlSez69r9kYi3-AJi8__BPCpvOvEPEm3UJbG32evozf1iUV?key=nKqg6ggY2dHhJPMO-ufaCw)

-   You can monitor the job's progress under "Runs" and "View Details" to ensure it executes as expected


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeBQERTmteNTEMd-IJFVT__TLJUqZ-DUtNWcJPQEL0deORRcmYXqrKx21-hV_lFOMcaSggg_FRtcLH26hW0PCOw32C0IdUd5E4TcO9dDYUed1Bs4DVsMCcdNKr4w_ZFmv8bY_2dQuQ07D4_yyl_H6QCZQz4?key=nKqg6ggY2dHhJPMO-ufaCw)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcs-6r0q8B81oItRACCix-DOn6guOqbtHJSALl0tdalhSpzZ-q_EEEW26qZElvEzRLptflpeHdii2sKdo0iGW1vwQW6JW7hHchrc2a42kHDwO5JWYg-xkMSI8Hq4lCPUzGmaUp0-NJmsOzR0VgeD0EhMUQC?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Go to Spark UI, from Data Integration and ETL > ETL Jobs from the left hand section of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe9NaMsiVoFOMoqxyIK11Fi3xL_FS1Teu6ZLLhJ1XQoD0arCfkTyOVeo0xVDh2Cvyjmguij7DuJ39-b37Ntd2qRXVAqS9WVeFT_MvY-qMEZSrexhGikvq2xTY9S_Sy-fUR9Ywtxtik_kKB01ZdavhSttlw?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Go to Monitoring > Job Run for monitoring the running job


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdUoqjS3lCyROx79bFPwCMZ61FkzZMRXwSTZ9P1XncXIIJHqV8iFWNn8vdiwGVDxArlg8m6-PkXqbaxzdYLNyzJ81HdmaXHLBp3zNp6k0g_xbkteszZi_61wNDnEUb_aqZxk519u3NaZb4lFxjWwGVo-0E?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Upon job completion, Navigate to the S3 bucket


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMhE_0Izi69GhavVHvMIO1BGB5VNcLvdeQLV5GXxkQOpkhXTLuGHEER-329hGA7eJ6w1bmdOnCgSUS1sTHhnQL7PRv3gPVlmfd0Fn6kyANO5CbYB2aTEMI7NffvRk1eQx8lvLtycVHRH8UiasnggJIjbw?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on "dcawstraining-01" bucket

-   Navigate within Output_Data/


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdy8q_hASvqz3cp_-BsywHPm5ZA5dDxNMdMHMI014-zhx3VkWvGEBOkAHQgN4jjnETMHH58cABFuovSPNVuSbV3yA5K8BC2F2um5WleIHHSsqoJpaAeCBGAnfPFNV-MJKoo_G-wnmv2YPIdYIfsVJHbMfJT?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Click on run-1717068112258-part-block-0-r-00000-snappy.parquet


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe95xgj9M3CbwsarkhrbCOVIlmotvROrVQGcw7L2A3OYkvAek66fGabU3CGLNbU7TbQLgPlHf7QJ7rS8XDJCN4NKOvs7dtjVCdIhm7QnpQzG-_NLHG_M6SUxMTpstTBfcvSS1GTQVXY04L_MCdefjseb0Vf?key=nKqg6ggY2dHhJPMO-ufaCw)

-   Download the output Parquet file to verify the successful conversion and ensure the data integrity.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeQQ3YSHmH4RgLzezW8cBSt8BxqywL644ejlV-w3_xo2VCUvUn02VjmFsGXwOyHQy6fwZE2F5j8vP0T2f2jH7KjhYvqDfCyXj_GuMZA11hs_SfgsT_sk76H4W_ryZIATueSeP8zVR6cKE2VVW9Nqa4xIj7h?key=nKqg6ggY2dHhJPMO-ufaCw)

Voila!! We have successfully completed this exercise
