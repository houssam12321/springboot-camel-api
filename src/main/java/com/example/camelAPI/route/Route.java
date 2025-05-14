package com.example.camelAPI.route;

import org.apache.camel.builder.RouteBuilder;

//@Component
class Route extends RouteBuilder {



    @Override
    public void configure() {
        from("timer:fetchProducts?period=60000")  // Fetch every 60 seconds
                .to("https://fakestoreapi.com/products")  // Call API
                .log("Fetched Products: ${body}");  // Log data
    }
}