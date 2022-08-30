package com.github.kop.bbs.service.category.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Category;
import com.github.kop.bbs.module.enums.category.CategoryViewPermissionsEnum;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.res.category.customer.CategoryListRes;
import com.github.kop.bbs.repo.CategoryRepository;
import com.github.kop.bbs.service.category.CategoryService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 板块服务 */
@Service
public class CategoryServiceImpl implements CategoryService {

  protected final CategoryCreateAndUpdateValidate categoryCreateAndUpdateValidate =
      new CategoryCreateAndUpdateValidate();

  @Autowired private CategoryRepository categoryRepository;

  /**
   * 添加板块
   *
   * @param req
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  @Override
  public Boolean create(CreateCategoryReq req) {
    categoryCreateAndUpdateValidate.createValidate(req);
    Category insertEntity = new Category();
    insertEntity.setCategoryName(req.getCategoryName());
    insertEntity.setCategoryIcon(req.getCategoryIcon());
    insertEntity.setParentId(req.getParentId());
    insertEntity.setViewPermissions(req.getViewPermissions());
    return categoryRepository.insert(insertEntity) > 0;
  }

  /**
   * 修改版块
   *
   * @param req
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  @Override
  public Boolean updateCategory(UpdateCategoryReq req) {
    categoryCreateAndUpdateValidate.updateValidate(req);
    Category updateEntity = new Category();
    updateEntity.setCategoryId(req.getCategoryId());
    updateEntity.setCategoryName(req.getCategoryName());
    updateEntity.setCategoryIcon(req.getCategoryIcon());
    updateEntity.setParentId(req.getParentId());
    updateEntity.setViewPermissions(req.getViewPermissions());
    return categoryRepository.updateById(updateEntity) > 0;
  }

  /**
   * 分页查询列表
   *
   * @param page
   * @param size
   * @param req
   * @return
   */
  @Override
  public IPage<CategoryListRes> page(Long page, Long size, QueryCategoryReq req) {
    IPage<Category> list = this.categoryRepository.page(page, size, req);
    return list.convert(this::conv);
  }

  @Override
  public List<CategoryListRes> topList() {
    List<Category> list = this.categoryRepository.topList();
    List<CategoryListRes> res = new ArrayList<>();
    for (Category category : list) {
      // TODO: 2022/8/24 帖子数量计算
      res.add(conv(category));
    }
    return res;
  }

  @Override
  public List<CategoryListRes> subList(Long categoryId) {
    List<Category> list = this.categoryRepository.subList(categoryId);
    List<CategoryListRes> res = new ArrayList<>();
    for (Category category : list) {
      // TODO: 2022/8/24 帖子数量计算
      res.add(conv(category));
    }
    return res;
  }


  private CategoryListRes conv(Category category) {
    CategoryListRes res = new CategoryListRes();
    res.setCategoryIcon(category.getCategoryIcon());
    res.setCategoryName(category.getCategoryName());
    Long parentId = category.getParentId();
    Category parentCategory = this.categoryRepository.byId(parentId);
    if (parentCategory != null) {
      res.setParentName(parentCategory.getCategoryName());

    }

    res.setViewPermissions(
        CategoryViewPermissionsEnum.getEnumByCode(category.getViewPermissions()).getDesc());
    return res;
  }

  protected class CategoryCreateAndUpdateValidate
      implements CreateValidate<CreateCategoryReq>, UpdateValidate<UpdateCategoryReq> {

    @Override
    public void createValidate(CreateCategoryReq createCategoryReq) throws ValidateException {
      if (StringUtils.isBlank(createCategoryReq.getCategoryName())) {
        throw new ValidateException("分类名称不能为空!");
      }
      boolean exists = categoryRepository.existsCategoryName(createCategoryReq.getCategoryName());
      if (exists) {
        throw new ValidateException("分类名称已经存在");
      }
    }

    @Override
    public void updateValidate(UpdateCategoryReq updateCategoryReq) throws ValidateException {
      idValidate(updateCategoryReq.getCategoryId());
    }
  }
}
