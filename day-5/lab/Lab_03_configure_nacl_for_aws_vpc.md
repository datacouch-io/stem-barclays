# Configure a Network Access Control List (NACL) for an AWS VPC

Network Access Control Lists (NACLs) in AWS are essential tools for enhancing security within your Virtual Private Cloud (VPC). They function as stateless firewalls that allow or deny traffic to and from your subnets. Unlike security groups, which are associated with instances, NACLs are associated with subnets, providing an additional layer of security control.

### Why Configure NACLs in AWS VPC?

Configuring NACLs is crucial for the following reasons:

1.  **Enhanced Security:**  NACLs help enforce strict traffic controls at the subnet level, allowing or denying traffic based on IP addresses, protocols, and ports.
2.  **Fine-Grained Control:**  With NACLs, you can implement detailed security policies, such as allowing traffic on specific ports while blocking others, which might be necessary for compliance or security best practices.
3.  **Layered Security:**  NACLs provide an additional security layer that complements security groups, offering more comprehensive protection for your AWS resources.

In this lab, you will explore the default NACL behavior, create custom NACLs, and associate them with subnets to enforce specific security policies. This hands-on approach will deepen your understanding of how NACLs operate within an AWS environment and how they can be configured to meet the security needs of your organization.

### Table of Contents

- [Understanding the Default NACL](#understanding-the-default-nacl)
- [Add a Custom NACL to a Subnet in the VPC](#add-a-custom-nacl-to-a-subnet-in-the-vpc)

## Understanding the Default NACL

In this scenario, you assume the role of IT administrator at Globomantics. Your colleague has set up a new VPC environment, and your task is to assess how network security is managed for the Virtual Machines within this new VPC.

The configuration in place includes:

-   A newly created VPC named Pluralsight-AWS-LAB

-   An EC2 instance Server-A1, listening on port 80 and associated with AWS-Lab-Subnet-A

-   An EC2 instance Server-A2, listening on port 8080 and also associated with AWS-Lab-Subnet-A

-   AWS-Lab-Subnet-A connected to an Internet Gateway

-   All EC2 instances are configured with a Security Group that permits all inbound and outbound traffic.




1.  To access the AWS Console, click Open AWS console to the right of this text and log in using the provided credentials.


Note: Please ensure that the region displayed in the upper-right corner of the AWS Console is set to Oregon (US West (Oregon) us-west-2) throughout this lab.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXehUsTWeE3e9Q4sIvpTtKrOwyKXlxheBEVSr3qosKLjq4Rf0mgTIZ4TPlTJuYbPrvTbyE4FBTQ4a8-Ny9dG2AJh5pIwNPJJYsRjbNoDuwNBXnu59Lc9j1rsDP9hkmRMZhviWAoT-UE40ZrrS2Io0zu4Lxlf?key=BVoK9VoQXU5AVMd3Yw73QQ)

2.  In the search bar at the top of the AWS homepage, type VPC and select VPC Isolated Cloud Resources.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXduJjzs0ZfyNGl1yJMHx9SrFjF7GrUNZZSo-QF19HOeus6cEOdXxXcJdKbUCupPnJoBJCPhFBYX1P6TFJI89Ya4KqMSM7qxpjVOQlZd5Pc0GVhY4dza6PKyheaeHgN62AUpPE0N7LXRsEOLB7b0qNmvBv4?key=BVoK9VoQXU5AVMd3Yw73QQ)

3.  Next, on the left-side menu, click Network ACLs to navigate to the AWS NACL Home Page. In the central area of the page, you will see a list of currently configured NACL objects. Click on the Network ACL ID associated with a VPC ID similar to vpc-<random-string>/Pluralsight-AWS-LAB.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcLqybiF5DGdopw2eGXf70a1nYHoAjg8nK71rBCEtrJ9n-E-j_POkMY8mr_3h1__VmNeoHAY7DMpRC8Ogx5BVzjQjUBstyDK62H1HOpvEdTNCAfwhFe--C-AC4FWHjwhuevitFkAuyP_UbGTxmOibnRf5A1?key=BVoK9VoQXU5AVMd3Yw73QQ)

4.  At the bottom of the window, review the Inbound Rules tab to view the listed rules.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXclOFRI2Mybgklr7LiP6Cb4uQlSpl60hDzRd6yh3uUJDLuTSMlk2RZdLOo2JQyHke9yQwNeMsr5qqIkKsIr0HCGhaOgCb_doX2khKmYdUiiXqZveSNhTpMX_TBOsTJH_vDft0fmL8tAOZ12OOXdyXdSIWfu?key=BVoK9VoQXU5AVMd3Yw73QQ)

5.  Then, click on the Outbound Rules tab to see the set of rules presented there.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc5-J_IC-3j39PZDKzaM1YwAmvft_IBdHdM-KI4amRTa9mWGbyHqomUnbyJ81fbBidsI10RpV80VoCu7vT3ijo1Zvw4gf1bxmAxH7Ex9PcqLNwSrmxrIub5LGZ6NpWFDPopLyGCdVGw8R-E9D4eTSPS0CA?key=BVoK9VoQXU5AVMd3Yw73QQ)

