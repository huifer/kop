package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectFeatureUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectFeatureUserRepository extends JpaRepository<ProjectFeatureUser, Integer>,
    JpaSpecificationExecutor<ProjectFeatureUser> {

}