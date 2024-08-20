# Launch an EC2 Instance from the Web Console

Amazon EC2 (Elastic Compute Cloud) is a core service within AWS that allows users to launch and manage virtual servers in the cloud. These virtual servers, known as instances, provide scalable computing capacity, making it easy to deploy applications, run complex computations, or manage cloud-based workloads. This guide will walk you through the process of launching an EC2 instance using the AWS Management Console, giving you the ability to start leveraging the power of cloud computing for your projects.

## Why Launch an EC2 Instance?

Launching an EC2 instance is a foundational task in cloud computing that provides several key benefits:

-   **Scalability:**  EC2 allows you to quickly scale your computing resources up or down depending on your needs, providing flexibility for varying workloads.
-   **Cost-Efficiency:**  With EC2, you only pay for the compute time you use, making it a cost-effective solution for running applications without the overhead of managing physical hardware.
-   **Customization:**  EC2 instances can be tailored to meet specific requirements, from the choice of operating system and software to the configuration of CPU, memory, and storage.
-   **Security:**  AWS provides robust security features, including security groups and IAM roles, ensuring your instances and data are protected.
-   **Global Reach:**  EC2 instances can be launched in multiple regions and availability zones around the world, helping to reduce latency and improve redundancy.

By launching an EC2 instance, you gain access to a flexible, secure, and scalable computing environment that can be used for a wide range of applications, from simple websites to complex machine learning models.

## Step-by-Step Guide to Launching an EC2 Instance

#### Step 1: Sign In to the AWS Management Console

1.  Open your web browser and navigate to the [AWS Management Console](https://aws.amazon.com/console/).

2.  Enter your AWS account credentials to sign in. If you don’t have an account:


-   Click “Create a new AWS account.”

-   Follow the on-screen instructions to complete the registration process.


#### Step 2: Open the EC2 Console

1.  After signing in, locate the services search bar at the top of the console.

2.  Type “EC2” into the search bar.

3.  Select “EC2” from the drop-down list. This will take you to the EC2 dashboard.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXckg-FcqbMkXLVGJ__47h06pJrlOJ2VHawB6oKheJc2RW_0CbezylQM2Hel5G6BOVkDN22JcSKHpziwt6QZ_IoqXGHuMncJxJEF0r0Rxe9QeMgAdN89o7VQwL8ad3DyEUU30XIjYE8TssK2Ep00rViWcA4?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 3: Launch an Instance

1.  On the EC2 dashboard, click the blue “Launch Instance” button.

2.  You will be directed to the “Launch an Instance” page, where you can start configuring your new instance.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfXHf4fpEQJaaP_amA_pSZ37aAX0L4iEu7CZrVLrJt1-jBY_XprZJ276lIA8BSV3MzfEtN-UZwW8PE7H0XlNboYJFDPMybrNEoDrzsqkkpEp7f0gHzl9gdqmEfaHS1ON1G-ZdOBKb7TsqSACnGbjVp2Y50?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 4: Name Your EC2 Instance

1.  In the “Name and tags” section, click on the “Name” field.

2.  Enter a meaningful name for your instance, such as “aws_linux.”

3.  Click “Add name” to save the name.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdgeZNITp9jcAV3TpbWZhN5w2FLwRNDgmqVL31ByMyNVfGSlnyxLcxCF_cROeJIW5VoWX4q8Ah6LWzAHJBv6IsBaGf4Y9m0F6O7gt7SwYz0DdxRYBSrldzaR8fUmJZk3hZc3rH0g_MsJL9nPyhYyxpkG5Kq?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 5: Choose an Amazon Machine Image (AMI)

1.  In the “Application and OS Images (Amazon Machine Image)” section, you will see a list of AMIs.

2.  To use Amazon Linux, type “Amazon Linux” into the search bar and press Enter.

3.  Select the latest version of the Amazon Linux AMI by clicking the “Select” button next to it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdcW6SJcebQmTHpFoED8zlakDAqqniwKx6XfuTWYaqD-p0lBgsYjgYWwzArAYQ6QnRyUTtbNkZ3yRfWwSZI8PzTSG30QeTlmjY5suHvw3U_zGdIAkZKVUA1_lS8Zqs5gJATHAezI6WVcTPNmZCjN5mPQkfI?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 6: Choose an Instance Type

1.  In the “Instance type” section, you’ll see a list of available instance types.

2.  For this guide, select the “t2.micro” instance type, which is eligible for the AWS Free Tier.

3.  Click “Next: Configure Instance Details” at the bottom right of the page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe4EjjVrKRnLqiA6qKu8nhd5rYwkj9342nQYZypZHtK3UbJgtufW0yIq9xZw0WYQZOZYvR9tl-esL4I2Rk4qcsC8LPuRzkdXM_QtnakHHeMQ8n4hueWiP3YTcXg8K2sXtFp4N5v_59x8YnfgIaWUgAfauo?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 7: Create a Key Pair

To securely access your EC2 instance, you need a key pair consisting of a public key that AWS stores and a private key that you download. The private key is used to authenticate and establish a secure connection with your instance.

-   Select an existing key pair or create a new one by clicking “Create new key pair”.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfgK7ft4AzHxy8H0ykena0iHAQiGukbhwktRn5OmP0M7rZexazlq0Gi8oRzWfoNBCbIbSG5m4StlAUDMxY2sT_a1tjqkXB3SXP3ECMPap3GzEA4W_IsORKnAUgo7emrEtlq6Rexf5apeTvA9PUFS3sJyG0k?key=7hoKZ2BB2A50XUYkIxdcUQ)