By default, the Network Access Control List (NACL) is created automatically when a Virtual Private Cloud (VPC) is set up and is associated with all subnets within the VPC. This default NACL permits unrestricted traffic in both directions for all networks within the VPC. Consequently, without additional configuration, your EC2 instances with public IPv4 addresses are vulnerable to various threats from the public internet.

6.  In the AWS homepage search bar at the top, type EC2 and select EC2 Virtual Servers in the Cloud.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf-qwrW9Shgk1cK2W4vBnOXbrFGwt9e3AjCahO0Nj183_6fwQsU2ZSfJHy3EBEiEqYoM9fr0UZL61jdGRidc0zTCaxgmnf_mPZDW9WbP5BllgqT0ZC0Gh-fru5LrmSgUkcZdAuC4pmIBuZnmZLa0lPEktzC?key=BVoK9VoQXU5AVMd3Yw73QQ)

7.  From the left menu, click on Instances.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcQ3vSYuq1v1kPFyl1mhltSEazB9jh6dQNrgj8503EHqky6w2fC55jCvt-V4Ud81PQdbCvxxuRTAFQnClNbOnGhTorX8Wdbf3udgj3hV3VVI8kUCx-QTdSWDZ_tX5kD59WubekYOJaVQ8brLX_gFLOlk1w?key=BVoK9VoQXU5AVMd3Yw73QQ)

8.  Locate the Server-A1 EC2 instance, check its box, then scroll right to the Public IPv4 address column and note the IP address listed there. This address will be referred to as Server-A1-IPv4 in the subsequent sections of this lab.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeFKtcaRQDGoa1jgDwAOBctmwHpjmLKI7vSoHsD7atQ5y5KX_bXpfTzQDLwZSf_-RwH2ct85VpwhJXVIOkXNtJuCwEFAnpmLQgfv2mw1i0dhWw_dIymNfLSEWW3wu2zaDPfGTeuGqU0Ki1b9Ec5OCHTPmk7?key=BVoK9VoQXU5AVMd3Yw73QQ)

9.  Next, select the Server-A2 EC2 instance, scroll to the Public IPv4 address column, and record the corresponding IP address. This address will be identified as Server-A2-IPv4 in the following sections.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcnTYdCRejEAFjTYCf2ooBCAygXj4hQ36oBYQDncqlPyPVqE59SpnJHTimKBqiKIvnbkY0QCqN9QxAA3xLAGghdieZoPqjSgthJdv4rX63EuPlwZCCTFlvFPLL7vcLJFw8fBlIW1o7m3w7JJcJYZwwKaclj?key=BVoK9VoQXU5AVMd3Yw73QQ)

10.  Replace <Server-A1-IPv4> in the URL below with the Server-A1-IPv4 address you noted earlier, and open this URL in a new browser tab:

	http://<Server-A1-IPv4>/home/ec2-user/
You should see a web page displaying:

Welcome to Pluralsight AWS LAB

This Service runs on TCP port = 80

This is Server-A1

This verifies that the default Network ACL (automatically created with VPC and associated with all its subnets) permits all inbound traffic within the VPC.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe169h7JLH7XqW6-NT0npJ6lFqF5OvSxMQDDH-dDBWicFuob-6xxHXLj_3GfytkmfUjricTOeiiuAoQYNr1E8y_jZRltdiAWkXKhP1_eFv_e_NTA50dbbtb2R5QkqJQczLKmqdaUddaMyA2dxUD5hsORZY?key=BVoK9VoQXU5AVMd3Yw73QQ)

11.  Open a new browser tab and visit the following URL, replacing <Server-A2-IPv4> with the address you recorded earlier:

	http://<Server-A2-IPv4>:8080/home/ec2-user/

The page should display:

Welcome to Pluralsight AWS LAB

This Service runs on TCP port = 8080

This is Server-A2

This confirms that the default Network ACL allows all inbound traffic in the VPC.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd0HxSzFLkubF3Q_d0MHuQPl8iAQ2qfaawnwq7GRQ3sYS0Cb5FSCwEDXpgg3jBi_eaWBVVugA0IAutT0G47ccYHKjlkJeMNYjA6k20Ti_KPmnfk8cYi_vcn40JhPx-ZxWmpokqZzVbkK50iHIMAkPgAgpe-?key=BVoK9VoQXU5AVMd3Yw73QQ)

12.  Open a terminal on your machine and send a ping request to Server-A1-IPv4 (e.g., ping 54.185.239.79). You should receive four consecutive replies from the target address.

13.  Similarly, send a ping request to Server-A2-IPv4 and expect four consecutive replies.

These examples illustrate that the default Network ACL permits ICMP traffic inbound to the VPC.

14.  Back on the AWS dashboard under the EC2 Instances page, right-click on the Server-A1 EC2 instance. Select Connect from the pop-up menu. In the new window that appears, go to the Session Manager tab and click the orange Connect button.


A new window will open, providing a shell to your EC2 instance.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfCO5LyQ6jGhCFX--r2SjndFw7cwvWLf-S8KBBIw8BzVUzq4s-jy9WK4J3TIF3ZfWDugEdf9REt25-5gY6XhHgDJ8fmiNwCFGKOC1ezffoqgRIlNOVic_FRVa6EuodnhjQwXTCSdn8BZMMwsJso2mKTr-Q?key=BVoK9VoQXU5AVMd3Yw73QQ)

15.  Execute the following command:


