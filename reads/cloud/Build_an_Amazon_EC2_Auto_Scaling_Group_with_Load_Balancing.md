
# Build an Amazon EC2 Auto Scaling Group with Load Balancing

Setting up an automated, elastic environment in AWS is crucial for modern applications. This guide provides a step-by-step approach to building an Amazon EC2 Auto Scaling Group with Load Balancing.

### Table of Contents

-   [Create a Launch Configuration](#create-a-launch-configuration)
-   [Create an Auto Scaling Group with a Launch Configuration](#create-an-auto-scaling-group-with-a-launch-configuration)
-   [Create a Launch Template](#create-a-launch-template)
-   [Edit an Auto Scaling Group to Use a Launch Template](#edit-an-auto-scaling-group-to-use-a-launch-template)
-   [Configure a Load Balancer Using an Auto Scaling Group](#configure-a-load-balancer-using-an-auto-scaling-group)

Follow these steps to transition to an automated and elastic AWS environment by creating a proof of concept for using Load Balancers and Auto Scaling Groups. This document covers creating a launch configuration, setting up an Auto Scaling Group, and configuring a load balancer to ensure seamless traffic distribution.

## Create a Launch Configuration

Your company will be utilizing Load Balancers and Auto Scaling Groups in AWS to transition towards a more automated and elastic environment. You will need to set up a proof of concept to validate this transition.

1.  Click the Open AWS Console button to the right of this text, then use the provided credentials to log in to AWS.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXebLj9FWbmoHTQsdHn9PgW1djbW5yMdChCGS6e8He8G_tU1fMPTxlsICZ_4nxPoSw7rHKXCiWNgdMov0KiwO4p214wX7F-WMybWWAS45x414RlfdvpdTe_hsyeq02kjjZSnAnzfPKgCRHg15MMBL3hNvQA?key=vAZmTY4xiASAJC-8-etUyQ)

2.  Use the search bar at the top of the page to find and navigate to the EC2 service.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcZEJveho1GJUQ831pVbPP2Ft1OE2v9ounFxFd9FoK37_5vlnCaibFg6K0yVrpXlGvFdkglWSP8fm3kqdK9-RQwW88v4ZjlN-wegmPhPHQWxDwRK9ZJ3YZTy-IbB60ZNOBBu5EWMHo_X5CRfdAw-KUgDOfb?key=vAZmTY4xiASAJC-8-etUyQ)

3.  Choose AMIs from the menu on the left.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdRmZsd8PpVDZkLXVo8pZtXZ_wfcqAQF798W96hQoueoPYaI8aO2XehASgFm0j1Ti2eil-TBr_S_dubFOlZqzuOa3xnEHEdgLFEnNfTUQxfwtyITL2DEuA9xPpnpjz2eCuuNKHUbtMSmXTA1Ht74GLQClri?key=vAZmTY4xiASAJC-8-etUyQ)

4.  Filter for Public images with an AMI Name of amzn2-ami-hvm and an Owner alias of amazon. Copy the image's AMI ID and save it for future use.


Note: The desired result should appear near the top of the list and will have an AMI Name similar to amzn2-ami-hvm-2.0.20201111.0-x86_64-ebs.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdmt-wjVxLe6qo9l1ddGOYlOmoYPK_BRYmlkFWn2UCY9Z_-ebNMlyu2gcyS3v5tSVs3eZzZu2TKlT5sxAafeTlx82M3KvvDO_BSci8bMGcPWICnsVQdcKADw9CuyH0t2cGPBhUSfjy1s9Gow7Qxec1WdAeF?key=vAZmTY4xiASAJC-8-etUyQ)

5.  On the left side of the screen, under Auto Scaling, select Launch Configurations.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdnBC-fQTj6DhQO_IGDMCNYNIQrxJTsAOOjXLk7cpgYZiXwK8Mso1jNHCZXeY1yqWRJENYyNqK9S4ZuhvxDXvxw2E7YLLh7wG1RPrglV1UqtT7wxf511_NWMzYsC2TymAigk4mgC5CUds0XqR-bj4_vso8V?key=vAZmTY4xiASAJC-8-etUyQ)

