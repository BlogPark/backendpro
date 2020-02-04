package com.yongming.backendpro.system.model.vo;

import com.yongming.backendpro.system.model.SystemMenuModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SystemMenuVO {
    private int id;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单类型（1 菜单 2 按钮）
     */
    private int menuType;
    /**
     * 菜单控制器
     */
    private String menuControllers;
    /**
     * 菜单路由
     */
    private String menuRouter;
    /**
     * 菜单徽标
     */
    private String menuIcon;
    /**
     * 菜单状态( 1 正常 2 删除)
     */
    private int menuStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 子菜单列表
     */
    private List<SystemMenuModel> childMenus;
    /**
     * 子菜单个数
     */
    private int childCount;
}
