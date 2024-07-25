# Create and Manage Users with AWS IAM


### Table of Contents  
- [Create Groups Based on Required Access](#create-groups-based-on-required-access)
- [Create Users and Apply Groups](#create-users-and-apply-groups)
- [Create A Custom Policy Access To S3 Bucket Functionality](#create-a-custom-policy-access-to-s3-bucket-functionality)
- [Create a Custom Role for EC2 Instance Access to S3 Bucket](#create-a-custom-role-for-ec2-instance-access-to-s3-bucket)

## Create Groups Based on Required Access

In your organization, there are five distinct groups requiring varying levels of access: AWS Administrators, Developers, ITOPs/DevOps Engineers, Security, and Management (Finance). To efficiently manage permissions, instead of assigning individual permissions to each user, you will create groups corresponding to each access level. This approach ensures that permissions can be scaled effectively.

1.  Click Open AWS console to access the lab environment, then use the provided credentials to log in.


	**Note:**

-   After logging in, check the top-right corner of the console. Ensure the username is prefixed with pluralsight- and the region displayed next to it is "US West (Oregon) us-west-2". If these details are incorrect, you are not logged in with the correct account or in the correct region. Log out of all instances of your personal AWS accounts and repeat the login steps.

-   Throughout the lab, make sure you stay in the US West (Oregon) us-west-2 region. Although much of the lab may appear to work in other regions, you will encounter issues during the final challenge if you do not remain in the correct region, potentially requiring you to redo significant portions of the lab.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe40cxDW3MvfyxwKf3ZoOM8pNNekgmpfkoyXlF--BzOJJibq00dJ3NElnggMA54e39y0fgNukf_UyngZ4wTObWKHcT3TG2B-zM0pTT0SN71tR0OyrOzDZfy6kt4BeIlabPtA9fDQ52lM6iZWlLtMtR7nmlW?key=b8d6kGHxCL787zxHYX9BOw)

2.  In the search bar at the top, enter IAM and then click on the corresponding result.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf5NRbJBHWnP3-CC8Drvi907FjxHDU6wVMo-yFbFixUdwnlID8NlQa0XxfI4AJaelhRt2isVjvUSYlTa85hnH8QhV4asWePUYKA8BqEzqn3nlC8f53Kui_YzU6mG9As9y0hvYGPAQp32Eyqr_KrP4m9JIN9?key=b8d6kGHxCL787zxHYX9BOw)

3.  Select User groups from the menu on the left-hand side.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe-9UVP63VCnVD4qGqkqXAD5_Prfh5WrGQfM4vn6OoaDrCvPONkL-BwHyyvMvdUU_U1d9btt3PRUSH5WTIklCnynLlxcxexniYEZPkWwWWXJb_zVmcED3QODfsXC6vx5dJo7gC64sJAdtkUgKVKmQsSOX4o?key=b8d6kGHxCL787zxHYX9BOw)

4.  Select Create group to open the Create User Group wizard.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeH-C0vPqj0Hxm6Xmw0xW8UR-T5Ck-E7TWzj_JJ2aQRU4ZnHHNjBRGi5tix6ilYSSPrYcKvbAvfQlwWyms7_Fe7uDLknoZslhyIk_eHR8m-apnocVLEWBYp7dODjubXpQ_EVx4QgijB1r7kL69qhpVdN9M6?key=b8d6kGHxCL787zxHYX9BOw)

5.  Update the User group name to Developer.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc2J-Q5ZzX61OkPE3hYMTrMkxFF6fe6be8ioFAH8yqNNjFtHAvZ-bFlU6idRTDEAGF1hKHtynZsv1bjqMklIL-w8fWN9ISKvFLP680ne8XvvS6s5hJhuafjR8B4gcwUOoS8ES9G67HZ8c2lMsqVBMREuPzN?key=b8d6kGHxCL787zxHYX9BOw)

6.  In the Attach permissions policies section, enter AmazonEC2FullAccess into the search box and press Enter. Then, select the checkbox next to the AmazonEC2FullAccess policy to attach it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc2J-Q5ZzX61OkPE3hYMTrMkxFF6fe6be8ioFAH8yqNNjFtHAvZ-bFlU6idRTDEAGF1hKHtynZsv1bjqMklIL-w8fWN9ISKvFLP680ne8XvvS6s5hJhuafjR8B4gcwUOoS8ES9G67HZ8c2lMsqVBMREuPzN?key=b8d6kGHxCL787zxHYX9BOw)

