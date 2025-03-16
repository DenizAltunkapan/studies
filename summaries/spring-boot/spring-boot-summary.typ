#line(start: (0%, 5%), end: (8.5in, 5%), stroke: (thickness: 2pt))
#show link: underline

#align(horizon + left)[

  #text(size: 24pt, [Spring Boot Basics])


  
  My name is Deniz, I am 20 years old, and a Software Engineering student from Stuttgart, Germany currently at the end of my 3th semester. This summary has been created as part of my personal revision, where I have compiled and highlighted the most important core concepts of Spring Boot. The goal of this summary is to provide a concise overview of the essential topics, allowing for a better understanding and quick reference to the key aspects of Spring Boot as I continue to develop my skills. I hope this summary helps you in your learning process, and I wish you much success and enjoyment in exploring the topic!

  If you have any questions or would like to connect, feel free to reach out to me via email at #link("deniz.altunkapan@outlook.com") or check out my GitHub at #link("https://github.com/DenizAltunkapan")[DenizAltunkapan].
]

#pagebreak()

#set heading(numbering: "1.")
#outline()
= Introduction
== What is Spring Boot?
Spring Boot is an open-source framework built on the Spring Framework, designed to simplify Java application development. It emphasizes convention-over-configuration, reducing boilerplate code and offering auto-configuration for faster setup. With embedded servers and starter dependencies, it enables standalone, production-ready applications with minimal effort. Spring Boot is ideal for building modern, scalable web applications efficiently.

== What is Maven?
Maven is a build automation and project management tool used primarily for Java projects. It uses a `pom.xml` file, which acts like a "shopping list" for dependencies. In this file, you specify the libraries and frameworks your project needs, and Maven automatically downloads and manages them. This simplifies dependency management and ensures consistent builds across different environments.

== Spring Boot Starters
Spring Boot Starters are pre-configured sets of dependencies that simplify adding common functionality to your Spring Boot application. Each starter includes a group of libraries for a specific task (e.g., web development, data access, security), allowing developers to quickly integrate them without manual configuration.

For example, spring-boot-starter-web bundles dependencies for building web applications, including Spring MVC (for handling HTTP requests and responses) and an embedded Tomcat server. spring-boot-starter-data-jpa provides everything needed for working with databases using JPA and Hibernate, while spring-boot-starter-security integrates authentication and authorization features. Additionally, spring-boot-starter-actuator adds built-in endpoints for monitoring and managing the application, exposing health status, metrics, and other operational data.

=== What is Tomcat and a Web Server?
A web server like Tomcat is responsible for hosting and serving web applications. It listens for incoming HTTP requests, processes them (e.g., runs business logic, accesses a database), and sends back responses, typically in the form of HTML, JSON, or other content types.

In the case of Spring Boot, Tomcat is embedded within the application, meaning it runs inside your project instead of being a separate software that needs to be installed and configured. This makes deployment and development much easier.
Spring Boot simplifies the use of Tomcat by including it as part of the spring-boot-starter-web starter. When you run your Spring Boot application, an embedded Tomcat web server will automatically start up, without any need for external server configuration.

Running the server: You can run the application easily from your IDE (like IntelliJ) or from the command line.
Listening on a port: By default, the embedded Tomcat server listens on port 8080 for incoming HTTP requests. This means that once the application is started, it will be ready to respond to requests on *http://localhost:8080 *.
For example, if you define a simple REST API, the Tomcat server will listen on port 8080, and any HTTP requests sent to this port will be handled by your application.

== Spring Boot Initializr

The Spring Boot Initializr is the ideal starting point for creating a Spring Boot application. It simplifies the process by allowing you to quickly generate a new project with the necessary setup and dependencies. You can access it #link("start.spring.io")[here]. When creating a project, you can select from various Spring Boot Starters, which are pre-configured sets of dependencies designed for specific functionality, such as web development, data access, or security. The Initializr automatically adds these Starters to your project’s configuration files (like pom.xml for Maven), ensuring all the required libraries are included. This streamlined setup allows developers to focus on building the application rather than managing dependencies, making the Spring Boot Initializr the perfect entry point for any Spring Boot project.