time curl -I [https://www.google.it](https://www.google.it/)

When performing an HTTP GET request from an EC2 server, we anticipate receiving a correct response. We are using CURL to generate the HTTP request in the Linux shell with the command time curl -I https://www.google.it.

The expected outcome of the final test should display the following output:

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdD8dXdAdJcuvyOaOD9O5YgTvMtcDNdtlJszhQ5PjRCvGL0H43TwI2U_LmTYzsn_iucJi23vdxo_Y-xlsJuqg2p-jRjTu-HttUrXOdalB_RVoFZqg2x3NdP-FlktzkkrggS9gr63a0jpTBz7XyGTOr3MjRn?key=BVoK9VoQXU5AVMd3Yw73QQ)

This final test showcases that the default Network ACL allows all traffic in the VPC Outbound direction.

## Add a Custom NACL to a Subnet in the VPC

In this scenario, you are acting as the IT administrator for Globomantics. Your objective is to implement a new security policy within your AWS environment. The policy includes the following primary rules:

-   Users on the public internet should be able to access web services exposed on the standard HTTP port. However, HTTP traffic over non-standard ports (such as port 8080) must be blocked.

-   Web servers, which are hosted on AWS EC2 instances, should not be allowed to initiate outbound HTTP sessions.

-   All other types of traffic should be denied in both directions.


The scenario is configured with the following setup:

-   A newly created VPC named Pluralsight-AWS-LAB.

-   EC2 instance Server-A1, listening on port 80, connected to AWS-Lab-Subnet-A.

-   EC2 instance Server-A2, listening on port 8080, connected to AWS-Lab-Subnet-A.

-   AWS-Lab-Subnet-A is linked to an Internet Gateway.

-   All EC2 instances are assigned a Security Group that currently permits all inbound and outbound traffic.




1.  In the AWS console tab, use the search bar to find the VPC service.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcXi2YWCXa20-Dae652hCVjf6LmNb_FaQzIvvjRJk6hc4CaNC2O22ora1gKfi2VJoq5SQIeHpqhPwnW-SdprDY6YoFp65pYJdJlKnSXZhqtBwI7t5t7FHnRxUzNgasIpqUHTYI8ueL22kQm8uORyR0RDieR?key=BVoK9VoQXU5AVMd3Yw73QQ)

2.  From the left-hand menu, select Network ACLs. This will take you to the AWS Network ACL Home Page. Click on the Create network ACL button in the upper-right corner.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeDynN3yO2gtXl45hn3QFIlAHlAehfaDSQAaVMvMKU4exBkSAhID326l8KZJGg6Ex7t43WNlWEABM7VfhJbKy4Sy5qi7JpZqtyZfI11zDguieAgZY5XlDDFZgQZEIWoQ4_54un1JJ9TIjo41lUR5QFt7I4?key=BVoK9VoQXU5AVMd3Yw73QQ)

3.  Enter Pluralsight-AWS-LAB-NACL-1 as the name. In the dropdown menu for VPC, choose the VPC with the name ending in Pluralsight-AWS-LAB, and then click Create network ACL button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdo3IpJXNI_43ijRXg-i0cJHh1giJJtvgwlG8x5m6CY29ddOg3K1CbzJW47p0mXmYJ5aW0HC1DI893Elv30mC4lt4wTKi9hhW1DU0EwOqdLt3YNM35xlym1JLGZWnByaSelA_gIy49V8d3CqvbK3HZz3Edu?key=BVoK9VoQXU5AVMd3Yw73QQ)

4.  From the list of Network ACLs, check the box next to Pluralsight-AWS-LAB-NACL-1 to view its details in the lower section of the window.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeRUyhJSoOQs2nWMQl8g72GVPllODn9_9Ti4UK6qQAPYZfBbnN1bkTo0juASPv5Bp-X7u_yJH1gfir_tSI0blHda4Wdsly2GnMSqZKebjPQ5rNdWaKfetmXtDV403KhXg1dGKd4xwtR-d7npol6I780sqc?key=BVoK9VoQXU5AVMd3Yw73QQ)

5.  Go to the Inbound rules tab and click Edit inbound rules.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcsicop7kZLjVObzd4eX6oOILDwQOv9FFRyXYtfBlsKtcKPneQF8crW_fRzSPlMr3T2ukdl58r5ntSveFdjloCUMJP_VM0VLJW_f6xi807Mq0YlTKZjLBx0PpU8Ehe9IdzUdbFdfqTf-yiFR7xZKqx3ikg?key=BVoK9VoQXU5AVMd3Yw73QQ)

6.  Click the Add new rule button and configure it as follows:

```
Rule Number: 10

Type: HTTP (80)

Protocol and Port Range: Automatically set; no configuration needed

Source: 0.0.0.0/0

Allow/Deny: Allow
```
![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcLF4YFqgwBIEvQbiGYumEimjW-VPZf4Ak0BFJMIHpvlxmkGyIuaojCxWNA_xBQ0A28vkRRXJrh2P5uY1sOR6c2d2AoauNG4diSVk-myhGa-l8LEzXqH-GfdWqTUDyZTkKF3dZQQKFIcPyHJQwwAhoCiOWz?key=BVoK9VoQXU5AVMd3Yw73QQ)

7.  Click Add new rule again and configure it with these settings:

```
Rule Number: 20

Type: HTTP (8080)

Protocol and Port Range: Automatically set; no configuration needed

Source: 0.0.0.0/0

Allow/Deny: Deny
```
![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMgeTkrEAL2fY6A0OuFsqWTct3CCig5yDoq4F_VX8iMa7cmAMhQyKWm_S7DANcvp2yfghHz8hMLP-DZ3d-74cgSw_725gTKlRZW1Y3O0iJuFXFK1YUHzRF8ksLSqAH56nUnblfuPkJgREW_nCdSfxEJRI_?key=BVoK9VoQXU5AVMd3Yw73QQ)

8.  Click "Add new rule" once more and set it up as follows:

```
Rule Number: 30
Type: Custom TCP
Protocol: Automatically set; no configuration needed
Port Range: 1024 - 65535
Source: 0.0.0.0/0
Allow/Deny: Allow
```
![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcm1BSxR3Emi7xp__t6XeczXO0s3Bt9z9cTTTGKT4AcJJ5kOj9PUBwhezhezqypXLOJZaMV31cKtup6B4NHtDPDfjwOPysRD2Tf9ZBw_sJAwmawEiHJlHeHgZeDFluIkw8nrsFUmIOJcbCJibVtzld4BifB?key=BVoK9VoQXU5AVMd3Yw73QQ)

9.  Click Save changes to update the inbound rules, and you will be taken back to the Network ACL main page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdQjwQGErOf2SQLasnPsDAoRqeNuLEr2gRvx0Xn-KJ7rbqq5Ew1vIu9NKtf3mKJaNW642EblnvQ3RnLsAk12VRI26coJ7YEnPnTzVK0BBd32rJgCEyFb7-3xeXds_QktAv7A8zJB1tYdzLSgQfX7efpufRC?key=BVoK9VoQXU5AVMd3Yw73QQ)

10.  Next, go to the Outbound rules tab and click Edit Outbound rules.


Consider the current configuration of the custom rule. We are explicitly allowing inbound HTTP traffic as required by the Globomantics policy. Since Network ACLs are stateless, we must also allow inbound TCP ephemeral ports to permit TCP sessions initiated by web servers in the subnet.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd4XMgivqDBH4svBtLfAqcsp1aw1b9voYQZ0Vmhtfon2CCLszU0Mvk762YR0z52uguWC946ub61sde9sTxjX3DFrBRARSHDXunF4uDIOR4Y1fOGkPHrUOBm7uCSHRS-y3w1CSOZe0XrySj1tUI4yNFnQj0?key=BVoK9VoQXU5AVMd3Yw73QQ)

11.  Click Add new rule and configure it with these settings:

```
Rule Number: 10
Type: HTTP (80)
Protocol and Port Range: Automatically set; no configuration needed
Destination: 0.0.0.0/0
Allow/Deny: Deny
```
12.  Click Add new rule again and configure it as follows:

```
Rule Number: 20
Type: Custom TCP
Protocol: Automatically set; no configuration needed
Port Range: 1024 - 65535
Destination: 0.0.0.0/0
Allow/Deny: Allow
```

13.  Click Add new rule one last time and configure it with these settings:

```
Rule Number: 30
Type: HTTPS (443)
Protocol and Port Range: Automatically set; no configuration needed
Destination: 0.0.0.0/0
Allow/Deny: Allow
```

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeY67PMNlQ4dTBswWMwsJreVYhnYTmFDaitN1Znnk8Mc_u3dTyNbqXd8i-dijW2iKnQiDsUaqm8gXSKVjhq1rKrCOUd-Q4hxG7l0hfOMCwbWaWJkjykolrq-lPOe4LKqwtBIippUnpxrKK_ChLF4EOB6oQ?key=BVoK9VoQXU5AVMd3Yw73QQ)

14.  Click Save changes to update the outbound rules, and you will be redirected to the Network ACL main page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfUGWScqeECs7E-us9v-UiF6MvvrEIe_cpE1R2p-ngI5vmCNyGPyNRp7cw0TUAM7OuUJyW23kPOeyO56dXjK3XC_LP9Mm2nLN6T740_dWrAW4va23O4Q-VrXO8lngbKv9WgHnINekbctrP6sexPhKQrl6pk?key=BVoK9VoQXU5AVMd3Yw73QQ)

15.  Select the Subnet associations tab and click Edit subnet associations. You will be taken to the Edit subnet associations page. Note that the rule with number 30 has been added to allow AWS SSM manager outbound traffic.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeLEqziGVa1XA4MdQIsQGwRXPPaKVSG4VlWLFOaSQGD7yAZQoERkbTpApO1pUrbhSHJ4Cw4oLrKZ2MJsM7MyI3z500nMr9fkY8mK53fswlsWY5vfGF0Axw9kpqgUvJiEN3pwOVihReLbMHg7oAbZPu3F6-u?key=BVoK9VoQXU5AVMd3Yw73QQ)

16.  Enable the AWS-Lab-Subnet-A association by checking the corresponding box, then click Save changes. You will return to the Network ACL main page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcUleet7wQH2Z38rbxhuUQAR-HradiGM6dGcxgOjxkkBUd4G6f4DxSrzyBgpBejEQH8xYCqVxonOIe4Y-K0gLstJefQa0OZUdFsZp4bVt7KL0j7tHYr4Xfp6xaBpNCK2rgf2j94tvNkuMfx6qO3sNCE2YM?key=BVoK9VoQXU5AVMd3Yw73QQ)