6.  Click Create launch configuration.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc7zkMV2-FPk53D2mOW57QUI462AgvnLjbj7-7dfI322ZyEVSCWqMcSjjsFvyrPncK8NUZBk1K-fkNqDWHinjwdltqpXkr3vtot6x2-Ql30xge8jMmB_Fb7T5iTyRZH0FriBNuVLNI7UtsXpGI1jVuNa2w?key=vAZmTY4xiASAJC-8-etUyQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcDaXOEhusqp7ZBp3FzL7rKtD5LwbyRFb7xIwJp270w-oZEE7yHGR4jaEWx1yLgBHqc4gY7FkM-VIbtM-Li6goeUGDE0onYRU1vH1Fhy7i3eUi1lCoFpJ2mBQv2ibFOVGMgtPB9mJ2ltUZ5V8Al_fRyZBk8?key=vAZmTY4xiASAJC-8-etUyQ)

7.  Name the launch configuration TestLC

8.  Paste the AMI ID you copied earlier into the AMI drop-down menu and select the appropriate result.

**Note:** It will resemble something like `amzn2-ami-hvm-2.0.20201111.0-x86_64-ebs`.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd4vTBeLJTG49MhGMBFQvN2COgV89L9B7U2btRlxxQn53F3KgYttWqjQ7sAPzleWiItiADJ3djmzMazxLhdTLPW-2-0yWGTFwz6ngNtWfPLIk7UR4Wx7XUQbV3UHQK2LVAhJYoupRzQ1BaG54dcKKmq4uyo?key=vAZmTY4xiASAJC-8-etUyQ)

9.  For the Instance type, click on Choose instance type, select t2.micro, and then click Choose.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfQ1vFg4MKijX-rX_9eHvByDH0w_JiZvG4P1a72BX8JkeKsAQgVWHGzrEJDc3WC1ljBWPsg-h1NkJckdGjoTxoTxfv26s8lv51nRquMJx5RVg0Z6WVoNoKnH_QVJ3N-ye1O4qsYwa7ouzyoZ7jeE_D0yA6b?key=vAZmTY4xiASAJC-8-etUyQ)

10.  Scroll to the bottom of the page, open the Key pair options dropdown, select Proceed without a key pair, check the I acknowledge box, and click Create launch configuration.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcr84HXUyBKYUvhT2DPnZdEFVaHtg3xl36jcLxbVb1UcqpiEc6JaZdmNSeKm3P4EFY64eIGOmWbf30geX94MIhQkY8CUGgJ7c2I2K7jaa3dve__vS5EQRg7mesITBcbfN_BCIwKLXTsRabQeGZa77-w8x6p?key=vAZmTY4xiASAJC-8-etUyQ)

You will be redirected to the main Launch Configurations page, where the TestLC launch configuration you just created will be listed.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf7hfb6yiURPLtIjNFiJBeD8TlCigmv9_OYDxRGU4BjZbg3zdNUAinQZAtgPSwwQA7nPDefuVq5fLRs21AKO__TGRcY6AIDKyEJHffmRmqBYX8-FFLO45vwSj8fSuxyPhaKtzk1GxIIifyWnwZhlAY-LaT8?key=vAZmTY4xiASAJC-8-etUyQ)

## Create an Auto Scaling Group with a Launch Configuration

Now that you've created a Launch configuration, you can proceed to develop a proof of concept for the most basic form of auto-scaling groups.

1.  Navigate to Auto Scaling Groups from the menu on the left-hand side.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfXFc0E5K72o_1IsOn08T2zzhmEseLJgWFqvWFdaRF9A0HbKTOXczuXoxlsy-P23s5h_oBEPwerQ8FcWI5k9kE2oXnMkRbNlDnn8Px2-fzPJGIWpSI1a62atRqNkoxmt6xs3k0Qf1CViytxWFrCtL7Bx-SK?key=vAZmTY4xiASAJC-8-etUyQ)

2.  Click Create Auto Scaling group.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMOv0cQ5aitcURsn05XfawCK_DaIFXJPnyryxqH3jWPapRmXzcXmvW4Hft-Q5UeeAdzoIfFFJwfuQ1K-sC75MOO_cjYMg7hmRF1qj5DS0Y3wBhaMumTOy3kj3dB5CZ-0w9BVLVsenyJ2p8B24u6QHiooq2?key=vAZmTY4xiASAJC-8-etUyQ)

