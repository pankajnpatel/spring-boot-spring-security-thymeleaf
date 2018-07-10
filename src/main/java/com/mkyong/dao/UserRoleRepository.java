package com.mkyong.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
