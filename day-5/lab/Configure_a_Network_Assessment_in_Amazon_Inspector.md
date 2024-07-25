# Configure a Network Assessment in Amazon Inspector


### Table of Contents  
- [Run a Basic Network Assessment](#run-a-basic-network-assessment)
- [Create an Advanced Assessment Configuration](#create-an-advanced-assessment-configuration)
- [Evaluating Assessment Findings](#evaluating-assessment-findings)

## Run a Basic Network Assessment

You are employed at Logistics Total Transportation, a trucking company, and have been assigned the task of identifying potential production security issues within the company's AWS network configuration using Amazon Inspector.

Your initial step is to familiarize yourself with Amazon Inspector and set up a basic default configuration.

1.  Click the Open AWS console link to the right of this text and log in using the provided credentials.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc7q7W1_uPldr8iHxBNC3dXZbU__KtthWQuTYQqHQqw2Cy27aRmYSJ4qvgfoimb9VUGnJmnn3ZCy6ekq1g8flSKZOlsBUmvlH7NwO8HyJUQnksPrilen3k31OTBZqRjfWN8dC4MmMkHVHHDV5R6oKCGvbCF?key=IHG69nLYporAh4AJgEG65Q)

2.  In the upper-left search bar, type Inspector and select it from the results.


Amazon Inspector is a security assessment service that scans your EC2 instances for vulnerabilities. Typically, it involves installing an agent on each EC2 instance, but this lab focuses on network assessments, which do not require the agent.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcI-hTY9abaDkVraj4hesLhGRE205dcbUO6VvCWbHrnpv757CrI5pj1EkZwq39Qh_hR4i4FWKgf3DCiDjztFz790SKugDweN0XWIa7rbHcm_F_eMCQwpwgeAY_SU1qmA1pE59mdgOns4Pj2pZFzn9gEFRZS?key=IHG69nLYporAh4AJgEG65Q)

3.  In the upper-left, click the ☰ button to expand the left-hand menu, then select Switch to Inspector Classic.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdSAvg_EeH_NB5KhW79STq54DOus3DSHQeYoE9RoqZ5oCbnPEcXepi9_MJSKRh4tzhj2MZPNae_u1Z2KOZgdTVJLJFvQVoxJEOcuWxEi02pHj7TYwpdQ-fdRoNp6DAcswKhMwFcTiU5s7U_crDTfC0Ujjo?key=IHG69nLYporAh4AJgEG65Q)

4.  Click the Get started button


This lab focuses on Network Assessments to identify open ports and insecure network configurations. Although the Inspector Agent is not required for network assessments, it is installed on three of the four EC2 instances in this account to demonstrate the additional information it provides.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcoH9rt0LMj_c1p4qPSui2p34WiAL-z9SRSLpRtvnYWPUqI02DNR_nboSheUjl9tjiYTESoo19dS1v4AHhfPyeC5DXHcvH9AEuZE8N41fdPtm-4MVPk0IcTAOxeIUcWPXNJ0nDuUCPhsipJQIhnBd6WqLw?key=IHG69nLYporAh4AJgEG65Q)

5.  Uncheck the Host Assessments checkbox.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfGoimRUlYI6WOiazxvO7f6GTU9ZybWm85o7Ky_XIar4UbxjRSjM2Br-kAW7TnfKHR3YiZ2ZFi-5mBohiZSIM1uCAwweDnr_gcL6PrNAinxcxLv-AVyhNPYnldDSJw-TTjQ3TOnyX-Y4kGALBXmVRBeV3U?key=IHG69nLYporAh4AJgEG65Q)

6.  Click the Run once button.


Since only Network Assessments is checked, you'll need to confirm that only Network Assessments will be run to check externally reachable ports, and other Amazon Inspector assessments won't be conducted.

Click the blue OK button.

Note: If you encounter an error stating Inspector Service Linked Role has not finished being created, wait a bit and try the task again.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXebuX5bByS1utBQgKa2pik1NhkTjPjkDyMCK1L4hEoNpThrFhANEDnVp9Wuz1nD_zPPh3CHI8yITduLMLdZmSBwJ9ka-khJQrvzCFcRPb-A2UNxDg_7ekGlm-UYAPMjoLgDu-VcmdxmoVc1F4zucEP6z3AI?key=IHG69nLYporAh4AJgEG65Q)

