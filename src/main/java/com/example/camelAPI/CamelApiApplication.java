package com.example.camelAPI;

///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.springframework.boot:spring-boot-starter:3.2.0
//DEPS org.apache.camel:camel-spring-boot-starter:4.3.0
//DEPS org.apache.camel:camel-jackson:4.3.0
//DEPS org.apache.camel:camel-http:4.3.0
//DEPS org.apache.camel:camel-sql:4.3.0
//DEPS org.postgresql:postgresql:42.6.0
//DEPS org.springframework.boot:spring-boot-starter-jdbc:3.2.0

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CamelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelApiApplication.class, args);
	}


}
