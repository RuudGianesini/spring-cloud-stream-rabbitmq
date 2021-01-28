package it.ruudg.demo.springcloudstream.billing;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import it.ruudg.demo.springcloudstream.ecommerce.model.Order;

@SpringBootApplication
@RestController
public class BillingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(BillingApplication.class, args);
    }

    @Bean
    public Consumer<Order> orderToBill() {

        return order -> {
            if (LOGGER.isInfoEnabled())
                LOGGER.info(String.format("the bill is printed for the order: %s", order.toString()));
        };
    }
}
