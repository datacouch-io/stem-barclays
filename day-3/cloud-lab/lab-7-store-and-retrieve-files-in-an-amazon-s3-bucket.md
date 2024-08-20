# Store and Retrieve Files in an Amazon S3 Bucket

Managing files in Amazon S3 (Simple Storage Service) is a fundamental skill for anyone working with AWS. Amazon S3 is a scalable and secure object storage service that allows users to store and retrieve any amount of data at any time, from anywhere on the web. This guide provides step-by-step instructions on how to create and manage an S3 bucket, ensuring that you can efficiently handle your data storage needs.

## Why Store and Retrieve Files in Amazon S3?

Amazon S3 is widely used for its durability, scalability, and security features. Whether you're backing up important files, hosting static websites, or storing large datasets, S3 provides a reliable solution. Here’s why S3 is essential:

-   **Scalability:**  S3 automatically scales to handle any amount of data, allowing you to grow your storage needs without worrying about capacity.
-   **Durability and Availability:**  S3 is designed for 99.999999999% durability, ensuring your data is safely stored and highly available.
-   **Security:**  With features like encryption, access controls, and audit logging, S3 helps secure your data against unauthorized access.
-   **Cost-Effectiveness:**  Pay only for what you use with no upfront costs, making it a cost-effective solution for storing data at scale.

This guide will help you navigate the basic operations of creating a bucket, uploading files, verifying and downloading them, and eventually deleting them, to help you manage your S3 storage effectively.

### Table of Contents

1.  [Create an S3 Bucket](#create-an-s3-bucket)
2.  [Upload a File into Your S3 Bucket](#upload-a-file-into-your-s3-bucket)
3.  [Download and Verify Your File from the S3 Bucket](#download-and-verify-your-file-from-the-s3-bucket)
4.  [Delete Your File from the S3 Bucket](#delete-your-file-from-the-s3-bucket)


## Create an S3 bucket

Log into the AWS Management Console and complete the following steps:

1.  In the top navigation bar, open the Services menu and select S3 from the Storage category.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcd33ALmfZ93-pgmyYh2Cvj_43pq7KD7_4X8Ntan0fX5_-Of-_XMEW59z8QSTyb08r37Zp3OeTT-v6NKc734To27tvBbfmQ8P4iPAipbqRICw6jzZXHvZMDfgn2OAH46AO5a6GkbEe7TWFMwLe_I8vl9Ty4?key=9FkTLzSK8c6u09hHQ6P1FQ)

2.  You will see an empty list of S3 buckets. From here, you can click the Create bucket button located at the top-right corner of the dashboard.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfnmmmZenGfkjJ25-pAu1ONjsTJV-t6JCT25iIBXR7vT0qdqyJHm0rRLtKT_4Ns-tVGc4bYpT7AFYEE0batPtg1QTo3SesVylmvFUprR2TAQ4JIrh7SmDQgdHCSVOvqt4-2uSt5RRTfB1D4_HiUhTYfnmhQ?key=9FkTLzSK8c6u09hHQ6P1FQ)

3.  This will direct you to the create bucket wizard page. The first required field is Bucket Name. You must enter a unique name for your bucket, ensuring it is distinct not only within your account but across all accounts. For this lab, include 5 random keyboard characters before the name, such as preq-pl-labs-backup. Replace preq with your own set of random characters.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcd4Iu0Y1PUsxlXk5n3au2cp9xaS2hDrHIHnHqYqSuP2xomYoDTanps5W-R_y2qz3VzYOBq1z_qldg6in4mgHZusTk32-ujetS24FVTpFB4fc_GXZR06JehHryU5Ubaq5MlquDGegTFUoF8BfR_by_v-FtD?key=9FkTLzSK8c6u09hHQ6P1FQ)

4.  You can leave the Region field set to its default value, us-west-2. Then, continue scrolling down.

5.  Keep the Block all public access settings at their default values to ensure the highest level of security for your bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXff1j3HDD-AN-EQSFvN2jCI8tumn0MFwMbnCCeyQ3T__CqoBVR-3ERFbfegwrL5nwnLnVmoWdeWDqlh0ddCr-eOTg7_h1T4Zqek__lVKhKCmU83ttmbbjxCPxnUsRsxr_FGTe4r-OdVpCAS_sCgFAThCOKh?key=9FkTLzSK8c6u09hHQ6P1FQ)

