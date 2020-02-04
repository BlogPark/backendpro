package com.yongming.backendpro.system.service;

import com.yongming.backendpro.system.model.vo.SystemMenuVO;

import java.util.List;

public interface SystemService {
    List<SystemMenuVO> getUsedMenus();

}
