package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.ProjectFileDTO;
import com.github.kop.pm.http.vo.ProjectFileQueryVO;
import com.github.kop.pm.http.vo.ProjectFileUpdateVO;
import com.github.kop.pm.http.vo.ProjectFileVO;
import com.github.kop.pm.module.ProjectFile;
import com.github.kop.pm.repository.ProjectFileRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProjectFileService {

  @Autowired private ProjectFileRepository projectFileRepository;

  public Integer save(ProjectFileVO vO) {
    ProjectFile bean = new ProjectFile();
    BeanUtils.copyProperties(vO, bean);
    bean = projectFileRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    projectFileRepository.deleteById(id);
  }

  public void update(Integer id, ProjectFileUpdateVO vO) {
    ProjectFile bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    projectFileRepository.save(bean);
  }

  public ProjectFileDTO getById(Integer id) {
    ProjectFile original = requireOne(id);
    return toDTO(original);
  }

  public Page<ProjectFileDTO> query(ProjectFileQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private ProjectFileDTO toDTO(ProjectFile original) {
    ProjectFileDTO bean = new ProjectFileDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private ProjectFile requireOne(Integer id) {
    return projectFileRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
