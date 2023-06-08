package com.example.gateway.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.feignclient.client.ConsumerClient;
import com.example.gateway.configuration.BlockHandlerConfigurer;
import com.example.gateway.configuration.FallbackConfigurer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class GatewayService {
    @Resource
    private ConsumerClient consumerClient;

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // fallback为发生异常的回调方法，blockHandler为进入流控时的回调方法
    @SentinelResource(value = "invokeConsumer", fallbackClass = FallbackConfigurer.class, fallback = "fallback",
            blockHandlerClass = BlockHandlerConfigurer.class, blockHandler = "blockHandler")
    public String invokeConsumer() throws ExecutionException, InterruptedException {
        Future<String> response = executorService.submit(() -> consumerClient.invokeConsumer());
        return response.get();
    }
}