7.  You will now attach a second policy. First, click Clear filters. Then, type AWSCodeBuildDeveloperAccess and check the corresponding policy that appears.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXetQprwW6Ng4BYGv7yGy14XzCEPP_jHz8Vvo1RqHRAWfMMXbPxUsZsyOoCtLrr_BtfQCZSDi2chw5OnTFUI4lcXvUx9MMKT1j_aKkn9Q-aBQF_aTiLsfl7xFdRH_3Sv2DYj6nVItPmmUMTkEXzzsx6ffsk?key=b8d6kGHxCL787zxHYX9BOw)

8.  Select Create group.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfsHvJST4gVhzQ9_9UxI7mNKsHgI16EFKecomg8PXW9Cq0lHEouB6LrYgu3yhclKNassHO2x2kUEfAZ9TXASYkAzO3UM2YhZuOQDD8TJWSJZ7DZFE3ed25CLWiCRqwi8IeokWeCTUHpTFwwP4M79on_9Gw?key=b8d6kGHxCL787zxHYX9BOw)

9.  Repeat the process above to create these four additional groups:


1.  Group Name: Administrators


Policies: AdministratorAccess

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcSg6Tm6swWVoA5QdQAvilUMP6oG8fVe9wcZWA7icmI-hQEu_0XpHiC4pi3RRSfDMIULR6b7uJYrEllhBFKhR6iSX__kTPYHfQVocZKDnwB1r5mu92Kgx6sXSU08fVBj0G8F96zHCNSyUjePAOTqd9mT7Tx?key=b8d6kGHxCL787zxHYX9BOw)

2.  Group Name: DevOpsEngineer


Policies: AmazonEC2FullAccess,  AmazonS3FullAccess

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXelUoZNqPU6V2auwYN7L6JNbkEuw04s_f-pBi2J_OdMBn90dwRoJKbgb9jJsouk_37VYiFFIEGLYym4rLz_7ChrqHJhrH4WWXbSk34GUl-yYyi6xCVvv7MVVes8jWuvnhtzZ_s4zxAbQvKoAU-26WpucFZm?key=b8d6kGHxCL787zxHYX9BOw)

3.  Group Name: Security


Policies: AWSSecurityHubFullAccess,  SecurityAudit

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXefGGVDzoLpqJLvVBBtOVdi4Qitf_TIFtdim3m_hTs2r7thQwq2af_mJRz2sr3Su_yivavQOJTCWjWnUgeTBtt22xwEVQ31GdW7cuClUO3aYbxIwjf5oCrAzYDtXhxxihU_nxhSMm6cmNyE-f0mbCXJETg?key=b8d6kGHxCL787zxHYX9BOw)

4.  Group Name: ITManagement


Policies: Billing

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcncdM3cN9bnazCqwF_oFgrfu0peZ1_b-JED0qeMJhWeGCiagBSHDiWeULIy5WhGE6UG0xGQk1Xa0iVAXKPqDXk-Hb0lPu4fbvXEkpxg6A86QG1T3uoUOfgHGYqko3dDEzDs0cNIeXTHY1_J-L3QqbGRAj8?key=b8d6kGHxCL787zxHYX9BOw)

Once you're done, you'll see all five groups listed at the User groups page.

With all of the groups created, you now are ready to create users!

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcc02h8EPkkOziCJDaf9dguu7qYaxpwmQwvMidtNqWmW0RLh63Qedjq44wwh1TwVxOCb_6OFVhy9WdGuM7hRWwBYLaZYNxl7gEnfwLxVK3wIx52zFmZlOJAY5G0_nQU5hCMPoOuk0CbmVJwoKCS9kLSwJ10?key=b8d6kGHxCL787zxHYX9BOw)

## Create Users and Apply Groups

Now that the global account settings are configured and groups are set up to meet various access needs, it's time to add users to IAM.

To create users with the correct tags and permissions, you'll need specific information for each user. The details required for users who need access to resources in this environment are listed in the table below:

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfGBBLDTdlbEATzmUZo2lEtE-ViSSrXLuhi82WsokzKil67uvvxBjv7fyjzCFUmZI0m9wqJCQnpKDOQamNr8Zaxni-Qg6t5GNco1k5okKiTn7EOOpHhNBR_8_6mia0xhu2V8Uw2PBx3SVfg4qxpEHBWiJey?key=b8d6kGHxCL787zxHYX9BOw)

