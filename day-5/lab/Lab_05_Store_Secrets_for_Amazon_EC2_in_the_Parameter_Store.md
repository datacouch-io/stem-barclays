# Store Secrets for Amazon EC2 in the Parameter Store


This guide will walk you through the process of securely storing and retrieving secrets using AWS Systems Manager Parameter Store. You will also learn how to use the stored secrets to create an RDS instance through CloudFormation and access it using the AWS CLI.

### Why Use Parameter Store?

Storing secrets like database passwords in a secure, managed service such as AWS Systems Manager Parameter Store provides several key benefits:

1.  **Security:**  Secrets are stored securely and can be encrypted with AWS Key Management Service (KMS).
2.  **Centralized Management:**  Manage secrets in a central location, reducing the risk of hardcoded secrets in your application code.
3.  **Ease of Access:**  Access secrets easily from AWS services like EC2, Lambda, and RDS without exposing them in the environment.

### Table of Contents  
- [Create a Secure Parameter](#create-a-secure-parameter)
- [Use the Parameter in an RDS Instance](#use-the-parameter-in-an-rds-instance)
- [Use the AWS CLI to Read the Parameter](#use-the-aws-cli-to-read-the-parameter)

# Create a Secure Parameter

As a database administrator, you are assigned to create an RDS DB Instance on AWS. Your security team requires that no passwords be embedded on the application servers or the bastion host. Therefore, your company has opted to use AWS Systems Manager Parameter Store to securely store the password for the DB Instance. Your task is to create the parameter and use CloudFormation to provision the DB.

Note: Before proceeding, ensure you are in the US West (Oregon) region by selecting it from the location dropdown in the upper right corner of your screen, next to the Support dropdown.

From the AWS Management Console, follow these steps:

1.  From the Services list, select Systems Manager under Management & Governance.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXfIQfk7r35-rO66aCbW0kgJSxrnZkTbA0a_nrAnzH0UjYqdkN1hWGAcht9xucvSaChoT_NpU4cwDBi-8Vd3EfJU95zO79V0iZqY-pBtOHMTDD29rM8tn_UDpb4vandXjwoErK3a2lAijpu_BBDs-yRyooTQ?key=THsUaRwAY0Nofh9f2mFbGg)

2.  In the left-hand menu, click Parameter Store.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXduxLlSGVMpeTdp68Rsc20JJn8hJKEdSX6AWsrpowEira4zrXyVSIjPQTqTVxnIPWMMmCvoCiZjD1YeooL558u2EMeBZLUfuC6SxqlCAY9hjYRwTNnSfWGGUGs_qOvGmWv7aLEvTG6-et5RFzT97OqSU0w?key=THsUaRwAY0Nofh9f2mFbGg)

3.  Click Create parameter and configure the following:

```
Name: DBPassword

Type: SecureString

Value: L7BRXThY9GdTbPfQikq0N41LECjaLLMbovhFIZGfGctPQ
```
![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdvx23YV7qta1ghwRDcAjgfDgJl-4FMwu6yhlLJ_wFQPGVrTtvQVhIdaklks4GyqdIKhEF1RMxZIyLSsiPiiiXbX1xdRZ1w7zvrkkhw_8sTLHlqsOmfhOn0HAJhY7mM3Er-_OlaS6At1S5i2mRH3LTvnsIn?key=THsUaRwAY0Nofh9f2mFbGg)

4.  Click Create parameter.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeK2Yyg4y70Y5dIK604zFkH5qwDGf2_nb8MVhZbpk8FpCLUzsNJ4LlFg0JSMw0qCdEX3dOpCM_xuf4-oniMkhiE5Fcdi9_YWc7efZFssdhT_D-cqwCIdgOPKdjWpNptaPebZeeZJpJhm0NmwQNU8run7REY?key=THsUaRwAY0Nofh9f2mFbGg)

Congratulations! You have successfully stored a secret in AWS Systems Manager Parameter Store. You should now see a parameter named DBPassword of Type SecureString in the Parameter Store.

## Use the Parameter in an RDS Instance

Tasks:

1.  From the Services list, select CloudFormation under Management & Governance.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXe1KLOlIzniamQbeyMGYG0tJyc5ll5DvaNTJJ5GPuUqXTqMoy3vw73lckPrzHlzNtUCgh6Fd2C7oQh_AZosDEatA9FzuSLf-kFigsmsywJIVRKsV3Hd5gcE03LxPTakxcAh-YaNfeResBjVitoQPX1a1kwf?key=THsUaRwAY0Nofh9f2mFbGg)

2.  Click Create stack.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcdeLAF4VEq44-87wb-5hBkh4xhz5esAAutQ-X4JQKK7AXFP6rZVyoIN6rUgZTTtmWPFzOASao3TKqMYzqKqZ6EfdjFEhX8pIlMe22smz-2jZ89yB82RDsAwan5D8AnGrPVRlPQs5h8aTlyycHUMjE56dg?key=THsUaRwAY0Nofh9f2mFbGg)

