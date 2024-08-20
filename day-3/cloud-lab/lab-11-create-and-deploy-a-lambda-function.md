# Create and Deploy a Lambda Function


AWS Lambda is a powerful, event-driven, serverless computing service that allows you to run code in response to events without provisioning or managing servers. In this guide, you will create a Lambda function that generates a random number, demonstrating the ease and flexibility of deploying serverless functions using AWS Lambda.

## Why Use AWS Lambda?

-   **Scalability:**  AWS Lambda automatically scales your applications by running code in response to each event. It can handle a few requests per day or thousands per second.
-   **Cost Efficiency:**  With AWS Lambda, you pay only for what you use. There are no charges when your code is not running, and you are billed based on the number of requests and the compute time your code consumes.
-   **Focus on Code:**  AWS Lambda allows developers to focus on writing code rather than managing infrastructure. You don't need to worry about server provisioning, scaling, or patching.
-   **Integration:**  Lambda integrates seamlessly with other AWS services, such as S3, DynamoDB, API Gateway, and more, enabling the creation of powerful, event-driven applications.

In this exercise, you will create a simple Lambda function to generate a random number, demonstrating the basics of working with AWS Lambda. You'll also learn how to deploy and test your function, which lays the foundation for more complex serverless applications.


1.  Access the AWS Console by entering the username and Password provided by this lab, and then clicking the Open AWS Console button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXf-Qs2szy1i644y_pa-27nLQ0kwAcLpz2CgEw11Qzu2d98mtVt09A7jdQo6-nQU8t3WDvn_RQWlLIbmqYgzZ7xeOq7i7DyMFS1M1sU3wh-8J7-BsqkGokiaL3x3ZEyBGmGU5qmxL_tl8J6PQY2NDWGGVws?key=spw-RV67cN5f2TMffOa2wQ)

2.  At the top of the page, enter Lambda into the search bar and click on it.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdty2ECjItZml9JUDI7w8RZaWUSM1SKF0cvStkPWsyP1bWAYLrurJ_1i7605yXv-M7WEmTTsvcVg2CJ-IKuKUtRRu4hYXBeizABRw9Wmkofs8eQA8eS9edqd7HQriWxJwSz7zbujPBk7PWi8uqYujlR2Po?key=spw-RV67cN5f2TMffOa2wQ)

3.  On the Functions page, select Create function.


Note: There are various options available for creating a Lambda function, which you can see on the Create function page. For your use-case, you'll be creating your function from scratch, so you'll leave the default option, Author from scratch, selected. Additionally, you'll keep the Runtime set to Node.js 20.x.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdXynfy9nuKAUhi095UK2hTBW9Q8w6E_SVcgwMfpEzrIN7aWaaABtNORxn9abQKqNTjkRJWQAkTNdthr1blu_7o5JGJyfaC6fqh9yVXi-n1lO9IBrX-_OE8cxb0Xwl1YTHAADdYmClE_z4hUHrXqXpDhxQ?key=spw-RV67cN5f2TMffOa2wQ)

4.  On the Create function page, under the Basic information section, enter random-number for the Function name.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXdvBwTZe0-lleAuUACduhO3bZ1K-_acXC9KL53Cn4EUpkF775Cin6F6PY10fylb70_HUQ5eS9AOEzzblmmQn1iggkIPwrsRnl8S3SvNjnNkKZEA6NRTW_-AGvHTCUy7NHT3fMizBWcI72ocbaUTlbFlHr01?key=spw-RV67cN5f2TMffOa2wQ)

5.  At the bottom of the page, click Create function.


Note: Once the Lambda function is created, you will be redirected to the random-number function page. A success banner at the top of the page will confirm that the function was successfully created.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeOv61TV27W0i1MMQdPCLRaFMLLPsXkOztz-UXYVrL642h4VTjuoj_4LWTBP54yK9Ib8HH8ZAFqhkHFzKH2lfFNPkU_LfkXgZC53ZHFUR6EMw-aJDFBLMkgZlaM69zc_Dn0FVnMxWJDDUa3aXtA_SXbv8Ul?key=spw-RV67cN5f2TMffOa2wQ)

6.  In the Code source section, double-click on index.js. Scroll to the bottom of the file in the editor and, after the existing export const handler() function, add the following code:

	```
	function getRandomInt(max = 10) {
	return Math.floor(Math.random() * Math.floor(max));
	}
	```
	Note: The handler() function executes when this Lambda runs.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcXJz2zsGRB27hZOPyGFEV-lDvwVIMxblvwlq1mVcLOVxUmXEcyM54Uhsf1epOjYsXAEgc3WcgLsG89d6fFlpiOl05XVGrEqtON0kEEn0ZuUf1R_P_bxqsvbUGbvHFCs3O6hpiHXbbH43S9ROUxUTtNmv4?key=spw-RV67cN5f2TMffOa2wQ)

