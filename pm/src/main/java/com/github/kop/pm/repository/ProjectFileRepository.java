package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectFileRepository
    extends JpaRepository<ProjectFile, Integer>, JpaSpecificationExecutor<ProjectFile> {}
