package com.example.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 声明producer客户端
 */
@FeignClient(name = "producer")
public interface ProducerClient {
    @RequestMapping("/invokeProducer")
    String invokeProducer();
}
