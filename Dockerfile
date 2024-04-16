FROM openjdk:17-jdk-alpine
 ​
WORKDIR app  # 切换到镜像中的指定路径，设置工作目录
 ​
COPY target/*.jar app.jar  # 会将宿主机的target/*.jar文件复制到 镜像的工作目录 /app/ 下
 ​
CMD ["java", "-jar", "app.jar"]  # 执行java -jar 命令