Here are the emails. Please note that they include the names and teams from the table above, which you can use to copy and paste for the tasks listed below:

-   Martyn.Wilkins@globomantics.com


AWS Administrators

-   Asmaa.Squires@globomantics.com


Developers

-   Allegra.Mcgill@globomantics.com


Dev Ops Engineers

-   Warwick.Ahmad@globomantics.com


IT Management

Note: The row for your name, on the Security team, was excluded.

You are now required to create five users, one for each group.

1.  Click Users from the left-hand menu, then select Add users.


Note: You should be on the Identity and Access Management (IAM) page, where you concluded the previous challenge.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf9uNasnlB1H3YpOOMGkJHov4TzvQbedm3Q0X2qqRMBJJfVVRtq0005wMPIZvljCd-wufIAI8bcnyv1L0JvczlLnKVLUCZQtVslpgeVa4waL0ooDW0RCQ9DaYX81N9oYFjWkb5wsNEDYsLRfM5rfdhpDgXu?key=b8d6kGHxCL787zxHYX9BOw)

2.  Begin with Martyn and input the following details using the table provided:


-   User name: Martyn.Wilkins (This corresponds to the first part of the email address).

-   Access key - Programmatic access: As indicated by Yes in the table, select this option.

-   Password - AWS Management Console access: Ensure that this box is checked for all users in this lab.

-   Autogenerated password and User must create a new password at next sign-in: Leave these options checked.


3.  Proceed to the Next: Permissions


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc2yCLqMQrQ-ns4AsL9UOnWsD7FPkt5i9U0NaTe-D7wmNAQre2O_Od7ud1UO8wdL2-sWxI8EwRYrRKK1It9eC3DyN58-SZmDdb5tX_kQANmqL-CIMqqqkt_1K7WO6pNPv240tpx2wDkDXUEenL-AcgzVZyO?key=b8d6kGHxCL787zxHYX9BOw)

4.  Check the box for the Administrators group, then click Next: Tags.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdjDeWiV1cJTl_0b4Z-Z5k7uKdBYzLex6ertMePer0rmYsHNdaequYy-jCaNGaGZUoodSIJh6tkEgmQeE0B3HCW1UK1lGfPbhOan7Qgk32A99LVE0h0J58QDo-_6_vm6FbO7KzgKnsqLrOOteQg1gBJpavE?key=b8d6kGHxCL787zxHYX9BOw)

5.  In the Key section, enter Email.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf8dZNT8Bh4JOF2ECAkq3vwB_gpceWztZJGgz0mmoJmPssgXJ5Xv9Dq1yZPkG-A9Jp7d4wjXjKEt4Jh5U3G00iGw7o3QtTnQlzIegkR9eVJzBdbPbPgeKhnOKSFvbJBJ4GgCTQm4QME-EsinbBOjPBG4zQl?key=b8d6kGHxCL787zxHYX9BOw)

6.  Please paste the provided email for Martyn into the Value field above.



![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeZI91MOi0Cy37AOtQHJfRdKmiSXrTvyqfRniFbNRHRmsNpkNtHL6JWaeYgQdKj0e67DRARK6-rDQeVZHmD_kOO8XJcjnnOvpUvokSj78Lp8-IA6-g0cV_gJhkakUCOXwwVhoNeT0-vG86xHqWrWSzzliM?key=b8d6kGHxCL787zxHYX9BOw)

7.  Enter Team as the next Key and set its Value to AWS Administrators.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf6EmIw-4uVfnWYTw9CSO7uHhSATkWSy-RcB7dbM4LLPDwi5EbhYm67Wb7MudI-LddV1A6yloIELFu6jURje4rUIzeXWtnQhQeZ_5kd6KOPWN1I7YkgEpEHmIto5tuxbPDNvl-FNbgXw_EFmZWLEDFSIbW3?key=b8d6kGHxCL787zxHYX9BOw)

8.  Click Next: Review and verify the user details to ensure their accuracy. Then, click Create user.


Note: After adding the user, a Success banner will appear on the Add user page, where you can find the sign-in link to the AWS Management Console and download the access keys. This is the only opportunity to download these keys, so it's best practice to keep a record of them offline. This step is not required for this lab.

