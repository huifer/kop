package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectProgramme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectProgrammeRepository extends JpaRepository<ProjectProgramme, Integer>,
    JpaSpecificationExecutor<ProjectProgramme> {

}