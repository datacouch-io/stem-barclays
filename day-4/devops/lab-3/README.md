# Automation with Jenkins

> So far, we have used jenkins in the old-school way. Where does the job definition live? How would you migrate it to a new Jenkins server? The better option is to use [pipelines](https://www.jenkins.io/doc/book/pipeline/), which use plugins that are already installed on this server.

## Storing Pipelines in Source Code

We'll use [this Jenkinsfile](./pipeline/Jenkinsfile) for our next build. It has multiple stages but it should be fairly clear what it's doing. 

To run the pipeline, first we'll configure this with a Jenkins pipeline job.

Browse Jenkins at http://localhost:8080/view/all/newJob to create a new job:

- call it `pipeline-lab`

- select _Pipeline_ as the job type

- click _OK_

This is the classic UI - you can still use it to work with new pipelines. Scroll to the _Pipeline_ section:

- select _Pipeline script from SCM_ in the dropdown
- set the SCM to _Git_
- set the _Repository URL_ to `https://github.com/datacouch-io/stem-barclays.git`
- change the _Branch Specifier_ from `*/master` to `*/main`
- set the _Script Path_ to `day-4/devops/lab-3/pipeline/Jenkinsfile`

Save and run the build. The build will be successful, you can check the build history and logs.

## Stage view

When you have complex build Pipelines, it is useful to be able to see the progress of each stage. The `Pipeline Stage View` plugin includes an extended visualization of Pipeline build history on the index page of a flow project, under Stage View.

![](/imgs/devops/who-broke-it.png)

Follow the steps to install the Pipeline stage view plugin:
- From the [Jenkins home screen](http://localhost:8080), click the _Manage Jenkins_ link in the left panel.
- In the _System Configuration_ section, click the _Plugins_ link
- In the left panel, select the _Available plugins_ link and search for `stage view plugin`
- Select the `Pipeline: Stage view plugin` and install `without restarting` jenkins.
- Come back to the [`pipeline-lab`](http://localhost:8080/job/pipeline-lab/)
- You will start seeing the pipeline stages