7.  In the handler() function, substitute the code on line 5 with body: getRandomInt(event.max).

Note:

1.  The event argument holds information passed when the handler is called. You will later provide a JSON object to define the maximum number for getRandomInt().

2.  Your updated code will appear as follows:


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcqV-ddgn24MnQnOme14qj6iw8aV5V9EIK0tdjQ_7DAAHyZ28zpgE8ZfeUYlDVw9OMzVB9fOo1uqTztCHPW9CYhP3g4EgFSAno_3yI-AKGhkWeKXTd8MmxxVMJAsc8B06godkNytF-qzTRh2h4PAubNBWE3?key=spw-RV67cN5f2TMffOa2wQ)

8.  Press the Deploy button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfZXAcbeJ5X8kOToY-ig2fCuWpf5ssl6ZDbYuvqh7frui9cHhq97WwYx-nZptoCKxAQZziGqjse3C_Fitj4YQkM1GcotePEGoTrXjqu4iNwazQbeV-jxGTicO5ymZd8Kk9AQp8krPqn89nIDzSvvPv8BqI?key=spw-RV67cN5f2TMffOa2wQ)

A message saying Changes deployed will be shown.

# Execute a Lambda Function

You've implemented your random-number function and are now ready to verify its functionality through testing.

1.  Click the Test button located near the top left of the code editor, next to the Deploy button.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcNAITqKnbyeKPjRVHvcTfGxP5oNQuAg32w7lkR1jS6Fx3LJTv2KGTai5isD_BguVX4OdZi7d_1wPp3pZCxF0E5xaavdTxoSX7YIF_JtnL7S5VL09bFBVKCpLl6qd0uwcLpzEgP58Ze-u7z-szDoudeBzab?key=spw-RV67cN5f2TMffOa2wQ)

2.  In the Configure test event pop-up, enter max500 as the Event name.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcfDNRf_KxZlQO0VtuEJzie1DgCcMKJQ8PhnuHvoVXKLgzPYLBL5rofk-KhBUI3HChWD__7k6d8xIed23wd0XQjmFCnhhn9HntKqmV_k7Wjukh8WXdYrPS8MDcdvHw_1bZ3kof9gUQgj94Wp0qY33injyo?key=spw-RV67cN5f2TMffOa2wQ)

3.  Replace the current JSON object in the editor with { "max": 500 }.


![](https://lh7-us.googleusercontent.com/docsz/AD_4nXeMsknovrxxkaLDiLJBurCf0OXVaCOAEvy7sjvh2KMehiVZQUBFbs04BhI-pHq50i4kEtMDdoyEP-LdpwS03E1hylge32cPTQxVgpjEPtxbjO6AhxeXRM1MRJB7PVbbQOFjbjjafzZqd6JkrliRr7k-oEku?key=spw-RV67cN5f2TMffOa2wQ)

4.  Click Create.


Note: After creating the test event, you'll return to the random-number page and the code editor.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXcnhJv2KVrqf6vg62waZOB9hl6Y28be5ZPmx3FSlMqwJMPFNdFR-Wg1GRq-sovu1GZaY78g0s6zhsF_OzDhVT5D0z9xPgHciKFadlbTHweN84fjIDlX_DWBwChNuZSmB-CFqrdrw7LSkUohauQzhPwMF58?key=spw-RV67cN5f2TMffOa2wQ)

5.  Near the top of the code editor, click on Test once more.


Note: This action will run the test function you recently created. If you have multiple tests, you can select the desired one from the dropdown next to it.

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfHAX4PeK1eOsgSiOclO_HWzNxdGfdPdbqcJzj7_J-GIzvWMnO9Nl78-I2PbVva1wJkBX2dkFjwubVzzzdIkEeQe7-_jwFyPaNIbx0jqcEBIb9J1mYz2w3iNIowK6rS22bGecXO5fIzVA5OShHA7wcwV91a?key=spw-RV67cN5f2TMffOa2wQ)

![](https://lh7-us.googleusercontent.com/docsz/AD_4nXfT9t_61Su5_dRF1RxAwvJ2-Gal8JCQZBigch56M-YT-AEtjrK0RuVQUHLN9wJVvBflx1ueGPCs552kR-czNrOY98TUxIBWjRc8zP-ryCgqMxPrtXRZh1RGliiVQ7tVsOVHWlakyK9BCRbjvVfN3yJ0gSlF?key=spw-RV67cN5f2TMffOa2wQ)

In the editor, upon executing the Lambda function, navigate to the new Execution Results tab to view various outcomes. Here, you'll find the execution results including logs, execution time, memory consumption, and the generated random number, all presented in the body section of the result.
