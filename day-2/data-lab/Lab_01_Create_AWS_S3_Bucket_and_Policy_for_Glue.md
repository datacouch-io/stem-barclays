# Create AWS S3 Bucket & Policy for Glue

This guide walks you through setting up an AWS S3 bucket tailored for AWS Glue, including creating necessary folders and configuring access policies. Learn to systematically organize your data, establish permissions, and create IAM roles to ensure secure and efficient data processing workflows within the AWS ecosystem.

## Why You Need This Setup

AWS Glue is a powerful service for ETL (Extract, Transform, Load) processes, but to fully utilize its capabilities, it requires a well-structured storage and permission system. This setup will enable you to:

-   **Organize Data Efficiently:**  By creating a dedicated S3 bucket and structured folders, you ensure that your data is stored in a way that is easy to manage, access, and analyze. This organization is crucial for handling large datasets and complex ETL workflows.
-   **Secure Data Access:**  Setting up specific policies and roles for your S3 bucket and AWS Glue ensures that only authorized services and users can access your data. This security is vital for protecting sensitive information and maintaining compliance with data regulations.
-   **Optimize ETL Workflows:**  By correctly configuring permissions and roles, you streamline the integration between S3 and AWS Glue, which leads to more efficient data processing and reduced errors during your ETL operations.

This setup is not just about creating storage; it's about building a secure, organized, and efficient environment for your data workflows in AWS.

## Let’s get Started

Access the S3 Management Console:

-   Navigate to the [S3 management console](https://us-west-2.console.aws.amazon.com/s3/bucket/create?region=us-west-2) for the US West (Oregon) region using the provided URL, where you can manage your S3 buckets


Initiate Bucket Creation:

-   Click "Create bucket" to start the process of setting up a new S3 bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe8_RoxoGxnrc6MiuEERYyq5NP9B77Si-k7QaegF_1-YdXrVOUxZtr4vcvczWaO3feluDnMERqPQixYCzJu6dnqcn1KUk50HBWGuQVMLyt2ng78coy6axT_8x1TGvmdyisq1NCO4IXWQmm-N-cU4RGUwHE?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on the "Bucket name" field and type "dcawstraining-01" as the unique identifier for your new bucket


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdrl6oaSKWzVdZwqdyF_N_TUCFRjuYRoVireDuEXaTmQjte0CdCd7vooO3Ab0-VnzIyMVWxHvButeN7TqjWgOy-wlPNNvuANtWzO4DaFzLYu_er1waHoKDeOyCj73OxpGU-BEGHV0QRpWLEFUZNNY5BKjbP?key=D8DFpYSKbOyW7AVmuZos8A)

-   After entering the name, click "Create bucket" to finalize its creation

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe0iMyu-vZTCLsPt0h91CG-ap52VeGHyKFeHAKE5gtV7ZXBnxyanzPPzzcr5bmKe035kyr0to540R1mH9D5kyMAYAedlkvvmt9rtXym_t0ymhkWOHCfhcxYc2UY-WezciRG4aCcfgiEqgBBLUd37SGgIlkb?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "dcawstraining-01" to open the newly created bucket's dashboard


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfD5AP3vhg9qKzCmBVy3z0wTFaQ01a7nq8eGtoH5wMnZzLZ8k3V6yPmQbscbbmLCV-ho5-aSQawyyl9laeNo9bGy2nA_I70NnlcyHDVMaHcg69FFN0urmPudPh7Wf8jOoZkgDUTxXWOY_cNn2HtiMAt3tX0?key=D8DFpYSKbOyW7AVmuZos8A)

Create Necessary Folders:

-   Click "Create folder" to start organizing your data within the bucket


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdCgdXqcQGfBzir1Y4DLaU1e46Q9JYikmXY7yQVLDnGLURi009SI2MM38y8oaSkDntJJd267Q1ZUR-I8XX1nSlbSdmWXPfNYbEzq6UL1Y-4Wl5d8pKuIMa4BNXov9VhEj079yt1T7UweUtrY4k2lmSKEb2I?key=D8DFpYSKbOyW7AVmuZos8A)

-   In the "Folder name" field, specify names for each folder as required for your data organization, like "Input_Data/".


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfpm1Pe3aGG1hXohIaKA0LcPGiwJRaXF-d_vwaQvGLi2i8ASsIMFO-coFrOdHZMqXncMTQwR8naQx1ZU8MIYAZtWUTMxfCV2Za9e0JgCSMvRcWEyAKFhy6DvolNxHO2dwKNlz-SAB0kILlxj-_WueIydcg?key=D8DFpYSKbOyW7AVmuZos8A)

-   If necessary, specify encryption requirements or other settings that are needed for compliance or security purposes within the bucket.




