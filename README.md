# MC

## REQUIREMENTS

* Oracle JAVA 9

## Automated deployment

### Deploy a spring java application with tomcat using the Maven Plugin for Azure

Before to perform a deploy in azure we need:
-  An Azure account
-  The Azure CLI
-  The latest KDK
-  Maven 3
-  Git

#### Steps

1. Open cmd and go to the project directory

2. Build the JAR file using maven, with the following command:
```
    mvn clean package
```
3. Start the web app using Maven
```
    mvn clean package
```
4. Run the web app using maven, for example if you are using spring:
```
    mvn spring-boot:run
```
5. The application should running locally:
```
    http://localhost:8080
```
6. To generatea war file open pom.xml and add:

```
<modelVersion>4.0.0</modelVersion>
<groupId>org.springframework</groupId>
<artifactId>gs-spring-boot</artifactId>
<packaging>war</packaging>
```
And add the following dependency
```
<dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-tomcat</artifactId>
         <scope>provided</scope>
</dependency>
```
7. In the properties section of the pom.xml file add:
```
<properties>
    <java.version>1.8</java.version>
    <maven.build.timestamp.format>yyyyMMddHHmmssSSS</maven.build.timestamp.format>
</properties>
```
And in the plugins section add:
```
<plugin>
   <groupId>com.microsoft.azure</groupId>
   <artifactId>azure-webapp-maven-plugin</artifactId>
   <!-- Check latest version on Maven Central -->
   <version>1.1.0</version>
   <configuration>
      <resourceGroup>maven-projects</resourceGroup>
      <appName>${project.artifactId}-${maven.build.timestamp}</appName>
      <region>westus</region>
      <javaVersion>1.8</javaVersion>
      <deploymentType>war</deploymentType>
   </configuration>
</plugin>
```
8. Open the azure cli and sign in you Azure account
9. Rebuild the JAR file:
```
    mvn clean package
```
10. Deploy your web adpp using maven:
```
    mvn azure-webapp:deploy
```
The application will be created.