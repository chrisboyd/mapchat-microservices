package com.eureka.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.user.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
