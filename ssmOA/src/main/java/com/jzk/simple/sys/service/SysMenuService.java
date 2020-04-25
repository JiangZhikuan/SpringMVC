package com.jzk.simple.sys.service;

import com.jzk.simple.sys.domain.SysMenu;

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

    List<SysMenu> findAllMenu();
}
