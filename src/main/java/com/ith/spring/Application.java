package com.ith.spring;

import com.ith.spring.dao.OrderRepository;
import com.ith.spring.dao.UserRepository;
import com.ith.spring.domain.Orders;
import com.ith.spring.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    InitializingBean initUserDB(UserRepository userRepository){
        return ()-> {
            userRepository.save(new User(1L,"小龙女","12345",0));
            userRepository.save(new User(2L,"杨过","12345",1));
            userRepository.save(new User(3L,"郭芙","12345",0));
            userRepository.save(new User(4L,"陆无双","12345",0));
        };
    }

    @Bean
    InitializingBean initOrderDB(OrderRepository orderRepository){
        return ()-> {
            orderRepository.save(new Orders(1L,"NO91003345","15570719300"));
            orderRepository.save(new Orders(2L,"NO91003346","15773205101"));
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
