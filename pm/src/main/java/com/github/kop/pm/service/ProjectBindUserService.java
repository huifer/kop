package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectBindUserDTO;
import com.github.kop.pm.http.vo.ProjectBindUserQueryVO;
import com.github.kop.pm.http.vo.ProjectBindUserUpdateVO;
import com.github.kop.pm.http.vo.ProjectBindUserVO;
import com.github.kop.pm.module.ProjectBindUser;
import com.github.kop.pm.repository.ProjectBindUserRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectBindUserService {

  @Autowired
  private ProjectBindUserRepository projectBindUserRepository;

  public Integer save(ProjectBindUserVO vO) {
    ProjectBindUser bean = new ProjectBindUser();
    BeanUtils.copyProperties(vO, bean);
    bean = projectBindUserRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectBindUserRepository.deleteById(id);
  }

  public void update(Integer id, ProjectBindUserUpdateVO vO) {
    ProjectBindUser bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectBindUserRepository.save(bean);
  }

  public ProjectBindUserDTO getById(Integer id) {
    ProjectBindUser original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectBindUserDTO> query(ProjectBindUserQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectBindUserDTO toDTO(ProjectBindUser original) {
    ProjectBindUserDTO bean = new ProjectBindUserDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectBindUser requireOne(Integer id) {
    return projectBindUserRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
