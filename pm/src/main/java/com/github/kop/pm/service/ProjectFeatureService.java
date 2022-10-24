package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectFeatureDTO;
import com.github.kop.pm.http.vo.ProjectFeatureQueryVO;
import com.github.kop.pm.http.vo.ProjectFeatureUpdateVO;
import com.github.kop.pm.http.vo.ProjectFeatureVO;
import com.github.kop.pm.module.ProjectFeature;
import com.github.kop.pm.repository.ProjectFeatureRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectFeatureService {

  @Autowired
  private ProjectFeatureRepository projectFeatureRepository;

  public Integer save(ProjectFeatureVO vO) {
    ProjectFeature bean = new ProjectFeature();
    BeanUtils.copyProperties(vO, bean);
    bean = projectFeatureRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectFeatureRepository.deleteById(id);
  }

  public void update(Integer id, ProjectFeatureUpdateVO vO) {
    ProjectFeature bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectFeatureRepository.save(bean);
  }

  public ProjectFeatureDTO getById(Integer id) {
    ProjectFeature original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectFeatureDTO> query(ProjectFeatureQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectFeatureDTO toDTO(ProjectFeature original) {
    ProjectFeatureDTO bean = new ProjectFeatureDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectFeature requireOne(Integer id) {
    return projectFeatureRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