7.  To the left of the Name column in the assessment you just created, click the arrow to expand the row.


The run will start at the bottom and display a generated Target name and Template name. Since Network Assessments was the only type chosen, Network Reachability is the only rules package being run. The default duration is 1 hour, but you don't need to wait for the run to complete before proceeding.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdB7A30QEamuWFd-3DYG0NGOGkQeBq26aStlhmCbVXYzkzBnkssWy_Vc8P0HedGg7vG4TrByMv-6VpPC77RMIDACKsqCmm0RRWSDRdcpcIqpKPxKes8opjd76s9YawUZX1kdixjIi2HBCacDGL14Xj-9Eg?key=IHG69nLYporAh4AJgEG65Q)

8.  Select the row and click Run.

9.  In the left-hand menu, click Assessment runs.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfrONgt6BVNZb09nnlC3sYjiT-7jaHeu9j-tGyUCNbx5yeU8a9sLHedV6Cz4iBT8W3CLXU0qpnWCRNJhzepOEsEUXOMQsp7NwjsX-HhcGHH4wgVcyuOAkNAiqGZ2Z1YOZ70OwOxybX5inXetAlrrhhyM2M?key=IHG69nLYporAh4AJgEG65Q)

10.  Expand the run by clicking the arrow, then click the Show AWS agents button.


This will display all the Amazon Inspector Agents that Inspector can access. There are four EC2 instances in this account; three are using the Amazon Linux 2 AMI with the Amazon Inspector Agent installed, and the fourth is using a Ubuntu AMI without the agent.

You should see three of the four instances with AWS agent health starting as RUNNING and then changing to UNHEALTHY, while the fourth instance will have AWS agent health as UNKNOWN. Although the fourth instance won't have the extra features provided by the agent (such as identifying which running process is listening on a port), its external ports will still be scanned.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXchSlYbcc1J0pkwFE5gn_t6P8xgODAY78X3FElN1ajqzvvmp8uMaoQUAA3n6z2tLiY1AwnmaCumb5ZI1voi_pLfteQyj8_iue5BXdlNcssqwJFuuTzDCl5HaFzpjbpNs0E0n9yplSTXFf28H5X89O70w49s?key=IHG69nLYporAh4AJgEG65Q)

11.  Click OK.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcuVhE5hT-AokxvG69RAVRwgFoiVjTjkqzuu_j_KXzcl3R_SU3nIutJyjeMuUhhk8HccuDGaquSpy3iVwkYVbiFI4my4nMGSovoFjOfiI8icG3ghhjzoL9G7SMyXRRH6mwq3vIEa7EtiW6A8G58XPgIcMGE?key=IHG69nLYporAh4AJgEG65Q)

12.  Select the checkbox next to the assessment run and click Cancel.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfJeC-empUPOXaIevDtdDCyNOlIhG8qeXClDz19AGNhawUXuxasBu0_pmfWdtL2QTfE2qFJ4jE_fpaT3GnJx1I8OuMGyUj32XIz8z_m75WC00z4HMy2jAC0Oxm2WXhVm8dWcBj4gC1qQ733vWvshsE9T4E?key=IHG69nLYporAh4AJgEG65Q)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc9fQwChGMzGv5AyF2-_KFIXlYw7fhk8p2Opw5kT7u833hliWRrUM3vAL_5SbrscvUkBHaJ-6uhdzkA_teGIPeJFV7BBw6-VIrfF02j3cUrIoDfpT4eWm3mYhVHpOp2XTa9sZEGq5-L8Nk4li9ehrJaB4c?key=IHG69nLYporAh4AJgEG65Q)

You have now created and run an Amazon Inspector Assessment. The assessment run should display a status of "Stopping." In the next challenge, you will create a new assessment that runs in less time so you can inspect its results.

## Create an Advanced Assessment Configuration

In the previous challenge, you created a basic assessment configuration using the default settings. Now, let's explore the advanced configuration options available.

1.  First, click on Assessment targets in the left sidebar.