3.  Enter TestASG as the Auto Scaling group name.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdXCkUMHwl0qtktZjxdq1x_MrKlZB4Je71qSurVAf1mqYrRNdwkAbE7HICpsTC71rG3YQGVndgOz6zIvQEFdJJt6qET9edkz6zIleoKC6vOo1hGaDhPKvjiyEpkHmr1zbP63k9kAwSQF8bnHefqRx2jns5-?key=vAZmTY4xiASAJC-8-etUyQ)

4.  Switch to launch configuration by selecting the option in the Launch template section.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd_wSF3KktGtJS8iJGeeONdaxczrAw9hLrSrbk56PMmO7RSxbEl88Vc09O-gKkQ8eKHOPd3nJHfJmPKiUF_wFXl1nHbmYTSPb8SvpxK2QXV8IE8IG1vG6Eisr2XsSp6x3cpWDTUzIp4udJ89MBjr0kZif1Y?key=vAZmTY4xiASAJC-8-etUyQ)

5.  Select TestLC from the Launch configuration dropdown, then proceed by clicking Next.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcOWGET1_F2188kIPUeL2udVbkWHpRNlmlTqTFsNlU_eK2IHZsDq40x1xoF3mumuH0GmPwkx0SRw53aHnbB5lMQmkQn2YKVfCqLc4-Mshi-HP389343SvHEh5jTzzpNUemJBKUWX4Ci1R7y6QdXIb_8KwXq?key=vAZmTY4xiASAJC-8-etUyQ)

6.  As the Subnets, select us-west-2a and us-west-2b.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXftvaZvclJGCHDHn6Fsfs6A0bFCjmS8Co5FwuDUA0xOyGB4VKa2qOI6EhNvOS_RPPTkAJDb9zLq6n1a0wgKBdb28RUXtjtyeZrPVwBE8M9ZG-yKjVrgQ79ZXzBmBPr0FU0XAlMR4zZb9PWx0_-XHQ1e7eOd?key=vAZmTY4xiASAJC-8-etUyQ)

7.  Click Skip to review.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfUI9IY3-xG0g4PaoUkwS1TeP4pz_lYgViuihlWhYBN2cltn8afZwgZ04MkGS01zdhhKFJ5vRKi6PMa7NAbCbqan9dlTZAnGYM4hARA0afQHHpdrCzde8_e_ri8m3qEGkg5s2VkHSzfTKpxxN-0IzJVEItU?key=vAZmTY4xiASAJC-8-etUyQ)

8.  Select Create Auto Scaling group.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXc1904sBR89UC5YK8tcq4x9M7NHb5Q8DqBT5Qg-LZtkhl9efYH_0T5WjhYdb2ti2eaJJFoQgiocBb20SBew3M9cq-DZR6KBGxTPNOKeSfF1hsNv8HlnZbcjLYrqaQQQR-2EN7wRVMBdINeA6C_e76sUDfFa?key=vAZmTY4xiASAJC-8-etUyQ)

The Auto Scaling Group named TestASG should now exist, with its associated Launch template/configuration being TestLC.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdnc_cC8b2UKQMUnLtNWUdVr7VC4PaFwQ7IDbW8dInTiYvDs_mVX3n-sxfDoKh8Jla2kKTy3nMg0R-fxFrkxP96TVWIFYoEwvqL5KIBjwvA0oUIjZTFg3IYRogAj-vxvXK3aS4MySKnbUR6XoWjkGOydR2s?key=vAZmTY4xiASAJC-8-etUyQ)



Note:

Alternatively, you can use the left-hand menu to navigate to the EC2 Dashboard. From there, click on Running instances to locate a t2.micro instance that has been launched from the Auto Scaling group.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeTsqP6N1EFi0XmCbv6kQs6lQ3fdM_EwfrjeDhRLZlCpkyT1L79bczXKcigks-kTcW_jPSdYZ0fx6D0dFsTkiz1H7HHUtoqxxawLETH-X9wHJ7gXAXAVYVpH1o3IDYdM08c0RVR-QwEpF-1IYhDiUX_pP9S?key=vAZmTY4xiASAJC-8-etUyQ)




## Create a Launch Template

