# Configure Security Groups on AWS EC2 Instances

Security groups are essential components of AWS EC2 instances, serving as virtual firewalls that control the inbound and outbound traffic to your instances. This lab provides a step-by-step guide on how to configure security groups to allow HTTP access to an EC2 instance. Additionally, you will learn how to troubleshoot and adjust network access control lists (ACLs) to ensure that traffic can reach your EC2 instance as intended.

### Why Configure Security Groups on AWS EC2 Instances?

Security is a top priority when managing cloud infrastructure. Security groups allow you to define rules that dictate which traffic is allowed to reach your EC2 instances. Properly configuring these rules is crucial for:

-   **Controlling Access:**  Security groups allow you to restrict access to your EC2 instances to specific IP addresses, ranges, or types of traffic, reducing the attack surface.
-   **Enhancing Security:**  By limiting the types of connections that can be made to your instances, you protect your applications from unauthorized access and potential attacks.
-   **Ensuring Compliance:**  Configuring security groups helps ensure that your infrastructure complies with industry standards and regulations by enforcing strict access controls.

In this lab, you will configure a security group to allow HTTP traffic to a proof-of-concept website hosted on an EC2 instance. You'll also troubleshoot network ACL issues that could prevent traffic from reaching the instance, ensuring that your web server is accessible to users.

### Table of Contents

- [Create Groups Based on Required Access](#create-groups-based-on-required-access)
- [Create Users and Apply Groups](#create-users-and-apply-groups)
- [Create A Custom Policy Access To S3 Bucket Functionality](#create-a-custom-policy-access-to-s3-bucket-functionality)
- [Create a Custom Role for EC2 Instance Access to S3 Bucket](#create-a-custom-role-for-ec2-instance-access-to-s3-bucket)


## Configure a Security Group for HTTP Access

Your organization is transitioning some of its on-premises websites, which run on Linux virtual machines (VMs), to Amazon Web Services (AWS). You need to set up access to a proof-of-concept website that is currently hosted on AWS.

The proof-of-concept deployment consists of:

-   A VPC (Virtual Private Cloud) with a single public subnet named public-subnet

-   An Internet Gateway attached to the public subnet

-   A network access control list configured to block all inbound traffic

-   An Amazon Linux EC2 instance named ec2-web located in the public subnet


Please log into the AWS Management Console and follow these steps to configure the access:

1.  Navigate to the top navigation bar, open the Services menu, and choose EC2 from the Compute category.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfcQFyk8lHm3nKcZxFyyAfLRkr9ZwAaNIG-4LIctdoQhGFJM0SBezcnK7wCe1dFydzVKsa5ZeTgyFZnG9tm93vEPX6TxGLtjr1NEi8P9y6KiPmUUQ1qbVee3LRvplzsFR3BiccMPKYonMHSHpzTas1ubZ1r?key=ml1io2dznJ7FUgQmpBAZqg)

2.  Choose Security groups from the Resources list and then click Create security group.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeNE23Q9XxVwS8LZdMT6rqJ_PJo_AdtXhRjYWog5LYted-2w0LBFKNshU0BlyjJqvux93ZjAfXRu5PLNmcVL55CMUNZyNC8GMWbKXSPioNYncHCQSXDxCNE8pnFfHTcymtRRUfYYzYcyYnsC8rkAau1p4F1?key=ml1io2dznJ7FUgQmpBAZqg)

3.  On the Create Security Group page, start setting up a new security group by providing the following information in the Basic Details section:


-   Security Group Name: Enter pub-ec2-sg

-   Description: Enter Allow public HTTP access to EC2 instances

-   VPC: Select virtual-private-cloud from the dropdown menu


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcZsojLuWeehalkSU7ANO4rH7qvqP_RkITHgtcIeXIsdaTqzN4ZQ75BP5BsFjpmWO6aEFR7zoGdiZ9eISaNENm_h7WHkKXNmdwqq4beXpba6Y4HEz3Dr39gZlzecSrDMJ5OAzXa0xbTruwUZIoxyoHthIM?key=ml1io2dznJ7FUgQmpBAZqg)

4.  In the Inbound rules section, click Add rule to set up a new inbound rule with these details:


-   Type: Select HTTP from the dropdown menu.

-   Source type: Choose Anywhere from the dropdown menu.

-   Description: Input Allow HTTP inbound from Internet.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeJdTYPnH7zDC2DnHpAe9lyVPkABHgEUEZKa7hk32eAjh_sY3CUW2QcGCQmYRqWqu-WGfzhp4hcm8tHclL8S8qK9Ws6FqGFp5G9FZbg6g3k_wqF5nw10B2PAKaiD_ACt8zrX5Y6JlVbtLNTBKQ_Dtacz6jt?key=ml1io2dznJ7FUgQmpBAZqg)