Although not necessary for this lab, you would typically send the user their new account details by clicking "Send email" on the far right of the table.

This action will only succeed if AWS Simple Email Service (SES) is correctly configured. SES is not included in this lab. The email sent would include the user's access information and the link required to log in to the organization’s console. Here is an example of the email that would be sent:

	Hello,

	You have been given access to the AWS Management Console for the Amazon Web Services account with the ID ending in 2825. You can get started by using the sign-in information provided below.

	-------------------------------------------------

	Sign-in URL: https://676287162825.signin.aws.amazon.com/console

	User name:

	Your initial sign-in password will be provided to you by your AWS account administrator, separately from this email. When you sign in for the first time, you must change your password.

	-------------------------------------------------

	Stay connected with AWS by creating a profile:

	https://pages.awscloud.com/IAM-communication-preferences.html

	Sincerely,

	Your AWS Account Administrator

	You would need to also separately send the user their temporary password.

9.  Click Close.

10.  Follow the same procedure for each of the remaining four users, ensuring that each user is assigned to the appropriate Group according to their team. Also, verify whether they require programmatic access.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdDzIvWU5fwaL-msLXaX57W_JGsXAH2GqAPd0lqo6ilbjWsJoKRaAU8t4ZMl51CYLd7aYm2lhu39gU2YGJDL7V2igJqecInNIBdZpILwR8_Fl-195R4kfZEKTLtkV5bURoNuzg8a75q-rKKKH4_EgBjnG4f?key=b8d6kGHxCL787zxHYX9BOw)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMGmzyirg-_nxEDBGLwyzGhkCnf2HR19xaEr0xPx1mT0nOeC9oHuM87AmRTS8aod1tehPux2cC21xh-GRbSoaBU-ZlC97oAzvgVafreMbBDjvRkvB19adrRLHyl66FWEGnIw3wUX1y11tSOime0UpIqCs?key=b8d6kGHxCL787zxHYX9BOw)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdy4_1jWj7tVY-uL6GvyIWVWhrPCN5zufJVXqiayE3t63N3jY6ubrI6nUqe7L7_CF6WrBRkc2geFXdv2ulqHeuwlZEVz1wtfQBI57T50vS4qzFyn9TY7zhCSaaXusMwwOVhGT1FG6qRBC1XHDyyWPQVvJc5?key=b8d6kGHxCL787zxHYX9BOw)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdwjU-_m6_obXCMyV7KALXhChQ-HETtzrcy1YXE4rSCmI-JeFyLMsKl8le4ka0egU-GxyCEmd8VT0y2zaQGIcwB8IaRThsg7U30Ib9cS2IZYx9cDvHDnSguAxzWvzR6R2VbXob9kTjVUXzXyLmhvjLB3ac?key=b8d6kGHxCL787zxHYX9BOw)

11.  Please note that you will be a single user within the Security Group, similar to Aaron in the screenshot below.


Upon completion, there will be a total of five users, including yourself.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd_gb_s6nXpNlAqrHw1l5TdsXAztRCTuExMhMkGDSlkpnJFm8n_GHb7n7KkmyRsAvvaiRl5vFjihxOs81hTGg7fqRz537snSSEArkmLMEFQXdRuXN6XPoNdzyOGwReN4dbExpU2_5mWP1VF7RmDuYcoCqPq?key=b8d6kGHxCL787zxHYX9BOw)

Note:

-   You will encounter a sixth user corresponding to the Pluralsight-prefixed user provided by this lab.

-   In a real-world scenario, companies typically require specific information for each user. Tags are where this information is entered. It’s crucial to maintain consistency by adhering to a policy for each user created. This underscores the importance of restricting administrative privileges to a select group who genuinely needs the ability to create accounts.

-   When adding each user, you can click "Download .csv" on the Add User page to save these credentials to an offline encrypted drive. This is advisable for future reference, such as recovering work after an employee's departure or for legal forensic investigations if the employee is suspected of illicit activity.


## Create A Custom Policy Access To S3 Bucket Functionality

In this challenge, you need to manage the migration of an application to AWS that involves two pre-existing resources: an EC2 Instance and an S3 Bucket. The EC2 Instance is running an application that must access data from the S3 Bucket without requiring a user to be logged in. Importantly, the EC2 Instance should only have access to the specified S3 Bucket and no other resources or S3 Buckets, and no other EC2 Instances should have access to this S3 Bucket.