6.  You can leave Bucket Versioning disabled by default unless you want S3 to track and save every change made to each file for future use.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfcLNIi5gbO03JqK72CxHCIym8gUt4ly1ThfqaCs73D9DnxP1Ph2DUvsXeXGiR_TTezjlV3AyTYvPcLETWVtYALhc-gFYIF6yQ5-STVDbwCtMxc3DX9Uwk3cY8h40L3nTR0jI0669m8eVBJvoou2TsjXH5H?key=9FkTLzSK8c6u09hHQ6P1FQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcAwE9ojOnIBwAUOcRw5nPm5ozoQ6yUmctbdqKtRmJdQiQ5MzKrtDnFzrHa9vqJ1eIF5zrDi39WBw6caYJ8uObsnUExFEU4pXzUclvRt1VwBd0kJ-LY15rG_E9WJgL3g0gK6qUQTW046GA3uiKr4tzPhvYu?key=9FkTLzSK8c6u09hHQ6P1FQ)

7.  Finally, click the Create bucket button located at the bottom of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeklSf697IvEq6sueYBtui7Z82aB-GkwEmDPQvWfO4aaCywGoHDWdeZJsZkoMOEVtjffaBuPhqHiJyryqbacZt2Kk4qcHSilCWtadHyyCav6mzghzrCyeg-c0_Ct5xaCd_7uldt38AIasStM17abtK3zueZ?key=9FkTLzSK8c6u09hHQ6P1FQ)

8.  If successful, you will be redirected to your list of S3 buckets, where you should see your new bucket included.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe08OTMetxpudECW5dr29DZ4FDX7Z2QPL4tNYgtPV-29hL-5rKH3c1HOB34nH08xr0HzuuZFfj-IlbU-vGg-h_HlefKhxQtdplHhWbhoReaylPcLypwjWxUopiIYQ8b75GQi6GTFxuDwanU_v3Z_FxLwXqM?key=9FkTLzSK8c6u09hHQ6P1FQ)



## Upload a file into your S3 bucket

In your newly created S3 bucket, let’s upload some important company files for safe storage.

1.  In your list of S3 buckets, locate and click on the name of the newly created bucket to open it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXds7PNeFkVAZbBj5oN0GCXOeQGaaykkrFjP3oTHb5JAM_1-yC9cpNcnbHoGMu1lfZHrFQn-fz3WQ4MRAFbCWg48h5ExGu2ZGxYK310JzzqAMVzNXnmW5Camaxw6unv-2VMDox39fzmJvnfw1SzPnpv60L8?key=9FkTLzSK8c6u09hHQ6P1FQ)

2.  Now you will view details about your bucket, including an empty list of bucket objects (files and folders). In the center of this empty list, click on the Upload button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXec9Brk7lAvB2rIde63H24hdGjg_MEQdprDAA5A9rTLfcG-bGnKsq3YcE9oFbko48O1bhpnFtPj6_oXwA99bJRz0guQ6GH9YDG-ys8F64j6bv_c4UNfmMe12eBlGyhABQCsufqFr0_pFiEMn4uGs5aH7djK?key=9FkTLzSK8c6u09hHQ6P1FQ)

3.  You can find your current location within the bucket by looking at the breadcrumb list at the top of the screen, which should display Amazon S3 > your bucket name > Upload.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfErP5sy4uHIIWE_uyhRSv-_7Ge91uoTswNYKsREXYBNzK0DmwswYp0BlW1QsMVW0i63Zv4kscAkZ2oKS8wKy0X3gjJ61KJHh7zJn0xYCuTf1IhkYN-X3swAHU6C6ifxnXFCTx1OOAKHcckyZFKtgytLjhQ?key=9FkTLzSK8c6u09hHQ6P1FQ)