5.  Click Add new tag, then enter Name as the key and pub-ec2-sg as the value. Finally, click Create security group to finish the process.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcyve7cYVvDFK3a1FeXQslCi-QpHcAOEL_w5f7JE6cDE8DpbsWMvxrOU5LTGgQPu-OHM-wnKasWyggT9aHE_V2o2ctAWCXr0MH-CgyWpPg6nN_aJuLRoAbRPWxF_umc6R1GmYqITOxZ-4DSTB4nSLkL_eJZ?key=ml1io2dznJ7FUgQmpBAZqg)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdpyvyWyGgOEzg8z8weoP-BSFp-aqT6HBDWFo3Y-wf1WQybGd-GaPQYfSjjzZHO9TEGQL0pQTjcB1ZfEwy1P492DbY9b65TIEX5QfRSNkrsbTwyr8bpzGyEDQmeMZC95XTjRnsBIT6nZkIKrnzkc5__jkxi?key=ml1io2dznJ7FUgQmpBAZqg)

6.  To link our new security group to our EC2 instances, select Instances from the navigation pane.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf6KxefcWZ4wJ2yAFYQnFuVcdh2HENFwBvVtn6AbzgcdykyU-mVhPYXuKp-wthJKLPf5v1TXDm16yosFPESnQwezKFbtsTH-2SS3SPipHq7WOITGMEKiZ-9N9LbRsscNnFuBnPHdlG8p2yC24Q9ugCUIjM?key=ml1io2dznJ7FUgQmpBAZqg)

7.  Choose ec2-web from the instance list, go to the Actions menu, and select Security > Change security groups


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcmFO-s-bgaGVcEb34LwKg2hjuwwlYGq2EvjH751F7Tv_NlRVA924kvD81bUzR8g4ndb0ysnVFT5A5VV-JOYT52B6rXvxhVcu95x4r63yvTsQi_a17zo7OleMLZZOxSS-6AkdgTcOIM-tUB_tQ2-J1KfvMK?key=ml1io2dznJ7FUgQmpBAZqg)

8.  In the Associated security groups section, choose pub-ec2-sg and then click on Add security group.

9.  Click Remove next to the default security group in the listing, then click Save.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe8iLQJIk-3MndSyiHdMfhsmti2cdp6WwxEER0rR5YZE5q3uECckb-ddxhpeyvZXxDktXxufL__txO4DQgF-I6nSEeDCQ40qftzjWZYMUoiq_xfOfTzAL6aLI-ohW07ilEv-kchj1tnKkhyvCZLK6MIxVcO?key=ml1io2dznJ7FUgQmpBAZqg)

10.  In the instance properties, go to the Security tab and ensure that only pub-ec2-sg appears under Security groups. This confirms that only the new security group will be applied.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdR71l_-Vt2iApRsrlBt_uF6SUaaKGAN3hBj1rg2VLJDqoLwA9g0ATOtLoXpIrZNoFcBL1NykKqBjTVnA-E5H_0krmgBtVElfwBlhLOC7yiWLmmtbDKyelzizPckB2xTcE0dEX9au-HHZssguGPcmovsZs-?key=ml1io2dznJ7FUgQmpBAZqg)

11.  Go to the Details tab of the instance, copy the Public IPv4 DNS value (by clicking the two-square icon next to the name), and paste it into your browser's address bar.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcICC-mDhi4XNfpCVovAAeq14KnwXESAwoHk4C-mKGsBnycK_R3ZAhLPNbObH6hx0lgAokRd-Y00_glmSn4ELdIKjEr5EEhM0IK4Gzl87u_-gh5b6uCIuim53wKM_8jmRZ97O-6DPQXnEGx2igSBHhijLzo?key=ml1io2dznJ7FUgQmpBAZqg)

After a short while, you will encounter a "connection timed out" error, indicating that your website is not accessible to the public. Leave this window open as you'll need it for the upcoming challenge.

You have successfully created and attached a security group to your EC2 instance. However, since traffic is still not reaching your website, you'll need to address this issue.

## Troubleshoot HTTP Access to the EC2 Instance

You believe the issue with HTTP connectivity may be related to the network access control list for your instance’s VPC. You will review and adjust the network access control list as needed to enable HTTP traffic to your website.

From the AWS Management Console, complete the following steps:

1.  From the Services list, choose VPC under Networking & Content Delivery.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXee93ysJITxMc2t0eqcKruONmhtInHkTMgX72LVjBnPdn5SBapINrW1KO-Atw0qoSZwnWPXt9SCMVILVRKZtVjwKr1HQ-1Ud3N15_riA69Q-mMh2fKoIaI5HaqPnqyYdzLTMcBoc60EdhVZ1QXV43_SRo0?key=ml1io2dznJ7FUgQmpBAZqg)

2.  In the VPC Dashboard navigation menu, click on Subnets.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXezf9dNBia8pY5atJ5lPR6qdtw9NpaGlP_RPYO-6Grpkk6pVE_TnneRJ_qLaoZyZb3x-mIOUC2yOP1c5wqFZFiAaQDaWKkHxYM5XGf33L_mY2j2MHaWby-f8pwvhAvnlXO4-kC9zdZKUZbVdbeqDafycOG6?key=ml1io2dznJ7FUgQmpBAZqg)

