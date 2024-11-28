FROM openjdk:17 
COPY "./tarjet/PARCIALMAYRAJUANPABLO-1-1.jar" "app.jar" 
EXPOSE "8102" 
ENTRYPOINT [ "java", "-jar", "app.jar" ]