package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectTaskCollaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskCollaboratorRepository
    extends JpaRepository<ProjectTaskCollaborator, Integer>,
        JpaSpecificationExecutor<ProjectTaskCollaborator> {}
