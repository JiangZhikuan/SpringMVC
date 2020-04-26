package com.jzk.simple.sys.mapper;

import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.vo.SysMenuVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:TestSysMenuMapper
 * Package:com.jzk.simple.sys.mapper
 * Description:
 *
 * @Date:2020/4/24 12:36
 * @Author:JiangZhikuan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-dao.xml"})
public class TestSysMenuMapper {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Test
    public void getAllMenus(){
        SysMenuVo sysMenuVo=new SysMenuVo();
        sysMenuVo.setStatus(true);
        List<SysMenu> menus =sysMenuMapper.findAllMenu(sysMenuVo);
        for (SysMenu sysMenu:menus){
            System.out.println(sysMenu.getId());
            System.out.println(sysMenu.getPid());
            System.out.println(sysMenu.getTitle());
        }
    }

}