3.  Download [this file](https://raw.githubusercontent.com/ps-interactive/store-secrets-amazon-ec2-parameter-store/main/db.yml) to your local machine.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdkWo2I1IyRyDRHvZ6Z6EQEu2x_BtmmafncGhc7rII9BHo9BgZ2ccAmPCK_MjN5xliteujt7J4_TqzK1-Vd2dS0Dt3wVpTfeAfqYNNUX6B5MLKxY4oltH1SpTCTai78AvQ5KbQDLZiKHPNBs0ffsL93i8f7?key=THsUaRwAY0Nofh9f2mFbGg)

4.  On the Create stack screen, under Template source, select Upload a template file and click Choose file.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeOTV69oKrlmZDN4mnGf7BTbJyFWN0lxRIbp_aLzeRRsWAXAEGnXdK3KT3UdyikHC_RJcalUMuTzmZTY1wG-__s9Lp9I7DjPYBzkqWNwdK1EpE2mQNAUlpijyLkJVXiGUYbD5A8-qYIDDuJqOOFulXMfDZr?key=THsUaRwAY0Nofh9f2mFbGg)

5.  Select the file you downloaded in step 3, then click Next.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcqFPPUc_cKbrbaAEEphQzlo-W2T4oJ3CPS1789kd9pcjGMfnqF-DtIDK-hAVeMgmkj33vg68U1DSWn5Hx8TG9bNGOaRNZt8m_BTH2nEMv6sOD4g-BcaNonZpn9h3P0br0ztEV4oLKSaMWi52nYni_N8nRI?key=THsUaRwAY0Nofh9f2mFbGg)

6.  Configure the following parameters:

```
Stack Name:  DB-Stack

DBSecurityGroup: ParameterStore-Lab-Db-Sg

VPC: ParameterStore-Lab-Vpc
```
Then click Next.

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdLQxkB8DIDt3tKWv5RePqWmd_2MJ0DmoeP7AoceAWF47GXNZxT37bG_7TUP1od4LMmU5IZtDrYthxTp2dcyRuDLTs-cbotyNR0lT5AjmfBWBtIWhR3MXwTLKRBaKhg7_WDgTQ6ilXTdKtxjAdbqecS36yL?key=THsUaRwAY0Nofh9f2mFbGg)

7.  Under Permissions, select the Role that begins with ParameterStoreLab, then click Next.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXf4eb2qKJMNqvPyLVL_kguoskvByabwGt_rbfV6AdEHOfrCZi8TEil8sfiuL7Kh91vjLi8zaBPRD6rLoxyv_9sbo1TPd2G0qPndTv6yOHHa9zSuH8KeC6x4LimXB2wfsLE-7UTHWWn6RxGb_iPB8-ZAt_Z0?key=THsUaRwAY0Nofh9f2mFbGg)

8.  Click Create stack.

9.  This will take you back to the dashboard for DB-Stack. Wait until the DB-Stack  status changes to Create Complete. This may take several minutes.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXecWope18d1cb8etUsH_IcZrV-b-L-rjBfUG2MpLB4htyq9lMiQri7x3Gl2jRDwFKTA5zZ8LAGJm_L6s2ankaI-oHYX7c7LH_9JfX3rOB-INEFAAFX_bi2JqmMGI8GMEuIFYEtaiXbTYBM0jxOaYp2vZYST?key=THsUaRwAY0Nofh9f2mFbGg)

10.  Click the Outputs tab and note the DatabaseEndpoint, as you will need it for the next challenge.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeHeKNaQThQOAaTGxu2rQg_PJlGZ06Rbif714vfS8wlH48zKoTyEUOSiFSpn5Wea0TcL2W3pupcAXPjG6MvK1UQJjHh5xjyuIS-OGqlxaJTQBhZ41TtUrXh4AVcEoS8ur3SLZOdqUT_ABNv9RkZ8tqHxPBH?key=THsUaRwAY0Nofh9f2mFbGg)

Once you have noted the value for DatabaseEndpoint, you will have completed this challenge.

## Use the AWS CLI to Read the Parameter

1.  From the Services list, select EC2.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXf7ubOIpejNJUuGJTYGE4Csih2FgwpK_hlACWHdM41N88IrEmIgvri3ZX4qXmSfREd7vhnSyiucnz4rQUcsd5Ns5kEQce_kRXzZywwvNd5PsLPggmGZQLxaCDxBTUc5JXr6MM3KARsLKfAEPwh_5wh6joFy?key=THsUaRwAY0Nofh9f2mFbGg)

2.  Click Instances (running).


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcwjJ-4_LyNH9oFER0B-ab1kH6yiPN6upFMReSC9Ir2WPHzFLkx6z6yOHyYgovJnsmcgLoWQqQAxdHVrtS-3nlds6kRlrGNtOOgN8Spii6y81m8IBYGtGyZP0REP9E0WfVERMdZIIpmwPMaRufJMX-24wA?key=THsUaRwAY0Nofh9f2mFbGg)