3.  Select the public-subnet subnet and navigate to the Network ACL tab.


On this tab, locate the access control rule (Rule 10) that blocks all inbound traffic to your instance’s subnet. You will need to remove this rule.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdBi8UgHxkjcspGL9kmrYlcC6NE6GC0pFhd43AL7rSLa1DnQZ9ilU3WGVFRfkcGyAJ6rWd5FUf3-BTfrYaPJW9oE-oGFtIx5Gr1WljhV4fPcqIPmnjZVNr2vTbQGwNMTQ3KmjUI-_G2YtRQs0m5ba1vZgAl?key=ml1io2dznJ7FUgQmpBAZqg)

4.  Next, from the navigation menu, select Network ACLs.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcuFQSZbGCTEXbWsQod2p3W6esH-xc9H4-JHrNUGwwugSkSSCaVmLkOirfbGX7wMsV73gYrGb8n8ukUWf0kD2k7TzU3syRKvzTcS7CML7B_eu2AiRz9VFWhcPqre8JbQYCvQymh043_tqQ-43LbQvTgyC4?key=ml1io2dznJ7FUgQmpBAZqg)

5.  Ensure that the network ACL is selected, then go to the Inbound Rules tab. Look for Rule 10, which is configured to deny all HTTP traffic. This is the rule that needs to be removed.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdChOSqUxyvcbmVX04x2iujIkfvpotnl1OOT6fvajQ7DO1xwZcsSN0XrAcQ5qGsweC1BNipcB5qTdBMoU0tymslIsmRZD9up-scBBUcI8ns_Lwd0cXYYOzM83M_zOX2xjSLyfb3Y7csbMEpDwqCuRK3Znmw?key=ml1io2dznJ7FUgQmpBAZqg)

6.  On the Inbound Rules tab, click Edit inbound rules.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcdkbHmrTah7s4l3H26kwV0B-l8FHRmiCRTJvjuMjtZ1AgdIDBuklJmufQjPTuHWIVvmy69pydbVuOImHYfE4vjWMYI3wg9p25CJa1D4BtCAnwCdpno5pc8GpYDwM_M9MdJo8wvzhho5nypfFCNEJt8rb66?key=ml1io2dznJ7FUgQmpBAZqg)

7.  On the Edit inbound rules page, delete Rule 10 by clicking the X icon on the right side of the row and then click Save. The deny rule will no longer appear under the inbound rules.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeNSVYqoeQbuVxMs-4_zkNTdfR0H0T2nZCUl-t05UEDUPlDLybp3ANjpCPyxpjVvCL0RU70SNw8dinue_KNQjP7jAEbnjZgAJrgk0IA7lW7OfTwS8V3kIQK1d4E-8lnAvWCiDDVEDm1fVzaRM0rmAx3Mtk?key=ml1io2dznJ7FUgQmpBAZqg)

8.  To re-test website access, open the Services menu and go to the EC2 dashboard.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXctw5KX326Hf3H9Hs7SaafakNj3Ap5fOOQaylPtDOBO7_LaObbldEFpsl7cdxMlzPlAfuvhvTvS8SrmaOf7GHoUBOyMEfEC4uhI0Oi6dDHUofwcRHr5xf8zLFohVq4hvSmsApl_aC777p_ppP-v5Zy0ftxl?key=ml1io2dznJ7FUgQmpBAZqg)

9.  From the navigation pane, select Instances and choose ec2-web from the list. This will open the Details tab for the instance.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfOhCr0U_Pg0FZ8FGoA9-9so_hGfvx8p5KH7z3PZXR9WeKAakwW0W3dAHEcWtAOyUGOA74QLnDyZ29SlPLWL1Cxc-2j9RmXQ9e5bwkC6QJgEKKzh6eHdUBPNTqZGHnf-N0X7cSFEaxyayJL1xMNJqPCYdz2?key=ml1io2dznJ7FUgQmpBAZqg)

10.  In the Details tab, copy the Public IPv4 DNS value (click the two-square icon next to the name) and paste it into your browser's address bar.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeEZjXLbEhKLqrWHq6vJBGcXW8r_8Yhdf_0hwoZ-4isKfSazT45mv5l5zgA-BZlYRf_A3PAQ3-bMBZ4M7-_UCZmBNlW-ohn1qFlEtivq_k66YPd6twVR48IeeHqtJZ-L5asBCp_cpGftdnsvkmk3OurXCs?key=ml1io2dznJ7FUgQmpBAZqg)

In your web browser, you’ll see a message similar to "Running on ec2-web-a | Instance-id i-XX," where XX represents the instance ID of your EC2 instance.

Congratulations! You have successfully set up a security group for an EC2 instance and configured network access control rules for traffic within a VPC and its associated subnets. While this example demonstrated HTTP traffic, the same principles can be applied to other types of traffic, such as SSH for host management.
