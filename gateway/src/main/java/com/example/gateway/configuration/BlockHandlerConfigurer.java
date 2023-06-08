package com.example.gateway.configuration;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 进入流控时的回调方法
 */
public class BlockHandlerConfigurer {
    public static String blockHandler(BlockException blockException) {
        return "发生了流控: " + blockException;
    }
}
