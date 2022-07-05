This is more like a document of how to use vscode remote and docker
to create reproducible local dev env.

## Docker Engines
Create a linux vm with docker and add config to allow it to listen
all tcp interfaces: [here](https://docs.docker.com/engine/install/linux-postinstall/#configure-where-the-docker-daemon-listens-for-connections)

## Set up the docker cli and context
Download docker desktop to get docker cli, but no need for the engine inside.

Export it into shell using `DOCKER_HOST`:
```
~ echo $DOCKER_HOST
tcp://192.168.64.9:2375
```

Also, you can add it to `docker context`, but it does not work with VSCode since
when it checks for docker on start it ignores docker context setting (hope they
fix it in the future)
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
   Use the command below to add your key to the ssh agent:
```
~ ssh-add <private key>
```
2. Install the container remote (no need for ssh remote), and choose "clone a
   repo in container..."
3. When starting the container, the ssh-agent will forward the host sock to the
ssh-agent inside the container:
```
[1263 ms] ssh-agent: SSH_AUTH_SOCK in container (/tmp/vscode-ssh-auth-a884cad7131b91bd33c0eb9b0805814bbd5708e7.sock) forwarded to local host (/private/tmp/com.apple.launchd.hOuZaqKrzA/Listeners).
...
vscode ➜ /workspaces/langs (main ✗) $ ssh-add -l
3072 SHA256:kR7tOzLKicg3NgpltuBy9vwmBMMxL6He8n5d9vhfdSQ junlongg@Junlongs-MacBook-Pro.local (RSA)
```