You should see the "Assessment-Target-All-Instances-Network" assessment target, which was automatically generated for you in the last challenge. Assessment targets specify which EC2 instances will be assessed. This one is set to run on all EC2 instances in this account and region.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeQ4dlnjqlSbSe5kMnpnbnQK5vEIzp1n4tW27s7P4Gsv8BcnhKb5dU4FTZKsLLclct4-m9KKbpSurFshZOuhRj5JVflXOkchYoSi2RF0Xl9a5uYSeusfHkzjVzyyNEk_AUVhIgqcCYQ693GTs6QzzOywRCB?key=IHG69nLYporAh4AJgEG65Q)

2.  Next, click the Create button.


You will need to provide a name and select which EC2 instances should be included. For this example, you'll create an assessment target for all production EC2 instances.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcH8vknRq4N-p7JYXJnmFBDfGvGNJGFOo1uAaDcOBw-ud0UYLbXkTq2vsMqWk4lPGDjv_VSLDmsdbws7T2fk6OB0JBFpgXTSv_6la8VHNgtf0ESePnbfF-NtZDuYzBrQgrvbfiT4lMLSL8wsjWpJ5ZPTIY?key=IHG69nLYporAh4AJgEG65Q)

3.  Enter Production as the Name.


Leave the Include all EC2 instances in this AWS account and region checkbox unchecked, as you'll be selecting specific EC2 instances using tags.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeDf8pjAJ2cr-4xQkg0SvzpWNniPSbuNFrHJBUv8nIgsYeZD17lq-2ig3VFb9nZ0adtAkZajDDotDRkNzw3m7KLwa_WEKCynunZJs9ZzDjaNvywd3jFsj0FViT6l0mhSeOsrJJCMXzup806GXsZopPkgzhS?key=IHG69nLYporAh4AJgEG65Q)

4.  Click Add a new key, select Environment, and under Value, choose Production.


The Amazon Inspector Agent is already installed on the EC2 instances. If the SSM Agent is configured on your instances, Amazon Inspector can install the Amazon Inspector Agent for you by selecting the "Install the Amazon Inspector Agent on all EC2 instances in this assessment target" checkbox.

5.  Click the blue Save button.


Your new assessment target will be created, but the Templates column will show it has 0 templates associated with it.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfTEL10DEEyOlsXP6F3-QHs8YAXT-QNlmluZYjnFAfaRofR9KX30hvPTITB1YG2-CAYM5rVQCjGTMY7jKFd11UsgxuD8r08p-vw0IrZdQRvBKAmTA6fIXn1eZcQiZ7fXbGn_4Nj-BqLBRpWtAAw-L9V_4I?key=IHG69nLYporAh4AJgEG65Q)

6.  Now, click on Assessment templates in the left sidebar.


Assessment templates define which rules packages will be run, which assessment target will be used, and the duration of the assessment. The automatically generated template was set to run for 1 hour on all EC2 instances by default.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeYZUSgVNoxNDR9Ji9bCkKwSAyWTAyisNcRmPTAKcp5_euFgIsPj8neP7WFVsveZaM7Xlp_M1Kho8B8opLyqJFb3RCVH57YI7Vx7Vba8gFUrPa5Tt53ea_Qp5J6XCwVWM4DRSf37Wlp9TPiP-3SvoBbsBRR?key=IHG69nLYporAh4AJgEG65Q)

7.  Click the Create button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf-duBNpJzSlaY8YkEQcWkbnzoNOUKp1bJSpw5MjjHA9rYOFxTv1CU3Z9iBNFs_AlXincl42_lwQq3NVlXlFDplcqslt7gIROGTMghUVJinznBYX9OmzxedxSjpO8yrIJN0kpCaspdlsYaeEGQbPlkeg5cb?key=IHG69nLYporAh4AJgEG65Q)

8.  Enter Production Network as the Name.


This template will be used to perform a network assessment of all production EC2 instances.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeK5EfNEHDp5T67lvr_8MPbj89cIiegP0ZpEtn--yk1UwR5Ylv59wxmJVYykVtAPA3mg-SD-7BshRQBKHtG-nXk2Pk4HNJsHIfBudZ4mOo_-baYcq-1I8r3C4PDtMjmB1SLHeVH7i81CAD6i162PAKF15GU?key=IHG69nLYporAh4AJgEG65Q)