![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfCAEmYUHLNu3-MeA8g73ajt6VZdmtSdgItR-v1vLQIy6d0UwsFS-uREZEgr2c9i1frQmPxByjqZYkwCUFSpF5J-i4KI2pC2bPd9eHYmTlVRdxkM1kG4rPMA4PVEzkyFrr7o7lNGUGGey5FgIWV5bB_OFZI?key=D8DFpYSKbOyW7AVmuZos8A)

-   Finally click on "Create folder"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXezwf_nkjeqO7ZB65Qr2uKdLM0xyW22aiuuQE5nYUhHfEJ6WQH56vW0qwJmcWL_HWlaJOeza46MA3m_Y8DUVSi_YLLOHieICQvsCVqtyx1Iq1Bw7wFC4xZbzsB9m27JqfN863-lSEUWU8M3d27HdnaduICR?key=D8DFpYSKbOyW7AVmuZos8A)

-   Navigate to "Input_Data/" folder


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcqa09JEstq4RoSeHni_agc2qa6E3XElzY28wlncS_u0_BNx2dVgv68gmtoTZBJg2jonUEJO3RSE21jVy71BIWNQHK5YF2wovYNNJ7HHlFR963Onjg86PkpPvsuZPtdBZmLszqdKPz6jtPmB6VD9oiEJz-5?key=D8DFpYSKbOyW7AVmuZos8A)

-   Use the "Upload" button to add files or entire folders that will be used by AWS Glue for processing.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd6yFXUECnsuQyK7QqTEFkPjvLLLmhiGtPpuKUMnFqtZyhZ_QaWR7pqnWDldYCRSVY1RZRm5HDgQ4RmjXiFdV7U-p86lQzvQLnlJpoveQu47_fdzl1kx7daj33XMKDvh-XEKON-pZ2pRlJh0dIyE9TquknH?key=D8DFpYSKbOyW7AVmuZos8A)

-   Now click on "Add folder" to upload the “csv/” folder


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcAszLr4rQ2qHPBtt8hRVwn6LAFED6qmRUM1b6VAHkjqBGHDON5s0vF5IwMxczlY9vbHbgFc-RkOC3RejnOluH540etzXXT01oz3FmFVRHnaR4yQXio-nx3ilijtUq9gVJ4t-dYdDsP2cDFJvPnl88zARoK?key=D8DFpYSKbOyW7AVmuZos8A)

-   Select the “csv/” from your local system and Click on “Upload”


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdd4QmTYDM-036e0Xc-qEQOCJ6dQk7xhWzmFKSnP2E1bznxcdBIjapaJuLeRFThrcf4ZEJQJxttjCgnCpArbfjvMTleptCYA0F1twBPPuEBdsq0qaldL8E0WMjHoO6x0jLJacKaC1LKX8CFxyLlhryR5K-P?key=D8DFpYSKbOyW7AVmuZos8A)

-   Once upload is done then click on "Permissions" and then "Edit" to modify the bucket’s policy settings.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc7ipR38X0JBsc6p7QP8QlupkgZpGeaYMoX-Ab3-u_65ElAyq_dYQBhYAiL_2YWHASQQfrB1kEJkCXm94TGwKBshSEZrngt2_mpLsb3d9Lm8RGdSjfB3blLR3TBj-x0itbJwynKinX2YfEfMu7iaD5xYjEr?key=D8DFpYSKbOyW7AVmuZos8A)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdWuObVDEC1OHllLt0NMOmndv2h-5RKiumSmJ1UXfQ04eB0zalzxXDSZfA190-V1r72W8CFPYBS-unK8A7lpGKGo-pItYxOMlW4taaq6A-jW2SUeBstPaoJPOBmvsmHSxf7O5ipCJrtbYFfK4JeuQ82K1eP?key=D8DFpYSKbOyW7AVmuZos8A)



-   Select "Policy generator" to create a new policy that will define what actions are allowed or denied on this bucket


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfwuSSaV2pQtpLNiz7KfrptNCjvks9NVBsgE8J9yJO3x7u3cBc_fK_DK6maU6BTFpgKhERmFB3SMe_9ev0WqnMM9Uc37YNqusr42HyBIQxOCIu3d5VSHqSQ65slhW8fzHPBX8K1SekkqTMgUbSfYxhNBdeV?key=D8DFpYSKbOyW7AVmuZos8A)

-   Now select “All Actions (‘*’)” checkbox for selecting all the Actions for this S3 Bucket


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXej1W-rCTkkQ1UcWNf6qUIh94v0OguQwRD_AjNg19QYu6X1s-V5oHBJs4DyTSzwoGprQLEYWEv5vqgpKR9rRtMKg1QNOSnQzqsm8ZyhMVWSRpGh3YZVL-2vFCb6IyavGh__Lro1EZ5JdgwX6TyL5bQTboE?key=D8DFpYSKbOyW7AVmuZos8A)

