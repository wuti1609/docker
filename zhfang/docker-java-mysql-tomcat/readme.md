# Docker Java/MySQL Tomcat Sample
This is a simple Java application with MySQL.

# Run

## Fig
* `fig up -d`

Then run `fig ps` to find the app port.

## Standalone

* `docker run --net=host   -v $(pwd):/host -e MYSQL_USER=java -e MYSQL_PASSWORD=java -e MYSQL_DATABASE=javatest --name mysql  --entrypoint /bin/bash index.shurenyun.com/zhfang/mysql:5.5 -c "/usr/local/bin/run&&sleep 10; mysql -u java --password=java  javatest < /host/init.sql"`
* `docker build -t javatest .`
* `docker run --net=host  javatest -c "java -jar /tmp/replace.jar&&/usr/local/bin/run"`

You should be able to access the app on http://\<docker-host-ip\>:8080/dbtest
