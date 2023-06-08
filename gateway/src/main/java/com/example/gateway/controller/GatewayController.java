package com.example.gateway.controller;

import com.example.feignclient.client.ConsumerClient;
import com.example.gateway.service.GatewayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.*;

@RestController
public class GatewayController {

    @Resource
    private GatewayService gatewayService;

    @RequestMapping("/invokeConsumer")
    public String invokeConsumer() throws ExecutionException, InterruptedException {
        return gatewayService.invokeConsumer();
    }
}