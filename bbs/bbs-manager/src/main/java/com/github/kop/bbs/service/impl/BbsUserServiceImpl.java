package com.github.kop.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.LoginUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.res.user.UserLoginRes;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.JwtTokenUtil;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.repo.mapper.BbsUserMapper;
import com.github.kop.bbs.module.entity.BbsUser;
import com.github.kop.bbs.service.BbsUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class BbsUserServiceImpl extends ServiceImpl<BbsUserMapper, BbsUser> implements BbsUserService {

    protected final UserCreateAndUpdateValidate userCreateAndUpdateValidate =
            new UserCreateAndUpdateValidate();

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public int updateBatchSelective(List<BbsUser> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<BbsUser> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Boolean create(CreateUserReq req) {
        userCreateAndUpdateValidate.createValidate(req);
        // 随机生成盐
        String salt = RandomStringUtils.randomAlphanumeric(10);
        return baseMapper.insert(BbsUser.builder()
                .username(req.getUsername())
                .password(DigestUtils.md5DigestAsHex((req.getPassword() + salt).getBytes(StandardCharsets.UTF_8)))
                .salt(salt)
                .avatar(req.getAvatar())
                .nickname(req.getNickname())
                .registerTime(new Date())
                .build()) > 0;
    }

    @Override
    public Boolean updateUser(UpdateUserReq req) {
        BbsUser bbsUser = baseMapper.selectById(req.getId());
        if(ObjectUtils.isEmpty(bbsUser)){
            throw new NoceException("当前用户不存在");
        }
        // 修改密码重新生成盐
        if(ObjectUtils.isNotEmpty(req.getPassword())){
            String salt = RandomStringUtils.randomAlphanumeric(10);
            bbsUser.setSalt(salt);
            bbsUser.setPassword(DigestUtils.md5DigestAsHex((req.getPassword() + salt).getBytes(StandardCharsets.UTF_8)));
        }
        if (ObjectUtils.isNotEmpty(req.getNickname())){
            bbsUser.setNickname(req.getNickname());
        }
        if (ObjectUtils.isNotEmpty(req.getAvatar())){
            bbsUser.setAvatar(req.getAvatar());
        }
        return baseMapper.updateById(bbsUser) > 0;
    }

    /**
     * 登录
     * @param req
     * @return
     */
    @Override
    public UserLoginRes login(LoginUserReq req) {
        QueryWrapper<BbsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(BbsUser::getUsername, req.getUsername());
        BbsUser bbsUser = baseMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(bbsUser)){
            throw new NoceException("用户不存在!");
        }
        if (!bbsUser.getPassword().equals(DigestUtils.md5DigestAsHex((req.getPassword() + bbsUser.getSalt()).getBytes(StandardCharsets.UTF_8)))) {
            throw new NoceException("密码不正确!");
        }
        UserLoginRes res = new UserLoginRes();
        res.setUsername(bbsUser.getUsername());
        res.setAvatar(bbsUser.getAvatar());
        res.setNickname(bbsUser.getNickname());
        res.setToken(jwtTokenUtil.generateToken(bbsUser.getId()));
        return res;
    }


    protected class UserCreateAndUpdateValidate
            implements CreateValidate<CreateUserReq>, UpdateValidate<UpdateUserReq> {
        @Override
        public void createValidate(CreateUserReq createUserReq) throws ValidateException {
            String name = createUserReq.getUsername();
            if (StringUtils.isEmpty(name)) {
                throw new ValidateException("用户名必填");
            }
            QueryWrapper<BbsUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(BbsUser::getUsername, name);
            boolean existsName = baseMapper.exists(queryWrapper);
            if (existsName) {
                throw new ValidateException("用户名已存在");
            }
            String password = createUserReq.getPassword();
            if (StringUtils.isEmpty(password)) {
                throw new ValidateException("密码必填");
            }

        }

        @Override
        public void updateValidate(UpdateUserReq updateUserReq) throws ValidateException {

        }
    }
}