4.  You'll be directed to an upload wizard where you can add files and folders to your bucket. Simply click Add files to include a file in your bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfAQ_LQR4sYuxggeQCfgFKwhiOf1MYr5wQm9bSJBq5yF1UJKRMUKjfmvChRc_DTq--umh50nCcBW4Mvg9aAoyYzZyFVF2k257SVKob1OY7NSF7L0E1Ojs8GTT-oDiENGunfSVRoWPJN7-PuDM7inFXPoMBo?key=9FkTLzSK8c6u09hHQ6P1FQ)

5.  Please locate a file on your local hard drive—choose an image or plain text file that is already saved on your device. Select the file in the explorer or finder window, then click the Open button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXclFl5WunFLK5qeN0U_8j9xrlJou7gh4mVzsO2YD3I_ECaY5wcE3auwnM5wjYFJguT4BMrgdRd8zZ8iEoLd4bmB4pNweluykUyV57cgUFnh2OFzvOMs9aRUOr9WS6cfe6PAv9yM_vd13jWnkasLJRW_z8g?key=9FkTLzSK8c6u09hHQ6P1FQ)

6.  This action will include the file in the list of files and folders prepared for uploading.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXellluX43En7IeppEvST8_xpPM3YSlvTxuUwLq9vIlKTePMDsr8YgTy6AFffrRQFZwFe-_XWbpDm3H38OZzbbL3XXhPK8XOoC2YrsWBlrAanI4zr9dRGJ9wJ8KOeS1GF_LXSyCMmoWy48VBh7mTgK6WOA6r?key=9FkTLzSK8c6u09hHQ6P1FQ)

7.  You can find the destination listed below the files, specified as s3://yourbucketname.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfrC3NUuDbIwcusOTkZA69FiU1I8-zwgpK_vdgpI-MAmrVlP2gY6PyeXTvx8-5qPfGRGGk6ql4FQqL79swn8EhXqmxBXZvq3nV3_LfyPeMu7p3mDQ_iAIrAKm-5djk0iJo-gEA8GWPFwuGqaHwTWn5ypaGp?key=9FkTLzSK8c6u09hHQ6P1FQ)

8.  Next, proceed to click the Upload button to transfer the file to your S3 bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcHhaAfsgmnAxrK_QV_9ujMgiw_QIXrCTvcgwOmOsiy7AaGCTu49Okokg9UOso9i98yu9bFC0_xRaQBglcYuVRGT_FHZeHBjX7j0rGF9DbmzlEucgWxut4ckpG_HFMI4C8bmQAK_JtDCPfp__dDERl1xRs7?key=9FkTLzSK8c6u09hHQ6P1FQ)

You will see a green bar across the top of the page showing Upload succeeded as well as the file you select in the list of Files and folders at the bottom of the page.

## Download and verify your file from the S3 bucket

To ensure your company's backup is reliable, it's crucial to verify that restoring it will function as expected. Let's confirm that your backup is in optimal working condition.

1.  After successfully uploading, click the Close button located at the top-right corner of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdL2ctaoJt7NdczwChDigqWYS-jYIScC9gjaiIpO7z87VEqEvPvi6qyJWjO0Mcctuo-jvWB22c_DQzk6OYkNqlHbwdd0IPSTLjYyDm_C7k_KlJdlllTg-nmhZerWWP-knfcDi8omAbqHEyCj6u0E4WyNJGu?key=9FkTLzSK8c6u09hHQ6P1FQ)

2.  After completing this step, you will be directed to the bucket detail page. Here, you'll find the Objects tab displaying a list of objects in your bucket, including the file you uploaded in the previous challenge.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdz_LlqU-nP0YrpCpvEaFMfWBn58zMP2QrCzujPIAqTPlU4jDIm8fWeLntlUzZldBGXNsKbzi6-tdzIK3Xr_TNVkQZcg5ZFKvbwIw_xjTWemPEpDmtWFMLp8GI2DJjFS2NzL33NYUBS9VI_ZKs4DDMbbfY?key=9FkTLzSK8c6u09hHQ6P1FQ)