-   Now go back to the S3 Bucket console page and click on the radio button in front of “dcawstraining-01” bucket. Then click on Copy ARN button, present on the top right corner of the page


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXchAbv24qN5ROM_YJTZXaBF_DtyekMql2seASYroAo04e6RTdOuAA3Yo00xTwMIN0i8OnlWuEkrFk2pzbSuOD8H4XzyPVRfZPY9NaYKt0eL8h9P8UXExoZI40KdiGcX5QUGniA1LZxWdIu_h1vZjzMjWn0?key=D8DFpYSKbOyW7AVmuZos8A)

Creating Policies

-   Navigate to IAM (Identity and Access Management) > Policies


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdzW5OaFYUX1H0TrNhyYjGnNHalcIKfH8aOG3dJwrpaQ2MEibc0O2phAd2-7S_KTKLC9dJdi6EDs-sBioE2X-flJqttl7P3K_DCOGw-FtdGGuSjvApyyekHCh_-JYC4WoOi-m8nUthW8B7MC5TV?key=D8DFpYSKbOyW7AVmuZos8A)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeEUu_jFUb8vsB8_JBo05rT46-qBujxpauBj4wif_fHRUM_T71_m2dQYY4EIlFCPJ8tO8Td5haexzip2xV-mT9nLeIqQvzZiuwU4ImXWFG5ghodoENLSTUAs2l9Qc8dOiWwEOJIOk2O4vj0du7gP_FF8Xi4?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "Create policy" button


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXflsNlvE4PNq9XWy0Usus7_zT3QCxhBoMGVxUp53x2L20obHl6T9G-AWFw5Qy3AdTrsGrX6TBcOSg3jvoJlU_1tkrIoSiTb-MZvB-h3du03L_Up7o5HzZKOM6BOHmbRymXafwg1mN6fyb5d89vrZr9OzXWh?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "Choose a service" and select S3


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdp8SyD9HG_2ZY1qac_NN0wWdbyZL1k_6hXUK2wJMgV7twmGSAplBFYkG2sAVH3KGAapVBfih8XNLGX1b2ip_tV38-szUdpP7utxUHMrjLEdRbwIY1EmzQedgFCbH6HUjVnUUBvLvmWj21IZ29l_qRaC8Ao?key=D8DFpYSKbOyW7AVmuZos8A)

-   Under the Manual Action section, select the “All S3 Actions” checkbox.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXehSpN-un2MHScQGhOPBCt2X7nfAfmXIuninZ9UiZlvQZ7CKsUug7Vy8WBJu9JUaQtaqbtwKcu_iGxHjv6L8B8gjJU6n7rHrY4bo4-RBdl5aQJ5w5rNNRIyhinjU7rilQubAZLDMPNqlTnPBuPpYt9SS6kt?key=D8DFpYSKbOyW7AVmuZos8A)

-   Scroll down under resources section select All radio button


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeZ3Nk_xM6CaOkflSQ4uY1ZQG_--hkQ9McUoUBjkgHidGRheWIKG9w8ecpuMUlkoF9qzedyzSEiC5_l3GX5m7AyAfMGEC3bt_5AbqT1JLMayhl81QXo-saRB8iM8nCrxXnPrDuJ9X3p8j2xPXCdCUAYf9M?key=D8DFpYSKbOyW7AVmuZos8A)

-   Now Click on "Add more permissions"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdq9dRgr7A1c5YWaN4UEMPzmOx5rirUVLicIcelv-cEG3luprwO-cCFwclOpg1EuCTEIzSpDbwH3Hkc3un6Xi3mOxbu1ewDJe2e9p30K-6hon5dXdQP-nIwygOzVMFUKKlXgvRbKnzGfMI7WT9dEEau0hpZ?key=D8DFpYSKbOyW7AVmuZos8A)

-   Now repeat the Creating Policy steps for Glue, Athena, RedShift, DMS, Quicksight

-   After this click on "Next" button


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd5c5F6ccPk2IAQKDD_On581Fx3IklIytnzKVrIhrMH1uTrJ3qN3z1kzhSreuqiNzPIPDtfN4DjNUoac3rkap6AghbP-QPcyvbSWPRC50cQfKdl8G8ZtPm0oS0HhEqQpKcyq70agYXHWhoP1IzSdGMHzjQ?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click the "Policy name" field and provide it a name as “AWS_Training_First_Batch”


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdtXUJck6URIlcP94a6VafUugzNTs5KvtVj-LS4Np3qhNBSr094G42wc06wqYf4rfiYv69_Q1FAJiVvJKFUVj-oH4FZnyyzOQWO9cnOOHsk2AoNM-1Ychsgmozs57acwzRGD5QnxnrgEvv4lwgsP7CsLiDQ?key=D8DFpYSKbOyW7AVmuZos8A)