3.  You should see one instance running. Select the instance named ParameterStore-Lab-BastionInstance.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdNwUGuxlXQNasEKxXGy_heEQWGF6dUDWwh69QvJdFjGKIpomRsbRZCCmQ22yWmKJYxgwIJsg-AVOMJMpPDLsmJ_5ulLCWCBM8isHfUsRdX0iy4MJN5BcF10mZXtfq2TiYovUC8ZqIg3EIdjO2djWEDzak?key=THsUaRwAY0Nofh9f2mFbGg)

4.  Click Connect.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdjdWjO_QyaP_PSuayAij0fZWup8X5cfN4pBi1fEQobpLuDl1mMQMDDtdI-Ghi4t6sVAnJu2EVO68rfhUfSbWlwOLjJjoMIdGbeDUbOlFvUUP_QqBINZ5OVQDhezf8EQmBXjDCGwVIdTlSzJ9XPEv2JGv1o?key=THsUaRwAY0Nofh9f2mFbGg)

5.  Select the Session Manager tab, then click Connect.


![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcsOLsg3MgflS-fvLyIXm_al50QmbABERR2-CXsqn8AWcfNW4Gcs2fN_YkDX3uScTFU3_hH3cLMWeESIWjma5TKF2q_DwN7nLqQ3RbOA_DXx0aSL4WeVDCf6HtaahzisXLAvg0GC-Cs9zg-p4GPBwzZbyM?key=THsUaRwAY0Nofh9f2mFbGg)

6.  Run the following command to retrieve the encrypted parameter value:

```
aws ssm get-parameter --name DBPassword --query Parameter.Value --region us-west-2
```
You should see random characters appear on the screen. By default, Parameter Store returns the encrypted version of your parameter.

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXfB7pJ8LjO58Mzqlt_aEOhvg6hYY-zH5Q7lGxNFEKNIOuUeh1Zh8bWuNsXvsHZuok8jQ12pMjfhrHE0GAePnQJdXAlho3YZ0u4OxwOIv7ZrffPN-rnp-VtsGUF5p2JZlDd3ryK8dGCnf9pSFkI8-47kAFI?key=THsUaRwAY0Nofh9f2mFbGg)

7.  To get the value of your parameter in plain text, run:

```
aws ssm get-parameter --name DBPassword --query Parameter.Value --region us-west-2 --with-decryption
```
You should then see the same value as what you set in the first challenge.

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeGjGkwJw_AVBBvOEp6RxvNWW1gSiNXbJYi4aWjY5Tyar4cyVi1GnIjRe_MkYYAbpCTI3T43lzNP3E_CtHbN5eZ8pl4zcwYnhLNOwyMHmbLAsR766hpLSX_mYdZxxk3y4Y3ahX8c4Zco3A3gUjypIWZGZFn?key=THsUaRwAY0Nofh9f2mFbGg)

8.  Run the following command to store the value in an environment variable:

```
export PGPASSWORD=$(aws ssm get-parameter --name DBPassword --query Parameter.Value --region us-west-2 --with-decryption --output text)
```
![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXfYc3VybRT8QRYHNiwQ8KvMMDGWLI5KGj9WHczlRwLeLpLik9Jbt2Bgm65SpHSUu5biLQcVW2yQWOwz8o7aQfH246X4fR_vp01n3b0qrvpqHaoNXzpNNowQ-DvkGuA5NzPZRs4hizIAha5J-mSmatDXTFVP?key=THsUaRwAY0Nofh9f2mFbGg)

9.  To connect to the DB instance, run:

```
psql -U labuser -h <rds host> demo
```
Replace <rds host> with the value of the DatabaseEndpoint that you noted in the second challenge.

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXe9JSx6RAZp3m5oZz_KH7bLIp6AQavGvr9n9Bh1icfIbYCmCeOc0aU3_Oyd3XD4unmvsaRRulNlXX0tPK2m3Ss1IgiyDq-2itUCm12iCj58QyLd1IpN0qc_YZjl8gxqbZxigZTW5ZbRQs-DEEk2PkrgLWBT?key=THsUaRwAY0Nofh9f2mFbGg)

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeDurKJdFpTPxW9SKhgZ5XdnXaqeT47i9EUg6cjIe0laWzwF2yCfrjm46Gy8V21CuTP41JhrNhfDMmPIYg5UICPgib1thzHzYOy4Rvzvoodoll8o97XeiXKBgU1JJKHXEGOHQS9XwbpWwC9e5Y36Sfzyyhb?key=THsUaRwAY0Nofh9f2mFbGg)

Congratulations! You have retrieved the secret and stored it in an OS environment variable. You should be able to successfully start an interactive session with the database. Running \l should list all the databases stored on this server.
