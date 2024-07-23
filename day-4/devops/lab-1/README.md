# Automation with Jenkins

[Jenkins](https://jenkins.io) is probably the most popular automation server around - but popular in terms of being well used rather than being liked. It's been around a long time and one of the main features is its extensibility: it has a plugin framework with over [1800 published plugins](https://plugins.jenkins.io) which you can use to build any type of application, or integrate with any third-party system. There's a web UI you can use to define jobs, which get stored on the server's filesystem.

The UI and the plugins are one of the main reasons people don't like Jenkins. Plugins are prone to security flaws so they need frequent updates, but they can be fiddly to automate. You tend to find Jenkins servers are maintained long after they should have been decomissioned, because no-one's sure if they'd be able to recreate the exact set of plugins and load all the job definitions from the old server. We'll use Jenkins in a different way, with minimal plugins and job definitions stored in source control.

## Running Jenkins

Start by running Jenkins inside a Docker container, along with a local Git server (using Gogs):

```
docker compose -f labs/jenkins/infra/docker-compose.yml up -d
```

> This is a custom setup of Jenkins with a few plugins already installed.

Browse to Jenkins at http://localhost:8080. You may see a page saying "Jenkins is getting ready to work" - it can take a few minutes for a new server to come online. When you see the home page, click the log in link and sign in with these admin credentials:

- username: `courselabs`
- password: `student`

Check out the UI - it's slightly "web 1.0". The left nav takes you to the main options, including the menu to manage Jenkins; the central section will show a list of jobs once you have created some. 

## Creating a Freestyle Job

We'll create a classic Jenkins job - using the freestyle type where you build up the steps using the web UI:

- click _Create a job_ on the home screen
- call the new job `lab-1`
- set the job type to be _Freestyle project_
- click _OK_

This creates the new job. There are different sections of the UI which represent typical stages of a build - source code connection details, the build triggers and the build steps.

We'll use this job to run a simple script which prints some text:

- scroll down to the _Build_ section
- click _Add build step_
- select _Execute shell_
- paste this into the _Command_ box:

```
echo "This is build number: $BUILD_NUMBER of job: $JOB_NAME"
```

- click _Save_

> Jenkins populates [a set of environment variables](http://localhost:8080/env-vars.html/) when it runs the job, which are accessible in the job steps. This script prints out the build number - which is an incrementing count of the number of times the job has run - and the job name.

Now you're in the main job window. The left nav lets you configure the job again, and the central section will show the recent runs of the job.

Click _Build Now_ to run the job. When the build finishes check the output in http://localhost:8080/job/lab-1/1/console

📋 Build the job again - how is the output different?

<details>
  <summary>Not sure?</summary>

Click _Build Now_ again. When the job completes you can see the output at http://localhost:8080/job/lab-1/2/console

The job name is the same, but the number has incremented.

</details><br/>