Because launch configurations are not scalable for a true production environment, you will instead create a launch template to replicate a production-like environment.

1.  Click on Launch Templates from the menu on the left-hand side under Instances.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe5CrHtvK9ibilqs0GYHYO-WGYkQSBs8baAjTeqx5gSQuFO9mmGy-W0GgdCGdmGi_vgPHY-tBB_t4RJfPm1vYPg-POOieGZbC35yehgJkQD1RtP-CDXzu0KvEQFcYhieLDtSPBLhkdjaqCWcx92q-Kmiggp?key=vAZmTY4xiASAJC-8-etUyQ)

2.  Click Create launch template.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcLQiDJHBREoa8Fa2fAGDp_tay_ivvEl6hPNCZmZkf4_QRZlUSZWjq2OGrXiBtohibhj26HR4QgOOyJW3DH5EmsnMsP4BgZvCJ5WXOVUyGJZnQMr99dePLyiv3C18K9WprFi0IwzSP6_4jeFhdVMCWnt8JN?key=vAZmTY4xiASAJC-8-etUyQ)

3.  Input a launch template name as TestLT.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdG5EnhE_fIz4y9Z1T8nkK7e7A3kPh4bwsEZ1JLVaYMCjqHCpyTP0NtBx0PVQzqqItkCnMjksvKHqckYdPIb1uE6NqGdnT4IRNkTsofsaU92W4Jpb0cn46IsoXpczTHsQ5kveAxRB9Q0NH1xk82C4EeO9xv?key=vAZmTY4xiASAJC-8-etUyQ)

4.  In the Amazon Machine Image (AMI) section, click on the AMI drop-down menu and select the initial option listed, which is the Amazon Linux 2 AMI (HVM), SSD Volume Type.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcxiZUskthB74EWWJ9zJ7UhdV3J0nGRhNyzutYs1zYPqPBa6T24NCcZEE-6neKR12_SqrO3LOJEbNx6qKz-cgbHIk-vsuTmPtuwiJeTTwvgZyDqkRk4e9ciEVsaruYoN55D_0zu2N66-lwOIPmlLEO6rOBX?key=vAZmTY4xiASAJC-8-etUyQ)

5.  For Instance type, choose t2.micro.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcZRLClCDlfkdJhdpEcFijjApVxgKzoCLURSuGHw_YY4e1wODfxHWUgzJwGV5HLlp70SA7xnCZJwvOkNqTqNpmUJPJ8CpKaYVlDUbljXUiM9ma7rWORhiOLKnZfnbcMZ_o2O1KArjDlD93CNCE3DNb81RbN?key=vAZmTY4xiASAJC-8-etUyQ)

6.  In the Network settings section, under Security groups, choose AutoScaling-Security-Group-1.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe6b4qdzLOhnciPwo18JpBokc58mwyt1NJVa4hkQIdR03FzQ3PXagfeuHL0HnB-vBp3Hw6gQSgpXesKODKUWAbDw7c7gAYK8ByUEsYYv1L5MX5-hle9TpYKSQfwhYSa6ElPU79Vkr7s0QY9OrCzb9T16hol?key=vAZmTY4xiASAJC-8-etUyQ)

7.  Click Create launch template.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfXOBBnpqdTiCk7sjt1Ts2mVpt1q3HENr-reqDC-NEAeRC35vx049o1CdWBZMpe-zfuCiILBH92kehiLbGz-e-bEx8GwLeF8uh3gEh47aemFWpyiXUtpLkjRQZEPjq5Bxh3t4BkYceSi7N49e2n7JPUa24?key=vAZmTY4xiASAJC-8-etUyQ)

8.  Click View launch templates


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfcDrSqgFppf8TxzV_KHhqZfnWYMqgKhzNCSgDqBDyQSGJXaMroJUjwa0Nnu06m720lKLb_n-s9sUoAnj_4SFqq9sbOX9a2BB3YDYKaHSZ9vdRrr-dN7Y1dEvaEsIPbrV_79d8c2j1jaAV9soxqoCq57HI?key=vAZmTY4xiASAJC-8-etUyQ)

The main Launch templates page should now display a launch template titled TestLT in the list.



## Edit an Auto Scaling Group to Use a Launch Template

