package com.example.gateway.configuration;

/**
 * 发生异常时的回调方法
 */
public class FallbackConfigurer {
    public static String fallback() {
        return "发生了异常.";
    }
}
