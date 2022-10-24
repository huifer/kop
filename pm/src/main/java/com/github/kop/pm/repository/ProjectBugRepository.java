package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectBug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBugRepository
    extends JpaRepository<ProjectBug, Integer>, JpaSpecificationExecutor<ProjectBug> {}
