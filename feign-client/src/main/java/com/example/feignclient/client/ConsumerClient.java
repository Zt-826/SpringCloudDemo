package com.example.feignclient.client;

import com.example.feignclient.configuration.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 声明consumer客户端
 */
@FeignClient(name = "consumer")
// 根据name去注册中心找对应的实例地址
@LoadBalancerClient(name = "consumer", configuration = LoadBalancerConfiguration.class)
public interface ConsumerClient {
    @RequestMapping("/invokeConsumer")
    String invokeConsumer();
}