The primary objective of this proof of concept is auto-scaling. By using the newly created launch template, you will now configure the auto-scaling to support the template and manually scale out.

1.  Return to the Auto Scaling Groups page.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfgqSZ20JolmGEdzW4Kr6NpvPHYdGc_5NJli736WKWJ5UZImIq32-FMn8zsXMigccnZv2p-CD8wSwzfi78AlwTVSW28HQ9tTGrUIhu_KhQPI_KNE3NNgveTAk8iaGh7bxctb00pX9ZBQnIr4-H1KRJ5aIZB?key=vAZmTY4xiASAJC-8-etUyQ)

2.  Please choose the Auto Scaling group already named TestASG, and then click on Edit located in the Group details section.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdzO_eYUlhslatD7iYcvrKgK1tUxSe4T3X1hI2VVqYSNLu8vQqzbbSgFMSIkiYiwXn4-RWwBMLNCj2M6ivZemfdxjRbX1HIUUgjvFZ3gohZJBK1I2_OWXw5h9silAik0Npov-p3-FrMzapIvj3m9e74q663?key=vAZmTY4xiASAJC-8-etUyQ)

3.  In the Group size section, adjust all values to 2 and then click on Update.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfbP_2Y6P7Soo0IWJwix4HeXcZNRB1hGDtlhCXWTi3V0xXffvSh9vr4_76vkY9NxBefsxy_hY9swbQ2jyxtePs3pTmbF4xhjK7RahpRNgQ_yy0y3qR3I586SccxM-7-MVx2NebMQXYhrnGIsXW9NTD8t1E?key=vAZmTY4xiASAJC-8-etUyQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcCaRH9c1UOECAbbYTCYzte333p3_9RJSvUIzbbWzgE-8XW4AO6K77pkcewJFc9y39vZUDfRogoSTF8dmM1cWAk82F6FPH8cnWBsMYHS375oiD4YQWqzhN0DALBztL49_uGxKnQ73UJIZJ-HD2iFEcV6gZ1?key=vAZmTY4xiASAJC-8-etUyQ)

4.  Click Edit in the Launch configuration section, then click Switch to launch template and choose the TestLT launch template you created earlier.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd0hflUwjcVOq_TRxun9AaDy8myv4vZqmTAtdfmSzcKCEhJ5BvjULgIYjnkgFMUQPNkcq8aUn7N6n2Wab_Ki5r9GPO_KcjOB9A840ISantxXdQ12tHbb9KuQ3AHXv9-kFLR-pEm22YC61Sl20sJ_Xx3rYHI?key=vAZmTY4xiASAJC-8-etUyQ)

5.  Scroll to the bottom and click Update.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdEUcPWdI2cEiZVd1MSjaoThosdK_GxM3vXboW4KvqQy9cH_i_d9QKF4-zbgJjQtaXHmfb5_y57XHfOOxl8Ui1xFkaW9eZsgH7roOz4uiQBo4MHfFc_uNvtJkYRXmkWSpu7qTxswH5LI6k8uTb14q4gjcA?key=vAZmTY4xiASAJC-8-etUyQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdRVXhQ4j1DHJd1MP1ubc6h4OrqesS_nChjYB_wVlifoefKSbPIpPRMB_l949FDEfcEuN3cn0ExfZmDfD5acRdNegHXae-J7zlOqMejhwNrUQdQuOX9UrTrlGWdTDfdGEATg4r_6MYuTYYBFqJnKfImMr0?key=vAZmTY4xiASAJC-8-etUyQ)

After being redirected to the Auto Scaling groups page, click the refresh icon and you will be able to see the instances go from 1 to 2.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdrigOG2OVJUE0XnfUkDV6XBeh5z4JJcReApPNOi8ztYLNkX9c41PfwIiwQStb1sk64vaLxNrQkqpvcIID1KwMrS27e8KLJkP53aAJez-ql-zLlK2QjCzdkLKNwsgiSq6uuK5Y1YdAc9UEJ7d6K_aVQb9kv?key=vAZmTY4xiASAJC-8-etUyQ)

## Configure a Load Balancer Using an Auto Scaling Group

A proof of concept for an auto-scaling group is incomplete without a load balancer to distribute traffic evenly across the group. Setting up this load balancer is the final step in the proof of concept.

