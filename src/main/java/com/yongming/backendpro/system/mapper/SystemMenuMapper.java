package com.yongming.backendpro.system.mapper;

import com.yongming.backendpro.system.model.SystemMenuModel;

import java.util.List;

public interface SystemMenuMapper {
    /**
     * 查询所有的启用菜单
     * @return
     */
    List<SystemMenuModel> getAllUsedMenu();
}
