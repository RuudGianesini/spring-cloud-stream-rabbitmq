package it.ruudg.demo.springcloudstream.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.ruudg.demo.springcloudstream.ecommerce.model.Order;

@RestController
@RequestMapping(path = "/order", consumes = "application/json")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private StreamBridge streamBridge;

    @Autowired
    private ObjectMapper jsonMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addOrder(@RequestBody String body)
        throws JsonProcessingException {

        Order payload = jsonMapper.readValue(body, Order.class);

        if (LOGGER.isInfoEnabled())
            LOGGER.info(String.format("received a new order: %s", payload.toString()));

        streamBridge.send("order-to-bill", payload);
    }

}
