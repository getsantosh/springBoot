# springBoot
SpringBoot with in-memory database

1. Create a new Maven project with group-id and artifact-id

2. Add Springframework boot parent and dependencies
    <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.3.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

3. Add spring boots maven plugin
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

4. Next will add a repository with in-memory Map db - StudentDAO. Which has the methods to get, post and delete 
operations on Student DB (annotate this with @Repository).

5. StudentService (annotated as @Service) has DAO autowired so as to get hold of db. 

6. StudentController (annotated as @RestController) handles the HTTP requests. Where we autowire StudentService.
To ensure HTT request mapping use @RequestMapping, default HTTMethod is GET and we can map with other request types by
RequestMethod.Put/GET/POST/DELETE etc.
To pass JSON as a request object, we can use MediaType.APPLICATION_JSON_VALUE.

7. Executing Application: Apart from making WAR file and deploying in application server, Spring provides inbuilt 
Tomcat Servlet container acting as runtime for Spring Boot. Adding annotation to plain old Java main method's class as
@SpringBootApplication with SpringApplication.run(FilName.class, args) will deploy the jar in inbuilt Tomcat container.
