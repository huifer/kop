package com.github.kop.pm.repository;

import com.github.kop.pm.module.ProjectFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectFeatureRepository extends JpaRepository<ProjectFeature, Integer>,
    JpaSpecificationExecutor<ProjectFeature> {

}