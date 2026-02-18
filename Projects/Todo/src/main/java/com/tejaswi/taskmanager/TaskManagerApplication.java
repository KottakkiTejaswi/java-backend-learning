package com.tejaswi.taskmanager; //Spring Boot scans this package and everything inside it

import org.springframework.boot.SpringApplication; //SpringApplication is a class provided by Spring Boot. It provides a convenient way to bootstrap a Spring application that is started from a main() method.
import org.springframework.boot.autoconfigure.SpringBootApplication; //This annotation is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. 
// It tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. 
// It also enables component scanning, which allows Spring to automatically discover and register beans in the application context.

@SpringBootApplication //Enables springboot features like component scanning, auto-configuration, and property support

public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

}

/* main() called
      ↓
SpringApplication.run()
      ↓
Spring scans packages
      ↓
Creates beans (@Controller, @Service, etc.)
      ↓
Starts Tomcat
      ↓
Application ready on port 8080 */
