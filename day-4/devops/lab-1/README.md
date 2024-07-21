## [Deploy an Application to Multiple EC2 Instances with AWS CodeDeploy](https://app.pluralsight.com/labs/detail/239d6cfb-ed92-4c18-8f7d-252979d96a36/toc)

This section contains step-3 of the above mentioned lab because the instructions are outdated.

### Step 3: Prepare an EC2 Instance for Use with CodeDeploy

1. At the top of the page in the search bar, type in and then click on **EC2**.

    **Note**: Before continuing, make sure your AWS region in the top-right corner of the screen is set to **US West Oregon**.

2. In the left-hand **EC2 Dashboard** navigation menu, click Instances.

3. Click on the **Launch instances** button.

4. Under the Name and tags section, enter `CodeDeployTestInstance` for **Name**.

5. Under the **Application and OS Images (Amazon Machine Image)** select Amazon **Linux 2 AMI (HVM)** from the Amazon Machine Image (AMI) dropdown.

6. Under the **Instance type** dropdown, select **t3.medium**.

7. In the **Key pair (login)** section, choose **Proceed without a key pair** from the dropdown.

8. Under **Network settings**, click the **Edit** button.

9. For **Security group name**, enter `CodeDeploySecurityGroup`.

10. Under **Security group rule 1**, select **HTTP** from the **Type** dropdown select **HTTP**. And make sure **0.0.0.0/0** is selected under Source.

11. Expand **Advanced Details**.

  - Select **IAM instance profile** role for instance as `CodeDeployDemoEC2`
  -  Paste in this user data script under **User data**.

  ```sh
  #!/bin/bash
  yum -y update
  yum install -y ruby
  yum install -y aws-cli
  cd /home/ec2-user
  wget https://aws-codedeploy-us-west-2.s3.us-west-2.amazonaws.com/latest/install
  chmod +x ./install
  ./install auto
  sudo yum update -y
  sudo yum install -y httpd
  sudo systemctl enable httpd
  sudo systemctl start httpd
  find /var/www -type d -exec chmod 2775 {} \;
  find /var/www -type f -exec chmod 0664 {} \;
  echo "<h1> This is version 1 of application. </h1>" > /var/www/html/index.html
  ```

12. Under **Summary**, enter `2` for Number of instances.

13. Finally, click **Launch Instance**.

14. Click on the **View all instances** button, then wait for the **Status check** column fields to each display **2/2 checks passed**.

    Note: It will take about three to five minutes for the fields to change from – or **Initializing**. You can click the refresh button to get an update periodically.

15. Select one instance and copy its **Auto-assigned IP address**, then open a new browser tab to that address.

    Note: You need to use `http`, not https. For example, if the IP was 127.0.0.1 go to http://127.0.0.1

16. Do the same thing with the other instance.

Each browser tab will open to a simple page displaying **This is version 1 of application**. You have successfully configured your AWS EC2 instances for use with CodeDeploy.

Note: To make the final challenge quicker, you can keep tabs to this IPs open, and for the final challenge just refresh each tab.
