package com.jzk.simple.sys.service;

import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.vo.SysLogLoginVo;

/**
 * InterfaceName:LogInfoService
 * Package:com.jzk.simple.sys.service
 * Description:
 *
 * @Date:2020/4/29 9:49
 * @Author:JiangZhikuan
 */

public interface LogInfoService {

    DataGridView queryAllLoginInfo(SysLogLoginVo sysLogLoginVo);

    void addLogInfo(SysLogLoginVo sysLogLoginVo);

    void deleteLogInfo(Integer logInfoId);

    void deleteBatchLogInfo(Integer[] ids);
}
