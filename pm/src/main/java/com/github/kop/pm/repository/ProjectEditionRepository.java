package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEditionRepository
    extends JpaRepository<ProjectEdition, Integer>, JpaSpecificationExecutor<ProjectEdition> {}
