package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectEditionDTO;
import com.github.kop.pm.http.vo.ProjectEditionQueryVO;
import com.github.kop.pm.http.vo.ProjectEditionUpdateVO;
import com.github.kop.pm.http.vo.ProjectEditionVO;
import com.github.kop.pm.module.ProjectEdition;
import com.github.kop.pm.repository.ProjectEditionRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectEditionService {

  @Autowired private ProjectEditionRepository projectEditionRepository;

  public Integer save(ProjectEditionVO vO) {
    ProjectEdition bean = new ProjectEdition();
    BeanUtils.copyProperties(vO, bean);
    bean = projectEditionRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectEditionRepository.deleteById(id);
  }

  public void update(Integer id, ProjectEditionUpdateVO vO) {
    ProjectEdition bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectEditionRepository.save(bean);
  }

  public ProjectEditionDTO getById(Integer id) {
    ProjectEdition original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectEditionDTO> query(ProjectEditionQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectEditionDTO toDTO(ProjectEdition original) {
    ProjectEditionDTO bean = new ProjectEditionDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectEdition requireOne(Integer id) {
    return projectEditionRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