Given the heightened concern about the security of the sensitive data stored in the S3 Bucket—especially in light of recent news about S3 data breaches—it is crucial to ensure tight access controls.

To achieve this, you need to assign a role to the EC2 Instance with specific policies that grant the required granular permissions. This process is similar to creating groups for user assignments, where you will need to develop a policy to attach to the role to enforce appropriate access controls.

1.  Click on Policies in the left-hand menu.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcQLAX6RiI9SQuk0c2rSWintqbqASArXxIlAT6pEHO3m3WFQFJA4lEDlHUBQf3vdDmGu-N5GTXV-XwP8caz6QDdXTcyfIYArr95VWqDosaH0b9DYdiPSPjCGjlGuV8F9MEzdRkwS96mEB-KI5mBqWmBwvKm?key=b8d6kGHxCL787zxHYX9BOw)

2.  Press the Create Policy button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfg-0gq5QnVuRkQMKvUzCeyLQk0nQiG_XU0AuZeZ4BSf_9zZU1HofaPiBvdKIj49m4WJ2b4gu4io_YQHk7krbbsfy2_1lMLdtcC1U9bodPkV_mmvNKTREnuwrwaipqbV63FYzJxpu0S5zT8sxfRnLuBYg8F?key=b8d6kGHxCL787zxHYX9BOw)

3.  Select Choose a service, enter S3, and then click on it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf4oM5axz9sVYLvqMCiaV84fDq533J_gDoS69hP64xKzNuquqdK8FBnBgZcziAMHdDEEGp4NLrOi6uxpROuOv0eWIEhlolAF-HZg9RWuPkW6EpNM_LbxsT7-hyxXJ-f3RtUHDcvKbKwEtidEPXbO7YKfoZ3?key=b8d6kGHxCL787zxHYX9BOw)

4.  Choose Read under the Access Level option.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdDd6j0dXYGwtyRr2VmKl4TwDSDHo89SpGpbsDxesr1ktyJw-FZVck8muTbiVDckgX_32q-u7IJnn5A449d3hPCEoWd3P9EvnTbB2i1grPTN6TGpgujCE9UIox8DDRqzyDdRmdYQK-qAyb1RINw2GyuMylf?key=b8d6kGHxCL787zxHYX9BOw)

5.  Open the Resources section, keep Specific selected, and then click Add ARN under the bucket.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdkHVdGDph2C2XU_5tAiFRvv7OomVTZaRE19hVdzs1HD4X9y5D6Iq6s963v1U1oaTAjGjgoGVj-XDIguVZ464nBTz30gFMQoy2C0NPcNUjcH1Qm5tvEo7ZfOAgrQtK0sibsntc9cUp4ti3WDC_9F3EU5nNx?key=b8d6kGHxCL787zxHYX9BOw)

6.  In the Add ARN(s) pop-up, enter sensitive-globo-bucket-* in the Bucket name field ( this will append to the ARN prefix, resulting in the full ARN arn:aws:s3:::sensitive-globo-bucket-*), then, click Add.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXekemI34bHkL1ToA6gl6N38FDUZrfjJR5W52Uv_Mpf4wvgezWsBl2xjQUx0UzvILs-LRuvguUDkOeaeg8y3mxWxWaRtNAazY2MOEE5clKI1Vyc18UnGweHXuQW3Tgs8byi3H94y3h92UJB-vCU4wHXAbn5g?key=b8d6kGHxCL787zxHYX9BOw)

7.  For accesspoint, job, and object, check the Any box.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeoJFsB68ZKLp6VHSUVCJh1w7n6O_7tJ5BQHJ1InqwL0S59TD7mssXeVfmOuKxXcd_WqlYlnrpM3jjiiL3z7gQKeGbn-sB4Ks_TPGqX8vkY0YA6QD35nEkP1dSKSwVIaY2N_NsityPzsN3m5vNOnUge6LQg?key=b8d6kGHxCL787zxHYX9BOw)

Note: The screenshot above may vary slightly, but please keep in mind that some resources, like the multi-region ones, will not require any checks.

