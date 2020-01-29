package com.johnny.spring.cloud.alibaba.consumer.service.fallback;

import com.johnny.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallBack implements EchoService {
    @Override
    public String echo(String string) {
        return "你的网络有问题";
    }

    @Override
    public String port() {
        return "请联系管理员";
    }
}
