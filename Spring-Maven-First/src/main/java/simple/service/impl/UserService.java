package simple.service.impl;

import org.springframework.stereotype.Service;
import simple.dao.IUserDao;
import simple.model.User;
import simple.service.IUserService;

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
