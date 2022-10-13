package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectBugExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectBugExecutorRepository extends JpaRepository<ProjectBugExecutor, Integer>,
    JpaSpecificationExecutor<ProjectBugExecutor> {

}