8.  Expand the Request Conditions section, select Source IP, and input the private IP address of the EC2 instance, 172.31.37.38 (This EC2 instance was created for you when you began the lab.)


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf08Wj7HpVbFfD06dqgdyg90Cba2osLb0AM_e3ZEKB5KwfLUeKu-VoY2oHVk9hcgbQiglEMNiz8x0Cf-n0dlU2mKl7RJ-tMHCNyQEXfh7ZC9IW9fcLVHivFmWtN8IA9s2eh7gLkaUpWDSipjtHKpVdGTAdk?key=b8d6kGHxCL787zxHYX9BOw)

9.  Click Next: Tags, then click Next:Review.

10.  On the Create Policy page, provide the policy Name as S3-Sensitive-Appdata, and include a Description stating Restricting access to the S3 bucket containing customer data by IP address.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcq56B5LCdc0Q9jvdMn_HDhn-3EFH9NQmWboMcNa3E7jTp4CdBl0L-xC0ZAtVV40ag8INhyUkG7rsff_MGcTpTqzu8LcMk0Coyfs3u7Hgd4Fy0fqM9meGJSRP3ZFU5corENySfrHlhA3TjbKTHDJ2nDBYbR?key=b8d6kGHxCL787zxHYX9BOw)

11.  Then click Create policy.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd3plCAJknwSMCHYnNBSge126FLfedLgPkuDwnWzigmVzgRD2XjvYU7nBaXouL22mfCzTNwbebzpp8kWQJq8mlylDQyNdBkszIGRPrkW-Nzpr7um7hhskmGF4TK5XUx61tzyax5s8ZHzXHCdyGD0t-YNGpU?key=b8d6kGHxCL787zxHYX9BOw)

You'll notice a message at the top of the page indicating that S3-Sensitive-Appdata has been created.

That's it! The policy is now created and ready to be assigned to a role.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeaP-BkU6BtPeSndCYACCXWkAH243IZ9lVijmSxV_Sdi0NiRTHE7BwwVrJw_LCwzTZagisAwfKPr44ZzbZ6ZMi_J7JhONQa1OyDUMsob9257lSFAH2zcMqC_7OoD2uOvOkLk5HI8aUFNBZD2CfIC8U1sO4K?key=b8d6kGHxCL787zxHYX9BOw)



## Create a Custom Role for EC2 Instance Access to S3 Bucket

A policy alone is ineffective unless it is associated with a specific role, and that role is then linked to the resource requesting access. Roles are employed to grant temporary permissions to users, applications, or services that do not have permanent credentials for accessing your AWS resources. For instance, this might include users from different accounts or, in this scenario, an EC2 instance running an application that requires access to read sensitive data stored in an S3 bucket.

1.  Click on Roles in the left-hand menu.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdpaUU7mNmzJidqPH_zIxonowOtjtWUckNBpo_wpnS9zuZECp9n-xIWJCkFEe7s7Ul6HC1NZfhETZhnrP_yCK5WRMZMME2U6xG9JHN8RgAjSL1BM8wyQ4nNK6-f93VTPDdQTbV7jgfeRN7nFJn6gBuwKmQA?key=b8d6kGHxCL787zxHYX9BOw)

2.  Click Create role to begin.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfQstU-U1V7CeQ5G79obMcqvFPj4hXQNlhcypWFFf2g24yRHqD4Uwon3tvSgm22f1hr-3281XY9LRb14siTa4DnFnMXnobSkhbqyMh_z2UuxSkl3VASNetpSW48EZ3e0XsqDZADvU9Xp6eVvnND20uOywKi?key=b8d6kGHxCL787zxHYX9BOw)

3.  Set the type of trusted entity to AWS service. Then, under Choose a use case, select EC2.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdW54Tw9W9mmAdCHz2vzZ-Gx3OkCN87sucBIra4m5n2zUGsEigr0SP-uhYM-XVaz2m4ukq9Hqwrt2Lli2gbmJoLediAooFnrE3r0w1orGfQSWirMPOU9QqR5hh3vA0qYeCnZ0jO-k2T86GmCQgrGO0ezvU0?key=b8d6kGHxCL787zxHYX9BOw)

In the lower-right click Next.

4.  Enter S3 in the search box and select the checkbox next to the S3-Sensitive-Appdata policy (you might need to scroll down slightly to find it). Then click Next to proceed.


