package com.spring_scheduling.dao;

import com.spring_scheduling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {

}
