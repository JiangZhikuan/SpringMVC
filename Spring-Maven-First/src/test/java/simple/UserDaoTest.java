package simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import simple.dao.IUserDao;
import simple.model.User;

import javax.annotation.Resource;

/**
 * ClassName:UserDaoTest
 * Package:simple
 * Description:
 *
 * @Date:2020/3/30 20:48
 * @Author:JZK
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Resource
    private IUserDao userDao;

    @Test
    public void testSelectUser(){
        int id=1;
        User user=userDao.selectUser(id);
        System.out.println(user.getId());
        System.out.println(user.getName());

    }

}