9.  Select the Production target from the Target name drop-down menu.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdqIuEcjzwFncSIWbmpMGUNTXOlORXd0swIeLCzdXnmKlevCYKtYsLpIcJl96wMydxhnaKzE6bumLonfl-OxbN_P5_JGZwrHCBc9OnnjRBObQfNidmwFLvUcp75osRd6q5pSbSs6UIrU_huiAxIb8j4zsw?key=IHG69nLYporAh4AJgEG65Q)

10.  From the Rules packages drop-down menu, choose the Network Reachability package.


If you want to run additional security scans on your instances, you can select them here.

Note: All rules packages other than the Network Reachability package require the Amazon Inspector Agent to be installed on the instances being scanned.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcCyFuSvTOQBHUArk2SHS3PZY4ZS3Pz8ATwh86sHVJmr6TZz8Ap41sIMiHHOg7tRfDWgQOSUoHZ7QBdZa84lji7nrSEZ4WS6WpVHRKm2n5Ux8o6o0CgIDimsI8eJFxz35YRJ5NN87mVU3lk4UkoN-NLlGEK?key=IHG69nLYporAh4AJgEG65Q)

11.  Change the Duration from 1 hour to 15 minutes. Although the default duration is recommended, 15 minutes will suffice for this lab to identify relevant vulnerabilities.


If desired, you can configure SNS notifications, further filter instances with additional tags, or add extra information to the assessment findings.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXePeUDz5lnvAHA5x8Bws-Ee0cRvut-GcF9izadjWC7cTe4Tt4B5Qvv4nYJkHcVTfqpA6K8q4_QEc0XMN0siF4YPAU95FlbX4nF9eJQHR5Pmdi0koeexwitXFN0r5U-hZ0p_jPaz4bEt7d2C8m0f5erYwdc?key=IHG69nLYporAh4AJgEG65Q)

12.  Uncheck the Set up recurring assessment runs checkbox. This ensures the assessment will only run manually.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeBvf9h60UDBFwiZI-S3ctfs88HGSXg2VnyhXb4aary50t0Mwa0LojQoejRUXj9C6bEQRWOrDoFXGqe7Dore8h9RTIJddbcbK94a7k8Pu9WhQoebDA1_HVdQT51YgZDjdV7Y7lkwYksrrMrReIF-kw8fiT5?key=IHG69nLYporAh4AJgEG65Q)

13.  Click the blue Create and run button.


You should see a green SUCCESS message indicating that the Assessment run has started.



![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdW1Ck02NPe71L8wV8EkZlX4MCELUfIaBK1h9wpuvhec1uFrp58F4jKCi-odek1RT17MeYzt6qaV57mNL-WJqwPUXDG8GtNkWLx6NSKcn_oEQypg6Oehen8UCE8yKQ_c43R_XkCXW4M1NsoVCpSv8wMCSSa?key=IHG69nLYporAh4AJgEG65Q)

14.  Click on Assessment runs in the left sidebar.


You should see the new assessment run with a Template name of Production Network and a Status of Collecting data.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcxwn813z-8fHoh9OZNOEY5KuLqY29DwakiQIokUYPK8w4gjyrm8Q9JPqGB6f4KOqrC4CCQgrjtv6bKxHTsn4JFgDG3xmYHBlUQ6Jr-SlALM01WGvqIKGzk_jZLGpEebH0-DEPLlHLSO3bH9yAGpglfY5Fo?key=IHG69nLYporAh4AJgEG65Q)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeL0RUXmyd_Dv8h7gLoBlGbnfWEDmJ5wRi9uLIELO_4GX3eIykNpnjD_D2AVe-urMTnZveuH9YLMnCu1u7YVw1N_VNEtGy0Yeb9onuo9i8N0Ou8XSoiVm0YFZ0naAJJBS-m_PHZlqIqlCy2eUbwhcoOv18O?key=IHG69nLYporAh4AJgEG65Q)