3.  Click on the name of that file in the list.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcJ9e3myne9UM2iaBe5KnbR8p0MQWi9IXufePydKfVq521fhCgeR6V3IV82UsWAZne8scl2dDdH0W5xBGoFB_vC48s6PpCAN8081GwCimaJrWBQgKhRtLxDUX-cTh4PoAq3KiJcku_zNwze2iblI1rjlK4?key=9FkTLzSK8c6u09hHQ6P1FQ)

4.  After navigating to the object detail page, locate the dropdown menu titled Object actions at the top right of the page, and click on it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf2-xCc-eDQgyhc_ZRsxZwbQ_UulY9879fSVjiEASUrBPN1eeXuT90wB4FUsa4Swq1xc6zG_m0ZlxD_3mAP_gX5XVk5isWt1tX9w3ANhPz-004towMilsat8dWAwQLspghBqzHU-51o9xDzTpl6fEI0lj6N?key=9FkTLzSK8c6u09hHQ6P1FQ)

5.  From the menu that appears, select the option Download as.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf0hM-VYHGjuAnZjTGkZJrUThY1L9d0HhCQSV49sMORBCAP1nIhp5iD8dKle6FEbpuwMVfxbJXtUG-dufeSxsOIKXtJkSn2o5zcD_r_CYi08BYWgmTeBx-4Mg0_2mUjwaCY9KRsEn8waKA6zHK0e3UyySc?key=9FkTLzSK8c6u09hHQ6P1FQ)

6.  You will receive a modal dialog with instructions to right-click on the link, which represents your filename. In the right-click menu that appears, select Save link as.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXerbiVFojGHns1VrUEkrHFoCMT3FKIUldaEwrTCmZe4GiMvfqYzw-m8tXm05MvhWnkhXfJ_19fzdgcPrAnlZ5Pg7BAdRPdwtGWyDodPr5VrfAAXjCJ5M4mBhbXxO1bbS-a48nksrUalHaaoeRKFtQozB-DN?key=9FkTLzSK8c6u09hHQ6P1FQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeJGBfD_UYI9eR1enIX01c8W074EGpvbWpFOIaDOtnO1LhTmNzRyiwhCO2QaaY7Ebv_dcUZr3WJWD_HvF2mANqYoYwNR1CTj778KErO7-TYLeDvIMWuBIEYdhlzD-2iyjpzZ-aDVwDgjkn6hwT2JhsdF54_?key=9FkTLzSK8c6u09hHQ6P1FQ)

7.  Please use the explore or finder file dialog window to locate a folder on your local hard drive. Click Save to download your file to a location different from where you originally uploaded it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe_aLzyGf6QWWiOfZ2_IXLW45cSILXs6ZCOMaa_9QDZCXDPByWKXSMpvz2sC7Jr-ToxJB7x-fs3-OHZ7JoXwINeKStNwc2y6XahMshz6RVUUpxtqtidr9MfmjDFNmKgf4PoL48DvphpwM6wg5WE2V8q8KJ4?key=9FkTLzSK8c6u09hHQ6P1FQ)

8.  Locate the folder on your local hard drive using either Mac Finder or Windows Explorer, and open the file to ensure it matches the original.

9.  Upon returning to the browser, the initial modal dialog should remain open; you can click Close to navigate back to the object detail page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXerbiVFojGHns1VrUEkrHFoCMT3FKIUldaEwrTCmZe4GiMvfqYzw-m8tXm05MvhWnkhXfJ_19fzdgcPrAnlZ5Pg7BAdRPdwtGWyDodPr5VrfAAXjCJ5M4mBhbXxO1bbS-a48nksrUalHaaoeRKFtQozB-DN?key=9FkTLzSK8c6u09hHQ6P1FQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdDczCEqPpud3Ef7A4aDQbxaf03GCnSfPS5JDbL7ru-XejqBPKtxOFJuygyH1XREVU_gsfs5SdqbIZZaNo8xbA8w1RNF7APnwIOn4vYjs9lmsbEImZaKzNmJIAZc66p_yxN-fGRZDOgUqckEZCoW3GsPTtv?key=9FkTLzSK8c6u09hHQ6P1FQ)

The downloaded file should be the same as the original uploaded file from the previous challenge.

