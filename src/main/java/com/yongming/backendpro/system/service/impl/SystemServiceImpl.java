package com.yongming.backendpro.system.service.impl;

import com.yongming.backendpro.system.mapper.SystemMenuMapper;
import com.yongming.backendpro.system.model.SystemMenuModel;
import com.yongming.backendpro.system.model.vo.SystemMenuVO;
import com.yongming.backendpro.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @Override
    public List<SystemMenuVO> getUsedMenus() {
        List<SystemMenuVO> result = new ArrayList<>();
        List<SystemMenuModel> menuModelList = systemMenuMapper.getAllUsedMenu();
        for (SystemMenuModel menuItem : menuModelList) {
            if (menuItem.getFatherId() == 0) {
                SystemMenuVO systemMenuVO = new SystemMenuVO();
                systemMenuVO.setId(menuItem.getId());
                systemMenuVO.setMenuName(menuItem.getMenuName());
                systemMenuVO.setMenuIcon(menuItem.getMenuIcon());
                systemMenuVO.setMenuRouter(menuItem.getMenuRouter());
                systemMenuVO.setMenuControllers(menuItem.getMenuControllers());
                List<SystemMenuModel> childMenus = menuModelList.stream().filter(p -> p.getFatherId() == menuItem.getId()).collect(Collectors.toList());
                systemMenuVO.setChildMenus(childMenus);
                systemMenuVO.setChildCount(childMenus.size());
                result.add(systemMenuVO);
            }
        }
        return result;
    }
}
