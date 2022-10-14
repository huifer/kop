package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectBindUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBindUserRepository extends JpaRepository<ProjectBindUser, Integer>,
    JpaSpecificationExecutor<ProjectBindUser> {

}