Note: This action will attach the policy that was created earlier.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcSXoa1fdkYU43AAil5rzLXBZqxIKS7V_Pn36eKBZWOJAZ3SSioLr-kW5trf8lBvOsuXx1iZ3Rhreu3NpQDPSYA5RBfLY4KPMj8t4GA92BZoYw1eVDpkP3rtdmnOY31qortRquT0Gna63ZgpEocUfpSRQO5?key=b8d6kGHxCL787zxHYX9BOw)

5.  Provide the Role name as EC2-read-sensitiveS3 and leave the role description unchanged.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe-2UTu1SOMTtxZQZJeAX7-SRHOkZtJg2G5Zmuwn2VrzHoMb4yWiRYmlweH_EriQUabVzE6SuL0I3zTMPzPZWiV8HqCZKsr8eSvrWPVfeaQUwy3EjVX_VVNCxlDAL0RFJNwQ_D-0S5GOfQz3u7nFk0eXeQ?key=b8d6kGHxCL787zxHYX9BOw)

6.  Create a tag with the Key  type and the Value  service, then click on Create role.


Note: After creating the role, you'll need to assign it to the resource that will assume the role—in this case, the EC2 instance. This will be done shortly.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcomktOJjqbnzksa4HhxiG-8Mol9mhYuEuTvPboqEgyoUF0Lvw1jE0Lrz4ttoa4qmcJ3rT_or9yGiqJfox8Sx5NNLkU1FPfOGw5oqDQEI1oKvfVjiHmkEnfewwGRcuWcv1Doa9nLOge6qLSpRyVJ7PE-sAP?key=b8d6kGHxCL787zxHYX9BOw)

7.  Type EC2 into the search bar at the top of the page and select it from the results.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcTIhUIrgBxECptFSDF51epqQxk9x0ZtmiQafAuBUx2HRH2GOVAAEZKQPLw2XjGjYQZFms7M43NCTxFi1muv-j31iXU5aejJxddVlGeuHFBc8lGoN-7TP0raLw1-h5tlKzWBhpm8ONzSyQo9qgroLGv-7D3?key=b8d6kGHxCL787zxHYX9BOw)

8.  Click on Instances from the Instances section in the left-hand menu.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd4U_bsJqsrSR_APbtGQWLmk2rTWBSJxE6CtcaiAzIOcBVgL5Rhuu206g2TS5iEqyRK33Mb1E2TePMOG2pBP1gbvoIQiYsCNkSJrkCY4hBADErn0dlD_q6eddSUGg0-lvdP269_p_Yv_jVZr3gsE24AlT0K?key=b8d6kGHxCL787zxHYX9BOw)

9.  You might not see any instances. If that’s the case, it may be because AWS has changed your region. In the upper-right corner, click the drop-down menu next to the Pluralsight username you used to log in, and select US West (Oregon) us-west-2.

10.  On the Instances page, select the checkbox for the sole instance listed.

11.  Click Actions > Security > Modify IAM role.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeYvsGMoiFyt75L8Lqix6cP-2VaIxRcKD1lTu0EKbLruo3atm30qcKPKBpRKzhEGJGG7eoI0SvoQ0clGRJbBEJCFL-izYfeyoWHxidWimw4NVRr7CdXsTJ4DUlsYOmH9wuP053HYNyrcWJ3ccV_IUiJEZ9P?key=b8d6kGHxCL787zxHYX9BOw)

12.  Open the IAM role drop-down menu and choose EC2-read-sensitiveS3.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXediu97mjMfDJ46W7_i4coXF1ulrOsppVHMo29dgPG-u2iUuXzAdMJSLM6TbyqsL47A5NxkKBXC9sCZAVAzZmmBO5q8XuTImrf9fso8ML8fLU8BBh04rI8aMFbjNKJiNb4dh1Cwrg3FELVe_NkA2D4bnFpV?key=b8d6kGHxCL787zxHYX9BOw)

13.  Click Save.

14.  On the EC2 Instances page, select the instance (if necessary). Scroll to the bottom of the page and go to the Security tab, where you should see the IAM Role value indicating that the EC2-read-sensitiveS3 policy has been applied. If you don’t see this, click the refresh button, select the EC2 instance again, and check the Security tab.


This process completes the assignment of the role and associated permissions needed to safeguard sensitive data. If you need to scale the application, you can update the IP settings to a range of IPs within a protected Security Group and apply this same role to multiple EC2 instances as needed.