-   Finally click on "Create policy"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcImkMa8qBTiAqfsiU2ax52PgNDfAiU6z_n6gSsygj6FGQwttBz21eNDWKZ2Vb9NK96U0dBXpr6-mMI3uNVK4HVioWBkCg00z3cCQ3ASpITY0W88ReZqWlM4x2Dqz4aeBZC_0hEMuBSz_uHs3IoGksdoBkI?key=D8DFpYSKbOyW7AVmuZos8A)

-   Now go to the Rules section from the left-hand section of the IAM Page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdz3NVGtZ9ZWDv1PFsb7EuPEdxL9URklz_ToQNhIN7y3BspmNzymCv66WWIr5KqALnSL9HFqqCm2RG2slOeVlcljG75glHD41CEuXu_YoL3XP3htxnLvHj7j2Xy9qyLOYVsXmwj4_NfSWDXdlVtKO2a2p0o?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "Create role"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf9Q9b5Xy6hYMBmfSE7195fI40MNeU0B5oBYP9Va8VbUq9Y2eReKaNPQbUm-Rqy914xPKSLPtTyTgAAJwCXqbqxTYrZsnsnDFLBulbQC9qmbC9XGgoFoMvjQuqWwFzHDULn9mmrcq6HHIM8yUUIKeYFejbS?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click "Choose a service or use case" and select “Glue”


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXehLKpwjS-U33mwP2m6Lqf0aelEa0o3-_KNRkIZyBnN0ZTdG5CF1upuXtGekiVMJJpEhJf0AA3YMfJL2Z-59sK29JrMa1U1slO4SD3x65pQ1lS8w4DAHZEsWcgq9j4BxJM5AfZjorU1OHC4Joew2VBkTPc?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "Next"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfGVD1XuonPSpe8KaNTYDQrTL_VSlYkUExXVReNbcMSCE5sVu6u1zV2DYLYtv_O8xR9CvSmwhxTvzIadmR7tLW1BLss-hUrSbx-dwRzOVYTip5rXovIaUGF4gokVypIAnvkUuzBPv7Yb27e6JbU4AGnwac?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click the "Search" field and select AWS_Training_First_Batch policy




![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdjNqTP48oDJENUqlJ-52xCy39nuGOb9YxAnckD0kMy7Ubr7yDsJBiTY3oIRcLY1wPUNrNw9qiM5KOeiBYfe-PYqOb5O_9AFhCf-RbySUi_wJrh44KjV0ypYMJKZsLNk9cAhV9UM9a_3Rea-srnFPkzr42S?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "Next"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd8nngsOZBUyr3Qsk6_bbAdce2tZix61u-CJ26AHohyUtwjgunzwuVUZI6SQWdxQ8hcgx45LxD-4Ru6JWLpa13Uixo4dK1o4KxROF1iPuXBNzRy4wyh40aU63bmM01Z3kntnNw6WaHEkiVRtP4HzQcNUQo?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click the "Role name" field ad provide it a name as “role_Glue_Training”


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd_i0s11MrN5hfGOeTScQgf4Z7drW1FDjfTcTv2-hx0oRDO9p4fhqEHNIPGHl-Q9YXRNG_FVZCAsFG5m8QOnwbXl66VwAPBWXFXkhd1Y7e6tnd0qg5zZUxidqAIUJhrhW6M_QiHzvAR6bNXE4GLSoEh4NvI?key=D8DFpYSKbOyW7AVmuZos8A)

-   Finally click on "Create role"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfYc-ouRcLBPsLkVDlxD1q0BJOL43DN9TStMbLlKOGiC8ItqJseU8rwRJ8bBRTPiFEAj5B1Sbk8ke9AyrZ0dn7G2wn-ZM4WgWNJIM8EM2aOJUMaLpZ4ewDBY40vIo43Cyq0i8wbB9J2toskFRrgNYRknJqA?key=D8DFpYSKbOyW7AVmuZos8A)

-   Click on "View role"


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXePEcMqI5tXyIgiCOmY6yoop5r0FtpDu3QOeTpsZMuDYtE7yoqWYCV7D1p22GXN3YanbCeHqKcH6c55G6OqlZueQ6WBm9_JSMK4geFB5BlJlbg2osuCyW-HPMyIasXBB4IyGmkeOHOLoYLA7vmBkWXIWLg?key=D8DFpYSKbOyW7AVmuZos8A)

Voila!! We have successfully completed this exercise.
