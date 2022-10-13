package com.github.kop.pm.repository;

import com.github.kop.pm.module.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectRepository extends JpaRepository<Project, Integer>,
    JpaSpecificationExecutor<Project> {

}