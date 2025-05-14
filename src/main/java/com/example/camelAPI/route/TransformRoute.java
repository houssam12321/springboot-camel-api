package com.example.camelAPI.route;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransformRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("timer:fetch?period=10000")  // Fetch every 10 sec
                .to("https://fakestoreapi.com/products")  // API call
                .process(exchange -> {
                    String jsonResponse = exchange.getIn().getBody(String.class);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode products = mapper.readTree(jsonResponse);

                    StringBuilder formattedOutput = new StringBuilder();
                    // Display the title and price only
                    products.forEach(product -> {
                        formattedOutput.append("🛒 ").append(product.get("title").asText())
                                .append(" - 💰 ").append(product.get("price").asDouble())
                                .append("\n");
                    });

                    exchange.getIn().setBody(formattedOutput.toString());
                })
                .log("Formatted Products:\n${body}");  //  Display formatted output
    }
}
