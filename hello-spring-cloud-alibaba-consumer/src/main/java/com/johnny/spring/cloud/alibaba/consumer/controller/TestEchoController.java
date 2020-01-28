package com.johnny.spring.cloud.alibaba.consumer.controller;

import com.johnny.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/feign/echo/{str}")
    public String echo(@PathVariable("str") String str) {
        return echoService.echo(str);
    }

    @GetMapping(value = "/port")
    public String port() {
        return echoService.port();
    }
}