17.  In a new browser tab, replace <Server-A1-IPv4> with the IPv4 address of Server-A1 and visit the URL:

```
http://<Server-A1-IPv4>/home/ec2-user/
```
You should see the following text:

Welcome to Pluralsight AWS LAB

This Service runs on TCP port = 80

This is Server-A1

This confirms that the custom Network ACL is correctly configured to allow HTTP traffic inbound according to Globomantics' security policy. Specifically, inbound rule 10 permits incoming HTTP traffic on TCP port 80, while outbound rule 20 allows HTTP responses on random TCP ports from 1024 to 65535.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcWxn0EZdDUBWVBkJ3lSOxdwNF3wVfKYE_akyju8ojBhB_Y0wd4aca7Q_UXfNge_07mYhQqcRIeFtc6TkeUJbz2GTUP_SfH1pdZmA7YkWr_2bHDE6ZwYncNx70PrXjfK9fAJPqsXqMaavxjzwBBUVGSqy9s?key=BVoK9VoQXU5AVMd3Yw73QQ)

18.  In a new browser tab, replace <Server-A2-IPv4> with the IPv4 address of Server-A2 and visit the URL:


http://Server-A2-IPv4:8080/home/ec2-user/

No response should be received.

This verifies that the custom Network ACL correctly denies HTTP traffic on the non-standard port 8080, as required by Globomantics' policy. Inbound rule 20 explicitly blocks incoming HTTP traffic on TCP port 8080.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeXQcLFYYciICRsK-b6XZ6D0M8bmhr6H7v5b_9U67JOt1Whbnc1Cv02yaEg0kAWAR2grure6vthVPUj8yc3hluSxuSPxXxzO55OFN_DK41cjAAyMsEdaWOGBYt5VFvOBFRBNG6feqc3prTV6i5kfBfMSJ95?key=BVoK9VoQXU5AVMd3Yw73QQ)

19.  Open a command terminal on your machine and ping Server-A1-IPv4 (e.g., ping 54.185.239.79). No replies should be received from the target IPv4 address (press Ctrl/Cmd + C to stop the ping command).


This demonstrates that traffic not explicitly allowed is blocked by the final rule, the deny-all rule.

Note that users cannot delete the deny-all rule, and Network ACL rules are evaluated from lowest to highest. Traffic not matching any rule will match the final deny-all rule.

20.  Send a ping request to Server-A2-IPv4 in the command terminal.


It is expected that no replies sent from the target IPv4 address are received.

This test again demonstrates that traffic which is not explicitly allowed is blocked by the final rule, the deny-all rule.

21.  Back in the AWS console, use the search bar to find the EC2 service and select Instances (running).


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcFD0WYugLeyoCUmT3AApYSxAp5b9-rKL6Ofrs-_ztSfkL-8K896h5Ovk7AY1OYf91pnhu1fo-OuCPEDibbWBYA11I77si4C5KLbQYQ-NFIlGNyhG1l5SyRoX6Wi9--8d-hUtcLT-cmFRF4dg7DwlpwZew-?key=BVoK9VoQXU5AVMd3Yw73QQ)

22.  Right-click on the Server-A1 EC2 instance and select Connect.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXckU4uLjfsSvMhB3X4TvBRlV6ENemn5KRDmS33cBB4Tw-2mQ0Mx4FXB--Y1X1kdLRGqCRkGCEaCWmt5tbLbn_fkL1aAvPnyj2zPDa5bH5pgo74ep3wqINgRneO8RKCneh_MmEx2SA9CZGOIbHMoAslp7EKq?key=BVoK9VoQXU5AVMd3Yw73QQ)

23.  In the new window, go to the Session Manager tab and click the orange Connect button.


You will be redirected to a new window displaying a shell for your EC2 instance.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf-fUeKuSZKSQ4ZpGsqck8_16vRfwFgwoHInMldCCvVHTb14wDWURN8zaaJrzAP-96EfKz3k3OlBmabh6nekuKEFVKOQNbsnqmkvVYdNhEiMnc-YYJIfiTR4RNJXULBkZ3NA_lO9BBVMn346K0gsITps-J6?key=BVoK9VoQXU5AVMd3Yw73QQ)

24.  Run the following command:


time curl --connect-timeout 10 -I http://ptsv2.com/

After having executed the shell command (which generates an HTTP request directed to the target host), we receive the following output:

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXebJoFEz4OBygosFBbC6nh5w6nmUZiT4ErpxDyV4hkpBI_Gw_a_FNHNdc3fdbemNJSZbffA67aQM-YpoCKEe9InuHXOPtmMVZKArC-4Tv9yY2nT1HvprJEsH2YRUBvgu95131dt4YAfIchTz2gsLhW7JChM?key=BVoK9VoQXU5AVMd3Yw73QQ)

This test verifies that Globomantics' policy has been correctly implemented, blocking HTTP traffic generated within the VPC from reaching the public internet. Specifically, outbound rule 10 prohibits HTTP traffic from leaving the VPC when the TCP destination port is set to 80.

## Add a Custom NACL to a Subnet in the VPC



