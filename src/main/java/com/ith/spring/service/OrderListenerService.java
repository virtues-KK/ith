package com.ith.spring.service;

import com.ith.spring.Common.OrderLinstener.AfterCreateOrderEvent;
import com.ith.spring.dao.OrderRepository;
import com.ith.spring.domain.Orders;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: pan le
 * @description: 监听器的简单运用
 * @create: 2021-01-18 16:14
 **/
@Service
public class OrderListenerService {

    @Resource
    private ApplicationEventPublisher publisher;

    @Resource
    private OrderRepository orderRepository;

    public void createOrder(){
        Orders orders = orderRepository.findAll().stream().findFirst().get();
        System.out.println("创建订单，订单编号：" + orders.getOrderNo());
        //发布事件解耦合
        publisher.publishEvent(new AfterCreateOrderEvent(orders));
        System.out.println("结束创建订单");
    }

    //事件监听处理
    @EventListener
    public void afterCreateOrder(AfterCreateOrderEvent event) throws InterruptedException {
        Orders orders = event.getOrder();
        Thread.sleep(2000);
        System.out.println("调用短信服务" + orders.getPhone());
        System.out.println("调用订单服务" + orders.getOrderNo() + "：积分+1");
        System.out.println("调用其他服务。。。");
        System.out.println("调用其他服务。。。");
        System.out.println("调用其他服务。。。");
    }

}
