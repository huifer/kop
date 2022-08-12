package com.github.kop.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.BbsCategory;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.req.category.ViewPermissionsEnum;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import com.github.kop.bbs.repo.CategoryRepository;
import com.github.kop.bbs.service.BbsCategoryService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsCategoryServiceImpl implements BbsCategoryService {

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
    @Override
    public Boolean create(CreateCategoryReq req) {
        categoryCreateAndUpdateValidate.createValidate(req);
        BbsCategory insertEntity = new BbsCategory();
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
    @Override
    public Boolean updateCategory(UpdateCategoryReq req) {
        categoryCreateAndUpdateValidate.updateValidate(req);
        BbsCategory updateEntity = new BbsCategory();
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
        IPage<BbsCategory> list = this.categoryRepository.page(page,
            size, req);
        return list.convert(this::conv);
    }

    private CategoryListRes conv(BbsCategory bbsCategory) {
        CategoryListRes res = new CategoryListRes();
        res.setCategoryIcon(bbsCategory.getCategoryIcon());
        res.setCategoryName(bbsCategory.getCategoryName());
        res.setViewPermissions(ViewPermissionsEnum.getEnumByCode(bbsCategory.getViewPermissions()).getDesc());
        return res;
    }

    protected static class CategoryCreateAndUpdateValidate
            implements CreateValidate<CreateCategoryReq>, UpdateValidate<UpdateCategoryReq> {

        @Override
        public void createValidate(CreateCategoryReq createCategoryReq) throws ValidateException {
            if(StringUtils.isBlank(createCategoryReq.getCategoryName())){
                throw new ValidateException("分类名称不能为空!");
            }
        }

        @Override
        public void updateValidate(UpdateCategoryReq updateCategoryReq) throws ValidateException {
            idValidate(updateCategoryReq.getCategoryId());
        }
    }
}
