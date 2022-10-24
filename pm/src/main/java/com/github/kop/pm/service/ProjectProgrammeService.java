package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectProgrammeDTO;
import com.github.kop.pm.http.vo.ProjectProgrammeQueryVO;
import com.github.kop.pm.http.vo.ProjectProgrammeUpdateVO;
import com.github.kop.pm.http.vo.ProjectProgrammeVO;
import com.github.kop.pm.module.ProjectProgramme;
import com.github.kop.pm.repository.ProjectProgrammeRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectProgrammeService {

  @Autowired
  private ProjectProgrammeRepository projectProgrammeRepository;

  public Integer save(ProjectProgrammeVO vO) {
    ProjectProgramme bean = new ProjectProgramme();
    BeanUtils.copyProperties(vO, bean);
    bean = projectProgrammeRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectProgrammeRepository.deleteById(id);
  }

  public void update(Integer id, ProjectProgrammeUpdateVO vO) {
    ProjectProgramme bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectProgrammeRepository.save(bean);
  }

  public ProjectProgrammeDTO getById(Integer id) {
    ProjectProgramme original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectProgrammeDTO> query(ProjectProgrammeQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectProgrammeDTO toDTO(ProjectProgramme original) {
    ProjectProgrammeDTO bean = new ProjectProgrammeDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectProgramme requireOne(Integer id) {
    return projectProgrammeRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