15.  Monitor the progress by clicking the refresh button. Wait for the assessment status to change to Analysis complete.


Note: This may take a little over 15 minutes.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdrxHHhos6aPvl5Xu6MkZFOxmS5PYccD7vYy6xkzr1PpUOjvm5XShBEdhKjKLQ00gy9fJbWrkSym-rbZ7eXgF8MSTetoT90rmaecOJ9Gk766cdnu2Z2XYVCA32IRIEJHhL111Oa09BVAyxWt808ZCsd-bM?key=IHG69nLYporAh4AJgEG65Q)

Once the assessment run is complete, it will have a status of Analysis complete and display a number of findings. In the next challenge, you'll review these findings to identify potential security vulnerabilities.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcO4me2tSFIGwDxILhK9N2rCYAAVYcLQlA0XchfVz4rK5QfgnrJZFou_E4DVH9NdjnjkTIpROtZahmYAujRbWEMcJAoHwszu04VCcalhBPlzO_WarS1BqlZCcBar2PvWOVV2rDOsTCvVmlQjwsMYwSkJqXU?key=IHG69nLYporAh4AJgEG65Q)



## Evaluating Assessment Findings



Now that you've configured and run an assessment, it's time to review the potential network configuration issues identified.



1.  To begin, click the arrow in the second column for the completed run using the Production Network template name to expand its details.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdmFM7v5r8r1oxgz-6x4lz79JEJLoEsDurDx0evuLc9uej7vkg3ahoih3EedEzbNPbdwZei_woUKRc_VRVn84A1RSY7OiChAlOOIM7lwOdZjRU8erw_VFlfkuzCcs4lHeCeLJTN69uq10eOVv3js-qwhKBs?key=IHG69nLYporAh4AJgEG65Q)

2.  You'll see there are 9 Findings for this run. Click on the "9" next to Findings.


This will take you to the Findings page. In the future, you can see findings for all assessments by visiting this page or removing the assessmentRunArns Filters at the top.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfzJqaNcwDfAmfF-4ktUqkgjq8EutBNJKem0ZeP9764-DF7RYnAudWTGDzRHAgCjopztnIB4yfxI0tyN0LLsQsdByquQPHMEVAZ9TOlLQ27dhlCRV9SxLJxF6m_O4Aw1uL8E3wjmmMZ0bpfRH36rOgIr16E?key=IHG69nLYporAh4AJgEG65Q)

3.  Next, click the arrow in the second column of the Medium Severity finding for TCP port 5432.


Amazon Inspector detected that port 5432 is accessible for this instance and identified it as typically used by the PostgreSQL database server.

The Description reveals that because the Amazon Inspector Agent isn't installed on this instance, the assessment couldn't determine if any process is listening on this port within the instance. The description also identifies the relevant VPC, ENI, ACL, Security Group, and IGW responsible for allowing public access to this port.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcFQ21RV60PFochLskPA7ttM-GPdPrKZA75-4lOs5irXQkJ7jbUWKh0D1W_4n5PeDDHfb4Fy-7oI4cHFkR6qqosMyEpQ7UFuspGwNP-RpO1evK4E2DpaUWGu_xxysJ-VyeFxHTUqSfeQDebkgZq4633clNI?key=IHG69nLYporAh4AJgEG65Q)

4.  Click the Show Details button to view all available details in JSON format, which would be sent on an SNS stream if configured.


Since the port was recognized but no agent is running, this finding has a RULE_TYPE of RecognizedPortNoAgent in the JSON details.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeKniLujyy2ZXVpvDiwwUDLAimPTCIUhfwhismas1ZcEy4qi9Szbh_OpLiuJwb475WKaw7ymbwVxK-kTn9ZdaHJvK6XahhFG-LySogm31IHZEs0TE2dqG6iUMcLYXdaJW2qd-Z3nlak5H0Wfe-aFgbSyyk?key=IHG69nLYporAh4AJgEG65Q)

5.  Close the Finding Details pop-up.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe-Uuw88nVoa8TKi31mr3V8qC3N0VA26VpmZr1KtpuXLpgxK-xK8JjJW-u_mxCfRFIvngaRnJAqoP3s5vdSWS-a311LzQ-i8wA0kGH9m5U0B8Mk3hf1DqEaf36f1mOgKor1tp9LWkvfbBBYDHYleymFZj4t?key=IHG69nLYporAh4AJgEG65Q)

