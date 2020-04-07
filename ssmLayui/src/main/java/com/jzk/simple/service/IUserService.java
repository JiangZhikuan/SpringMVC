package com.jzk.simple.service;


import com.jzk.simple.model.User;

/**
 * InterfaceName:IUserService
 * Package:simple.service
 * Description:
 *
 * @Date:2020/3/30 15:29
 * @Author:JiangZhikuan
 */

public interface IUserService {

    User selectUser(int id);

}
