## A Single EC2 Instance in a Private Subnet + Bastion Host


This lab is designed to demonstrate how to securely access an EC2 instance deployed in a private subnet by using a bastion host in a public subnet. A bastion host acts as a gateway for accessing instances in private subnets, ensuring that the instances themselves do not need to have direct internet access, which enhances security.

### Why Use a Bastion Host?

-   **Security:**  By placing your EC2 instances in a private subnet, you reduce the attack surface, as these instances are not directly exposed to the internet.
-   **Controlled Access:**  The bastion host serves as the only point of entry to your private instances, allowing you to enforce strict access controls.
-   **Cost Efficiency:**  Instead of requiring a dedicated VPN or direct connect, a bastion host provides a simple and cost-effective method to access your private instances securely.

### Lab Objectives

-   Set up a Virtual Private Cloud (VPC) with both public and private subnets.
-   Deploy an EC2 instance in the public subnet to serve as a bastion host.
-   Deploy an EC2 instance in the private subnet that can only be accessed via the bastion host.
-   Demonstrate secure access to the EC2 instance in the private subnet through the bastion host.

## Goal
The goal of this lab is to demonstrate how to access an EC2 instance launched in a private subnet using a bastion host.

## Architecture Diagram
![lab-002-arch-01](images/lab-002-arch-01.png)

## Overview

In order to achieve the goal of this lab, you will have to go through the following steps:

### Step 1 - Create VPC
Create a new VPC with the *Name tag* lab-002 and the *IPv4 CIDR block* 192.168.0.0/16.

![lab-002-scrn-01](images/lab-002-scrn-01.png)
![lab-002-scrn-02](images/lab-002-scrn-02.png)
![lab-002-scrn-03](images/lab-002-scrn-03.png)

### Step 2 - Create an Internet Gateway
Create an [Internet gateway](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html) with the *Name tag* lab-002 and attach it to lab-002 VPC.

![lab-002-scrn-04](images/lab-002-scrn-04.png)
![lab-002-scrn-05](images/lab-002-scrn-05.png)
![lab-002-scrn-06](images/lab-002-scrn-06.png)
![lab-002-scrn-07](images/lab-002-scrn-07.png)
![lab-002-scrn-08](images/lab-002-scrn-08.png)

### Step 3 - Create the Public Subnet
Create a public subnet on lab-002 VPC with the *Name tag* public and *IPv4 CIDR block* 192.168.100.0/24.  

![lab-002-scrn-09](images/lab-002-scrn-09.png)
![lab-002-scrn-10](images/lab-002-scrn-10.png)
![lab-002-scrn-11](images/lab-002-scrn-11.png)

### Step 4 - Enable Auto-assign IPv4
Enable *Auto-assign IPv4* in the newly created public subnet.

![lab-002-scrn-12](images/lab-002-scrn-12.png)
![lab-002-scrn-13](images/lab-002-scrn-13.png)

### Step 5 - Create a Route Table
Create a new route table with the *Name tag* public and with a default route to the internet gateway created in step 2.

![lab-002-scrn-14](images/lab-002-scrn-14.png)
![lab-002-scrn-15](images/lab-002-scrn-15.png)
![lab-002-scrn-16](images/lab-002-scrn-16.png)
![lab-002-scrn-17](images/lab-002-scrn-17.png)
![lab-002-scrn-18](images/lab-002-scrn-18.png)
![lab-002-scrn-19](images/lab-002-scrn-19.png)
![lab-002-scrn-20](images/lab-002-scrn-20.png)
![lab-002-scrn-21](images/lab-002-scrn-21.png)

### Step 6 - Associate the Route Table to the Public Subnet
Associate the newly created route table to the public subnet.

![lab-002-scrn-22](images/lab-002-scrn-22.png)
![lab-002-scrn-23](images/lab-002-scrn-23.png)

### Step 7 - Create the Private Subnet
Create a private subnet on lab-002 VPC with the *Name tag* private and the *IPv4 CIDR block* 192.168.200.0/24.

![lab-002-scrn-24](images/lab-002-scrn-24.png)
![lab-002-scrn-25](images/lab-002-scrn-25.png)
![lab-002-scrn-26](images/lab-002-scrn-26.png)

### Step 8 - Launch the EC2 Instances
Launch EC2 instances using the procedure described in [Lab 1: Launch an EC2 Instance from the Web Console](../lab-1-launch-an-ec2-instance-from-the-web-console); make sure that each subnet has one of the instances.

Note that the EC2 instance that you will create in the public subnet (labeled as A in the diagram) is necessary so you can later connect to the EC2 instance in the private subnet (labeled as B in the diagram).  EC2 A is normally called *bastion host* or *jump host*.  

## Test and Validation

1. Select your instance from the list.

2. Click the “Connect” button.

3. Follow the instructions provided to connect to your instance using SSH. Typically, this involves running a command in your terminal
