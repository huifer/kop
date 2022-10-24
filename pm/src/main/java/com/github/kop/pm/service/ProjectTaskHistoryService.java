package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectTaskHistoryDTO;
import com.github.kop.pm.http.vo.ProjectTaskHistoryQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskHistoryUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskHistoryVO;
import com.github.kop.pm.module.ProjectTaskHistory;
import com.github.kop.pm.repository.ProjectTaskHistoryRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskHistoryService {

  @Autowired
  private ProjectTaskHistoryRepository projectTaskHistoryRepository;

  public Integer save(ProjectTaskHistoryVO vO) {
    ProjectTaskHistory bean = new ProjectTaskHistory();
    BeanUtils.copyProperties(vO, bean);
    bean = projectTaskHistoryRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectTaskHistoryRepository.deleteById(id);
  }

  public void update(Integer id, ProjectTaskHistoryUpdateVO vO) {
    ProjectTaskHistory bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectTaskHistoryRepository.save(bean);
  }

  public ProjectTaskHistoryDTO getById(Integer id) {
    ProjectTaskHistory original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectTaskHistoryDTO> query(ProjectTaskHistoryQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectTaskHistoryDTO toDTO(ProjectTaskHistory original) {
    ProjectTaskHistoryDTO bean = new ProjectTaskHistoryDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectTaskHistory requireOne(Integer id) {
    return projectTaskHistoryRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