In this scenario, you are tasked with the role of IT administrator at Globomantics. Your objective is to ensure that a new security policy is consistently applied to your AWS environment by configuring the Network ACL for a group of target subnets. The security policy at Globomantics includes the following key rules:

Users from the public internet must be able to access web services on standard HTTP ports.

-   HTTP traffic over standard ports (port 8080) must be blocked.

-   Web servers (hosted on AWS EC2 instances) should not be able to initiate outbound HTTP sessions.

-   Inbound ICMP traffic is permitted.

-   All other traffic must be denied in both directions.


The scenario includes the following configuration:

-   A new VPC named Pluralsight-AWS-LAB.

-   EC2 instance Server-B1, listening on port 80 and associated with AWS-Lab-Subnet-B.

-   EC2 instance Server-B2, listening on port 8080 and associated with AWS-Lab-Subnet-B.

-   EC2 instance Server-C1, listening on port 80 and associated with AWS-Lab-Subnet-C.

-   EC2 instance Server-C2, listening on port 8080 and associated with AWS-Lab-Subnet-C.

-   AWS-Lab-Subnet-B and AWS-Lab-Subnet-C are connected to an Internet Gateway.

-   All EC2 instances are set up with a Security Group that permits all inbound and outbound traffic.




1.  In the AWS console, use the search bar at the top to access the VPC service.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfpTxtIgUiJuOJPgahkvO3dy3rRfsC4I_LOy5IwbvUQDO2kx4HMuWksjzGEE_knJ-T8wKjShx7XY-LRfcUqwoIF7zkEdKDxOVUBBmWuLAlausiN0l4SGZ8UR6696KRC0NApfjQqDP89D0IJdsvPwW7Dq7ff?key=BVoK9VoQXU5AVMd3Yw73QQ)

2.  From the left menu, select Network ACLs, then click the Create network ACL button in the upper-right corner of the screen.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdw_0CgZQTPNWpAgu7Ld7z9DoQP_xgVqaVfcxSusoRZX1gphaVdLChzY6Md2TpsToD04AA8a2az5dXY7JMsXhmcR0cN7XxWN5_4mhN-DARssl7jPiMlgRYG_YtRO2NNBhOY4qxt6IcJFVYa8MoA3JAUznSP?key=BVoK9VoQXU5AVMd3Yw73QQ)

3.  Enter Pluralsight-AWS-LAB-NACL-2 as the name.

4.  Choose the VPC with the name ending in Pluralsight-AWS-LAB from the VPC dropdown menu, then click the Create network ACL button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdMfOVbrgfR3zOR5NRzkZIZRJK2e58eHquaWor4xQQLIp9qStLylz6ZusXtD_2k6c_ZYF9-c_quuMNo17S3k_djTTTtpie1GV2HhFoBoqHPhTHWuZS-dLAu76WME2WNjDkYmvthfEpdIcp3V0B4CNL13Qa_?key=BVoK9VoQXU5AVMd3Yw73QQ)

5.  In the Network ACLs table, check the box for Pluralsight-AWS-LAB-NACL-2.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf0Wbm-oTwcfj1PUUZOPJk-pZB2AP-woaKZD-TTVQp-apvrT_et-yYxkPRpNOeJJZ_mejzAEA1ZHbZ4N7z7NdRsuYrbYvAOIilqcGwlkgvIy6s3jXWVE-P9rrcO-nOzWbTmgMC9p9rg-NnFfPAhErUCWbAu?key=BVoK9VoQXU5AVMd3Yw73QQ)

6.  Navigate to the Inbound rules tab and click Edit inbound rules.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdQEy0iIsPzFbBwGO8Shq90TPq2LsEFTz-XwhY9teSem_5G9IxRqgaKxXdHcVyiL93YbMwFtj0iQOmafxj9d2soezhWp193B-GEg_X3gHzEcU8i271HYPerujd4sA3HfP8Q_AYTkBLgDOd_AaASBtuCPaZC?key=BVoK9VoQXU5AVMd3Yw73QQ)

7.  Click Add new rule and configure it with these settings:

```
Rule Number: 10

Type: HTTP (80)

Protocol and Port Range: No configuration needed (greyed out)

Destination: 0.0.0.0/0

Allow/Deny: Allow
```
8.  Click Add new rule again and configure it as follows:

```
Rule Number: 20

Type: HTTP*(8080)

Protocol and Port Range: No configuration needed (greyed out)

Destination: 0.0.0.0/0

Allow/Deny: Deny
```
9.  Click Add new rule once more and configure it with these settings:

```
Rule Number: 30

Type: Custom TCP

Protocol: No configuration needed (greyed out)

Port Range: 1024 - 65535

Destination: 0.0.0.0/0

Allow/Deny: Allow
```
10.  Click Add new rule again and configure it as follows:

