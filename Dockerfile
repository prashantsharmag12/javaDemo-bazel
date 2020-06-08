FROM tomcat:9.0-alpine

RUN rm -rf /usr/local/tomcat/webapps/*

ADD ./target/todo-app-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
