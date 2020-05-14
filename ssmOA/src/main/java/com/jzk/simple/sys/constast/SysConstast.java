package com.jzk.simple.sys.constast;

/**
 * ClassName:SysConstast
 * Package:com.jzk.simple.sys.constast
 * Description:
 *
 * @Date:2020/4/22 21:58
 * @Author:JZK
 */
public interface SysConstast {

    String USER_LOGIN_ERROR_MSG="用户名或密码不正确";

    String VERIFICATION_CODE_MSG="验证码错误";

    Boolean AVAILABLE_TRUE=true;
    Boolean AVAILABLE_FALSE=false;

    Integer AVAILABLE_ROLE_TRUE=1;
    Integer AVAILABLE_ROLE_FALSE=0;

    Integer CODE_ZERO=0;
    Integer CODE_ONE=1;

    String ADD_SUCCESS="添加成功";
    String ADD_ERROR="添加失败";

    String UPDATE_SUCCESS="更新成功";
    String UPDATE_ERROR="更新失败";

    String RESET_SUCCESS="重置成功";
    String RESET_ERROR="重置失败";

    String DISPATCH_SUCCESS="分配成功";
    String DISPATCH_ERROR="分配失败";

    String DELETE_SUCCESS = "删除成功";
    String DELETE_ERROR = "删除失败";

    Integer CODE_SUCCESS=0;
    Integer CODE_ERROR=-1;

    /**
     * 默认密码配置
     */
    String USER_DEFAULT_PWD = "123456";

    /*
    * 临时文件标记
    * */
    String FILE_UPLOAD_TEMP="_temp";

    /*
    * 默认图片地址
    * */
    Object DEFAULT_CAR_IMG="images/defaultcarimage.jpg";


    String CAR_ORDER_CZ="CZ";
    String CAR_ORDER_JC="JC";

    Integer RENT_BACK_FALSE=0;
    Integer RENT_BACK_TRUE=1;

    Integer RENT_CAR_TRUE=1;
    Integer RENT_CAR_FALSE=0;
}