```
Rule Number: 40

Type: All ICMP - IPV4

Protocol: No configuration needed (greyed out)

Port Range: No configuration needed (greyed out)

Destination: 0.0.0.0/0

Allow/Deny: Allow
```
![](https://lh7-us.googleusercontent.com/docsz/AD_4nXehU_zxotiNgXHhLQ4hRohxt9WggqUezExlVWWyU9YmyAd29PFjql8pZvKn2_JS3aQ7GtXci3BA8Yiuoo97h81TItTLxut36kOi32eLRrx6vwGu0AhgrP5xt8deR2RxZ7YhceYiXMaW64Pbpy91iKkzx3M4?key=BVoK9VoQXU5AVMd3Yw73QQ)

11.  After configuring these inbound rules, click Save changes.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeyBDvnxck2DQ0rtt4FP5HasyhtASRF1ho34ir1EZc-4EM50KMDtJFtZc7RlUAn4QyI-Y2EVF5C2B5x8lDxP7PCxg-QEjbX3B1FLmSo4js9-ZYeUeAU9hmcXY23KjhOQlmtzs4OtgnX8GXG9J5jVXDqYRRD?key=BVoK9VoQXU5AVMd3Yw73QQ)

12.  Click on the Outbound rules tab, then click Edit outbound rules.


Review the custom rules configured so far. Since Network ACLs are stateless, we need to explicitly allow inbound TCP ephemeral ports to enable TCP sessions from web servers on the subnet.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXesOBoQWOV5jXrMu6pfFOseFKveFSZ_dGK_sWc2G5RUfhUOe_A72UmYfbXDzz9kw989_QKEPOoQxe0ZMKHU2gIZjPwSHUIhgmjMkVUjdT8xbvvTCokZxZGgibB1NATga1aMjFpU8EEFLaD9dO-g7paTf3Pp?key=BVoK9VoQXU5AVMd3Yw73QQ)

13.  Click Add new rule and configure it with the following settings:

```
Rule Number: 10

Type: HTTP (80)
Protocol and Port Range: No configuration needed (greyed out)

Destination: 0.0.0.0/0

Allow/Deny: Deny
```
14.  Click Add new rule again and configure it as follows:

```
Rule Number: 20

Type: Custom TCP

Protocol: No configuration needed (greyed out)

Port Range: 1024 - 65535

Destination: 0.0.0.0/0

Allow/Deny: Allow
```
15.  Click Add new rule once more and configure it with these settings:

```
Rule Number: 30

Type: HTTPS(443)

Protocol and Port Range: No configuration needed (greyed out)

Destination: 0.0.0.0/0

Allow/Deny: Allow
```
16.  Click Add new rule again and configure it as follows:

```
Rule Number: 40

Type: Custom ICMP - IPV4

Protocol: No configuration needed (greyed out)

Port Range: No configuration needed (greyed out)

Destination: 0.0.0.0/0

Allow/Deny: Allow
```
![](https://lh7-us.googleusercontent.com/docsz/AD_4nXenyXiJtzO1mVMlvbYqAybmwB53KINwCzlmkuLjyHyXPLdEZbd49MB1KFagnhQsSoz76Tpd-kqGoIeJWip4JHsDlONRh7TonSgkXqihIJXMaIYskERzqoBYwEsCSHPesbuAckq1LUl5nIo7C-q4kI4VQCF7?key=BVoK9VoQXU5AVMd3Yw73QQ)

17.  After configuring the outbound rules, click Save changes.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfS6IJtnSEHrufutv2NISnREowha9gag0ZD62nbxLOZqCu6TVO8bXwdX-_N8RDN8_3ojKRLiciKY8co3zb-lTjXWz5qpCx7b8pI7lteUqDX6beqy3N1npCCkafuA40n0ttioXnDG2x8W2yCorRQGD-RU5Bn?key=BVoK9VoQXU5AVMd3Yw73QQ)

18.  Go to the Subnet associations tab and click Edit subnet associations.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf9Y5MWLEGBUdFz1RcM8MKdUQavEBNmFH3Vum4ylH1ab-9VhJCtt6BcBUcOmSbODIk9Y5PJuP4eR9JZ4Tjfmk9bm4uXZcyu3_At7vrAujW8Ug0j7loRZ8bfB31JSQB3FRBJKL6ihPwfL1_fAzpsszTS-x7o?key=BVoK9VoQXU5AVMd3Yw73QQ)

19.  Enable the AWS-Lab-Subnet-B and AWS-Lab-Subnet-C associations by checking the boxes next to them, then click Save changes.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXecayCHCMv_4oaQIFZJHjreVzrsV9jU58SthJq22H2rCCeKjRX3uDWBvNsDgtbpTsAlovxu2oKb3rhR5OFmWtzGVCT7miVKm7BHquS3ezV3eQ2KehSeEIS1qirRiTrAZ3dnERTkPMlpKLFiyBNvQGMsu20X?key=BVoK9VoQXU5AVMd3Yw73QQ)

20.  Use the search bar at the top to navigate to the EC2 service, then click on Instances (running).


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfr4wkQhR1F-iKjiO2C5bCXsOnLwRLUvv7YdJTRero6GSz5RPLH4bKiN19a4WTo5ZawiI0OfB2qXEsJRQvc2jsl0bOMsR07f6SUoMMfSM8BzI5FOWFlvQ96KRzH7eBP4h4DRwSpWf1Av6IRLHYmboy8lMo?key=BVoK9VoQXU5AVMd3Yw73QQ)

21.  Note the Public IPv4 addresses of the following servers for use later:

```
Server-B1

Server-B2

Server-C1

Server-C2
```
22.  Open a new browser tab and enter the following URL, replacing <Server-B1-IPv4> with Server-B1's IPv4 address:

