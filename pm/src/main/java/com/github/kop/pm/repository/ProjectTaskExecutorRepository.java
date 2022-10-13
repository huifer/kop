package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectTaskExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectTaskExecutorRepository extends JpaRepository<ProjectTaskExecutor, Integer>,
    JpaSpecificationExecutor<ProjectTaskExecutor> {

}