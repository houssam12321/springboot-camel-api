package com.example.camelAPI.route;


import com.example.camelAPI.model.Product;
import com.example.camelAPI.repo.ProductRepo;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Component
public class NewRoute extends RouteBuilder {

    @Autowired
    private ProductRepo productRepository;

    @Override
    public void configure() {
        from("timer:fetch?period=10000")
                .to("https://fakestoreapi.com/products")
                .process(exchange -> {
                    String jsonResponse = exchange.getIn().getBody(String.class);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode products = mapper.readTree(jsonResponse);

                    products.forEach(productNode -> {
                        Product product = new Product();
                        product.setTitle(productNode.get("title").asText());
                        product.setPrice(productNode.get("price").asDouble());
                        productRepository.save(product); // ✅ Insert into MySQL
                    });
                })
                .log("Inserted Products: ${body}");
    }
}
