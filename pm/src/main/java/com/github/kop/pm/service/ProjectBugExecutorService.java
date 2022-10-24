package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectBugExecutorDTO;
import com.github.kop.pm.http.vo.ProjectBugExecutorQueryVO;
import com.github.kop.pm.http.vo.ProjectBugExecutorUpdateVO;
import com.github.kop.pm.http.vo.ProjectBugExecutorVO;
import com.github.kop.pm.module.ProjectBugExecutor;
import com.github.kop.pm.repository.ProjectBugExecutorRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectBugExecutorService {

  @Autowired private ProjectBugExecutorRepository projectBugExecutorRepository;

  public Integer save(ProjectBugExecutorVO vO) {
    ProjectBugExecutor bean = new ProjectBugExecutor();
    BeanUtils.copyProperties(vO, bean);
    bean = projectBugExecutorRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectBugExecutorRepository.deleteById(id);
  }

  public void update(Integer id, ProjectBugExecutorUpdateVO vO) {
    ProjectBugExecutor bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectBugExecutorRepository.save(bean);
  }

  public ProjectBugExecutorDTO getById(Integer id) {
    ProjectBugExecutor original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectBugExecutorDTO> query(ProjectBugExecutorQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectBugExecutorDTO toDTO(ProjectBugExecutor original) {
    ProjectBugExecutorDTO bean = new ProjectBugExecutorDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectBugExecutor requireOne(Integer id) {
    return projectBugExecutorRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
