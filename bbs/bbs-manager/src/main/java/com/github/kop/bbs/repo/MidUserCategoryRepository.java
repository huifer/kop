package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.MidUserCategory;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 16:03
 */
public interface MidUserCategoryRepository {
  /**
   * 根据用户id和分类判断版主
   *
   * @param userId
   * @param categoryId
   * @return
   */
  boolean existsUserIdAndCategory(Long userId, Long categoryId);

  /**
   * 添加版主
   *
   * @param build
   * @return
   */
  Boolean insert(MidUserCategory build);

  /**
   * 根据id获取信息
   *
   * @param id
   * @return
   */
  MidUserCategory selectById(Long id);

  /**
   * 根据id删除
   *
   * @param id
   * @return
   */
  int deleteById(Long id);

  /**
   * 根据用户id获取版主信息的数量
   *
   * @param userId
   * @return
   */
  int selectCountByUserId(Long userId);

  /**
   * 根据用户id获取版主信息的
   *
   * @param userId
   * @return
   */
  List<MidUserCategory> selectByUserId(Long userId);
}
