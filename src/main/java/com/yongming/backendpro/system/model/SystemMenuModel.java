package com.yongming.backendpro.system.model;

import lombok.Data;

import java.util.Date;

@Data
public class SystemMenuModel {
    private int id;
    /**
     * 父级ID
     */
    private int fatherId;
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
}
