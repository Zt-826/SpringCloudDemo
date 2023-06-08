package com.example.producer.controller;

import com.example.producer.datasource.MyDatasource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class ProducerController {
    @Resource
    private MyDatasource dataSource;

    @RequestMapping("/invokeProducer")
    public String invokeProducer(HttpServletRequest httpServletRequest) {
        log.info("Database type is {}", dataSource.getDbType());
        log.info("Url is {}", dataSource.getUrl());
        return "Producer port is " + httpServletRequest.getLocalPort();
    }
}
