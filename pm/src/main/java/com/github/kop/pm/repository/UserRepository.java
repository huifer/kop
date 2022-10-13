package com.github.kop.pm.repository;

import com.github.kop.pm.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Integer>,
    JpaSpecificationExecutor<User> {

}