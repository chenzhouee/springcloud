#### 一、安装CentOS 7

- 参考博客

  https://blog.csdn.net/qq_42570879/article/details/82853708

- 镜像下载

- 常用命令

  ```
  一直使用管理员权限：sudo su
  
  查看内核版本信息：cat /proc/version 或者 uname -a 或者 uname -r
  
  查看linux版本信息：lsb_release -a
  
  服务状态查看：sudo service [服务名称] status
  
  开启服务：sudo service [服务名称] start
  
  删除文件夹:rm -r [文件夹名称]
  
  强制删除无提醒：rm -f [文件名称](-i 每一步有提醒)
  
  创建txt：touch xx.txt
  
  解压文件：tar -zxvf [压缩包名称]
  
  压缩文件：tar -zcvf [压缩路径名称] [文件夹路径]
  
  解压ZIP文件：unzip [ZIP文件路径] -d [需要解压的路径]
  
  打开txt：cat [文件名]（-n 查看并为行编号）
  
  创建并且编辑一个文件(使用ctrl+c结束，并且最后一行的数据会被忽略)：cat >【文件路径】
  
  把某个文件的内容赋值到另一个文件：cat【源文件路径】>【目标文件路径】
  
  增加中文字符编码：sudo locale-gen zh_CN.GB18030
  
  打开文件：sudo gedit [文件路径]
  
  编辑文件:vi [文件名]（:w保存 :q退出文件 q!退出不保存 :wq退出并且保存文件）
  a 在右边添加文本
  i 在当前字符开始添加文本
  A 在当前行的末尾添加文本
  O 在当前行的上面添加一行
  o 在当前行的下面添加一行
  x 删除当前光标字符
  nx 删除当前光标后的n个字符
  ```
  
- 固定ip地址

  - 首先将linux的虚拟机的网络连接设置成桥接模式

  - 打开/etc/sysconfig/network-scripts夹子

  - 用vi命令修改ifcfg-ens33文件

    ```
    HWADDR：linux虚拟机的mac地址
    
    IPADDR：linux的IP
    
    NETMASK：固定值
    ```

  - 修改好之后用：wq来保存退出，然后用service network restart命令重启服务

  - 最后用ifconfig/ip addr命令来查看修改的IP地址

  - 在Windows上ping虚拟机的ip地址

- 解决ifconfig命令不生效问题

  需要安装net-tools工具`yum install net-tools`

- 安装docker

  - 如果docker存在，卸载

    ```
    yum remove -y docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
    ```

  - 安装所需要的软件

    ```
    yum install -y yum-utils device-mapper-persistent-data lvm2
    ```

  - 设置docker的存储库

    ```
    yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
    ```

  - 安装最新的docker-ce

    ```
    yum install -y docker-ce
    ```

  - 启动docker

    ```
    systemctl daemon-reload && systemctl start docker
    ```

  - 查看docker的信息与版本

    ```
    docker info / docker version
    ```

  - doker运行hello world

    ```
    docker run hello-world
    ```

