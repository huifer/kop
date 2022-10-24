package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectFeatureUserDTO;
import com.github.kop.pm.http.vo.ProjectFeatureUserQueryVO;
import com.github.kop.pm.http.vo.ProjectFeatureUserUpdateVO;
import com.github.kop.pm.http.vo.ProjectFeatureUserVO;
import com.github.kop.pm.module.ProjectFeatureUser;
import com.github.kop.pm.repository.ProjectFeatureUserRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectFeatureUserService {

  @Autowired private ProjectFeatureUserRepository projectFeatureUserRepository;

  public Integer save(ProjectFeatureUserVO vO) {
    ProjectFeatureUser bean = new ProjectFeatureUser();
    BeanUtils.copyProperties(vO, bean);
    bean = projectFeatureUserRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectFeatureUserRepository.deleteById(id);
  }

  public void update(Integer id, ProjectFeatureUserUpdateVO vO) {
    ProjectFeatureUser bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectFeatureUserRepository.save(bean);
  }

  public ProjectFeatureUserDTO getById(Integer id) {
    ProjectFeatureUser original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectFeatureUserDTO> query(ProjectFeatureUserQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectFeatureUserDTO toDTO(ProjectFeatureUser original) {
    ProjectFeatureUserDTO bean = new ProjectFeatureUserDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectFeatureUser requireOne(Integer id) {
    return projectFeatureUserRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
