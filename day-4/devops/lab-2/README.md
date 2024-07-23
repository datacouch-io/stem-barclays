# Failing job in Jenkins

Jenkins marks a job pass or fail based on the [exit status](https://en.wikipedia.org/wiki/Exit_status) of a command. Shell commands always return with an `exit code`, usually `0` means `OK` and `non-zero` means the command `failed`. To check the status code of any command, you can use `echo $?`. Let's try some example

📋 Open terminal and type below commands one by one

```sh
# prints the current date time
date
# prints the exit status.
echo $? # should be 0

ls -l 
echo $? # should be 0

ls -l *.exe
echo $? # should be 1, exe files does not exist
```

There are other tools installed in this Jenkins server, which you would use in a real pipeline. What happens if you print the version of the Java compiler, the Docker command line or the Kubernetes command line in the script?

📋 Create a new _Freestyle_ job to print the version numbers of `javac`, `docker` and `kubectl`.

<details>
  <summary>Not sure how?</summary>

We'll create a classic Jenkins job - using the freestyle type where you build up the steps using the web UI:

- click _Create a job_ on the home screen
- call the new job `lab-2`
- set the job type to be _Freestyle project_
- click _OK_

Add the _Command_
- scroll down to the _Build_ section
- click _Add build step_
- select _Execute shell_
- paste this into the _Command_ box:

```
docker --version

javac -version

kubectl version
```

Click _Save_.

</details><br/>

When you build the updated job, it will fail. As you know now, shell commands always return with an `exit code`, usually `0` means `OK` and `non-zero` means the command `failed`. The Kubernetes CLI errors because it can't connect to a Kubernetes environment. The exit code is non-zero so Jenkins takes that as a failure so the job step fails. 

If there were other steps after this one, they wouldn't run because the job exits when a step fails.