- docker的常用命令

  ```
  ﻿docker info
  
  重启docker服务  sudo service docker restart
  关闭docker服务  docker service docker stop
  开启docker服务  docker service docker start
  
  开机启动docker：
  systemctl start docker.service
  systemctl enable docker.service
  
  登录dockerhub：docker login
  
  注销登录：docker logout
  
  创建自定义网络：docker network create --subnet <CIDR> <网络名称>
  固定容器的ip：docker run -it --name <容器名> --net <网络名> --ip <ip> <镜像名> /bin/bash
  
  docker run -it ubuntu /bin/bash 启动一个ubuntu容器
  docker exec -it [容器ID] /bin/bash
  {
  进入Ubuntu容器安装Apache
  apt-get update
  apt-get -yqq update
  apt-get -y install apache2
  }
  docker commit [options] [container id] [目标镜像仓库/镜像名]:[tag]
  [options]{
  -m 用来指定创建镜像的提交信息；
  --author 用来列出该镜像的作者信息；
  }
  docker inspect [镜像仓库名] 查看新创建的镜像的详细信息
  
  docker build -t=[镜像名称] -f [Dockerfile文件路径] 使用Dockerfile构建镜像
  
  docker run -d -p [端口] --name [容器名称] [镜像仓库ID] nginx -g "daemon off;"
  {
  -d选项，告诉Docker以分离（detached）的方式在后台运行。这种方式非常适合运行类似Nginx守护进程这样的需要长时间运行的进程。
  这里也指定了需要在容器中运行的命令：nginx -g "daemon off;"。这将以前台运行的方式启动Nginx，来作为我们的Web服务器。
  
  -p选项，控制Docker在运行时应该公开哪些网络端口给外部（宿主机）。运行一个容器时，Docker可通过两种方法在宿主机上分配端口。
        1.Docker可以在宿主机上通过/proc/sys/net/ipv4/ip_local_port_range文件随机一个端口映射到容器的80端口。
        2.可以在Docker宿主机中指定一个具体的端口号来映射到容器的80端口上。
  }
  
  docker ps -a 查看所有容器
  docker ps 查看所有正在运行的容器
  docker ps -a --no-trunc 不隐藏内容
  
  docker images 查看所有镜像
  
  停止所有的container，这样才能够删除其中的images：
  docker stop $(docker ps -a -q)
  如果想要删除所有container的话再加一个指令：
  docker rm $(docker ps -a -q)
  
  删除images，通过container的id来删除指定容器
  docker rm <container id>
  
  删除images，通过image的id来指定删除谁
  docker rmi <image id>
  
  要删除全部image的话
  docker rmi $(docker images -q)
  
  查找容器IP
  docker inspect <容器名称> | grep IPAddress
  
  退出容器并且保持后台运行
  CTRL+P+Q
  
  查看容器完整的启动命令
  docker ps -a --no-trunc
  
  docker启动容器自动启动
  docker run --restart=always <容器名称>
  
  如果没有设置docker启动容器自动启动，那么对正在运行的容器修改
  docker update --restart=always <容器名称>
  
  推送镜像
  docker push <注册用户名>/<镜像名>
  
  修改镜像名称和版本
  docker tag <原名称>:<旧tag> <新名称>:<新tag>
  
  修改已经运行的容器的对外映射端口
  {
  	1 docker inspect <container name>查看容器信息，其中container id就是第二步要使用的[容器哈希值]
  
  	2 打开/var/lib/docker/containers/[容器哈希值]/hostconfig.json
  
  	3 找到PortBindings属性，举例：把容器的8080端口映射到主机8081端口
  	"PortBindings":{"8080/tcp":[{"HOstIp":"","HostPort":"8081"}]}
  
  	4 重启docker服务，重启docker容器
  }
  
  win10作为宿主机的时候ping不通docker容器的解决方案
  {
  	1 使用ipconfig查看docker的虚拟网卡ip
  	
  	2 ping docker的虚拟ip，如果不能ping通进行3
  	
  	3 添加docker虚拟机的ip路由 route -p add <网段地址> mask <子网掩码> <网关地址> metric <数量（默认是16）> if <端口号>
  	此句话的意思是
  	所有需要发往<网段地址>/16地址段的IP数据包，全部由<网关地址>路径转发
  	docker默认虚拟机ip网段从10.0.75.0开始，子网掩码为255.255.255.0，则metric取默认16，端口取默认，则可以写成如下命令
  	route -p add 10.0.75.0 mask 255.255.255.0 192.168.31.89
  	
  	4 添加docker容器的ip路由 route -p add <网段地址> mask <子网掩码> <网关地址>
  	默认情况下docker容器的网段从172.17.0.0开始，子网掩码为255.255.0.0，docker虚拟机的虚拟ip为10.0.75.1
  	route -p add 172.17.0.0 mask 255.255.0.0 10.0.75.1
  	
  	5 使用route print查看路由信息是否添加
  }
  ```

- docker下安装RabbitMQ

  - 拉取镜像

    ```
    docker pull rabbitmq:3.7.7-management
    ```

  - 根据下载的镜像创建和启动容器

    ```
    docker run -d --name rabbitmq3.7.7 -p 5672:5672 -p 15672:15672 -v `pwd`/data:/var/lib/rabbitmq --hostname myRabbit -e RABBITMQ_DEFAULT_VHOST=my_vhost  -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin df80af9ca0c9
    ```

    -d 后台运行容器；

    --name 指定容器名；

    -p 指定服务运行的端口（5672：应用访问端口；15672：控制台Web端口号）；

    -v 映射目录或文件；

    --hostname  主机名（RabbitMQ的一个重要注意事项是它根据所谓的 “节点名称” 存储数据，默认为主机名）；

    -e 指定环境变量；（RABBITMQ_DEFAULT_VHOST：默认虚拟机名；RABBITMQ_DEFAULT_USER：默认的用户名；RABBITMQ_DEFAULT_PASS：默认用户名的密码）

    最后几位：镜像的imageID

  - 用浏览器打开web管理端 ：http://Server-IP:15672





