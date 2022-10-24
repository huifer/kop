package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository
    extends JpaRepository<ProjectTask, Integer>, JpaSpecificationExecutor<ProjectTask> {}
