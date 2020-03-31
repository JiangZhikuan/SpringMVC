package simple.service;

import simple.model.User;

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
