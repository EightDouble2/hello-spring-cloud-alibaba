package com.johnny.spring.cloud.alibaba.consumer.controller;

import com.johnny.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestEchoController {

    @Qualifier("echoServiceFallBack")
    @Autowired
    private EchoService echoService;

    @Value("${user.name}")
    private String username;

    @GetMapping(value = "/feign/echo/{str}")
    public String echo(@PathVariable("str") String str) {
        return echoService.echo(str);
    }

    @GetMapping(value = "/feign/echo")
    public String echo() {
        return echoService.echo(username);
    }

    @GetMapping(value = "/port")
    public String port() {
        return echoService.port();
    }
}
