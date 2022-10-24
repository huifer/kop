package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectTaskExecutorDTO;
import com.github.kop.pm.http.vo.ProjectTaskExecutorQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskExecutorUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskExecutorVO;
import com.github.kop.pm.module.ProjectTaskExecutor;
import com.github.kop.pm.repository.ProjectTaskExecutorRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskExecutorService {

  @Autowired
  private ProjectTaskExecutorRepository projectTaskExecutorRepository;

  public Integer save(ProjectTaskExecutorVO vO) {
    ProjectTaskExecutor bean = new ProjectTaskExecutor();
    BeanUtils.copyProperties(vO, bean);
    bean = projectTaskExecutorRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectTaskExecutorRepository.deleteById(id);
  }

  public void update(Integer id, ProjectTaskExecutorUpdateVO vO) {
    ProjectTaskExecutor bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectTaskExecutorRepository.save(bean);
  }

  public ProjectTaskExecutorDTO getById(Integer id) {
    ProjectTaskExecutor original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectTaskExecutorDTO> query(ProjectTaskExecutorQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectTaskExecutorDTO toDTO(ProjectTaskExecutor original) {
    ProjectTaskExecutorDTO bean = new ProjectTaskExecutorDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectTaskExecutor requireOne(Integer id) {
    return projectTaskExecutorRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
