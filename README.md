# Welcome to the project!

Cette application est développée en tant que Tache dans un projet avec Spring Boot & angular.

## Getting Started

All the code required to run this project is available in this Git repository. 
You can either download it as a zip file from gitlub or run:

```bash
$ git clone  https://github.com/tarekbensassi/angular-springbboot.git

```

### Environment

In order to run  project you will need:

* [Java 11]- Main Backend Language
* [Maven](https://maven.apache.org/) - Dependency Management
* [PostgreSQL](https://www.postgresql.org) - The default RDBMS.
* [nodejs](https://nodejs.org)


In addition, there are a few optional yet recommended installations:

* [Git](https://git-scm.com)
* Your favorte IDE. I am using [Spring STS](https://spring.io/tools/sts/all), which is based on Eclipse, but feel free to use whichever you find more convenient.


### Prerequisites

#### Database Setup

Before starting the application, you will need to set up the database. By default, DB Consulting project  attempts to connect to a database called dbc  in localhost:5432, or one called dbc in the same location for the E2E automatic tests. You can change the default location and name of the databases in application.properties.

If you don't wish to set up a PostgreSQL database, dbc also comes with H2 support out of the box. In order to switch to an h2 database, you need to activate the h2 profile. If you are unsure of how to accomplish this, please refer to [this document](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-profiles.html).



### Time to run the application!

You can run the application either using maven on the command line or using your IDE to import and run the code. We'll be covering Maven and Spring STS in this section.

#### Using Maven

If you don't want to go through the process of using an IDE and just want to get the project running to explore it, navigate to the directory where you downloaded the source code and run:

```bash
$ mvn spring-boot:run
```

If everything went well, you should be able to access the web app here: http://localhost:9191/dbc

#### Using Spring STS

Spring STS makes it simple to import and run Spring Boot projects. In order to do so:

##### Import the project:
1. Open Spring STS.
2. Navigate to "File - Import".
3. In the Wizard, look for "Existing Maven Projects" and click Next.
4. Click Browse and select the root directory of the source code.
5. Click on Finish.

##### Run the project:

Before hitting run, lets make sure all the Maven dependencies are in place:

1. Open the Package Explorer.
2. Right click on the dbc project.
3. Navigate to "Maven - Update Project".

Once the dependencies are downloaded and installed, we have two options to run:

1. Run via "Package Explorer":
   1. In the Package Explorer, right click on the dbc project.
   2. Navigate to "Run As - Spring Boot App".
2. Run via "Boot Dashboard":
   1. Open the "Boot Dashboard".
   2. Expand "local".
   3. Select dbc.
   4. Hit the Play button.

If everything went well, you should be able to access the web app here: http://localhost:9091/

#### Generating WAR file

To generate the Jar file and start up the server, run:

```bash
$ mvn clean package
$ cd target
$ java -jar dbc.jar
```

#### Database 

before executing the application, you must insert the following data :

```bash

 Roles User :
 
INSERT INTO public.roles (name) VALUES ('CHEF');
INSERT INTO public.roles (name) VALUES ('MEMBER');

```

# ProjectFrontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.0.5.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.



## Tehcnologies Used

### Backend

#### Java

* [Java 11] - Main Backend Language
* [Maven](https://maven.apache.org/) - Dependency Management

#### The Spring Family

* [Spring Boot](https://projects.spring.io/spring-boot/) - The Framework of Frameworks
* [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) - Abstraction Layer on top of JPA

#### Databases

* [PostgreSQL](https://www.PostgreSQL.org) - The default RDBMS.


#### Testing

* [JUnit](http://junit.org/junit5/) - The main Testing Framework.




# ProjectFrontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.0.5.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.



## Authors

* **BENSASSI TAREK** - *Main Developer* - [tarekbensassi](https://gitlab.com/tarekbensassi)


## License

Ce projet est sous licence MIT -