1.  From the left-hand menu, select Load Balancers.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXegpxLmeb27yJrmdOLlW-Mm-QTs7PE94plLj2t5_xpU9pSvhNrJzK_fq9AJiWI9o3Q64OYQVjlSYx8oAp729meIjMHEXoHrwurfY7Ksfryc1f34ukWkur5NHrkzBjApsPdPk50KEc2s04KT_jtyLh-Hq7w?key=vAZmTY4xiASAJC-8-etUyQ)

2.  Select the Create Load Balancer option.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXelyfM3goP6sxSt40laBb-505gc3XFj3-aIMRN0XNVcuPuN02OU90u_hK07JNJXaKpAxvIUhpbPntcQ7NvMQpPgZhz55LKW425KZLdzfKAu7vdjiPJQfqwxFeqYeiT04o-Ed4K7AB6oreZNc5Zizv4r0oJK?key=vAZmTY4xiASAJC-8-etUyQ)

3.  Click Create under Application Load Balancer.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdWn9S4kHYDzZPPSbjS06BSG9kO3qhq9LyauykfOasS6Fu0oCTIr6Qe5waU4PI9K5e9Wb6xfyJQjfSXTtqSGhkGyHTglqucRbamcyGnxmsflklDMiNZKmvJXV9q9JWv4ZFVJsGU0uph-CKRlnEOMsormsO9?key=vAZmTY4xiASAJC-8-etUyQ)

4.  Enter TestLB as the Load balancer name.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfnnWGFzVVV--5ejfUR53xGc_J2dU5f2RiIeeag_cl277fAmDYzqPCCjCIs89K4WIkBZ3ax4ipRWgHQOweaCPFem_ptQB3USkVd3GJJMEOGAtu_ssdKrwnuUWq2DTQ3M2067drcLJ7d6SLlgGe9vhpsu_mb?key=vAZmTY4xiASAJC-8-etUyQ)

5.  In the Network mapping section, please select the checkboxes corresponding to us-west-2a and us-west-2b.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdTMOnKxyeg60L_T_L9ssHvIwJ_-4eaBJm_OQn_7MuIfpjo4ZuJTHWY0pYQxbuycjNSOtf3J0cCh-QuEZ9NGULT01lwkhOLuf1pxvjhcdliNuoWIIL0f0qsPqHMwTTCKIh7a_7qc9LKpdsPue-5sNYsuoa_?key=vAZmTY4xiASAJC-8-etUyQ)

6.  Click on the Security Groups section, choose AutoScaling-Security-Group-1, and optionally deselect the default group if necessary.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXe7SO8kZnG2xYsLUb9HT9vrXRwOOA2MYtJWKeDpYc1xnZX3nW5b9dzMoUH5dnzEl67U1Asqo2c7GSUiHUCXDlh_hA9mnzxgq2oJIfm4PhviH-Q4R8szsEJ9OhNsjN_al-pcefCjZpxX4MtG5zfC1zOumBNw?key=vAZmTY4xiASAJC-8-etUyQ)

7.  In the Listeners and routing section, navigate to the Default action bar and select the Create target group link to open a new tab.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeV-clnESd8fL0HY7XqHd-1V7syHAT95ENAckT1oKydfTWqWsDwW7kOLSo6bVTEoD4U-kGk82bREaS2UVSW3ScoACcpZhcSyMGyUHLc0tlhJ0IFeAs6RdDvM9nNIGajpRJ2pz6D_ieSbqXdO9WdEB86SnM?key=vAZmTY4xiASAJC-8-etUyQ)

8.  Enter TestTG as the Target group name, then proceed by clicking Next at the bottom.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXef2DZmiHEPS92RbQEycjVJhDWkoB_zJla6Xgy3VK9kBsfk9M1dh897kC5Z4LuSE1-IpmVzgMsdaCk4RKAcAf6DXxwtz09RaGLfSIwUI_mu0fBh--K69CcUnpuDEo456lulSLTAQEUp2C6dMT5W3SdX4v9n?key=vAZmTY4xiASAJC-8-etUyQ)

