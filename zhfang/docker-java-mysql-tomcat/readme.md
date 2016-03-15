# Docker Java/MySQL Tomcat Sample
This is a simple Java application with MySQL.
##TREE

```
├── Dockerfile                        #tomcat Dockerfile
├── dbtest                            #jsp 文件
│   ├── META-INF
│   │   └── contextbak.xml
│   ├── WEB-INF
│   │   ├── lib
│   │   │   ├── jstl.jar
│   │   │   ├── mysql.jar
│   │   │   └── standard.jar
│   │   └── web.xml
│   └── index.jsp
├── fig.yml
├── init.sql                         ＃数据库初始化sql
├── readme.md
├── replace.jar                      ＃test 的jar包
└── test                             ＃java简单读取环境变量的例子
    ├── bin
    │   └── test
    │       └── ReadWriteFile.class
    └── src
        └── test
            └── ReadWriteFile.java
```
## 流程
####1、用docker启动数据库，并向数据库中插入一条数据；
* `docker run -d --net=host   -v $(pwd):/host -e MYSQL_USER=java -e MYSQL_PASSWORD=java -e MYSQL_DATABASE=javatest --name mysql   index.shurenyun.com/zhfang/mysql:5.5`
* `docker exec -it mysql bash`
* `mysql -u java --password=java  javatest < /host/init.sql`
* `exit`

####2、制作docker镜像
* `docker build -t javatest .`


####3、制作docker镜像，java先通过读取环境变量，得到mysql的参数，从而tomcat访问数据库
* `docker run --net=host -e MYSQL_USER=java -e MYSQL_PASSWORD=java -e MYSQL_DATABASE=javatest -e MYSQL_HOST=10.3.10.11 javatest  bash -c "java -jar /tmp/replace.jar&&/usr/local/bin/run"`

####4、访问
You should be able to access the app on http://\<docker-host-ip\>:8080/dbtest


## 数人云发布







