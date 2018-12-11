package com.bitbybit.service.controller;

import com.bitbybit.service.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    StoreService storeService;

    @RequestMapping("hello")
    public String hello() {
        return "hello liulin";
    }

    @RequestMapping(value = "store", method = RequestMethod.POST)
    public Integer store() {
        Integer result = storeService.updateStore();
        return result;
    }

}