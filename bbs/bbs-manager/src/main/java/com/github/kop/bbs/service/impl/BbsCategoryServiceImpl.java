package com.github.kop.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.req.category.ViewPermissionsEnum;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsCategory;
import com.github.kop.bbs.repo.mapper.BbsCategoryMapper;
import com.github.kop.bbs.service.BbsCategoryService;
@Service
public class BbsCategoryServiceImpl extends ServiceImpl<BbsCategoryMapper, BbsCategory> implements BbsCategoryService{

    protected final CategoryCreateAndUpdateValidate userCreateAndUpdateValidate =
            new CategoryCreateAndUpdateValidate();


    @Override
    public int updateBatchSelective(List<BbsCategory> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsCategory> list) {
        return baseMapper.batchInsert(list);
    }

    /**
     * 添加板块
     *
     * @param req
     * @return
     */
    @Override
    public Boolean create(CreateCategoryReq req) {
        userCreateAndUpdateValidate.createValidate(req);
        BbsCategory insertEntity = new BbsCategory();
        insertEntity.setCategoryName(req.getCategoryName());
        insertEntity.setCategoryIcon(req.getCategoryIcon());
        insertEntity.setParentId(req.getParentId());
        insertEntity.setViewPermissions(req.getViewPermissions());
        return baseMapper.insert(insertEntity) > 0;
    }

    /**
     * 修改版块
     *
     * @param req
     * @return
     */
    @Override
    public Boolean updateCategory(UpdateCategoryReq req) {
        userCreateAndUpdateValidate.idValidate(req.getCategoryId());
        BbsCategory updateEntity = new BbsCategory();
        updateEntity.setCategoryId(req.getCategoryId());
        updateEntity.setCategoryName(req.getCategoryName());
        updateEntity.setCategoryIcon(req.getCategoryIcon());
        updateEntity.setParentId(req.getParentId());
        updateEntity.setViewPermissions(req.getViewPermissions());
        return baseMapper.updateById(updateEntity)>0;
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
        IPage<BbsCategory> list = baseMapper.listWithPage(new Page<>(page, size), req);
        return list.convert(this::conv);
    }

    private CategoryListRes conv(BbsCategory bbsCategory) {
        CategoryListRes res = new CategoryListRes();
        res.setCategoryIcon(bbsCategory.getCategoryIcon());
        res.setCategoryName(bbsCategory.getCategoryName());
        res.setViewPermissions(ViewPermissionsEnum.getEnumByCode(bbsCategory.getViewPermissions()).getDesc());
        return res;
    }

    protected class CategoryCreateAndUpdateValidate
            implements CreateValidate<CreateCategoryReq>, UpdateValidate<UpdateCategoryReq> {

        @Override
        public void createValidate(CreateCategoryReq createCategoryReq) throws ValidateException {
            if(StringUtils.isBlank(createCategoryReq.getCategoryName())){
                throw new ValidateException("分类名称不能为空!");
            }
        }

        @Override
        public void updateValidate(UpdateCategoryReq updateCategoryReq) throws ValidateException {

        }
    }
}
