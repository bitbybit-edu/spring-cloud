package com.bitbybit.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-provider", qualifier = "service-provider", fallback = TestClientFallback.class)
public interface TestClient {

    @RequestMapping("/test/hello")
    String hello();

}
