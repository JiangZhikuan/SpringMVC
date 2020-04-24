package com.jzk.simple.sys.utils;

import com.jzk.simple.sys.vo.MenuVo;
import com.jzk.simple.sys.vo.SysMenuVo;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:TreeUtil
 * Package:com.jzk.simple.sys.utils
 * Description:
 *
 * @Date:2020/4/24 12:18
 * @Author:JiangZhikuan
 */
public class TreeUtil {
    public static List<MenuVo> toTree(List<MenuVo> treeList, Integer pid) {
        List<MenuVo> retList = new ArrayList<MenuVo>();
        for (MenuVo parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }
    private static MenuVo findChildren(MenuVo parent, List<MenuVo> treeList) {
        for (MenuVo child : treeList) {
            if (parent.getId().equals(child.getPid())) {
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<>());
                }
                parent.getChild().add(findChildren(child, treeList));
            }
        }
        return parent;
    }
}