6.  Expand the details of the other Medium Severity finding for sshd and TCP port 22.


Here, Amazon Inspector verified that a process (/usr/sbin/sshd) is listening on port 22 because the Amazon Inspector Agent is installed on this instance.

Using a service like AWS Systems Manager is generally preferred over public SSH access, which is why this is of Medium severity. Running other rules packages would check for additional SSH vulnerabilities, such as allowing root login over SSH.

Since the port was recognized as SSH, this finding has a RULE_TYPE of RecognizedPortWithListener in the JSON details.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc8zLJd1Ry96Pso3hPJCwqp7hUIgi24elFXjhkI0WxjU8EMIMkv9KMFjpkrcWExsBa5d1sObx2wLksRQsB7CBlBime3zqSAphZsBQ7eJPcXXqgcgKD4qcChN1hknGJkprIjzf7WDGeEkVzwKdGDgWtydLWB?key=IHG69nLYporAh4AJgEG65Q)

7.  Expand the details of the Low Severity finding for nc and TCP port 25565.


Although Amazon Inspector couldn't identify what this port is used for like it did with PostgreSQL, it detected a running /usr/bin/ncat process listening on it.

Since the port wasn't recognized, this finding has a RULE_TYPE of UnrecognizedPortWithListener in the JSON details.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcsr9kPnIA14HOmpS4riUrLDuw1_XHeae_9EOz5Rux8w18I5mVFqr37zXj60SIxr9c99M8iUhSB6kbxjTIZ9bbYxuCyl2WxXLhjWkU4er70kuAOkkMJtcu8Klf_ZJJksElwJAtLad3e75UdRIpIicm5AhZp?key=IHG69nLYporAh4AJgEG65Q)

8.  Expand one of the Informational Severity findings for Aggregate network exposure.


These findings are generated whenever any ports are reachable from the internet. They are always of Informational severity and generated in addition to findings about specific ports with varying severity.

They have a RULE_TYPE of NetworkExposure in their JSON details.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXefQhLQSI1tNwR7Ij_5pJ0KZhP7_rhVV6AubhG0HRMuNIkDx_j4slQ8NAd_Q4ikfJEts06Ai9K3G2yikxiM9UrCVa1knTpIk3KscvcZXsQKTTaxCaPPyLqujAUDGqrKhbp5WjMH8txmnkLnBEpNuEJm6Mw?key=IHG69nLYporAh4AJgEG65Q)

9.  Expand the Informational Severity findings for TCP  port  443.


This finding isn't of higher severity because public HTTPS access to an EC2 instance is necessary for running a web server. This applies similarly to TCP port 80, which corresponds to HTTP.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcVvPhc79meWd3geqRiVNPv0qutcdeMv3KB4gEPwxeq2awchbAkApYG0sKzZBnKCzTWXP3kTVrSeurwFk2X-UdLzc8EQXRx6VPSLbPPQt-hRRTWxLQFI2xG6BZlli21vbl0hwX3M_zsW2cFLoxXXNtWh9bQ?key=IHG69nLYporAh4AJgEG65Q)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfJl_ZlaBC4S8KC1XZleUnlijHVn0iQNti37uC3Iri9SgzhjkZDxJQolxhXjtEHUt8hZ_yVTQxwWSOAnFNPeyFg5CYeNCfb8SxUpEMKOB43fB_jEab5U4A4rT2oKlrGtP3z1xkDKcNKACD1FxSYpUUcEaUB?key=IHG69nLYporAh4AJgEG65Q)

You've now reviewed all the findings identified by Amazon Inspector. If any findings are unexpected or mistaken, they can be addressed by following the link to the relevant Security Group in the Recommendation of the finding.

Using Amazon Inspector Network Assessments is an excellent way to ensure an AWS network is configured correctly. Assessment templates can be set to run automatically on a regular schedule, quickly catching potential misconfigurations before they can be exploited. Findings can also be configured to send to an SNS topic for phone or email alerts.
