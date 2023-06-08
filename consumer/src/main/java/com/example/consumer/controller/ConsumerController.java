package com.example.consumer.controller;

import com.example.feignclient.client.ProducerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class ConsumerController {

    @Resource
    private ProducerClient producerClient;

    @RequestMapping("/invokeConsumer")
    public String invokeConsumer(HttpServletRequest httpServletRequest) {
        log.info("Consumer received request by port {}", httpServletRequest.getLocalPort());
        String response = producerClient.invokeProducer();
        log.info("Response from producer is {}", response);
        return response;
    }
}
