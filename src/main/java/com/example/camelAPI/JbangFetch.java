package com.example.camelAPI;
import org.apache.camel.builder.RouteBuilder;

//DEPS org.apache.camel:camel-main:4.0.0
//DEPS org.apache.camel:camel-http:4.0.0
//DEPS com.fasterxml.jackson.core:jackson-databind:2.15.0

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class JbangFetch extends RouteBuilder {
    @Override
    public void configure() {
        from("timer:fetch?period=20000")  // Fetch every 10 sec
                .to("https://fakestoreapi.com/products")  // API call

                .log("Formatted Products:\n${body}");  // ✅ Display formatted output
    }
}
