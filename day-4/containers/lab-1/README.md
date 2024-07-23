# Pulling images

Pull an image or a repository from a registry

Most of your images will be created on top of a base image from the [Docker Hub](https://hub.docker.com/) registry.

Docker Hub contains many pre-built images that you can `pull` and try without needing to define and configure your own.

To download a particular image, or set of images (i.e., a repository), use `docker pull`. If no tag is provided, Docker Engine uses the `:latest` tag as a default. This command pulls the `nginx:latest` image:

```shell
# pulls the latest nginx image from docker hub
$ docker pull nginx

Using default tag: latest
latest: Pulling from library/nginx
31b3f1ad4ce1: Pull complete
fd42b079d0f8: Pull complete
30585fbbebc6: Pull complete
18f4ffdd25f4: Pull complete
9dc932c8fba2: Pull complete
600c24b8ba39: Pull complete
Digest: sha256:0b970013351304af46f322da1263516b188318682b2ab1091862497591189ff1
Status: Downloaded newer image for nginx:latest
docker.io/library/nginx:latest
```

Layers can be reused by images. For example, the `nginx:1.22.0` image shares one layer with `nginx:latest`. Pulling the `nginx:1.22.0` image first pulls its metadata, but not its all layers, because some layers are already present locally

```shell
# pulls the 1.22.0 version nginx image from docker hub
$ docker pull nginx:1.22.0

1.22.0: Pulling from library/nginx
31b3f1ad4ce1: Already exists
66a98d59896d: Pull complete
24c392b45f28: Pull complete
165e89c55246: Pull complete
2ffb33914b01: Pull complete
14a89ead234b: Pull complete
Digest: sha256:4535aaa94ae5316180fac74c56035921280275d0ec54282253e1a95536d62a05
Status: Downloaded newer image for nginx:1.22.0
docker.io/library/nginx:1.22.0
```
