package com.ith.spring.controller;

import com.ith.spring.service.OrderListenerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: pan le
 * @description: 监听器的简单运用
 * @create: 2021-01-18 16:24
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderListenerService service;

    @RequestMapping("listenerTest")
    public void listenerTest(){
        service.createOrder();
    }

}
