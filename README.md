This is more like a document of how to use vscode remote and docker
to create reproducible local dev env.

## Docker Engines
Create a linux vm with docker and add config to allow it to listen
all tcp interfaces: [here](https://docs.docker.com/engine/install/linux-postinstall/#configure-where-the-docker-daemon-listens-for-connections)

## Set up the docker cli and context
Download docker desktop to get docker cli, but no need for the engine inside.

Export it into shell using `DOCKER_HOST`, or use `docker context`
```
~ docker context list
NAME                TYPE                DESCRIPTION                               DOCKER ENDPOINT                                  KUBERNETES ENDPOINT   ORCHESTRATOR
default             moby                Current DOCKER_HOST based configuration   unix:///var/run/docker.sock                                            swarm
desktop-linux       moby                                                          unix:///Users/junlongg/.docker/run/docker.sock
dev.local *         moby                from the local multipass                  tcp://192.168.64.9:2375
```

Creating a new one:
```
~ docker context create dev.local --docker "host=tcp://192.168.64.9:2375" --description "from the local multipass"
dev.local
Successfully created context "dev.local"

~ docker context use dev.local
```

## Configure VSCode
1. Get ssh key working with the linux vm, and use ssh-agent (default on in Mac OS),
   check out [this](https://code.visualstudio.com/docs/remote/troubleshooting#_setting-up-the-ssh-agent).
   Use the same key to authenticate github and the linux vm.
2. Install the container remote (no need for ssh remote), and choose "clone a
   repo in container..."