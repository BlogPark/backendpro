package com.yongming.backendpro.system.controller;

import com.yongming.backendpro.system.model.vo.SystemMenuVO;
import com.yongming.backendpro.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private SystemService systemService;

    @GetMapping("/getmenus")
    public List<SystemMenuVO> getMenus() {
        return systemService.getUsedMenus();
    }
}
