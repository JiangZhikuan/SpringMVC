package com.jzk.simple.sys.mapper;

import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.vo.SysUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ClassName:TestSysUserMapper
 * Package:com.jzk.simple.sys.mapper
 * Description:
 *          测试SysUserMapper接口
 * @Date:2020/4/22 22:11
 * @Author:JZK
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-dao.xml"})
public class TestSysUserMapper {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void testLogin(){
        SysUserVo sysUserVo=new SysUserVo();
        sysUserVo.setLoginname("admin");
        sysUserVo.setPwd("123456");
        SysUser sysUser=sysUserMapper.login(sysUserVo);
        System.out.println(sysUser.getLoginname());
    }

}
