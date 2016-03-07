# Docker Java/MySQL Tomcat Sample
This is a simple Java application with MySQL.

# Run


## Standalone

* `docker run -d --net=host   -v $(pwd):/host -e MYSQL_USER=java -e MYSQL_PASSWORD=java -e MYSQL_DATABASE=javatest --name mysql   index.shurenyun.com/zhfang/mysql:5.5`
* `docker exec -it mysql bash`
* `mysql -u java --password=java  javatest < /host/init.sql`
* `exit`
* `docker build -t javatest .`
* `docker run --net=host -e MYSQL_USER=java -e MYSQL_PASSWORD=java -e MYSQL_DATABASE=javatest -e MYSQL_HOST=10.3.10.11 javatest  bash -c "java -jar /tmp/replace.jar&&/usr/local/bin/run"`

You should be able to access the app on http://\<docker-host-ip\>:8080/dbtest
