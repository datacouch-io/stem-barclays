## Container Ports

📋 Run a background Nginx container called `nginx`.

<details>
  <summary>Not sure how?</summary>

```
# alpine is the smallest variant but any will do:
docker run -d --name nginx nginx:alpine
```

</details><br/>

> You have started the container but you cannot access nginx using the browser, the container is running in isolation. To check the exposed ports use `docker ps` command

You will see the nginx is running on port 80 but the port is not exposed with the host machine. To expose the port we need to stop and remove the container.

📋 Stop and remove the running container.

<details>
  <summary>Not sure how?</summary>

```shell
# stop and remove the running `nginx` container
docker stop nginx
docker rm nginx
```
</details><br/>

Lets start the container once again, this time with the `-p` option
```
# run a container mapping TCP port 80 in the container to port 8080 on the Docker host:
docker run -d \
  -p 8080:80 \
  --name nginx \
  nginx:alpine

# access the page at http://localhost:8080 from the browser  
```

> The container has the Nginx web server installed, and some default HTML pages.

The page which you are watching on the browser is being served from the `/usr/share/nginx/html/index.html`. You can connect to a detached container and watch the contents of this file inside it.

```
docker exec -it nginx sh

ls /usr/share/nginx/html/

cat /usr/share/nginx/html/index.html

# make changes inside the file, save it and refresh the browser window.

vi /usr/share/nginx/html/index.html

# If you are not comfortable using vi editor, you can also install nano editor inside the container. 
apk update
apk add nano
nano /usr/share/nginx/html/index.html

# Refresh the browser window after making changes.

exit
```
> Remember, the container is an immutable system that means all the changes done inside the container will be lost when you stop and remove the container.

📋 Stop and remove the running container and run the container once again. You will see the changes made to the `index.html` file are gone and the `nano` editor is also not available any more.

___
## Cleanup

Cleanup by removing all containers:

```
docker rm -f $(docker ps -aq)
```