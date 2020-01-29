package com.johnny.spring.cloud.alibaba.consumer.service;

import com.johnny.spring.cloud.alibaba.consumer.service.fallback.EchoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider", fallback = EchoServiceFallBack.class)
public interface EchoService {

    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable("string") String string);

    @GetMapping(value = "/port")
    String port();
}