## Delete your file from the S3 bucket

S3 storage incurs costs, so your company requests that you delete older backups to reduce AWS expenses.

1.  You can navigate back to your bucket details page from the object detail page using the breadcrumbs located at the top of the page. Simply click on your bucket's name in the breadcrumbs.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfSf3UM0fbucZTKxD5X1J_bxdQxX9XgNT4Isy4Ge4wq6oLIvt0G5GUxjXIqfbYu3FQIaKlaY3w4qE37LmFaKP0TyNcYajAtMnvh0CYSv4j8ALvuAJ1kNduTsz6KExb_u4Xc8QVywVTiwv_a-k_9zzrTsFWu?key=9FkTLzSK8c6u09hHQ6P1FQ)

2.  Select the checkbox next to the name of your file from the list of objects.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe1BuWc_aC6Yihs2DpeB28QEexVfTsIpufyQu3WWzoVVJ3jsN83e1HrcaU0fhXd78wUhF9AH7a_yBJv3dRWEANAqXD1ODlE7CcqrxOemRxGtcl-QuGouSyNQZk7eBvjk4-XMiBTm9dCn8XAiUMErGfCliI?key=9FkTLzSK8c6u09hHQ6P1FQ)

3.  Please proceed by activating the delete button in the object list menu, then click on Delete.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfPl0ewkxPeECW_VV0HN5bGxeuIRgJC_Xi2r-1LeL58SlLkbGeuwNCsGiVLe9ckQsthMnNgA3aekOZkk9AAeT0yuev3fXwj4wojx_7dThCs8csLjPzgyXSP0OJ2rL2L7aHkkt7Lo-LrnUI-n7Bp92eQ-0bu?key=9FkTLzSK8c6u09hHQ6P1FQ)

4.  Once you proceed, you'll reach a deletion warning page. Here, you'll see the file(s) slated for deletion and a field prompting you to manually enter the phrase permanently delete. This step is part of AWS's process to confirm that the requester understands the irreversible nature of deleting these files.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf81x6P9DrEf2YJJ4j1yfI99BmKOy-OjYG55p0MbRNTFEX99mFMnmXCF2pT6yfhQ-4mrmL1D5PPGRQsM8ngJ_kRO5zcBHz7I0O2n9oUOSkFnZH5YDuZKzTpHnIt1-zmEv5teZgPphzR1S5G3H3W4YysmLI?key=9FkTLzSK8c6u09hHQ6P1FQ)

5.  Once you enter those words in the field, the Delete objects button will become active. Click on Delete objects to remove the file from your bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdGba1_uvZ5dFAzLiwUUzep1Kiaf4d6JXvoVtHmXmZa7VPTLWalHeDOR-xqxGJRtBIIXbiDzj6vR__-mVGpN4lV4KMOlA0EOpjQuFoFBQQfNyIvxJI3_LFS5oQ0p5Gc-dEH0XOviyhJUK2gHJlrAxSmiSKi?key=9FkTLzSK8c6u09hHQ6P1FQ)![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfWPPhLQduVdMNjh8TkLVnRl1Tl0t7v_BOLxVNTQwEzXRTMmE39DqchR-IAhu_9a61zsEOnUHFo5dGBi_3rzNvqoU2HKLLrj0ro1pnrpWAR45wiod_FclnPFQEP6UqAm9SbfNdbIQgNF5Oi7czljs5j149C?key=9FkTLzSK8c6u09hHQ6P1FQ)

After successfully deleting your files, you'll see a green bar confirming the deletion and an empty list of objects at the bottom of the page. Clicking Close will take you back to your bucket's objects list, where your deleted file should no longer appear.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdTmgxoLPUpNYRS2GiilGEIN0lvnb7Xhq04SfGWCCs9FTsvcv5NlS5bEukrkDsNGGPNAixIF39qTh3xB8ACoIeMHXdvvZZFkQ8BwJCZ1_vh523bM70C_Oz814zmdmRXbKKIHN1CsObIbDUklmlZNFyP9Mo?key=9FkTLzSK8c6u09hHQ6P1FQ)
