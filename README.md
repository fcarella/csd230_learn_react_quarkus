# README.csd230\_learn\_quarkus\_react

[(Ref ) : git repo…](https://github.com/fcarella/csd230_learn_react_quarkus.git)  
[(Ref ) :](https://docs.google.com/document/d/1DdfN8DQawOVm4fdKn5iTw9n-yqT3bNZ4xWhh9wMdpb8/edit?usp=sharing) [README.csd230\_learn\_quarkus\_react](https://docs.google.com/document/d/1DdfN8DQawOVm4fdKn5iTw9n-yqT3bNZ4xWhh9wMdpb8/edit?usp=sharing)  
[(Ref ) : Using Hibernate ORM and Jakarta Persistence...](https://quarkus.io/guides/hibernate-orm)   
[(Ref ) : quarkus-h2 project...](https://github.com/CodeWithJuancho/Quarkus-H2/tree/master)

## Introduction

- this project is in support of learning react for the CSD230 course.

[0.0 Setup](https://docs.google.com/document/d/1Ujyg9mL1aFOaH0RNEfFDiE5sagRL8onpoOnVI_n67zE/edit?usp=sharing)  
[0.0 Setup](https://docs.google.com/document/d/1Ujyg9mL1aFOaH0RNEfFDiE5sagRL8onpoOnVI_n67zE/edit?tab=t.0#bookmark=id.gtzrb8wm527i)\# 0.1 Backend  
[0.0 Setup](https://docs.google.com/document/d/1Ujyg9mL1aFOaH0RNEfFDiE5sagRL8onpoOnVI_n67zE/edit?tab=t.0#bookmark=id.a1ncpz5w32z4)\# 0.2 Frontend  
[0.0 Setup](https://docs.google.com/document/d/1Ujyg9mL1aFOaH0RNEfFDiE5sagRL8onpoOnVI_n67zE/edit?tab=t.0#bookmark=id.8ia04n19amug)\# 0.3 git repo



# ORIGINAL README BELOW...
# csd230_learn_react_quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/csd230_learn_react_quarkus-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and
  more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
