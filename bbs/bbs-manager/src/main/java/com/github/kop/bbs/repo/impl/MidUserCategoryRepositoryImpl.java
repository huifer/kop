package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.MidUserCategory;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.repo.MidUserCategoryRepository;
import com.github.kop.bbs.repo.mapper.MidUserCategoryMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 16:03
 */
@Repository
public class MidUserCategoryRepositoryImpl implements MidUserCategoryRepository {

  @Resource private MidUserCategoryMapper midUserCategoryMapper;

  /**
   * 根据用户id和分类判断版主
   *
   * @param userId
   * @param categoryId
   * @return
   */
  @Override
  public boolean existsUserIdAndCategory(Long userId, Long categoryId) {
    QueryWrapper<MidUserCategory> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(MidUserCategory::getUserId, userId)
        .eq(MidUserCategory::getCategoryId, categoryId);
    return midUserCategoryMapper.exists(queryWrapper);
  }

  private void insertValidate(Long userId, Long categoryId) {
    boolean b = existsUserIdAndCategory(userId, categoryId);
    if (b) {
      throw new RuntimeException("该用户已经是版主!");
    }
  }

  /**
   * 添加版主
   *
   * @param build
   * @return
   */
  @Override
  public Boolean insert(MidUserCategory build) {
    insertValidate(build.getUserId(), build.getCategoryId());
    return midUserCategoryMapper.insert(build) > 0;
  }

  /**
   * 根据id获取信息
   *
   * @param id
   * @return
   */
  @Override
  public MidUserCategory selectById(Long id) {
    return midUserCategoryMapper.selectById(id);
  }

  /**
   * 根据id删除
   *
   * @param id
   * @return
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public int deleteById(Long id) {
    return midUserCategoryMapper.updateById(
        MidUserCategory.builder().categoryId(id).deleted(DeletedEnum.TRUE.getCode()).build());
  }

  /**
   * 根据用户id获取版主信息的数量
   *
   * @param userId
   * @return
   */
  @Override
  public int selectCountByUserId(Long userId) {
    return selectByUserId(userId).size();
  }

  @Override
  public List<MidUserCategory> selectByUserId(Long userId) {
    QueryWrapper<MidUserCategory> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(MidUserCategory::getUserId, userId)
        .eq(MidUserCategory::getDeleted, DeletedEnum.FALSE.getCode());
    return midUserCategoryMapper.selectList(queryWrapper);
  }
}
