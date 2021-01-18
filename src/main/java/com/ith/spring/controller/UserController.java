package com.ith.spring.controller;

import com.ith.spring.dao.UserRepository;
import com.ith.spring.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: pan le
 * @description: test
 * @create: 2021-01-18 14:47
 **/
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public List<User> hello(){
        return userRepository.findAll();
    }

}
