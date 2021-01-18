package com.ith.spring.Common.OrderLinstener;

import com.ith.spring.domain.Orders;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author: pan le
 * @description: 订单完成事件
 * @create: 2021-01-18 16:09
 **/
@Component
public class AfterCreateOrderEvent extends ApplicationEvent {
    public AfterCreateOrderEvent(Orders Orders) {
        super(Orders);
    }
    public Orders getOrder(){
        return (Orders) getSource();
    }
}
