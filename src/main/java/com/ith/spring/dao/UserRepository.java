package com.ith.spring.dao;

import com.ith.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> getUserByUsernameAndGender(String username, Integer gender);
}
