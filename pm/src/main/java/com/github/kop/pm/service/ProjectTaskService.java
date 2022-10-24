package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectTaskDTO;
import com.github.kop.pm.http.vo.ProjectTaskQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskVO;
import com.github.kop.pm.module.ProjectTask;
import com.github.kop.pm.repository.ProjectTaskRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

  @Autowired private ProjectTaskRepository projectTaskRepository;

  public Integer save(ProjectTaskVO vO) {
    ProjectTask bean = new ProjectTask();
    BeanUtils.copyProperties(vO, bean);
    bean = projectTaskRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectTaskRepository.deleteById(id);
  }

  public void update(Integer id, ProjectTaskUpdateVO vO) {
    ProjectTask bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectTaskRepository.save(bean);
  }

  public ProjectTaskDTO getById(Integer id) {
    ProjectTask original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectTaskDTO> query(ProjectTaskQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectTaskDTO toDTO(ProjectTask original) {
    ProjectTaskDTO bean = new ProjectTaskDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectTask requireOne(Integer id) {
    return projectTaskRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
