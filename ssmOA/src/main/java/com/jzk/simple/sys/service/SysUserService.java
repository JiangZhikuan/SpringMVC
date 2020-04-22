package com.jzk.simple.sys.service;

import com.jzk.simple.sys.domain.SysUser;
import com.jzk.simple.sys.vo.SysUserVo;

/**
 * interfaceName:SysUserService
 * Package:com.jzk.simple.sys.service
 * Description:
 *
 * @Date:2020/4/22 21:54
 * @Author:JZK
 */

public interface SysUserService {

    SysUser login(SysUserVo sysUserVo);

}
