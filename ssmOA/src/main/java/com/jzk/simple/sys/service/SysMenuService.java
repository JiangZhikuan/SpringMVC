package com.jzk.simple.sys.service;

import com.jzk.simple.sys.domain.SysMenu;
import com.jzk.simple.sys.vo.SysMenuVo;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Map;

/**
 * InterfaceName:SysMenuService
 * Package:com.jzk.simple.sys.service
 * Description:
 *
 * @Date:2020/4/24 12:54
 * @Author:JiangZhikuan
 */

public interface SysMenuService {

    Map<String,Object> menu();

    List<SysMenu> findAllMenu(SysMenuVo sysMenuVo);

    void addMenu(SysMenuVo sysMenuVo);

    void updateMenu(SysMenuVo sysMenuVo);

    Integer queryMenuByPid(Integer  pid);

    void deleteMenu(SysMenuVo sysMenuVo);
}
