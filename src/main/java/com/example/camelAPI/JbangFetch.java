package com.example.camelAPI;

//DEPS org.apache.camel:camel-main:4.0.0
//DEPS org.apache.camel:camel-http:4.0.0
//DEPS com.fasterxml.jackson.core:jackson-databind:2.15.0

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class JbangFetch {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("timer:fetch?period=10000") // Fetch every 10 sec
                        .to("http4://fakestoreapi.com/products")
                        .log("Fetched Products: ${body}");
            }
        });

        context.start();
        Thread.sleep(30000); // Keep running
        context.stop();
    }
}
