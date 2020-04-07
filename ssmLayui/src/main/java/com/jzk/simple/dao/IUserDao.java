package com.jzk.simple.dao;


import com.jzk.simple.model.User;

/**
 * InterfaceName:IUserDao
 * Package:simple.dao
 * Description:
 *
 * @Date:2020/3/30 15:28
 * @Author:JiangZhikuan
 */

public interface IUserDao {

    User selectUser(int id);

}
