package com.mkyong.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.model.Role;
import com.mkyong.model.User;

public interface RoleRepository  extends JpaRepository<Role,Long>{

}