package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectBugDTO;
import com.github.kop.pm.http.vo.ProjectBugQueryVO;
import com.github.kop.pm.http.vo.ProjectBugUpdateVO;
import com.github.kop.pm.http.vo.ProjectBugVO;
import com.github.kop.pm.module.ProjectBug;
import com.github.kop.pm.repository.ProjectBugRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectBugService {

  @Autowired private ProjectBugRepository projectBugRepository;

  public Integer save(ProjectBugVO vO) {
    ProjectBug bean = new ProjectBug();
    BeanUtils.copyProperties(vO, bean);
    bean = projectBugRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectBugRepository.deleteById(id);
  }

  public void update(Integer id, ProjectBugUpdateVO vO) {
    ProjectBug bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectBugRepository.save(bean);
  }

  public ProjectBugDTO getById(Integer id) {
    ProjectBug original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectBugDTO> query(ProjectBugQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectBugDTO toDTO(ProjectBug original) {
    ProjectBugDTO bean = new ProjectBugDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectBug requireOne(Integer id) {
    return projectBugRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
