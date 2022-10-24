package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectTaskCollaboratorDTO;
import com.github.kop.pm.http.vo.ProjectTaskCollaboratorQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskCollaboratorUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskCollaboratorVO;
import com.github.kop.pm.module.ProjectTaskCollaborator;
import com.github.kop.pm.repository.ProjectTaskCollaboratorRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskCollaboratorService {

  @Autowired private ProjectTaskCollaboratorRepository projectTaskCollaboratorRepository;

  public Integer save(ProjectTaskCollaboratorVO vO) {
    ProjectTaskCollaborator bean = new ProjectTaskCollaborator();
    BeanUtils.copyProperties(vO, bean);
    bean = projectTaskCollaboratorRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectTaskCollaboratorRepository.deleteById(id);
  }

  public void update(Integer id, ProjectTaskCollaboratorUpdateVO vO) {
    ProjectTaskCollaborator bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectTaskCollaboratorRepository.save(bean);
  }

  public ProjectTaskCollaboratorDTO getById(Integer id) {
    ProjectTaskCollaborator original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectTaskCollaboratorDTO> query(ProjectTaskCollaboratorQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectTaskCollaboratorDTO toDTO(ProjectTaskCollaborator original) {
    ProjectTaskCollaboratorDTO bean = new ProjectTaskCollaboratorDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectTaskCollaborator requireOne(Integer id) {
    return projectTaskCollaboratorRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
