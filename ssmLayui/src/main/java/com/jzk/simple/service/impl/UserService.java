package com.jzk.simple.service.impl;

import com.jzk.simple.dao.IUserDao;
import com.jzk.simple.model.User;
import com.jzk.simple.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:UserService
 * Package:simple.service.impl
 * Description:
 *
 * @Date:2020/3/30 15:29
 * @Author:JiangZhikuan
 */

@Service
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;


    @Override
    public User selectUser(int id) {
        return userDao.selectUser(id);
    }

}
