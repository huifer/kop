package com.github.kop.pm.service;

import com.github.kop.pm.http.dto.UserDTO;
import com.github.kop.pm.http.vo.UserQueryVO;
import com.github.kop.pm.http.vo.UserUpdateVO;
import com.github.kop.pm.http.vo.UserVO;
import com.github.kop.pm.module.User;
import com.github.kop.pm.repository.UserRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Integer save(UserVO vO) {
    User bean = new User();
    BeanUtils.copyProperties(vO, bean);
    bean = userRepository.save(bean);
    return bean.getId();
  }

  public void delete(Integer id) {
    userRepository.deleteById(id);
  }

  public void update(Integer id, UserUpdateVO vO) {
    User bean = requireOne(id);
    BeanUtils.copyProperties(vO, bean);
    userRepository.save(bean);
  }

  public UserDTO getById(Integer id) {
    User original = requireOne(id);
    return toDTO(original);
  }

  public Page<UserDTO> query(UserQueryVO vO) {
    throw new UnsupportedOperationException();
  }

  private UserDTO toDTO(User original) {
    UserDTO bean = new UserDTO();
    BeanUtils.copyProperties(original, bean);
    return bean;
  }

  private User requireOne(Integer id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
  }
}