-   Provide a unique name for your key pair.

-   Select the key pair type as “RSA” and the private key file format as “.pem”.

-   Click “Create Key Pair” to generate and download your new key pair.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdb48aQF6bwFj66DfwN4XEUh4Q0GbFk-G5XkHlgflgS3aeG80Q_tsaoQr1rLfHVRyLG7HB0RMvHu2nC3rIx4LxjM01UNlpkSoZyAM4PaetgXoS1WRkA04HjnQd0f7S02P483-ENOQC47yfvvp8KZI1_G74w?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 8: Configure Instance Details, Add Storage, and Configure Security Groups

Configure various settings for your EC2 instance based on your requirements:

1.  Instance Details: Specify the number of instances, choose the VPC (Virtual Private Cloud) network, and assign an IAM role if needed. Enable detailed monitoring if desired.

2.  Storage: Attach storage to your instance by specifying the size and type of Elastic Block Store (EBS) volumes. Consider storage size, performance, and encryption options.

3.  Security Groups: Define inbound and outbound traffic rules for your instance by configuring security groups. Add rules to allow specific types of traffic.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXekyKbt-ACG_SE29woaEmpP6Qwk4f8m_LK2CyPxXrYjVJFxMG4j4CpfJRM0GAGJumaDust3Ki5xsFqRKn0Yv4iJ5vMNq60zhEERFMfZstc9OYWVt3bpLFhRIJJGumdJgQA6Ujc0trZadXs0Nj8hMGPRrgM?key=7hoKZ2BB2A50XUYkIxdcUQ)

#### Step 9: View and Manage Your Instance

1.  After launching, you will see a confirmation page. Click the “View Instances” button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeLtc55EKHi1hP0aAwqN1Q9qAklc-bPC0jYD9ukvTVOq9bzrMCR03_ZLPEmcUk0Zh9iFiiUzn-mpuxYXmknLc9Sz4l-7zvaaqqWfmrk0VEvDtY9McKGf-_jahPmW12DVEtzfIhZLL7WnxAr9SCVE8zx1JE?key=7hoKZ2BB2A50XUYkIxdcUQ)

2.  You will be redirected to the “Instances” page where you can see the status of your instance.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcqPZwHnO1E8c_a-EZgvovDVDCo45uI4RkclRMFicV2E7iwWhSlZprEZB0j8b4uCzHtBeUHWis9sGG-23D4bZkXKoL_EDB2bHkIVU_ETsQ-iV2mdM4CoyJOYg5dQFnqmCc8WgTYFzSCMv-o3q_V_wai2NN8?key=7hoKZ2BB2A50XUYkIxdcUQ)

3.  Here, you can monitor the instance, connect to it, and perform various actions such as start, stop, reboot, and terminate.


#### Step 10: Connect to Your EC2 Instance

1.  Select your instance from the list.

2.  Click the “Connect” button.

3.  Follow the instructions provided to connect to your instance using SSH. Typically, this involves running a command in your terminal
