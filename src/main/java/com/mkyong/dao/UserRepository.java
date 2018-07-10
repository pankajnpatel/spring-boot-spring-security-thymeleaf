package com.mkyong.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.model.User;

public interface UserRepository  extends JpaRepository<User,Long>{

}