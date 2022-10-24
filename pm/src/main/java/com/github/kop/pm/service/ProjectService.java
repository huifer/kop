package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectDTO;
import com.github.kop.pm.http.vo.ProjectQueryVO;
import com.github.kop.pm.http.vo.ProjectUpdateVO;
import com.github.kop.pm.http.vo.ProjectVO;
import com.github.kop.pm.module.Project;
import com.github.kop.pm.repository.ProjectRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public Integer save(ProjectVO vO) {
    Project bean = new Project();
    BeanUtils.copyProperties(vO, bean);
    bean = projectRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectRepository.deleteById(id);
  }

  public void update(Integer id, ProjectUpdateVO vO) {
    Project bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectRepository.save(bean);
  }

  public ProjectDTO getById(Integer id) {
    Project original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectDTO> query(ProjectQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectDTO toDTO(Project original) {
    ProjectDTO bean = new ProjectDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private Project requireOne(Integer id) {
    return projectRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