9.  Select both instances, click Include as pending below, and proceed to click Create target group.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeVzoS5dNxuavgzpgET7QB9lG4AdYVlvhgPBhJIs4hjmkHh8p_BhXvQlPqgMG_4KMfyHQycsDsZ961y3EkHukJkG0txXpLopiV0CRi8r-boXkGhvVhLfLDq8sXC2YwNwrUSdcildTPT1SBIiXlsCFI3lJ2n?key=vAZmTY4xiASAJC-8-etUyQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXd-GEpPMxPejf-waOdfrinO2Oy5bznJPoRN3mrQypYhuTJVVgPj3UPqdhtgB8xVgZgO19UPgRAsRI60aJL3RPLy0D74F2Nqrwky3RB3Pp5-34m0eDE6StXeJgTBlImpIQuvF1Syv5RIYO0INVt1RU0afpSP?key=vAZmTY4xiASAJC-8-etUyQ)

10.  A new page will open listing Target groups, click on TestTG. On the next page click on check boxes next to the instance ID and then click Register targets.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeSphYbIqPvAd6Atxc5nPFhD1mDOE769pno5J9M-wX_Q6_hD1H2lpU8oi-F7JsGlNqPpObvgdoC3J2stGxEgU5FM9qzl_m5i2zakM2Vj_qwNiZr2POpvaAYVfzF59g5c6tXmS8HeK-OU7ujYh5iphvhGea8?key=vAZmTY4xiASAJC-8-etUyQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXewc52SN939z4KJ68KRtaHfOycAe0dhWHE-FG4YY6EXHnllDl1X5qqXK5za7lOxC42As3vp-3ctoXVBu1ukUq5mbxp3U2l0XH9jZE2QOHwEta2xRZttcilXJGhDPeXNzZe10ZpeVGZ-_5JqFJQb_jNa2SF0?key=vAZmTY4xiASAJC-8-etUyQ)

11.  In the previous tab, within Listeners and routing, click the refresh icon by the Default action bar, then click the dropdown and select TestTG.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfjFCORo2L8xi7fwwT9k3elKIFdlDZqNPEoVMfFncF3iuDPk3LC6GKD0HsgFQKTqJXZJBM4jjm-hHKBZst2qgH3QzVVqIUFcF-WB21A8TRdqsAdFNkye2zLYF2ectvdmbzXY6L7jeh4dmxJonTUc7f9PTMm?key=vAZmTY4xiASAJC-8-etUyQ)

12.  Navigate to the bottom of the page and select Create load balancer. Then, on the following page, click on View load balancers.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdEDjuJf8tr5uwhkQoOPrNl4qhmH-ndY3fptFz1bFuxnK-LwW7ttHOEEgUPsmYpm-Kfe8ussNwVc6HInFBJKYwON2gh6JCvgQEaUqR8Lvzbg2g3nnB2F19V5OgCduijw4H2mNhOn_ODeD8MZT6TUClGM0mE?key=vAZmTY4xiASAJC-8-etUyQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfxrJWYJr3DSo_jP1__8yKGf-pfvBfUB4hiQ8TbCqEL9c1ze2itd80inNyorLbIwYV-4-REOoikwax2rTZE3-Z4kY8OiAmveXFYCKtqiwURPkvtvW1TIXRZl7yRC24aQOUCrHW17cO3N3xCH5gglKouUO8?key=vAZmTY4xiASAJC-8-etUyQ)

13.  You should now find a Load Balancer listed. To verify this, navigate to the left-hand menu, click on Target Groups, select the TestTG link, and then go to the Targets tab. Here, you can confirm that the two instances previously launched are now linked to that target group.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf7QCMW5GRQ0uTbURjfJfWntL48LbAGaA6eQ9iCX9N3Siml7wC5bl1Wnh4ySBOIonJOYgJbHemqSLb9W8XYkfqF6KSeDJkqQjBcaLPZPGDU5rVG9uM7umrWKcknWYzg5Hp7UQV7jO3Z8x5tMglLLCnQkv0?key=vAZmTY4xiASAJC-8-etUyQ)

**Note:**

Their status will show as unhealthy, and resolving this requires enabling a service on the instances capable of responding to HTTP health checks. However, this topic is not covered in this lab.

By now, you should be capable of setting up multiple launch types, configuring an auto-scaling group for manual scaling, and implementing a load balancer to distribute traffic across instances in the auto-scaling group.
