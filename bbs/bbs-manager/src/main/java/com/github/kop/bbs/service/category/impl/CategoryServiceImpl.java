package com.github.kop.bbs.service.category.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Category;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.enums.category.ViewPermissionsEnum;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import com.github.kop.bbs.repo.CategoryRepository;
import com.github.kop.bbs.service.category.CategoryService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 板块服务
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    protected final CategoryCreateAndUpdateValidate categoryCreateAndUpdateValidate =
        new CategoryCreateAndUpdateValidate();

    @Autowired
    private CategoryRepository categoryRepository;

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
    public IPage<CategoryListRes> list(Long page, Long size, QueryCategoryReq req) {
        IPage<Category> list = this.categoryRepository.page(page,
            size, req);
        return list.convert(this::conv);
    }

    private CategoryListRes conv(Category category) {
        CategoryListRes res = new CategoryListRes();
        res.setCategoryIcon(category.getCategoryIcon());
        res.setCategoryName(category.getCategoryName());
        res.setViewPermissions(ViewPermissionsEnum.getEnumByCode(category.getViewPermissions()).getDesc());
        return res;
    }

    protected class CategoryCreateAndUpdateValidate
            implements CreateValidate<CreateCategoryReq>, UpdateValidate<UpdateCategoryReq> {

        @Override
        public void createValidate(CreateCategoryReq createCategoryReq) throws ValidateException {
            if(StringUtils.isBlank(createCategoryReq.getCategoryName())){
                throw new ValidateException("分类名称不能为空!");
            }
           boolean exists = categoryRepository.existsCategoryName(createCategoryReq.getCategoryName());
            if(exists){
                throw new ValidateException("分类名称已经存在");
            }
        }

        @Override
        public void updateValidate(UpdateCategoryReq updateCategoryReq) throws ValidateException {
            idValidate(updateCategoryReq.getCategoryId());
        }
    }
}