```
http://<Server-B1-IPv4>/home/ec2-user/
```
You should see a web page with the text:

Welcome to Pluralsight AWS LAB

This Service runs on TCP port = 80

This is Server-B1

This confirms that your custom Network ACL is correctly allowing HTTP traffic in the VPC inbound direction. Specifically, inbound rule 10 permits HTTP traffic (port 80), while outbound rule 20 allows HTTP responses with random TCP destination ports (1024-65535). This policy applies to all subnets associated with the Network ACL.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcDgfn5yKwJ_uCoMpRN-3YOvuQzR81YFYwMn4q56eTtFfcZFP4XqN7FDkm-OGwkNhGfVEU481IVNtqgPo_SY-RA08FmZjvcIiBNM3zDZalXWNaIYsWGrq1w-4eu7O-7eI5AW6YwHjZc93U9KFdzVqqlnAM?key=BVoK9VoQXU5AVMd3Yw73QQ)

23.  Open a new browser tab and enter the following URL, replacing <Server-B2-IPv4> with Server-B2's IPv4 address:


http://<Server-B2-IPv4>:8080/home/ec2-user/

This request should not receive a response, confirming that your Network ACL is correctly denying HTTP traffic over port 8080.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfWCQOC3-loUiqJI48pVOWONBJuaqcGOkhpa_3Uf6g_4hBDQVEnq40sOXvu7UrflENqJoElnxrKW2lSZQ2YTTqXi9XFAaXyn_ub2jSqiTu6IGhwdMYPDukU8DpZz7RjxUygS-ocm8S28ukysOl8-BXZ6Pwc?key=BVoK9VoQXU5AVMd3Yw73QQ)

24.  Open a new browser tab and enter the following URL, replacing <Server-C1-IPv4> with Server-C1's IPv4 address:

```
http://<Server-C1-IPv4>/home/ec2-user/
```
You should see a page with the text:

Welcome to Pluralsight AWS LAB

This Service runs on TCP port = 80

This is Server-C1

This confirms that inbound rule 10 allows HTTP traffic (port 80) and outbound rule 20 permits HTTP responses (ports 1024-65535).

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfrh_zwbo7sW7BB4CzuI4ek7pxHT19AgjMz7D_2v8r8Qu2alAN1q-TYI7mP0ns88qtjbe4it1ZxY8bmDKPX4gvH0djMq1_zH7PmAu8Im8dwBkjIorB0PkXhF3dIahT8lZabuQ5bYTOVNXzPE34Hm8Nlk4bb?key=BVoK9VoQXU5AVMd3Yw73QQ)

25.  Open a new browser tab and enter the following URL, replacing <Server-C2-IPv4> with Server-C2's IPv4 address:

```
http://<Server-C2-IPv4>:8080/home/ec2-user/
```
You should see an ERR_CONNECTION_REFUSED response, indicating that rule 20 correctly denies HTTP traffic on port 8080.

26.  Open a command terminal on your machine and ping Server-B1-IPv4 (e.g.,  ping 54.185.239.79).


You should receive four consecutive ping replies.

This test verifies that ICMP requests are allowed by inbound rule 40 and ICMP replies are allowed by outbound rule 40, applying to all subnets associated with the Network ACL.

A similar ping to Server-C1-IPv4 should also receive replies.

27.  Back in the AWS console, navigate to the EC2 service's Instances (running) page, right-click on Server-B1, and select Connect.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdn8-_8DbD0dikkShxDno7b-uz6s5Yz25A-aDTRJTtJpGfBQaof7QtZeGfilfou6EIol3QwtlgM621J8177EK8FAg-oSsHQDG4QlBeHgbUlYJZV6R5IkLao9aLknTcLB2om8f7qHZmGDnWc1JjaUXJu_tc?key=BVoK9VoQXU5AVMd3Yw73QQ)

28.  In the Connect to instance window, go to the Session Manager tab and click the orange Connect button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf-fUeKuSZKSQ4ZpGsqck8_16vRfwFgwoHInMldCCvVHTb14wDWURN8zaaJrzAP-96EfKz3k3OlBmabh6nekuKEFVKOQNbsnqmkvVYdNhEiMnc-YYJIfiTR4RNJXULBkZ3NA_lO9BBVMn346K0gsITps-J6?key=BVoK9VoQXU5AVMd3Yw73QQ)

You will be redirected to a new window with a shell for your EC2 instance.

29.  Run the following command:

```
time curl -I --connect-timeout 10 http://ptsv2.com/
```
After having executed the shell command (which generates HTTP requests directed to the target host residing on public internet), you will receive output similar to the following:

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXebJoFEz4OBygosFBbC6nh5w6nmUZiT4ErpxDyV4hkpBI_Gw_a_FNHNdc3fdbemNJSZbffA67aQM-YpoCKEe9InuHXOPtmMVZKArC-4Tv9yY2nT1HvprJEsH2YRUBvgu95131dt4YAfIchTz2gsLhW7JChM?key=BVoK9VoQXU5AVMd3Yw73QQ)

This test confirms that Globomantics' policy has been successfully implemented, blocking HTTP traffic generated within the VPC from reaching the public internet. This is due to outbound rule 10, which explicitly denies HTTP traffic with a TCP destination port of 80 from leaving the VPC.
